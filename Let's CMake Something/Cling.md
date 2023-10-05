
# 建置 "Cling" C++直譯器

### 前言及建置先決工具
Cling是CERN的ROOT統計及資料分析框架底下的一個C++直譯器，由LLVM/Clang為基底建置。該直譯器可透過簡短的C++語法完成近似於Python的直譯式命令互動，並以REPL形式執行互動殼層。

Cling有macOS及Linux的發行版本(即安裝可用的二進位制檔)，Windows平臺則需要自行使用原始碼建置。以下會基於Windows平臺建置逐步說明。

Cling可單獨建立，但通常包含在LLVM內與Clang一起編譯生成。我們以Microsoft Visual Studio 2022 Community作為開發工具:
 - [C++桌面開發選項](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Let's%20Do%20Setup/vscode_Setup(1)_VS2022.md)
    ```
     MSVC v143 - VS2022 x64/x86 Build Tools       (必選)
     MSVC v143 ATL                                (可選)
     MSVC v143 MFC                                (可選)
     Windows CMAKE C++                            (必選)
     Windows 11 SDK                               (必選)
     Windows 10 SDK                               (可選)
    ```

開始建置Cling:
 - PowerShell
   ```
    & cmd.exe /E:ON /K "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/Tools/VsDevCmd.bat" -host_arch=x64 -arch=x64
   ```
 - CMD
   ```
    cd //Users/UserX/Desktop
    mkdir CLING
    cd CLING

    git clone --branch=cling-patches --depth=1 --config core.autocrlf=false http://root.cern.ch/git/llvm.git src
    git checkout cling-patches
    cd src
    cd tools
    git clone --depth=1 --config core.autocrlf=false http://root.cern.ch/git/cling.git
    git clone --branch=cling-patches --depth=1 --config core.autocrlf=false http://root.cern.ch/git/clang.git
    git checkout cling-patches
   ```

命令列當中，git控制套件複製原始碼至現有路徑底下的`src/`子目錄(由於未有該路徑，故會自行生成`src`資料夾)。由於原有LLVM組織發佈的LLVM原始碼是沒有Cling的，`cling-patches`為確認ROOT-Project所發佈的LLVM架構原始碼為適用於Cling的重新發佈分支。

在以CMake開始建置之前，我們以啟動VSCode程式編輯器的方式修改一部分原始碼以避免部分警告或報錯。
- CMD
  ```
   code "./cling/lib/interpreter/DeclUnloader.cpp"
  ```

在`DeclUnloader.cpp`修改的內容如下:
- C++
  ``` 

  bool DeclUnloader::VisitFunctionTemplateDecl(FunctionTemplateDecl* FTD) {         // 第1027行
    bool Successful = true;

    // Remove specializations:
    for (FunctionTemplateDecl::spec_iterator I = FTD->loaded_spec_begin(),          //  <<===== 將loaded_spec_begin()替換成spec_begin()
          E = FTD->loaded_spec_end(); I != E; ++I)                                  //  <<===== 將loaded_spec_end()替換成spec_end()
    Successful &= Visit(*I);

    Successful &= VisitRedeclarableTemplateDecl(FTD);
    Successful &= VisitFunctionDecl(FTD->getTemplatedDecl());
    return Successful;
  }

  bool DeclUnloader::VisitClassTemplateDecl(ClassTemplateDecl* CTD) {
    // ClassTemplateDecl: TemplateDecl, Redeclarable
    bool Successful = true;
    // Remove specializations:
    for (ClassTemplateDecl::spec_iterator I = CTD->loaded_spec_begin(),             //  <<===== 將loaded_spec_begin()替換成spec_begin()
           E = CTD->loaded_spec_end(); I != E; ++I)                                 //  <<===== 將loaded_spec_end()替換成spec_end()
      Successful &= Visit(*I);
  }                                                                                 // 第1046行
  ```

該程式未修改而逕行編譯時會有以下Error C2036報錯:
 - Output
    ```
    「loaded_spec_begin()並非clang::FunctionTemplateDecl的成員」
    「loaded_spec_end()並非clang::FunctionTemplateDecl的成員」
    「loaded_spec_begin()並非clang::ClassTemplateDecl的成員」
    「loaded_spec_end()並非clang::ClassTemplateDecl的成員」
    ```

## 使用Ninja生成器建置Cling

建立專案建置的資料夾:
 - CMD
   ```
    cd ../..; mkdir build; cd build

    cmake -DCMAKE_INSTALL_PREFIX="<INSTALL_DIR>" -DLLVM_TARGETS_TO_BUILD="<TARGET_PLATFORM_ARCH>" -G "Ninja" -S ../src
    cmake --build . --config Release --target install 
   ```
## 使用NMAKE生成器建置Cling

若你的Cling專案以預設的Visual Studio的NMAKE作為生成器，則執行的`cmake`命令列如下:
 - CMD
   ```
    cmake -DCMAKE_INSTALL_PREFIX="<INSTALL_DIR>" -DLLVM_TARGETS_TO_BUILD="<TARGET_PLATFORM_ARCH>" -G "Visual Studio 17" -S ../src -Thost=x64 -A x64
    cmake --build . --target "<TARGET>" --config "<VERSION>" --parallel
   ```
若有自定義依據需求提升權限者，可在命令列開頭以`sudo`提權([gsudo](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Let's%20Do%20Setup/vscode_Setup(0.1)_gsudo.md)套件)執行`cmake`命令。舉例將Cling建置並安裝到`C:/Program Files/Cling`底下:
 - CMD
   ```
    cd build
    cmake -DCMAKE_INSTALL_PREFIX="C:/Program Files/Cling" -DVARIABLE_0="<Value>" -DVARIABLE_1="<Value>" -G "GENERATOR" -S "SRC_PATH"
    sudo cmake --build . --target Install --config "<VERSION>" --parallel
   ```

## 筆者建置安裝範例

筆者的建置環境如下:
```
                                                                          --> LLVM_TARGETS_TO_BUILD
  PC: NB, ASUS ROG Zephyrus S15 2020 GX502LXS
          CPU:      Intel Core i7-10875H                                  --> x86_64; Host=x64;     Build_Target=x64
          GPU:      NVIDIA GeForce RTX 2080 Super with Max-Q design       --> NVIDIA CUDA GPU;      Build_Target=NVPTX
          DRAM:     Micron 32GB DDR4 SO-DIMM
          Storage:  Samsung 970 EVO Plus 2TB TLC NVMe PCIe 3.0 SSD
          OS:       Windows 11 Pro Workstation 22H2
```

筆者建置Cling專案調用的工具如下:
  ```
    Tools:
      Python 3                                              3.9.7
      Ninja:                                                1.11
      Gsudo:                                                2.0.4
      Git for Windows:                                      2.41.0
      Visual Studio Code:                                   1.81.0
      Visual Studio:                                        2022 Community 
            Desktop C++:      MSVC v143                     14.37.32822
                              CMAKE for Windows VC++        3.26.4-msvc4
                              Windows 11 SDK                10.0.22621.0
                              Windows 10 SDK                10.0.20348.0
  ```

筆者的建置目標如下:
  ```
      <DEFINED_FOLDER>                  <LOCATION>

      Cling Project Root Folder:        ~/Desktop/CLING
      Cling Project Source Folder:      ~/Desktop/CLING/src
      Cling Project Build Folder:       ~/Desktop/CLING/build
      Cling Project Install Folder:     C:/Cling
  ```
  ```
      CMAKE:                            CMAKE 3.26.4-msvc4 (Visual Studio 2022)

      <-DVARIABLE>                      <VALUE>

      CMAKE_C_COMPILER:                 cl.exe MSVC v143
      CMAKE_CXX_COMPILER:               cl.exe MSVC v143
      CMAKE_ASM_COMPILER:               cl.exe MSVC v143
      Generator:                        Ninja (Replace default NMAKE Utility)
      LLVM_ENABLE_PROJECTS:             clang
      LLVM_TARGETS_TO_BUILD:            "host;NVPTX"
      Build Version:                    "Release"
  ```

筆者的Cling建置執行命令範本如下(專案建置執行時間: `Ninja`約為57分鐘，`NMake`約為3小時46分鐘):

- Developer Command Prompt for Visual Studio 2022(x64) 
  ```
    cd C:/Users/TaiXeflar/Desktop; mkdir CLING; cd cling

    git clone --branch=cling-patches --depth=1 --config core.autocrlf=false http://root.cern.ch/git/llvm.git src
    git checkout cling-patches
    cd src
    cd tools
    git clone --depth=1 --config core.autocrlf=false http://root.cern.ch/git/cling.git
    git clone --branch=cling-patches --depth=1 --config core.autocrlf=false http://root.cern.ch/git/clang.git
    git checkout cling-patches

    cd ../..; mkdir build; cd build

    cmake -DCMAKE_INSTALL_PREFIX="C:/Cling" -DLLVM_TARGETS_TO_BUILD="host;NVPTX" -G "Ninja" -S ../src
    cmake --build . --config Release --target install
  ```

### Reference

- Root-Project/Cling(GitHub): https://github.com/root-project/cling
- LLVM Official Website: [llvm.org](https://llvm.org/)
- Clang Documentation: https://clang.llvm.org/doxygen/classclang_1_1FunctionTemplateDecl.html


### Future targets

  1. Resolving Cling Jupyter Kernel spawn ENOENT error: 403
  2. Testing MinGW/Cygwin/MSYS2 Environment Build Task