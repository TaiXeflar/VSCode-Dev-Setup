# VSCode安裝及入門個人化事項

## VSCode安裝

VSCode的下載地址: https://code.visualstudio.com/#alt-downloads
 - 請依照上述安裝路徑(User/System)版本選擇Windows **`x64`** 版本。
 - 請注意VSCode要求Windows 10以上，因此不支援以下作業系統:
     - Windows XP
     - Windows 7(Service Pack 1, 2, 3)
     - 比Windows XP更早的Windows x86 (32-bit)作業系統

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_download_select.png)

首先，安裝檔案會是這個檔名: 
 - User: `VSCodeUserSetup-x64-1.74.3.exe`
 - System: `VSCodeSetup-x64-1.74.3.exe`

開始安裝VSCode。首先，需要同意使用條款:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscodeInst1.png)

接著是安裝位置: (請將TaiXeflar換成你/妳自己的使用者名稱)
 - User安裝版本。安裝路徑會在: `C:\Users\TaiXeflar\AppData\Local\Programs\Microsoft VS Code`
 - System安裝版本。安裝路徑會在: `C:\Program Files\Microsoft VS Code`

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscodeInst2.png)

接著設定加入VSCode捷徑至開始功能表的資料夾位置:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscodeInst3.png)

接著是附加工作，例如加入至右鍵選單或加入PATH變數(這個強烈建議添加)。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscodeInst4.png)

最後是產品安裝的確認信息。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscodeInst5.png)

## 終端機呼叫VSCode

VSCode可以作為文字編輯器開啟，並且可以系統管理員身分運行(這可以做到使用VSCode修改系統文件等)。

 - 在終端中以一般使用者身分(User)呼叫VSCode的樣子:
     ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_invoke_user.png)

 - 在終端中以系統管理員身分(Administrator)呼叫VSCode的樣子: (此處透過gsudo套件實現權限提升)
    ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_invoke_sudo.png)

## VSCode延伸套件

VSCode在未擴充功能的情況下只是單純的文字編輯器(Text Editor)。

VSCode的所有額外延伸功能皆透過安裝 **"延伸套件"** (Extentions)實現功能擴充或改變。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscodeExt_search.png)

以下是改變VSCode系統內語言延伸套件:
 - Chinese (Traditional) Language Pack for Visual Studio Code (繁體中文套件)
 - Chinese (Simplified) Language Pack for Visual Studio Code (簡體中文套件)
 - Japanese Language Pack for VS Code (日本語套件)

以下是支援快速/自動選字(IntelliSense)的模組:
 - IntelliCode
 - IntelliCode API Usage Examples

以下是支援遠端桌面登入的延伸套件:
 - Remote - SSH
 - Remote - SSH: Editing Configuration Files
 - Remote Explorer

以下是支援VSCode編輯C/C++的延伸套件:
 - C/C++
 - C/C++ Extention Pack

以下是支援VSCode編輯Python的延伸套件:
 - Python
 - Pylance

以下是支援VSCode編輯基於Jupyter Notebook支援的延伸套件:
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

以下是支援MATLAB偵錯的延伸套件:
 - Matlab (Xavier Hahn)
 - Matlab Interactive Terminal (Aurelien Pommel)
 - Code Runner (Jun Han)

## VSCode個人化設定

我們以修改`settings.json`內部JSON鍵值的形式來改變VSCode設定。

為配合JSON語法的教學，請參閱`vscode_Setup(Build 0)_JSON_config.md`。

## VSCode 熱鍵

你可以使用熱鍵加速你的效率。

  - `Ctrl + K` + `Ctrl + O`: 開啟資料夾。
  - `Ctrl + K` + `F`: 關閉資料夾。
  - `Ctrl + O`: 開啟檔案。
  - `Ctrl + F4`: 關閉檔案。
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
