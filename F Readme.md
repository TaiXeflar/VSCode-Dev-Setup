# 以VSCode建置Fortran專案 


## 編譯器確認:  

  - 本存放庫以Windows執行Intel oneAPI Fortran編譯器:  

   Intel Fortran需要以Intel oneAPI套件安裝。
   
    - 如果你要使用Intel的編譯器, 專案內編譯環境需要以`setvars.bat`啟動.

## PATH 路徑確認

  - 範例提及的所有編譯器可在預設安裝的路徑下找到。請把列出的編譯器路徑的資料夾添加至環境變數中(PATH)。

  - Intel Fortran Compiler:

      `PATH`:

      - setvars.bat: "C:/Program Files (x86)/Intel/oneAPI/setvars.bat"
      - ifort.exe: "C:/Program Files (x86)/Intel/oneAPI/compiler/latest/windows/bin/intel64/ifort.exe"

## 設定PATH變數

  - 請把編譯器路徑所在路徑添加至使用者/系統環境變數中。可能需要重新開機。
  - `PATH` = 

        - "C:/Program Files (x86)/Intel/oneAPI/"
        - "C:/Program Files (x86)/Intel/oneAPI/compiler/latest/windows/bin/intel64/"

  - 添加`PATH`變數之後以終端機呼叫該編譯器做為測試。以下是分別呼叫`setvars.bat`和`ifort.exe`的結果: 

    ```
    Windows PowerShell
    Copyright (C) Microsoft Corporation. 著作權所有，並保留一切權利。

    請嘗試新的跨平台 PowerShell https://aka.ms/pscore6

    PS C:\Users\TaiXeflar> setvars
    :: initializing oneAPI environment...
    Initializing Visual Studio command-line environment...
    Visual Studio version 17.3.4 environment configured.
    "C:\Program Files\Microsoft Visual Studio\2022\Community\"
    Visual Studio command-line environment initialized for: 'x64'
    :  compiler -- latest
    :  debugger -- latest
    :  dev-utilities -- latest
    :  mpi -- latest
    :  tbb -- latest
    :: oneAPI environment initialized ::
    PS C:\Users\TaiXeflar>
    ```
    ```
    PS C:\Users\TaiXeflar> ifort
    Intel(R) Fortran Intel(R) 64 Compiler Classic for applications running on Intel(R) 64, Version 2021.6.0 Build 20220226_000000
    Copyright (C) 1985-2022 Intel Corporation.  All rights reserved.

    ifort: command line error: no files specified; for help type "ifort /help"
    PS C:\Users\TaiXeflar>
    ```

## 專案根目錄定義

本範例在Desktop路徑下，定義在一個名為ftest的專案資料夾中有以下內容:
 - .vscode (資料夾)
 - test.f90 (C#來源底稿)

## .vscode資料夾設定

  - 請注意，在VSCode中編輯路徑的時候，使用`/`或`\\`替代`\`.
  - JSON檔案: 你需要2個JSON檔案完成C#環境設定。
    - `tasks.json`: C#/F#/VB底稿進行編譯的設定。
    - `launch.json`: 偵錯C#/F#/VB已編譯的偵錯執行檔.
  
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
                "label": "csc.exe",
                "command": "csc.exe",
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

  當中:
  - `version`:  值預設是`"2.0.0"`。
  - `tasks`: ，JSON清單物件，且包含一個或多個JSON物件。鍵值就像這樣: `"tasks": [{}]`

      - `windows`: 這個鍵值可以在VSCode終端內呼叫環境設定Batch檔。如果你使用MSVC或Intel oneAPI的編譯器才需要呼叫這個鍵值。
          複製`"options": {"shell": {}}`到`windows`鍵值內。有2個鍵值需要設定:
          - `executable`: `cmd.exe`或`powershell.exe`兩個都可以。
          - `args`: `["/C", "setvars.bat", "&&"]`.
      - `type`: `shell`.
      - `label`: 標籤。你可以叫一個喜歡的名字。
      - `command`:編譯器的檔案名。舉例C#就是`csc.exe`，F#就是`fsc.exe`，VB就是`vbc.exe`。
      - `args`: 傳遞至編譯器內的引數。至少需要一個`"${file}"`。
      - `problemMatcher`: `["$msCompile"]`,
      - `"group"`: `{"kind": "build", "isDefault": true}`

 2. launch.json:

  - 以下是VC#的launch tasks示範:
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
    - `"type"`: `"cppvsdbg"`。該適用於C++組態值不影響。
    - `"request"`: `"launch"`.
    - `"program"`: `"${fileDirname}/${fileBasenameNoExtension}.exe"`.
    - `"args"`: [],
    - `"stopAtEntry"`: `false`.
    - `"cwd"`: `"${workspaceFolder}"`
    - `"environment"`: []
    - ` "console"`: `"integratedTerminal"`或`externalTerminal`.取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。
    - `"preLaunchTask"`: 你必須和tasks.json內的`label`名稱一致。

## C#/F#/VB 注意事項

 - 請注意，Fortran是編譯語言，且有多種副檔名(`.f`, `.f90` )。
 - 編譯Fortran語言底稿時，必須在`tasks.json`以`VsDevCmd.bat`初始化開發編譯環境。

## 後言

- 本專案對Visual Studio的建置方法是採建置時以殼層呼叫`setvars.bat` 初始化環境後再以殼層呼叫編譯器本體，與呼叫ICL, MSVC為同一種偷吃步的做法。