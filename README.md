# VSCode安裝及入門個人化事項

## ZH-TW

分享實驗性建置結果。

說明檔以Markdown語法編寫，在TaiXeflar/vscode_build_sample_repos/Markdown_Readme內。

 - C/C++說明請閱覽`C_C++ README_[zh-tw].md`。範例程式檔請至TaiXeflar/vscode_build_repos/ctest查看。
 - C#/F#/VB說明請閱覽`C#/F#/VB README_[zh-tw].md`。範例程式檔請至cstest, fstest, vbtest查看。
 - Python說明請閱覽`PyReadme_[zh-tw].md`。範例程式檔請至TaiXeflar/vscode_build_repos/pytest查看。
 - Fortran說明請閱覽`F Readme.md`。範例程式檔請至TaiXeflar/vscode_build_repos/ftest查看。
 - Java目前測試中，敬請期待。
 - Git套件說明請閱覽`vscodeGit.md`。

## VSCode安裝

VSCode有兩種安裝版本: (請將TaiXeflar換成你/妳自己的使用者名稱)
 - User安裝版本。安裝路徑會在: `C:\Users\TaiXeflar\AppData\Local\Programs\Microsoft VS Code`
 - System安裝版本。安裝路徑會在: `C:\Program Files\Microsoft VS Code`

VSCode的下載地址: https://code.visualstudio.com/#alt-downloads
 - 請依照上述安裝路徑(User/System)版本選擇Windows **`x64`** 版本。
 - 請注意VSCode要求Window 10以上，因此不支援以下作業系統:
     - Windows XP
     - Windows 7(Service Pack 1, 2, 3)
     - Windows 8, 8.1
     - 比Windows XP更早的Windows x86 (32-bit)作業系統

## VSCode延伸套件

VSCode在未擴充功能的情況下只是單純的文字編輯器(Text Editor)。
VSCode的所有額外延伸功能皆透過安裝 **"延伸套件"** (Extentions)實現功能擴充或改變。

以下是改變VSCode系統內語言延伸套件:
 - Chinese (Traditional) Language Pack for Visual Studio Code (繁體中文套件)
 - Chinese (Simplified) Language Pack for Visual Studio Code (簡體中文套件)
 - Japanese Language Pack for VS Code (日本語套件)

以下是支援VSCode編輯C/C++的延伸套件:
 - C/C++
 - C/C++ Extention Pack

以下是支援VSCode編輯Python的延伸套件:
 - Python
 - Pylance

以下是支援VSCode編輯基於Jupyter支援的延伸套件:
 - Jupyter
 - Jupyter Keymap
 - Jupyter Cell Tags
 - Jupyter Slide Show
 - Jupyter Notebook Renders

以下是支援VSCode編輯基於Java支援的延伸套件:
 - Debugger for Java
 - Extention Pack for Java
 - Language Support for Java by Red Hat
 - Maven for Java
 - Project Manager for Java
 - Test Runner for Java

## VSCode個人化設定

我們以修改`settings.json`內部JSON鍵值的形式來改變VSCode設定。事實上，以UI形式修改也會更動JSON設定。

點選左下角"管理">"命令選擇區"或按下 `Ctrl + Shift + P` 組合鍵，輸入 `Preferences: Open User Settings (JSON)`並點選，進入settings.json。

在settings內，你所鍵入的鍵(Key)或值(Value)均可透過Intellisense快速選字，使用上下方向鍵切換並以Tab鍵快速填入。

以下是較常見的設定項:
 - `"editor.mouseWheelZoom"`: 布林值(`true` / `false`)。允許透過滑鼠滾輪放大/縮小工作區字體大小。
 - `"editor.fontFamily"`: 工作區的字體家族。你可以使用**銀河標準字母**惡整別人的電腦成 **"被附魔台附魔過"** 的樣子。

      請注意這個JSON鍵值不具有Intellisense自動選字，因此需自行手動確認該字體名稱是否輸入正確。
 - `"editor.fontWeight"`: 字體粗細程度，允許**一般**及**粗體**字體，不允許**斜體**。
 - `"terminal.integrated.fontFamily"`: VSCode內鍵終端機的字體。請注意僅能使用等寬字體。

      若使用非等寬字體則會讓終端機看起來像被撇開的bug出現。(海馬: 人生就是要看開點.jpg)
 - `"workbench.startupEditor"`: 控制在啟動時顯示哪個編輯器，若沒有(`"none"`)，則從上個工作階段還原。這意味著VSCode會開啟你上次最後一個工作狀態。
 - `"workbench.colorTheme"`: 主題色彩。
 - `"files.associations"`: 設定檔案關聯性。可覆寫預設關聯設定。以下提供一段範例:

      ```
      "files.associations": {"*.json": "jsonc"}
      ```
      這段程式碼的含意是，允許VSCode將json檔案關聯至jsonc檔案，從而允許在json檔案內以`//`撰寫註釋(在json內撰寫註釋是違反語法的)。

 - `"terminal.integrated.profiles.windows"`: 自定義VSCode內終端機的下拉式選單，值為自定義且包含特定子鍵值的JSON物件。

      預設會有`PowerShell`, `Command Prompt`兩個JSON物件。事實上，JSON物件可以是你隨意指定的內容。若是在VSCode安裝後再安裝Git，則會自動建立可呼叫Git的終端設定檔。

      下列均以**手動建立**設定檔為範例。
      
      以建立Cygwin，並啟動目錄位置在/home/_USER/為例: (`_USER`是你的使用者名稱，底下2個範例)

      ```
         "Cygwin": 
         {            
            "path": ["C:/cygwin64/Cygwin.bat"],
            "args": []
            "icon": "console"
         }
      ```
      ```
         "Cygwin": 
         {            
            "path": ["C:/cygwin64//bin/bash.exe"],
            "args": ["--login", "-i"]
            "icon": "console"
         }
      ```
      
      以建立Git為例:

      ```
         "Git":
         {
            "path": ["C:/Program Files/Git/bin/bash.exe"],
            "args": ["-i", "-l"],
            "icon: "console"
         }
      ```

      當中:
      - `"source"`鍵值可以自動偵測殼層路徑的設定檔來源。因為Cygwin在非標準可執行位置，因此以`"path"`取代。
      - `"path"`為殼層可執行檔的檔案位置。你可以直接填入殼層可執行檔的檔案路徑，或是以JSON陣列填入多個可執行檔。
      - `"args"` 為要傳遞到該殼層內的參數或引數(flags)，使用JSON清單包含所有要被傳遞的引數。
      - `"icon"`為顯示於下拉式清單的圖示。

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
    "editor.fontFamily": "Xolonium",
    "editor.fontWeight": "normal",
    "terminal.integrated.fontFamily": "Consolas",
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
                "${env:windir}\\Sysnative\\cmd.exe",
                "${env:windir}\\System32\\cmd.exe"
            ],
            "args": [],
            "icon": "terminal-cmd"
        },
        "Git Bash": {
            "source": "Git Bash"
        },
        "Cygwin": 
        {            
            "path": ["C:/cygwin64//bin/bash.exe"],
            "args": ["--login", "-i"]
            "icon": "console"
        }
    }
}
```

## VSCode 熱鍵

你可以使用熱鍵加速你的效率。

  - `Ctrl + K` + `Ctrl + O`: 開啟資料夾。
  - `Ctrl + K` + `F`: 關閉資料夾。
  - `Ctrl + C`: 複製文字。
  - `Ctrl + V`: 貼上複製內容。
  - `Ctrl + X`: 剪取文字。
  - `Ctrl + S`: 存檔。 你可以快速存檔，以及將`COMMIT_EDITMSG`存檔以提交至GitHub存放庫。
  - `Ctrl + Shift + S`: 另存新檔。
  - `Ctrl + Shift + P`: 尋找vscode設定。
  - `Ctrl + Shift + B`: 啟動專案建置工作(Build Task)。
  - `Ctrl + Shift + ‵`: 新增一個終端。
  - `F5`: 啟動專案偵錯工作(Run Debug)。
  - `Ctrl + F`: 尋找目標。
  - `Ctrl + H`: 尋找及取代目標。
  - `Shift + Enter`: 在Jupyter Notebook內執行單一個cell的直譯式偵錯或執行Markdown的編輯儲存。
