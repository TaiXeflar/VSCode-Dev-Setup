# 以VSCode建置Fortran專案 

## 專案執行環境

我們建議在以下硬體配置中，執行基於Windows 10/11環境的Fortran專案:

  |  配置等級  |  CPU  |  GPU  |  RAM  |  SSD  |  OS  |
  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |
  |  基本配置  |  4C8T  |  iGPU  |  8GB  |  128GB  |  Windows 10/11  |
  |  建議配置  |  6C12T  |  dGPU, 2GB  |  16GB  |  256GB  |  Windows 10/11  |
  |  高階配置  |  6C12T  |  dGPU, 6GB  |  32GB  |  512GB  |  Windows 10/11  |

  - CPU配置建議應支援超執行緒(Hyper-Threading)。
  - 請注意，Intel第12代處理器(Intel Core 12th Gen)後採用大小核設計，其中效能核心(P-Core)支援超執行緒，效率核心(E-Core)則不支援。因此可能出現執行緒數量不等於原雙倍核心數量的結果。
     - 例如在 Intel Core i7-12700H中，核心分配為 6P8E， 執行緒最大數量 = 6x2 + 8x1 = 12+8 = 20。
  - 請注意，Intel oneAPI在CPU上運行的套件適用於所有64位元的x86系列處理器。這意味著你可以在Intel及AMD處理器上運行Intel Fortran。
  - 請注意，適用於Windows的AMD Radeon顯示卡(包含iGPU及dGPU)不支援CUDA GPU。

## 編譯器確認:  

  - 本存放庫以Windows執行Intel oneAPI Fortran編譯器:  

     - Intel Fortran需要以Intel oneAPI套件安裝。整合至Visual Studio需要Visual C++的工具(VS2022 C++桌面開發)。
         - 整合至Visual Studio之前，Visual Studio必須在安裝後初始化。 

        該Intel oneAPI Fortran整合至Visual Studio所要求Visual C++的具備先行工作負載是：
          - MSVC v143
          - MSVC v143 ALT
          - Windows 11 SDK (latest)
          - Windows 10 SDK (x3)
          - C++ AddressSanitizer
          - Clang for Windows
          - CMake for Windows C++ 
          - Windows SDK C++

    

  - 本存放庫以Windows執行GNU Fortran編譯器:
     - 本GFortran透過Cygwin MinGW64安裝。

## PATH 路徑確認

  - Intel Visual Fortran Compiler:

    由於開發人員命令提示字元`setvars.bat`會自動配置環境變數(例如`INCLUDE`，`LIB`等)，在`setvars.bat`初始化後的殼層環境會加入編譯器/標頭檔/程式庫等路徑。

    Intel Fortran(`ifort.exe`)可直接透過`setvars.bat`傳遞呼叫，因此，我們直接把`setvars.bat`的路徑加入至PATH中即可。

    `PATH`:

    - setvars.bat: "C:/Program Files (x86)/Intel/oneAPI/setvars.bat"

## 設定PATH變數

  - 請把環境變數設定批次檔(`setvars.bat`)的路徑所在路徑添加至使用者/系統環境變數中。可能需要重新開機。
     - `C:/Program Files (x86)/Intel/oneAPI/`


  - 添加`PATH`變數之後以終端機呼叫該編譯器做為測試。本範例示範由CMD啟動Intel 64開發人員命令提示字元，調用PowerShell後呼叫ifort。
     ```
     cmd.exe /E:ON /K setvars.bat && powershell.exe -noexit
     ```

    開啟殼層後呼叫`ifort.exe`的結果: 

    ```
    PS C:\Users\TaiXeflar> ifort
    Intel(R) Fortran Intel(R) 64 Compiler Classic for applications running on Intel(R) 64, Version 2021.6.0 Build 20220226_000000
    Copyright (C) 1985-2022 Intel Corporation.  All rights reserved.

    ifort: command line error: no files specified; for help type "ifort /help"
    PS C:\Users\TaiXeflar>
    ```

## 專案根目錄定義

本範例在Desktop路徑下，定義在一個名為ifort/gfort的專案資料夾中有以下內容:
 - .vscode (資料夾)
 - test.f90 (Fortran 來源底稿)

## .vscode資料夾設定

 - 如果你要使用Intel的編譯器, 專案內編譯環境需要以`setvars.bat`啟動.

  - 請注意，在VSCode中編輯路徑的時候，使用`/`或`\\`替代`\`.
  - JSON檔案: 你需要2個JSON檔案完成Fortran的編譯環境設定。
    - `tasks.json`: Fortran底稿進行編譯的設定。
    - `launch.json`: 偵錯Fortran已編譯的偵錯執行檔.
  
 1. tasks.json:

 - 以下是Intel Fortran的build tasks示範:
    ```
    {
        "version": "2.0.0",
        "tasks": [
            {
                "windows":{
                    "options": {
                        "shell": {
                            "executable": "cmd.exe",
                            "args": ["/C", "setvars.bat", "&&"]
                        }
                    }
                },
                "type": "shell",
                "label": "ifort.exe",
                "command": "ifort.exe",
                "args": 
                [
                    "${file}", 
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

 - 以下是gfortran的build tasks示範:
    ```
    {
        "version": "2.0.0",
        "tasks": [
            {
                "type": "shell",
                "label": "gfort.exe",
                "command": "gfortran.exe",
                "args": 
                [
                    "-O",
                    "-o",
                    "${fileBasenameNoExtension}.exe",
                    "${file}"
                ],
                "problemMatcher": ["$gcc"],
                "group": {
                    "kind": "build",
                    "isDefault": true
                }
            }
        ]
    }
    ```

 2. launch.json:

  - 以下是Intel Fortran的launch tasks示範:
  ```
    {
        "version": "0.2.0",
        "configurations": [
            {
                "name": "ifort.exe",
                "type": "cppvsdbg",
                "request": "launch",
                "program": "${fileDirname}/${fileBasenameNoExtension}.exe",
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

  - 以下是GFortran的launch tasks示範:
    ```
    {
        "version": "0.2.0",
        "configurations": [
            {
                "name": "gfort.exe",
                "type": "cppvsdbg",
                "request": "launch",
                "program": "${fileDirname}/${fileBasenameNoExtension}.exe",
                "args": [],
                "stopAtEntry": false,
                "cwd": "${workspaceFolder}",
                "environment": [],
                "console": "integratedTerminal",
                "preLaunchTask": "gfort.exe"
            }
        ]
    }
    ``` 

## Fortran 注意事項

 - 請注意，Fortran是編譯語言，且有多種副檔名(`.f`, `.f90`,`.FOR`等)。
 - 編譯Intel Fortran語言底稿時，必須在`tasks.json`以`setvars.bat`初始化開發編譯環境。

## 後言

- 本專案對Visual Studio的建置方法是採建置時以殼層呼叫`setvars.bat` 初始化環境後再以殼層呼叫編譯器本體，與呼叫ICL, MSVC為同一種偷吃步的做法。