# VSCode的JSON檔配置個人化及程式碼建置和執行

## JSON語法

JSON全名JavaScript Option Notation，為一種半結構式的訊息交換的程式語言。

由於結構容易理解，因此是繼XML結構後新的後繼者。從VSCode的設定，到Jupyter筆記本的訊息紀錄，再到Minecraft的資料包訊息設置均由JSON格式設定完成。

首先稍微理解一下JSON內的物件形式:
 - JSON鍵值: 由一對鍵值(Key-Pair Value)形成。
    ```
    "author": "TaiXeflar"
    ```
    範例中，鍵是`"author"`，值是`"TaiXeflar"`。
    
    其中，值可以是:
     - 字串(以雙引號`""`為字串值，空字串也可以)。
     - 數值(整數或浮點數)。
     - 布林值 `true`, `false`。
     - 空物件 `null`。
     - JSON物件 `{}`。
     - JSON陣列 `[]`。

 - JSON物件: 該物件為一組大擴號(花擴號) `{}`。JSON物件內可以是:
     - JSON鍵值
     
 - JSON陣列: 該物件為一組中擴號(方擴號) `[]`。JSON陣列內可以是:
     - JSON陣列
     - JSON物件
     - 字串值
     - 數值 (整數或浮點數)
     - 布林值 `true`, `false`
     - 空物件 `null`

 - JSON註解: 該註解形式限在`.jsonc`上才能以`//`標記註解。在`.json`中加入註解是違法的。
     - 參考 **VSCode的個人化設定** 以設定將json關聯至jsonc的方法。

無論任何被包含在內物件，均需以逗號分隔(最後一個物件不能有逗號)，鍵值的鍵或是字串需要以雙引號`""`為合法。

以下是一個JSON檔案範例:
```
{                                       // JSON 註釋就是加上//形成單行註釋
    "Units":                        // 加上這行註釋就是違反JSON語法了
    [                                   // 參考"VSCode的個人化設定"以設定將json關聯至jsonc的方法
        {                              // 這樣才可以光明正大地寫註釋而不會被告知違反語法
            "name": "user1",
            "id": 1,
            "boss": true
        },
        {
            "name": "user2",
            "id": 2,
            "boss": false
        },
        {
            "name": "user3",
            "id": 3,
            "boss": false
        },
    ]
}
```

## 以JSON編輯VSCode的個人化設定

在settings.json中，僅有一個空的JSON物件。我們會逐步添加下列解說的鍵值。

常見的設定項:
 - `"editor.mouseWheelZoom"`: 布林值(`true` / `false`)。允許透過`Ctrl+滑鼠滾輪`放大/縮小工作區字體大小。
 - `"editor.fontFamily"`: 工作區的字體家族。此處範例為"Xolonium"字體(ROG官方字體)。
      ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_Fonts.png)

      你可以使用`銀河標準字母`惡整別人的電腦成 **"被附魔台附魔過"** 的樣子:
      ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_Fonts_Enchanted.png)

      請注意這個JSON鍵值不具有Intellisense自動選字，因此需自行手動確認該字體名稱是否輸入正確。
 - `"editor.fontWeight"`: 字體粗細程度，允許**一般**及**粗體**字體，不允許**斜體**。
 - `"terminal.integrated.fontFamily"`: VSCode內鍵終端機的字體。請注意**僅能使用等寬字體**。

      若使用非等寬字體則會讓終端機看起來像被撇開的bug出現。
         ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_integratedTerminal_Fonts_cracked1.png)
         ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_integratedTerminal_Fonts_cracked.png)

 - `"workbench.startupEditor"`: 控制在啟動時顯示哪個編輯器，若沒有(`"none"`)，則從上個工作階段還原。這意味著VSCode會開啟你上次最後一個工作狀態。
 - `"workbench.colorTheme"`: 主題色彩。
 - `"files.associations"`: 設定檔案關聯性。可覆寫預設關聯設定。以下提供一段範例:

      ```
      "files.associations": {"*.json": "jsonc"}
      ```
      這段程式碼的含意是，允許VSCode將json檔案關聯至jsonc檔案，從而允許在json檔案內以`//`撰寫註釋。

 - `"terminal.integrated.profiles.windows"`: 在Windows底下自定義VSCode內終端機的下拉式選單，值為自定義且包含特定子鍵值的JSON物件。
    
        以下是Windows環境下的VSCode整合式終端機的預設值:
        ```
        "terminal.integrated.profiles.windows": {
        "PowerShell": {
            "source": "PowerShell",
            "icon": "terminal-powershell"
        },
        "Command Prompt": {
            "path": [
                "${env:windir}/Sysnative/cmd.exe",
                "${env:windir}/System32/cmd.exe"
            ],
            "args": [],
            "icon": "terminal-cmd"
        },
        "Git Bash": {
            "source": "Git Bash"
        }
        ```

        預設會有`PowerShell`, `Command Prompt`兩個JSON物件。事實上，JSON物件可以是你隨意指定的內容。若是在VSCode安裝後再安裝Git，則會自動建立可呼叫Git的終端設定檔。

      下列以**手動建立**設定檔為範例。
      
      - 建立Cygwin環境Bash，並啟動目錄位置在`/home/USER/`為例: (`USER`是你的使用者名稱)
        ```
            "Cygwin Bash": 
            {            
                "path": ["C:/cygwin64/bin/bash.exe"],
                "args": ["--login", "-i"]
                "icon": "console"
            }
        ```
        
        當中:
        - `"source"`鍵值可以自動偵測殼層路徑的設定檔來源。因為Cygwin在非標準可執行位置，因此以`"path"`取代。
        - `"path"`為殼層可執行檔的檔案位置。你可以直接填入殼層可執行檔的檔案路徑，或是以JSON陣列填入多個可執行檔。
        - `"args"` 為要傳遞到該殼層內的參數或引數(flags)，使用JSON清單包含所有要被傳遞的引數。
        - `"icon"`為顯示於下拉式清單的圖示。

     - 建立Visual Studio 2022的開發人員命令提示字元:
        ```
            "VS2022 CMD": 
            {            
                "path": ["C:/Program Files/Microsoft Visual Studio/2022/Common7/Tools/VsDevCmd.bat"],
                "args": [""]
                "icon": "console"
            }
        ```


 - `"terminal.integrated.profiles.osx"`: 在macOS底下自定義VSCode內終端機的下拉式選單，值為自定義且包含特定子鍵值的JSON物件。

    以下是macOS環境下的VSCode整合式終端機的預設值:
    ```
    "terminal.integrated.profiles.osx":{
        "bash": {
            "path": "bash",
            "args": ["-l"],
            "icon": "terminal-bash"
        },
        "zsh": {
            "path": "zsh",
            "args": ["-l"]
        },
        "fish": {
            "path": "fish",
            "args": ["-l"]
        },
        "tmux": {
            "path": "tmux",
            "icon": "terminal-tmux"
        },
        "pwsh": {
            "path": "pwsh",
            "icon": "terminal-powershell"
        }
    }
    ```

    預設會有`BASH`(Borune Again Shell), `ZSH`(Z Shell), `FISH`(Friendly Interactive Shell), `tmux`等4個JSON物件。
      
 - `"files.autoSave"`: 設定自動存檔的觸發時機，共有4個選項可以選擇。
  
     - `"off"`: 關閉自動存檔的功能。若`"files.autoSave"`選項不存在則亦視為不自動存檔。
     - `"afterDelay"`: 設定自動存檔的延遲時間。若`"files.autoSaveDelay"`設定鍵值不存在時，預設是1000毫秒(即1秒)。
     - `"onFocusChange"`: 設定成該編輯檔案若失去焦點(當你在VSCode內切換其他已開啟的檔案標籤)時自動儲存。
     - `"onWindowsChange"`: 設定成該VSCode視窗若失去焦點(當你切換其他應用程式視窗)時自動儲存。

 - `"files.autoSaveDelay"`: 設定自動存檔的延遲時間，以毫秒為單位。預設是1000。

 - `"explorer.confirmDelete"`: 在左側的檔案總管中刪除檔案時，是否跳出互動視窗確認刪除該檔案。
 - `"security.workspace.trust.untrustedFiles"`: 是否信任工作區內未受信任的檔案。

筆者以自用的VSCode範例提供完整的settings.json參考 :
 
```
{
    "editor.mouseWheelZoom": true,
    "editor.fontFamily": "Xolonium, Microsoft JHengHei UI, Consolas",
    "editor.fontWeight": "normal",
    "terminal.integrated.fontFamily": "Consolas",
    "terminal.integrated.fontSize": 16,
    "git.confirmSync": false,
    "git.autofetch": true,
    "git.enableSmartCommit": true,
    "workbench.startupEditor": "none",
    "security.workspace.trust.untrustedFiles": "open",
    "explorer.confirmDelete": true,
    "files.autoSave": "afterDelay",
    "files.autoSaveDelay": 100,
    "files.associations": {
        "*.json": "jsonc"
    },
    "workbench.colorTheme": "Visual Studio Dark",
    "terminal.integrated.profiles.windows": {
        "PowerShell": {
            "source": "PowerShell",
            "icon": "terminal-powershell"
        },
        "Command Prompt": {
            "path": [
                "${env:windir}/Sysnative/cmd.exe",
                "${env:windir}/System32/cmd.exe"
            ],
            "args": ["/E:ON"],
            "icon": "terminal-cmd"
        },
        "Git Bash": {
            "source": "Git Bash"
        },
        "Cygwin Bash": 
        {            
            "path": ["C:/cygwin64//bin/bash.exe"],
            "args": ["--login", "-i"],
            "icon": "console"
        }
    },
    "terminal.integrated.profiles.osx": {

        "bash": {
            "path": "bash",
            "args": ["-l"],
            "icon": "terminal-bash"
        },
        "zsh": {
            "path": "zsh",
            "args": ["-l"]
        },        
        "pwsh": {
            "path": "pwsh",
            "icon": "terminal-powershell"
        },
    }   
}
```

## 以JSON自定義VSCode的建置工作(Build Task)

對於需要建置的程式語言，其執行程式語言前的作業極為建置工作。
 - 例如需要編譯的語言: C/C++，Obj-C/C++，Fortran，VB，C#，F# 等。

執行程式的建置由`tasks.json`內的訊息配置完成自定義的建置流程。該`tasks.json`路徑在專案資料夾底下的`.vscode`資料夾內。

本範例執行MSVC的建置`test.c`偵錯:
```
{
    "version": "2.0.0",
    "tasks": 
    [
      {
        "windows":
        {
          "options": {
            "shell": {
              "executable": "cmd.exe",
              "args": ["/E:ON", "/C", "VsDevCmd.bat", "&&"]
              }
            }
          },
          "type": "shell",
          "label": "cl.exe",
          "command": "cl.exe",
          "args": ["/Fe:", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"],
          "problemMatcher": ["$msCompile"],
          "group": {"kind": "build", "isDefault": true}
      }
    ]
}
```
當中:
  - `version`:  值預設是`"2.0.0"`。
  - `tasks`: ，JSON陣列物件，且包含一個或多個JSON物件。

      - `windows`: 特殊的鍵值設定。該鍵值透過`"options"`的JSON鍵值建立用來呼叫一個殼層`"shell"`執行環境，此處呼叫Visual Studio環境初始化(`VsDevCmd.bat`)。
          - `executable`: 殼層可執行檔。建議使用`cmd.exe`(例如Intel oneAPI沒有PowerShell的支援)。
          - `args`: 傳遞至該殼層的引數。因為呼叫該殼層並執行建置後需要直接關閉，因此需要`"/E:ON"`, `"/C"`, `"VsDevCmd.bat"`, `"&&"`引數。當中，各引數意義如下:
             - `"/E:ON"`: `cmd.exe`啟用延伸模組。
             - `"/C"`:  執行該殼層所有命令後關閉該`cmd.exe`殼層。
             - `"VsDevCmd.bat"`: 呼叫Visual Studio環境初始化。
             - `"&&"`: 傳遞一個後接的命令。

            該殼層的起動命令是:
             - Shell
                ```
                cmd.exe /E:ON /C VsDevCmd.bat && ...........
                ```

      - `type`: `shell`(因為該C/C++編譯命令從`cmd.exe`殼層啟動)。
      - `label`: 標籤。你可以叫一個喜歡的名字。
      - `command`:編譯器的檔案名。舉例MSVC就是`cl.exe`.
      - `args`: 傳遞至編譯器內的引數。不同編譯器在`args`JSON清單物件中有不同引數及排列順序:
        ```
        MSVC cl.exe: ["/Fe:", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
        Intel dpcpp.exe: ["-o", "${fileDirname}/${fileBasenameNoExtension}.exe","/Zi","/EHsc", "${file}"]
        Intel icl.exe: ["-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
        Intel icx.exe: ["-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
        CUDA nvcc.exe: ["-g", "${file}", "-o", "${fileDirname}/${fileBasenameNoExtension}"]
        GNU gcc.exe: ["-g", "-o", "${fileDirname}/${fileBasenameNoExtension}.exe", "${file}"]
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
    cmd.exe /E:ON /C VsDevCmd.bat && cl.exe /Fe: test.exe test.c
    ```

## 以JSON自定義VSCode的執行工作(Launch Task)

執行程式的偵錯由`launch.json`內的訊息配置完成自定義的偵錯測試。該`launch.json`路徑在專案資料夾底下的`.vscode`資料夾內。

執行程式即為對程式執行偵錯。編譯程式可額外設定透過建置後執行偵錯，直譯程式則直接執行。

本範例執行MSVC的偵錯設定:
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
          - `externalTerminal`: 外部的終端機。該偵錯透過Windows終端機或Windows傳統主控台輸出偵錯。
    - `"preLaunchTask"`: 執行該目標執行檔的偵錯前建置作業。該值必須和tasks.json內的`label`名稱一致或其中一個相符。
          - 若有這項設定，則該目標底稿(此處為`test.c`)會在執行偵錯時，自動先進行建置(依照`tasks.json`)作業。

整體而言，執行對`test.c`偵錯的流程如下:
 - Shell
    ```
    cmd.exe /E:ON /C VsDevCmd.bat && cl.exe /Fe: test.exe test.c
    .\test.exe                                                                                      
    ```
    當中，第一列是`test.c`建置的命令列，由`preLaunchTask`呼叫並執行。第二列才是執行建置後目標執行檔(test.exe)的偵錯。

本範例再執行一個Python的執行偵錯設定(執行`test.py`):


```
{
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Python: Current File",
            "type": "python",
            "request": "launch",
            "program": "${file}",
            "console": "integratedTerminal",
            "justMyCode": true
        }
    ]
}
```
當中:

- `version`: 值預設是`0.2.0`.
- `configurations`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:
      - `"name"`: `"Python: Current"`。
      - `"type"`: 偵錯類型。這裡選擇`"python"`。
      - `"request"`: 因為是執行，所以選擇`"launch"`。
      - `"program"`: `"${file}"`. 該鍵值`"${file}"`對應至欲偵錯的Python底稿(對應至本存放庫即為`test.py`)。
      - ` "console"`: `"integratedTerminal"`或`externalTerminal`。
      - `"justMyCode"`: 限偵錯由vscode使用者所寫的程式碼。這裡選擇`true`。


## 以JSON自定義VSCode的C/C++特性設定(Properties)

C/C++的特性設定由`c_cpp_properties.json`配置完成自定義的程式庫訊息。該`c_cpp_properties.json`路徑在專案資料夾底下的`.vscode`資料夾內。

本範例執行MSVC的C++特性設定。

以下是MSVC的C/C++ properties示範:

  ```
    {
        "version": 4,
        "configurations": [
            {
                "name": "Win32",
                "includePath": [
                    "${workspaceFolder}/**"
                ],
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

當中:
  - `version`: 值預設是`4`。
  - `configurations`: C/C++的確認信息，由JSON清單物件(`[]`)組成，且包含一個或多個JSON物件(`{}`)。

  在`configurations`的JSON物件下(`{}`)有以下鍵值:

  - `name`: `Win32`.你要叫甚麼都可以，但像`Win32`, `Linux`, `Mac`是特殊識別態，依照你的作業系統為準。
  - `includePath`: 你的程式庫的包含路徑，例如`stdio.h`等標頭檔路徑位置等，由JSON清單物件(`[]`)傳遞。
      - 若是有包含在專案根目錄底下的標頭檔(headers)則填入`"${workspaceFolder}/**"`。其中`/**`代表對該路徑下的遞迴搜尋。
  - `defines`:JSON清單物件(`[]`)。當中包含: `"_DEBUG"`, `"UNICODE"`, `"_UNICODE"`.
  - `WindowsSDKVersion`: `10.0.22000.0`. 你可以換成其他的版本號。
  - `compilerPath`: 編譯器的絕對路徑。 
  - `cStandard`: 編譯器的C標準。若是不知道則以`${Default}`替代。該設定值可依據該編譯器的標準提供更準確的Intellisense。
  - `cppStandard`: 編譯器的C++標準。若是不知道則以`${Default}`替代。該設定值可依據該編譯器的標準提供更準確的Intellisense。
  - `"intelliSenseMode"`: 依照你的編譯器選擇Intellisensea模式。該範例為Windows x64下執行MSVC。
      - 作業系統: 例如`Windows`/`macOS`/`Linux`。
      - 編譯器: 例如`msvc`/`clang`/`gcc`。
      - 處理器架構: 例如 `x86`(32位元x86)/`x64`(64位元x86，AMD64或Intel 64)/`ARM64`(ARM架構64位元處理器)。
