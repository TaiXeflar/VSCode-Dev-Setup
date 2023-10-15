# 以VSCode建置Fortran專案

## VSCode調用編譯器確認
在Windows平臺較少有Fortran編譯器選擇(大多相容於Linux)，因此我們選擇較為常見的Fortran編譯器:(標註`<# Targeted Compiler #>`為編譯Fortran來源時所用到的編譯器名稱。標註`symlink`為符號連結。)

 - [Intel oneAPI Visual Fortran Compiler](../Let's%20Do%20Setup/vscode_Setup(OneAPI_CUDA).md):前身為Microsoft Visual Fortran，後由Intel接手，並於Intel的開發者工具oneAPI發佈的免費版本。
    ```
     ifort.exe       # Intel Visual Fortran Compiler                          <# Targeted Compiler #>
     ifx.exe         # Intel Visual Fortran Compiler                  <# Targeted Compiler #>
    ```
 - [GNU Compiler Collection(GCC)](../Let's%20Do%20Setup/vscode_Setup(Cygwin).md): GNU作業系統的C/C++語言前端，由GNU組織指導並發行至跨平臺，GFortran為GC編譯器集合之一。GCC以GNU GPL v3.0條款授權公開免費使用。
    ```
     gfortran        # GNU Fortran Compiler                                  <# Targeted Compiler #>

     as              # GNU Binary Utils Assembler
     cpp
     c++
     gcc             # GNU  C  language Frontend                             
     g++             # GNU C++ language Frontend                             
     ld              # Linker
     make            # GNU Makefile Utility
    ```
 - [LLVM/Clang](../Let's%20CMake%20Something/LLVM.md): 原PGI編譯器集合以LLVM架構基底的Fortran編譯器前端，與LLVM官方的Flang相同專案名稱但來源不同。
    ```
     flang.exe       # PGI Open-Sourced LLVM Fortran language frontend       <# Targeted Compiler #>

     clang.exe       # LLVM Compiler Infastructure  C  language frontend    
     lld.exe         # LLVM Compiler Infastructure Linker
     llvm-as         # LLVM Compiler Infastructure Assembler
    ```

 - [NVIDIA HPC SDK](../Let's%20Do%20Setup/vscode_Setup(WSL).md#wsl-%E9%83%A8%E7%BD%B2-nvidia-hpc-sdk): NVIDIA發佈的HPC開發套件，包含GPU加速程式庫、GPU運算科學工具函式庫、以及包含原PGI編譯器集合的NVIDIA C/C++編譯器、NVFortran編譯器執行環境。
    ```
     nvcc            # NVIDIA CUDA Compiler Driver                          
     nvc             # NVIDIA CUDA C Language Frontend                             
     nvc++           # NVIDIA CUDA C++ Language Frontend                    
     nvfortran       # NVIDIA Fortran Language Frontend                      <# Targeted Compiler #>

     pgfortran       # PGI Compiler Collection Fortran Language Frontend
     pgf95           # PGI Compiler Collection Fortran Language Frontend
     pgc++           # PGI Compiler Collection C++ Language Frontend
    ```
 - AMD ROCm: AMD ROCm框架開發工具，Flang僅支援Linux系統。由LLVM基底建構而成，支援HIP API執行AMD GPU偵錯。

## VSCode建置簡單Fortran專案偵錯

以下定義一個專案位置(資料夾)`myFort`，並有以下內容:
 - Folder
 ```
  |
  ├─> test.f90(Fortran語言來源)
  |
  └─> .vscode(資料夾)
         |
         ├─> tasks.json
         |
         └─> launch.json
 ```

### VSCode 建置作業 - tasks.json
VSCode對編譯類型程式進行建置(Build Task)，並會根據所引用條件(包含Include引用標頭檔、LIB引用靜態程式庫等)執行預處理(pre-processing)->編譯(compilation)->彙編->(assembly)->鏈接(linking)程序。該建置作業由`tasks.json`引導vscode設定原始碼建置編譯信息傳遞作業。

以下是基於使用ifort編譯的設定:
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
                 "args": ["/E:ON", "/C", "setvars.bat", "intel64 VS2022", "&&"]
                 }
               }
             },
             "type": "shell",
             "label": "ifort.exe",
             "command": "ifort.exe",
             "args":[
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
          - `args`: 傳遞至該殼層的引數。因為呼叫該殼層並執行建置後需要直接關閉，因此需要`"/E:ON"`、`"/C"`、`"setvars.bat"`、`"intel64 VS2022"`和`"&&"`引數。當中，各引數意義如下:
             - `"/E:ON"`: `cmd.exe`啟用延伸模組。
             - `"/C"`:  執行該殼層所有命令後關閉該`cmd.exe`殼層。
             - `"setvars.bat"`: 呼叫Intel oneAPI環境初始化。`"intel64"`及`"VS2022"`引數傳遞給`setvars.bat`。`setvars.bat`會設定環境變數並遞迴搜尋所安裝的開發人員工具、SDK、程式庫、標頭程式庫等開發必要元件(例如UCRT程式庫位置、include、lib等)。
             - `"intel64"`: 設定本機架構所決定執行的編譯器。因本機架構是x64(Intel 64/AMD64)，故選擇`x64`。
             - `"VS2022"`: 遞迴搜尋Visual Studio開發人員程式的SDK並加入環境變數。
             - `"&&"`: 傳遞一個後接的命令。

            該殼層的起動命令是:
             - Shell
                ```
                cmd.exe /E:ON /C setvars.bat "intel64 VS2022" && ...........
                ```
      - `type`: `shell`(因為該Fortran編譯命令從`cmd.exe`殼層啟動)。
      - `label`: 標籤。你可以叫一個喜歡的名字。
      - `command`:編譯器的檔案名。舉例MSVC就是`cl.exe`.
      - `args`: 傳遞至編譯器內的引數。不同編譯器在`args`JSON清單物件中可有不同引數及排列順序:
        ```
         Intel    ifort.exe:     ["${file}"]
         Intel    ifx.exe:       ["${file}"]

         NVIDIA   nvfortran:     ["${file}", "-o", "$"${fileDirname}/${fileBasenameNoExtension}"]

         GNU      gfortran.exe:       ["-g", "-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]

         LLVM     flang.exe:     ["-g","${file}","-o", "${fileDirname}/${fileBasenameNoExtension}.exe"]
        ```

        調用ifort的命令列為:
         - Shell
            ```
            ifort.exe test.f90
            ```

      - `problemMatcher`: 問題對比器選項。這裡選擇`["$msCompile"]`。
      - `"group"`: 群組定義工作為建置或測試及預設選項。`{"kind": "build", "isDefault": true}`

整體而言，該`tasks.json`呼叫的殼層建置命令為:
 - Shell
    ```
    cmd.exe /E:ON /C setvars.bat "intel64 VS2022" && ifort.exe test.f90
    ```

### VSCode 偵錯執行 - launch.json
執行程式的偵錯由`launch.json`內的訊息配置完成自定義的偵錯測試。執行程式即為對程式執行偵錯。編譯程式可額外設定透過建置後執行偵錯，直譯程式則直接執行。

本範例執行MSVC的偵錯設定:
 - JSON
    ``` 
    {
        "version": "0.2.0",
        "configurations": [
            {
                "name": "ifort.exe",
                "type": "cppvsdbg",
                "request": "launch",
                "program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
                "args": [],
                "stopAtEntry": false,
                "cwd": "${workspaceFolder}",
                "environment": [],
                "console": "integratedTerminal",
                "preLaunchTask": "ifort.exe"
            }
        ]
    }
    ```

當中:

  - `version`: 值預設是`0.2.0`.
  - `configuration`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:

    - `"name"`: 偵錯設定情境的名稱。
    - `"type"`: 選擇`"cppvsdbg"`。因為該執行是執行Fortran專案偵錯，會無視這項設定。
    - `"request"`: 因為是執行，選擇`"launch"`。
    - `"program"`: 偵錯建置的檔案。由`"${fileDirname}/${fileBasenameNoExtension}.exe"`關聯的檔案是經建置出來的目標執行檔(`test.exe`)。
    - `"args"`: 傳遞至該欲偵錯可執行檔的引數。由於沒有引數要傳遞所以為JSON空陣列(`[]`)。
    - `"stopAtEntry"`: 偵錯工具在目標的進入點停止的動作。這裡選擇`false`.
    - `"cwd"`: `"${workspaceFolder}"`
    - `"environment"`: 開啟偵錯時的環境變數設定，例如臨時附加的變數等。由於沒有引數要傳遞所以為JSON空陣列(`[]`)。
    - `"console"`: 取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。有以下的值:
       - `"integratedTerminal"`: 整合式終端機。偵錯結果將在vscode內的終端列印。
       - `"externalTerminal"`: 外部的終端機。該偵錯透過Windows終端機或Windows傳統主控台輸出偵錯。
    - `"preLaunchTask"`: 執行該目標執行檔的偵錯前建置作業。該值必須和tasks.json內的`label`名稱一致或其中一個相符。若有這項設定，則該目標底稿(此處為`test.f90`)會在執行偵錯時，自動先進行建置(依照`tasks.json`)作業。

整體而言，執行對`test.f90`偵錯的流程如下:
 - Shell
    ```
    cmd.exe /E:ON /C setvars.bat "intel64 VS2022" && ifort.exe test.f90
    .\test.exe                                                                                      
    ```
    當中，第一列是`test.f90`建置的命令列，由`preLaunchTask`呼叫並執行。第二列才是執行建置後目標執行檔`test.exe`的偵錯。
