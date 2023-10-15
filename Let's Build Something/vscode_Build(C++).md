# 以VSCode建置C/C++專案

## VSCode調用編譯器確認
在眾多C/C++編譯器發行版本之下，你可以有多種常用選擇:(標註`<# Targeted Compiler #>`為編譯C/C++來源時所用到的編譯器名稱。標註`symlink`為符號連結。)
 - GNU Compiler Collection(GCC): GNU作業系統的C/C++語言編譯器前端集合，由GNU組織指導並發行至跨平臺。GCC以GNU GPL v3.0條款授權公開免費使用。可在GNU體系應用程式環境[Cygwin](../Let's%20Do%20Setup/vscode_Setup(Cygwin).md)、MSYS2 pacman等程式管理套件找到，或是使用Dev-C++、Code::Blocks等C/C++程式IDE。
    ```
     as              # GNU Binary Utils Assembler
     cpp
     c++
     gcc             # GNU  C  language Frontend                             <# Targeted Compiler #>
     g++             # GNU C++ language Frontend                             <# Targeted Compiler #>
     ld              # Linker
     make            # GNU Makefile Utility
    ```
 - Borland C/C++(BCC): Borland 32位元C/C++語言編譯器。
    ```
     bcc32.exe       # Borland C/C++ Compiler                               <# Targeted Compiler #>
     ilink32.exe     # Turbo Incremental Linker
    ```
 - [Microsoft Visual C++(MSVC)](../Let's%20Do%20Setup/vscode_Setup(VS2022).md): 微軟的開發者工具[Visual Studio](../Let's%20Do%20Setup/vscode_Setup(VS2022).md)選用的C/C++開發工具。限定Windows 10/11 Intel64/AMD64/ARM64平臺。
    ```
     cl.exe          # Microsoft Visual C/C++ Compiler Driver                <# Targeted Compiler #>

     c1.dll          # Microsoft Visual  C  Language Frontend
     c1xx.dll        # Microsoft Visual C++ Language Frontend 
     c2.dll          # Microsoft Visual  C  Language Backend

     link.exe        # Microsoft Incremental Linker
     lib.exe         # Microsoft Library Stub

     ml64.exe        # Microsoft Macro Assembler
     nmake.exe       # Microsoft Program Maintainence Utility
    ```
 - [LLVM/Clang](../Let's%20CMake%20Something/LLVM.md): LLVM編譯器架構體系的C/C++語言前端Clang。可有獨立發行版[LLVM](https://github.com/llvm/llvm-project/releases)以及[Visual Studio](../Let's%20Do%20Setup/vscode_Setup(VS2022).md)、Xcode或[Cygwin](../Let's%20Do%20Setup/vscode_Setup(Cygwin).md)、MSYS2 pacman等程式管理套件找到。
    ```
     clang.exe       # LLVM Compiler Infastructure  C  language frontend    <# Targeted Compiler #>
     clang++.exe     # LLVM Compiler Infastructure C++ language frontend     :: symlink ==> clang.exe                     
     clang-cl.exe    # LLVM Compiler Infastructure C++ language frontend     :: symlink ==> clang.exe
     clang-cpp.exe   # LLVM Compiler Infastructure C++ language frontend     :: symlink ==> clang.exe

     lld.exe         # LLVM Compiler Infastructure Linker
     llvm-as         # LLVM Compiler Infastructure Assembler
    ```
 - [Intel DPCPP/CPP and Intel Classic C/C++ Compiler](../Let's%20Do%20Setup/vscode_Setup(OneAPI_CUDA).md): Intel的開發者工具oneAPI發佈的Intel C/C++版本。Intel DPCPP為CUDA平臺移植sycl工具。
    ```
     icx.exe         # Intel Classic C/C++ Compiler                         <# Targeted Compiler #>
     dpcpp.exe       # Intel DPCPP C/C++ Language Frontend                  <# Targeted Compiler #>
    ```
 - [NVIDIA CUDA Toolkit](../Let's%20Do%20Setup/vscode_Setup(OneAPI_CUDA).md#nvidia-cuda%E5%AE%89%E8%A3%9D): NVIDIA發佈的CUDA開發套件，包含GPU加速程式庫、GPU運算科學工具函式庫、以及一個NVIDIA C/C++執行環境。
    ```
     nvcc.exe        # NVIDIA CUDA Compiler Driver                          <# Targeted Compiler #>
     cu++filt.exe    # NVIDIA CUDA Language Frontend
     cudafe++.exe    # NVIDIA CUDA Language Frontend
     nvlink.exe      # NVIDIA CUDA Linker Driver
     ptxas.exe       # NVIDIA PTX Optimizing Assembler
    ```
 - AMD ROCm for Windows: AMD ROCm框架開發工具的Windows發行版本。由LLVM基底建構而成，支援HIP API執行AMD GPU偵錯。

## VSCode建置簡單C/C++專案偵錯

以下定義一個專案位置(資料夾)`buildCPP`，並有以下內容:
 - Folder
 ```
  |
  ├─> test.c(C/C++語言來源)
  |
  └─> .vscode(資料夾)
         |
         ├─> c_cpp_properties.json
         |
         ├─> tasks.json
         |
         └─> launch.json
 ```

### VSCode C/C++特性設定 - c_cpp_properties.json
VSCode延伸模組[ext:C/C++](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools)決定由`c_cpp_properties.json`配置完成自定義的程式庫訊息。該`c_cpp_properties.json`路徑在專案資料夾底下的`.vscode`資料夾內。

以下是基於使用MSVC編譯的C/C++特性設定:
 - JSON
   ```
    {
        "version": 4,
        "configurations": [
            {
                "name": "Win32",
                "includePath": ["${workspaceFolder}/**"],
                "defines": 
                [
                    "_DEBUG",
                    "UNICODE",
                    "_UNICODE"
                ],
                "windowsSdkVersion": "10.0.22000.0",
                "compilerPath": "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.29.30133/bin/HostX64/x64/cl.exe",
                "cStandard": "c17",
                "cppStandard": "c++17",
                "intelliSenseMode": "windows-msvc-x64"
            }
        ]
    }
   ```

我們逐步介紹`c_cpp_properties.json`內所有鍵值的傳遞訊息:
  - `version`: 值預設是`4`。
  - `configurations`: C/C++的確認信息，由JSON清單物件(`[]`)組成，且包含一個或多個JSON物件(`{}`)。
 
    在`configurations`的JSON物件下(`{}`)有以下鍵值:

    - `name`: `Win32`.你要叫甚麼都可以，但像`Win32`, `Linux`, `Mac`是特殊識別態，依照你的作業系統為準。
    - `includePath`: 你的程式庫的包含路徑，例如`stdio.h`等標頭檔路徑位置等，由JSON清單物件(`[]`)傳遞。
        - 若是有包含在專案根目錄底下的標頭檔(headers)則填入`"${workspaceFolder}/**"`。其中`/**`代表對該路徑下的**遞迴搜尋**。
    - `defines`:JSON清單物件(`[]`)。當中包含: `"_DEBUG"`, `"UNICODE"`, `"_UNICODE"`.
    - `WindowsSDKVersion`: `10.0.22000.0`. 你可以換成其他的版本號。
    - `compilerPath`: 編譯器的絕對路徑。這會逕行調用該指定編譯器以執行Intellisense或是Linting功能。
    - `cStandard`: 編譯器的C標準。若是不知道則以`${Default}`替代。該設定值可依據該編譯器支援的標準提供更準確的Intellisense。
    - `cppStandard`: 編譯器的C++標準。若是不知道則以`${Default}`替代。該設定值可依據該編譯器支援的標準提供更準確的Intellisense。
    - `"intelliSenseMode"`: 依照你的編譯器選擇Intellisense模式。該範例為Windows x64下執行MSVC。
        - 作業系統: 例如`Windows`/`macOS`/`Linux`。
        - 編譯器: 例如`msvc`/`clang`/`gcc`。
        - 處理器架構: 例如 `x86`(32位元x86)/`x64`(64位元x86，AMD64或Intel 64)/`ARM64`(ARM架構64位元處理器)。

### VSCode 建置C/C++作業 - tasks.json
VSCode對編譯類型程式進行建置(Build Task)，並會根據所引用條件(包含Include引用標頭檔、LIB引用靜態程式庫等)執行預處理(pre-processing)->編譯(compilation)->彙編->(assembly)->鏈接(linking)程序。該建置作業由`tasks.json`引導vscode設定原始碼建置編譯信息傳遞作業。

以下是基於使用MSVC編譯的設定:
 - JSON
    ```
    {
       "version": "2.0.0",
       "tasks": 
       [
         {
           "windows":{
             "options": {
               "shell": {
                 "executable": "cmd.exe",
                 "args": ["/E:ON", "/C", "VsDevCmd.bat", "host_arch=x64", "arch=x64", "&&"]
                 }
               }
             },
             "type": "shell",
             "label": "cl.exe",
             "command": "cl.exe",
             "args": [
                       "/Fe:", 
                       "${fileDirname}\\${fileBasenameNoExtension}.exe", 
                       "${file}"
             ],
             "problemMatcher": ["$msCompile"],
             "group": {
               "kind": "build",
               "isDefault": true
             }
         }
       ]
     }
    ```
我們逐步介紹`tasks.json`內所有鍵值的傳遞訊息:
  - `version`:  值預設是`"2.0.0"`。
  - `tasks`: JSON陣列物件，且包含一個或多個JSON物件。

      - `windows`: 特殊的鍵值設定。該鍵值透過`"options"`的JSON鍵值建立用來呼叫一個殼層`"shell"`執行環境，此處呼叫Visual Studio環境初始化(`VsDevCmd.bat`)。
          - `executable`: 殼層可執行檔。建議使用`cmd.exe`(例如Intel oneAPI沒有PowerShell的支援)。
          - `args`: 傳遞至該殼層的引數。因為呼叫該殼層並執行建置後需要直接關閉，因此需要`"/E:ON"`、`"/C"`、`"VsDevCmd.bat"`、`"VsDevCmd.bat"`、`"arch"`和`"&&"`引數。當中，各引數意義如下:
             - `"/E:ON"`: `cmd.exe`啟用延伸模組。
             - `"/C"`:  執行該殼層所有命令後關閉該`cmd.exe`殼層。
             - `"VsDevCmd.bat"`: 呼叫Visual Studio環境初始化。`"host_arch"`及`"arch"`引數傳遞給`VsDevCmd.bat`。
              
               `VsDevCmd.bat`會設定環境變數並遞迴搜尋所安裝的開發人員工具、SDK、程式庫、標頭程式庫等開發必要元件。透過`VsDevCmd.bat`配置的環境變數可一定程度省略`sysdm.cpl`所設定系統變數或在`c_cpp_properties.json`所手動設定鍵入的程式庫引用路徑。(例如UCRT程式庫位置、include、lib等)
             - `"host_arch"`: 設定本機架構所決定執行的編譯器。因本機架構是x64(Intel 64/AMD64)，故選擇`x64`。
             - `"arch"`: 設定建置目標架構所決定執行的編譯器。因目標是本機架構(建置在本機上執行)，故選擇`x64`。
             - `"&&"`: 傳遞一個後接的命令。

            該殼層的起動命令是:
             - Shell
                ```
                cmd.exe /E:ON /C VsDevCmd.bat -host_arch=x64 -arch=x64 && ...........
                ```
      - `type`: `shell`(因為該C/C++編譯命令從`cmd.exe`殼層啟動)。
      - `label`: 標籤。你可以叫一個喜歡的名字。
      - `command`:編譯器的檔案名。舉例MSVC就是`cl.exe`.
      - `args`: 傳遞至編譯器內的引數。不同編譯器在`args`JSON清單物件中可有不同引數及排列順序:
        ```
         MSVC     cl.exe:        ["/Fe:", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
                                 ["/Zi", "/EHsc", "/Fe:", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
         Intel    dpcpp.exe:     ["-o", "${fileDirname}/${fileBasenameNoExtension}.exe","/Zi","/EHsc", "${file}"]
         Intel    icl.exe:       ["-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
         Intel    icx.exe:       ["-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
         CUDA     nvcc.exe:      ["-g", "${file}", "-o", "${fileDirname}/${fileBasenameNoExtension}"]
         GNU      gcc.exe:       ["-g", "-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
         LLVM     clang.exe:     ["-g","${file}","-o", "${fileDirname}/${fileBasenameNoExtension}.exe"]
        ```

        調用MSVC的命令列為:
         - Shell
            ```
            cl.exe /Fe: test.exe test.c
            ```

      - `problemMatcher`: 問題對比器選項。這裡選擇`["$msCompile"]`。
      - `"group"`: 群組定義工作為建置或測試及預設選項。`{"kind": "build", "isDefault": true}`

整體而言，該`tasks.json`呼叫的殼層建置命令為:
 - Shell
    ```
    cmd.exe /E:ON /C VsDevCmd.bat -host_arch=x64 -arch=x64 && cl.exe /Fe: test.exe test.c
    ```

### VSCode 執行C/C++偵錯 - launch.json
執行程式的偵錯由`launch.json`內的訊息配置完成自定義的偵錯測試。執行程式即為對程式執行偵錯。編譯程式可額外設定透過建置後執行偵錯，直譯程式則直接執行。

本範例執行MSVC的偵錯設定:
 - JSON
    ``` 
    {
        "version": "0.2.0",
        "configurations": [
            {
                "name": "cl.exe",
                "type": "cppvsdbg",
                "request": "launch",
                "program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
                "args": [],
                "stopAtEntry": false,
                "cwd": "${workspaceFolder}",
                "environment": [],
                "console": "integratedTerminal",
                "preLaunchTask": "cl.exe"
            }
        ]
    }
    ```

當中:

  - `version`: 值預設是`0.2.0`.
  - `configuration`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:

    - `"name"`: 偵錯設定情境的名稱。
    - `"type"`: 因為是MSVC的C/C++偵錯，所以選擇`"cppvsdbg"`。
    - `"request"`: 因為是執行，選擇`"launch"`。
    - `"program"`: 偵錯建置的檔案。由`"${fileDirname}/${fileBasenameNoExtension}.exe"`關聯的檔案是經建置出來的目標執行檔(`test.exe`)。
    - `"args"`: 傳遞至該欲偵錯可執行檔的引數。由於沒有引數要傳遞所以為JSON空陣列(`[]`)。
    - `"stopAtEntry"`: 偵錯工具在目標的進入點停止的動作。這裡選擇`false`.
    - `"cwd"`: `"${workspaceFolder}"`
    - `"environment"`: 開啟偵錯時的環境變數設定，例如臨時附加的變數等。由於沒有引數要傳遞所以為JSON空陣列(`[]`)。
    - `"console"`: 取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。有以下的值:
       - `"integratedTerminal"`: 整合式終端機。偵錯結果將在vscode內的終端列印。
       - `"externalTerminal"`: 外部的終端機。該偵錯透過Windows終端機或Windows傳統主控台輸出偵錯。
    - `"preLaunchTask"`: 執行該目標執行檔的偵錯前建置作業。該值必須和tasks.json內的`label`名稱一致或其中一個相符。若有這項設定，則該目標底稿(此處為`test.c`)會在執行偵錯時，自動先進行建置(依照`tasks.json`)作業。

整體而言，執行對`test.c`偵錯的流程如下:
 - Shell
    ```
    cmd.exe /E:ON /C VsDevCmd.bat -host_arch=x64 -arch=x64 && cl.exe /Fe: test.exe test.c
    .\test.exe                                                                                      
    ```
    當中，第一列是`test.c`建置的命令列，由`preLaunchTask`呼叫並執行。第二列才是執行建置後目標執行檔(test.exe)的偵錯。

### 解釋
 - Incremental Linker: 累加式連結器，可對連接器(Linker)指定連結模式是否為累加模式，若非累加模式則對各項編譯的前置作業執行獨立連結；若為累加模式則逕行直接連接。依用途而有不同的鏈接表現。
