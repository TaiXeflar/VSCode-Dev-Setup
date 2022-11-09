# 以VSCode建置C#/F#/VB專案 

## 專案執行環境

我們建議在以下硬體配置中，執行基於Windows 10/11環境的Python專案:

  |  配置等級  |  CPU  |  GPU  |  RAM  |  SSD  |  OS  |
  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |
  |  基本配置  |  4C8T  |  iGPU  |  8GB  |  128GB  |  Windows 10/11  |
  |  建議配置  |  6C12T  |  dGPU, 2GB  |  16GB  |  256GB  |  Windows 10/11  |
  |  高階配置  |  6C12T  |  dGPU, 6GB  |  32GB  |  512GB  |  Windows 10/11  |

  - CPU配置建議應支援超執行緒(Hyper-Threading)。
  - 請注意，Intel第12代處理器(Intel Core 12th Gen)後採用大小核設計，其中效能核心(P-Core)支援超執行緒，效率核心(E-Core)則不支援。因此可能出現執行緒數量不等於原雙倍核心數量的結果。
  - 例如在 Intel Core i7-12700H中，核心分配為 6P8E， 執行緒最大數量 = 6x2 + 8x1 = 12+8 = 20。

## 編譯器確認

  - 本存放庫以Windows執行3種不同的Visual .NET語言編譯器:  

   1. C# (Microsoft Visual C Sharp)。

   2. F# (Microsoft Visual F Sharp)。

   3. VB (Microsoft Visual Basic)。

## 編譯器安裝

 - Visual C#, F# 及Visual Basic為.NET環境下程式語言，限定由Visual Studio環境安裝。

 - 勾選 "**.NET桌面開發**"並選擇:

   - C# 與 Visual Basic
   
   - F# 語言支援

## PATH 路徑確認

  - 範例提及的所有編譯器可在預設安裝的路徑下找到。請把列出的環境初始化執行檔/編譯器/直譯器路徑的資料夾添加至環境變數中(PATH)。

    - Microsoft Visual Studio Development Command Prompt:

      `PATH`:

      - VsDevCmd.bat : "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/Tools/VsDevCmd.bat"

    - Microsoft Visual C# :

      `PATH`:
      - C# compiler: `csc.exe` "C:/Program Files/Microsoft Visual Studio/2022/Community/MSBuild/Current/Bin/Roslyn/csc.exe"
      - C# REPL interactive: `csi.exe` "C:/Program Files/Microsoft Visual Studio/2022/Community/MSBuild/Current/Bin/Roslyn/csi.exe"

    - Microsoft Visual F# compiler:

      `PATH`:

      - F# compiler: `fsc.exe` "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/IDE/CommonExtensions/Microsoft/FSharp/Tools/fsc.exe"
      - F# interactive: `fsi.exe` "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/IDE/CommonExtensions/Microsoft/FSharp/Tools/fsi.exe"

    - Microsoft Visual Basic compiler:

      `PATH`:

      - vbc.exe: "C:/Program Files/Microsoft Visual Studio/2022/Community/MSBuild/Current/Bin/Roslyn/vbc.exe"

## 設定PATH變數

  - 請把編譯器路徑所在路徑添加至使用者/系統環境變數中。可能需要重新開機。以MSVC的cl.exe(VS2022 v143)為例:
    - `PATH` = "C:/Program Files/Microsoft Visual Studio/2022/Community/MSBuild/Current/Bin/Roslyn/"

  - 添加`PATH`變數之後以終端機呼叫該編譯器。以Visual C#的csc.exe為例: 
    - PS> csc

    若成功的話會在終端機看到以下內容:
    ```
    PS C:\Users\TaiXeflar> csc
    Microsoft (R) Visual C# 編譯器 版 4.3.0-3.22423.10 (b35bb0ba)
    Copyright (C) Microsoft Corporation. 著作權所有，並保留一切權利。

    warning CS2008: 未指定任何原始程式檔。
    error CS1562: 沒有來源的輸出必須有指定的 /out 選項
    ```
    
## VSCode延伸套件 

在可能的前提下，你可能需要安裝延伸套件:

  - C#

## 專案根目錄定義

本範例在Desktop路徑下，定義在一個名為cstest的專案資料夾中有以下內容:
 - .vscode (資料夾)
 - test.cs (C#來源底稿)

## .vscode資料夾設定

  - 請注意，在VSCode中編輯路徑的時候，使用`/`或`\\`替代`\`.
  - JSON檔案: 你需要2個JSON檔案完成C#環境設定。
    - `tasks.json`: C#/F#/VB底稿進行編譯的設定。
    - `launch.json`: 偵錯C#/F#/VB已編譯的偵錯執行檔.
  
 1. tasks.json:

 - 以下是VC#的build tasks示範:
    ```
    {
        "version": "2.0.0",
        "tasks": [
            {
                "windows":{
                    "options": {
                        "shell": {
                            "executable": "cmd.exe",
                            "args": ["/C", "VsDevCmd.bat", "&&"]
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
          - `args`: `["/C", "VsDevCmd.bat", "&&"]`.
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
                "name": "chashtag",
                "type": "coreclr",
                "request": "launch",
                "program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
                "args": [],
                "stopAtEntry": false,
                "cwd": "${workspaceFolder}",
                "console": "integratedTerminal",
                "preLaunchTask": "csc.exe"
            
            }
        ]
    }
  ```
  當中:

  - `version`: 值預設是`0.2.0`.
  - `configuration`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:

    - `"name"`: 偵錯設定情境的名稱。
    - `"type"`: `"coreclr"`.
    - `"request"`: `"launch"`.
    - `"program"`: `"${fileDirname}/${fileBasenameNoExtension}.exe"`.
    - `"args"`: [],
    - `"stopAtEntry"`: `false`.
    - `"cwd"`: `"${workspaceFolder}"`
    - ` "console"`: `"integratedTerminal"`或`externalTerminal`.取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。
    - `"preLaunchTask"`: 你必須和tasks.json內的`label`名稱一致。

## C#/F#/VB 注意事項

 - 請注意C#，F#以及Visual Basic是編譯語言。
 - 編譯C#/F#/VB語言底稿時，必須在`tasks.json`以`VsDevCmd.bat`初始化開發編譯環境。

## 後言

- 本專案對Visual Studio的建置方法是採建置時以殼層呼叫`VsDevCmd.bat`/`setvars.bat` 初始化環境後再以殼層呼叫編譯器本體，與呼叫MSVC為同一種偷吃步的做法。