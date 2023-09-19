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
     - 參考 **以JSON編輯VSCode的個人化設定** 以設定將json關聯至jsonc的方法。

無論任何被包含在內物件，均需以逗號分隔(最後一個物件不能有逗號)，鍵值的鍵或是字串需要以雙引號`""`為合法。

以下是一個JSON檔案範例:
```
{                                       // JSON 註釋就是加上//形成單行註釋
    "Units":                            // 加上這行註釋就是違反JSON語法了
    [                                   // 參考"VSCode的個人化設定"以設定將json關聯至jsonc的方法
        {                               // 這樣才可以光明正大地寫註釋而不會被告知違反語法
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
 - `"editor.fontFamily"`: 工作區的字體家族。

     - JSON
     ```
        "editor.fontFamily": "Font1, Font2, 'Font 3', 'Font 4'"
     ```
    該鍵值可由逗號傳遞一組以上的字體設定；字體名稱有空格則以單引號括住傳遞。若第一順位的字體找不到實則由第二順位遞補。

    此處範例為"Xolonium"字體(ROG官方字體)。
      ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_Fonts.png)

      你可以使用`銀河標準字母`惡整別人的電腦成 **"被附魔台附魔過"** 的樣子:
      ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_Fonts_Enchanted.png)

    請注意這個JSON鍵值不具有Intellisense自動選字，因此需自行手動確認該字體名稱是否輸入正確。
    以下是特殊字體樣式參考:
     - Xolonium: ROG官方字體(RTX 30系以前主題)。
     - ROG Fonts: ROG官方標頭/萬國碼字體。
     - GeForce: NVIDIA GeForce GTX/RTX字體(RTX 30系以前主題)。
     - IntelOne Display: Intel新版主題格式(Intel Core 11代以後)。
     - Klavika: AMD官網標準字體。
     - Helvetica: Apple官網及Apple產品的標準字體。
     - Minecraft: Minecraft遊戲內標準字體。
     - Minecraft Enchantment: Minecraft遊戲內附魔字體。該字體為銀河標準字母。
     - Aurebesh: 星際大戰(Star Wars)世界觀字體。
     - Rainbow: 虹彩六號圍攻行動(Rainbow Six Siege)的主題字體。
     - HYWenHei 85: 原神(Genshin Impact)官方主題字體。
     - Microsoft JHengHei UI: 微軟正黑體。
     - Consolas: VSCode內標準字體(第一順位)。

 - `"editor.fontWeight"`: 字體粗細程度，允許**一般**及**粗體**字體，不允許**斜體**。
 - `"terminal.integrated.fontFamily"`: VSCode內鍵終端機的字體。請注意**僅能使用等寬字體**。

      若使用非等寬字體則會讓終端機看起來像被撇開的bug出現。
         ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_integratedTerminal_Fonts_cracked1.png)
         ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_integratedTerminal_Fonts_cracked.png)

 - `"workbench.startupEditor"`: 控制在啟動時顯示哪個編輯器，若沒有(`"none"`)，則從上個工作階段還原。這意味著VSCode會開啟你上次最後一個工作狀態。
 - `"workbench.colorTheme"`: 主題色彩。
 - `"files.associations"`: 設定檔案關聯性。可覆寫預設關聯設定。以下提供一段範例:
     - JSON
     ```
         "files.associations": {
            "*.json": "jsonc",
            "*.m": "matlab"
         }
     ```
    這段程式碼的含意是:
    1. 允許VSCode將json檔案關聯至jsonc檔案，從而允許在json檔案內以`//`撰寫註釋。
    2. 允許VSCode將m檔案關聯至Matlab M-Files。 (原`.m`檔案關聯至Objective-C來源檔案。)

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
        }
    ```

    預設會有`PowerShell`, `Command Prompt`兩個JSON物件。事實上，JSON物件可以是你隨意指定的內容。若是在VSCode安裝後再安裝Git，則會自動建立可呼叫Git的終端設定檔。

      下列以**手動建立**設定檔為範例。
      
      - 建立Cygwin環境Bash，並啟動目錄位置在`/home/USER/`為例(`USER`是你的使用者名稱): {**請務必確認你的路徑到底在哪裡。**}
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
                "args": ["host_arch=x64", "arch=x64"]
                "icon": "console"
            }
        ```


 - `"terminal.integrated.profiles.osx"`: 在macOS底下自定義VSCode內終端機的下拉式選單，值為自定義且包含特定子鍵值的JSON物件。

    以下是macOS環境下的VSCode整合式終端機的預設值:
    ```
    "terminal.integrated.profiles.osx":{
        "zsh": {
            "path": "zsh",
            "args": ["-l"]
        },
        "bash": {
            "path": "bash",
            "args": ["-l"],
            "icon": "terminal-bash"
        },
        "fish":{
            "path": "fish"
            "args": ["-l"]
        },
        "tmux":{
            "path": "tmux",
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

 - JSON
 
    ```
        {
            "editor.mouseWheelZoom": true,
            "editor.fontFamily": " '-Xolonium', 'HYWenHei 85W', Consolas, Microsoft JHengHei UI",
            "editor.fontWeight": "normal",
            "editor.fontSize": 18,
            "terminal.integrated.fontFamily": "Consolas",
            "terminal.integrated.fontSize": 18,
            "git.confirmSync": false,
            "git.autofetch": true,
            "git.enableSmartCommit": true,
            "workbench.startupEditor": "none",
            "security.workspace.trust.untrustedFiles": "open",
            "explorer.confirmDelete": true,
            "files.autoSave": "afterDelay",
            "files.autoSaveDelay": 100,
            "files.associations": {
                "*.m": "matlab",
                "*.json": "jsonc",
            },
            "workbench.colorTheme": "Visual Studio Dark",
            "terminal.integrated.profiles.windows": {
                "PowerShell": {
                    "source": "PowerShell",
                    "icon": "terminal-powershell"
                },
                "PowerShell for VS2022": {
                    "source": "PowerShell",
                    "args": ["-NoExit", "-Command", "&{Import-Module 'C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/Tools/Microsoft.VisualStudio.DevShell.dll'; Enter-VsDevShell 8f5c46dc -SkipAutomaticLocation -DevCmdArguments '-arch=x64 -host_arch=x64'}"]
                },
                "PowerShell for intel oneAPI": {
                    "path": [
                        "${env:windir}/Sysnative/cmd.exe",
                        "${env:windir}/System32/cmd.exe"
                    ],
                    "args": ["/E:ON", "/K", "setvars.bat", "intel64 VS2022", "&&", "powershell.exe", "-nologo"]
                },
                "Command Prompt": {
                    "path": [
                        "${env:windir}/Sysnative/cmd.exe",
                        "${env:windir}/System32/cmd.exe"
                    ],
                    "args": ["/E:ON"],
                    "icon": "terminal-cmd"
                },
                "Cygwin Bash": 
                {            
                    "path": ["C:/Program Files/Cygwin/bin/bash.exe"],
                    "args": ["--login", "-i"],
                    "icon": "console"
                },
                "Cygwin Zsh": 
                {            
                    "path": ["C:/Program Files/Cygwin/bin/zsh.exe"],
                    "args": ["--login", "-i"],
                    "icon": "console"
                },
                "Git Bash": null,
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
                "MATLAB Interactive":{
                    "path": "matlab"
                    "args": ["-nodisplay"]
                }
            },
            "code-runner.executorMap": {
                "matlab": "cd $dir && matlab.exe -batch $fileNameWithoutExt"
            },
            "matlab.matlabpath": "C:/Program Files/MATLAB/R2022a/bin/matlab.exe",
            "matlab.mlintpath": "C:/Program Files/MATLAB/R2022a/bin/win64/mlint.exe",
            "matlab.linterEncoding": "gb2312",
            "remote.SSH.remotePlatform": {
                "XXX.XXX.XXX.XXX": "linux"
            },
            "editor.accessibilitySupport": "off",
            "terminal.integrated.commandsToSkipShell": [
                "language-julia.interrupt"
            ],
            "julia.symbolCacheDownload": true,
            "julia.cellDelimiters": [

                "^##(?!#)",
                "^#(\\s?)%%",
                "^#-"
            ],
            "julia.enableTelemetry": true,
            "python.languageServer": "Jedi",
            "python.experiments.enabled": false,
            "workbench.editor.enablePreview": false,
            "editor.minimap.enabled": false,
        }
    ```
