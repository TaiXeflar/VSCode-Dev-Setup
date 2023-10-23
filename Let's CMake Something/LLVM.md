# LLVM 環境建置

### LLVM 前言簡介
LLVM架構原全名為「低階虛擬機器」"Low Level Virtual Machine"，後因其程式庫專案擴充而沿用LLVM縮寫名稱為「LLVM編譯器架構」"The LLVM Compiler Infastructure"，是一套編譯器基礎設施專案，其為編譯器前端-中間代碼-後端的全模組化架構，並以C++實現(即LLVM是以C++源代碼編譯而成)。由於LLVM在發展史上由UNIX近似系統產生，並有一段時間由蘋果電腦(Apple Inc.)主持Clang(LLVM的C語言前端)，因此可發現LLVM架構的應用程式與GCC部分近似，並與UNIX/Linux有更好的相容性。LLVM已將源代碼託管在GitHub上，並有發行版本(即安裝程式)和源代碼壓縮包可供下載。授權條款以Apache 2.0可商用條款(有LLVM例外的Apache License 2.0)釋出。

現如今LLVM已有以下應用: LLVM專案(The LLVM Project)、LLVM/Clang(LLVM C language Frontend)、Swift等一系列程式語言編譯器、編譯式程式語言編譯器、直譯式語言解釋器、編譯式語言的可直譯化解釋器(Root-Project Cling、LFortran等)、特定架構晶片執行代碼編譯器/轉譯器架構(Intel LLVM DPCPP-sycl(oneAPI DPC++/C++)、AMD Optimized C/C++(AOCC)、NVIDIA CUDA: NVC/C++ NVFortran)等全自定義化語言編譯架構。

LLVM說明，LLVM工具組中具備一個組譯器(Assembler)，一個反組譯器(disassembler)，一個中間代碼分析器(bitcode-analyzer)及一個中間代碼優化器(bitcode-optimizer)。LLVM工具作為中間代碼(Intermediate Representation, IR)的優化器所優化目標即為Bitcode。

### Windows平台的LLVM
LLVM緣起於UNIX/Linux平臺，因此相對於Windows平臺，可能有部分程式庫提供的發行版本未提供支援(例如`llvm-config.exe`)；或是編譯LLVM專案時可能缺少部分程式標頭檔等問題；但LLVM在Windows平台的建置是可以單靠Cygwin/MSYS2/MinGW64等GNU工具列或使用VS20XX的MSVC工具列完成LLVM套件或LLVM/Clang的全部建置。

LLVM的Windows發行版本可在以下地方找到:
 - LLVM的GitHub[官網發佈版本](https://github.com/llvm/llvm-project/releases)，以Windows安裝程式執行安裝。
 - Visual Studio Installer所提供[適用於Windows的Clang C++](../Let's%20Do%20Setup/vscode_Setup(VS2022).md)。該C++工具為包含LLVM/Clang的發行版本，與LLVM在GitHub發佈的安裝包內容一致。
 - Cygwin環境的[Cygwin下載程式](../Let's%20Do%20Setup/vscode_Setup(Cygwin).md)`setup-x86_64.exe`所發佈線上下載的LLVM發行版。透過Cygwin安裝程式選擇clang及llvm等開發者程式及程式庫。
 - MSYS環境的套件管理員`pacman`所託管的LLVM發行版。透過`pacman`套件管理員執行llvm/clang的安裝。
 - etc.

 - LLVM原始碼在Windows平臺的建置。

## LLVM原始碼建置LLVM及LLVM架構C/C++語言前端Clang

本專案目標為建置LLVM架構的C/C++語言前端Clang。Clang的C語言前端支援編譯C/C++，Objective-C/C++(物件導向C/C++)。

### Visual Studio的前置準備

以下會基於本機所擁有安裝Visual Studio 2022環境進行LLVM建置說明。

首先，你的電腦需要以下開發套件:
 - [Visual Studio Installer](../Let's%20Do%20Setup/vscode_Setup(VS2022).md)
    ```
     C++桌面開發
     
     MSVC v143
     適用於Windows的C++ CMake工具
     Windows 11/10 SDK
    ```
 - [Git for Windows](../Let's%20Do%20Setup/vscode_Setup(Git).md)
 - [Python 3](../Let's%20Do%20Setup/vscode_Setup(Python).md) (Python 3.X >= 3.6)

我們解釋以下開發套件的必要原因:
 - Visual Studio: C++開發環境是以MSVC為C/C++來源編譯，依照VS2022版本選擇`MSVC v143`為LLVM建置時所選定的編譯器。
 - CMake: 由於LLVM使用CMake(CrossMake)作為大型組織化編譯呼叫的建置工具，因此我們需要安裝CMake，並且VS2022會為該選項配置生成器`Ninja`。該CMake為適用於MSVC的特規版，只有CLI介面(沒有視窗介面)。
  
   CMake全名為CrossMake，是Kitware的跨平臺建置程式(這在很多由GCC/G++及LLVM/Clang基底建置C/C++專案中可以看到)的跨平臺編譯建置工具。CMake有組織化的檔案生成規劃及編譯呼叫。適用於大型規模的組織化建置生成作業。請注意CMake是獨立語法，與C/C++語言沒有任何關係。
 - Windows 11/10 SDK: 至少需要一組選用適用於MSVC的通用CRT程式庫及標頭檔函式庫(Universial C++ Runtime, UCRT)。
 - Python 3: 為LLVM內`llvm-lit.py`測試性能時所必要的Python執行環境。

### 以命令列建置LLVM/Clang並進行安裝

首先，我們確認我們建置LLVM的目標。共有LLVM以及Clang:
 - LLVM Projects
    ```
     llvm
     clang
    ```

本處範例定義LLVM專案資料夾的路徑如下:(`~/`路徑即為`C:/Users/USERX/`)
 - PATH
    ```
     專案根目錄:            "~/Desktop/LLVM"
     原始碼目錄:            "~/Desktop/LLVM/src"
     建置檔目錄:            "~/Desktop/LLVM/build"
     安裝檔目錄:            "C:/LLVM"
    ```

我們以命令列形式執行LLVM建置。首先需要啟動終端機，呼叫Visual Studio開發人員環境。執行`Win+R`組合鍵並啟動CMD:
 - `Win+R` Key
    ```
     cmd.exe /E:ON /K "%VS2022INSTALLDIR%/Common7/Tools/VsDevCmd.bat" -host_arch=x64 -arch=x64
    ```
該命令列會呼叫CMD，並建立開發人員環境變數。`-host_arch`為執行建置的本機架構指定`x64`，`-arch`為執行建置的目標架構指定`x64`。後續將繼續執行CMD殼層。

建立專案根目錄並執行`git`指令以複製LLVM專案原始碼:
 - CMD
    ```
     cd ~/Desktop
     mkdir LLVM; cd LLVM
     mkdir src; mkdir build;
     git clone --config core.autocrlf=false --depth=1 https://github.com/llvm/llvm-project.git src
     cd build
    ```
命令列當中，`git`版本控制套件複製LLVM原始碼，並設定複製的原始碼儲存時不強制設定CRLF換行；複製的程式碼存放至底下的`src`資料夾。

接著我們呼叫`CMake`生成建置檔案:
 - CMD
    ```
     cmake -DCMAKE_INSTALL_PREFIX="C:/LLVM" -DLLVM_ENABLE_PROJECTS="clang" -DLLVM_TARGETS_TO_BUILD="host" -G "Ninja" -S ../src/llvm
    ```
CMake會開始檢查編譯器設定、尋找引用的標頭檔、生成建置規則檔案並測試編譯性能。

若有自定義依據需求安裝至系統資料夾位置(例如`C:/Program Files/LLVM/`等路徑)而需要提權，可在命令列開頭以`sudo`提權(gsudo套件)執行`cmake`命令。

開始執行LLVM專案建置的編譯:
 - CMD
    ```
     cmake --build . --config "release" --target "install" --parallel
    ```
建置完成後，會將所生成的應用程式及可執行檔(\*.exe)、動態連結程式庫(\*.dll;\*.so)、靜態程式庫(\*.lib;\*.a)、標頭檔程式庫(\*.h;\*hpp;\*.inc)、CMake建置目標列表(\*.cmake)等工具鏈安裝至指定位置(範例指定至`C:/LLVM`)。最後手動設定把LLVM加入至PATH即完成LLVM的建置部署。


### LLVM專案全覽    
完整的LLVM專案可有以下選擇:
 - LLVM Projects
    ```
     bolt
     clang
     clang-tools-extra
     compiler-rt
     cross-project-tests
     libc
     libclc
     libcxx
     libcxxabi
     libunwind
     lld
     lldb
     llvm
     llvm-libgcc
     mlir
     openmp
     polly
     pstl
    ```

### Visual Studio開發人員命令提示字元
呼叫Visual Studio開發者命令列時須指定建置本機架構及建置目標架構。`VsDevCmd.bat`被呼叫時會載入編譯器應用程式/可執行檔路徑(Compiler/Compiler Driver Executable/Binary PATH)、程式庫路徑(LIB, LIBPATH)、標頭檔程式庫路徑(INCLUDE PATH)等工具變數及路徑變數，並**自動**設定本機架構為x86的32位元平臺，目標架構為x86的32位元平臺。為符合建置目標為Intel64或AMD64處理器之Windows 64位元平臺，指定`-host_arch`變數為本機架構x64，指定`-arch`架構變數為目標架構x64，以避免cmake呼叫成32位元的編譯器造成可能的耗盡記憶體導致編譯錯誤或BSOD(Blue Screen of Death)情況。

### CMAKE指令參數
CMake會依據`CMakeLists.txt`規定專案編譯架構、可用參數或覆寫參數設定範圍、引用的原始碼或本地程式庫(未在原始碼內但在本機上其他路徑下的程式庫等)、CMake通用參數設定等決定專案建置的編譯行為。由於本次LLVM/Clang建置是由LLVM開始建置，此處列出在LLVM專案下`LLVM/src/llvm/CMakeLists.txt`所規範可用的`cmake`參數。

以下講述CMake後接述的引數`-DVARIABLE=<VALUE>`。當中`VARIABLE`可有以下常見的覆寫引數:
 - `CMAKE_INSTALL_PREFIX`: CMake專案建置後安裝路徑。
 - `CMAKE_BUILD_TYPE`: CMake專案建置的版本。預設為`Debug`(適用於開發人員)，可選`Release`為穩定版本。
 - `CMAKE_C_COMPILER`: CMake呼叫的C語言編譯器(C Compiler)。本處未指定編譯器，自動選擇VC++ `cl.exe`。
 - `CMAKE_CXX_COMPILER`: CMake呼叫的C++語言編譯器(C++/CXX Compiler)。本處未指定編譯器，自動選擇VC++ `cl.exe`。
 - `CMAKE_ASM_COMPILER`: CMake呼叫的組合語言編譯器(Assembler)。本處未指定編譯器，自動選擇VC++。
    ```
    -DCMAKE_C_COMPILER="<COMPILER>"
    -DCMAKE_CXX_COMPILER="<COMPILER>"
    -DCMAKE_ASM_COMPILER="<COMPILER>"

        <COMPILER>=
        cl:         MSVC C/C++/ASM 編譯驅動程式。
        clang:      LLVM架構的  C  Frontend。
        clang++:    LLVM架構的 C++ Frontend。
        llvm-as:    LLVM架構的 Assembler。
        gcc:        GNU Compiler Collection C Frontend。
        g++:        GNU Compiler Collection C++ Frontend。
        as:         GNU Compiler Collection Assembler。
    ```
 - `LLVM_ENABLE_PROJECTS`: LLVM專案中選用哪些工具連同LLVM建置生成。請注意，共同建立的工具將依據`src/llvm/CMakeLists.txt`內`LLVM_ALL_PROJECTS`及`LLVM_EXTRA_PROJECTS`變數規定的工具選項提供可用選擇。下列LLVM工具的選擇範例是依據`src/llvm/CMakeLists.txt`當中的`LLVM_ENABLE_PROJECTS`變數定義規定逕行選擇。
   ```
   -DLLVM_ENABLE_PROJECTS="<Tools1;Tools2;Tools3;...>"

      LLVM: 語言編譯器中間層代碼(IR)及後端(Backend)   # LLVM不需要加入至引數

      clang:   LLVM專案的C/C++語言前端(Compiler)
      flang:   LLVM專案的Fortran語言前端(Compiler)
      libc:    標準C/C++程式庫
      libclc   OpenCL程式庫
      libcxx   標準C/C++程式庫                       # 透過 -DLLVM_ENABLE_RUNTIME="VALUE"建置libcxx
      lld      LLVM專案的鏈接器(Linker)
      lldb     LLVM專案的偵錯器(Debugger)

      bolt
      clang-extra-tools
      compiler-rt
      libcxxabi
      libunwind
      mlir
      openmp
      polly
      pstl
   ```
 - `LLVM_TARGETS_TO_BUILD`: LLVM專案建置的目標平台架構。若未指定則生成適用於全部架構的目標工具。變數以字串傳遞並以分號添加架構。
    ```
    -DLLVM_TARGETS_TO_BUILD="Target1;Target2;..."

      host: 本機架構。CMake會自動偵測本機架構。

      AArch64:  ARM64處理器架構。
      AMDGPU:   AMD Radeon/Instinct Graphics處理器架構。
      ARM:      ARM32處理器架構。
      Hexagon:  Qualcomm Hexagon ARM32處理器架構。
      NVPTX:    NVIDIA CUDA架構(CUDA執行CUDA C/C++/Fortran轉譯的PTX代碼)。
      PowerPC:  PowerPC架構處理器。
      RISCV:    RISC-V架構處理器。
      X86       X86架構處理器(Intel x86_64/AMD AMD64)。

      etc.
    ```
 - `LLVM_HOST_TRIPLE`: LLVM專案建置的平台架構。若`src/llvm/cmake/config-ix.cmake`仍然報錯至無法判斷建置的本地架構時，添加該變數的指定架構。

 - `-S`: Source File Path，指定的源代碼根路徑。
 - `-B`: Build File Path，指定的專案建置生成檔案的存放路徑。因為終端機路徑已經在`build`內，在該處執行camke建置時不加入此參數。
 - `-G`: Generator，即指定的Makefile生成器。本處使用`Ninja`覆寫預設`Visual Studio 17`的NMAKE以加快編譯速度。若你的生成器使用NMAKE，請加入`-Thost`及`-A`參數。
   ```
    -G "<Generator>"

      Unix MakeFiles        以適用於UNIX-Like的Make生成檔案。GNU GCC Compiler Collection etc.
      Ninja                 以Ninja作為生成器。
      Code::Blocks          Code::Blocks IDE框架的解決專案。
      Borland               Borland C/C++ Compiler的生成器。
      MSYS                  MSYS2的Make專案。
      MinGW                 MinGW的Make專案。
      Visual Studio XX      以Visual Studio的NMAKE Utility作為生成器。
               -->> XX= 17:   Visual Studio 2022
                        16:   Visual Studio 2019
                        15:   Visual Studio 2017
                        14:   Visual Studio 2015
   ```
 - `-Thost`: 建置的目標架構。使用NMAKE Utility時加入該引數，指定本機(Host)建置平臺屬性。
 - `-A`: 建置的本機架構。使用NMAKE Utility時加入該引數，指定目標(Target)建置平臺屬性。
 - `--build`: 參照專案建置後要使用的檔案路徑。由於已經在`build`內建置生成檔案，故讀取路徑即為該路徑"` . `"。
 - `--config`: 確認建置版本。與`CMAKE_BUILD_TYPE`功能相同，但`--config`僅執行建置指定的版本而非覆寫CMake設定。
    ```
     --config "<VERSION>"

       <VERSION>=
        Debug               偵錯版本。適用於程式開發人員偵錯版本，建置時會輸出偵錯紀錄。未指定<Version>則以Debug為預設建置版本。
        Release             發行版本。適用於專案使用者的穩定版本，建置時不輸出偵錯紀錄。
        RelWithDebInfo      發行版本。適用於專案使用者的穩定版本，但建置時輸出偵錯紀錄。
        MinSizeRel          發行版本，但會以最小的儲存空間要求建置專案，適用於硬碟空間有限者。
    ```
 - `--target`: 確認建置的最終目標。未指定則為預設`All`，指定`Install`會執行建置後安裝至指定位置。
    ```
     --target "<TARGET>"
    ```
 - `--parallel`: 指定CMake執行多重執行緒編譯。若生成器為`Ninja`則預設啟用(即不加入`--parallel`仍生效)。

## VSCode調用LLVM/Clang
參照[vscode_Build(C++).md](../Let's%20Build%20Something/vscode_Build(C++).md)實作，並以clang替換成欲使用的C/C++編譯器前端調用。執行監測(Watchdog)或偵錯(Debug)可調用gdb(GNU Debugger)或lldb(LLVM Debugger)。
 - tasks.json
   ```
    {
      "version": "2.0.0",
      "tasks": [
         {
            "type": "shell",
            "label": "C/C++: clang++ build active file",
            "command": "clang++",
            "args": [
               "-g",
               "${file}",
               "-o",
               "${fileDirname}/${fileBasenameNoExtension}"
            ],
            "options": {
               "cwd": "${workspaceFolder}"
            },
            "problemMatcher": ["$gcc"],
            "group": {
               "kind": "build",
               "isDefault": true
            }
         }
      ]
         
    }
   ```

## 註釋

## 後言及參考出處
本LLVM建置為偏向理論及純命令介紹性質，該敘述內容可參閱LLVM官網詳細介紹(英文):https://www.llvm.org 

專案建置實作可參考實作Cling專案的介紹[Cling.md](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/CMAKE_Projects/Cling.md)。

- LLVM Website:         [llvm.org](https://llvm.org/)
- LLVM GitHub Repo:     https://github.com/llvm/llvm-project
- LLVM  Release:        https://github.com/llvm/llvm-project/releases