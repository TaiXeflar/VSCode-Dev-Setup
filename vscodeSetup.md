# VSCode安裝及入門個人化事項

## VSCode安裝

VSCode有兩種安裝版本:
 - User安裝版本。安裝路徑會在: `C:\Users\TaiXeflar\AppData\Local\Programs\Microsoft VS Code`
 - System安裝版本。安裝路徑會在: `C:\Program Files\Microsoft VS Code`

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
 - `"editor.fontFamily"`: 工作區的字體家族。你可以使用**銀河標準字母**惡整別人的電腦成被附魔台附魔過的樣子。
 - `"editor.fontWeight"`: 字體粗細程度，允許**一般**及**粗體**字體，不允許**斜體**。
 - `"terminal.integrated.fontFamily"`: VSCode內鍵終端機的字體。請注意僅能使用等寬字體。
 - `"workbench.startupEditor"`: 控制在啟動時顯示哪個編輯器，若沒有(`"none"`)，則從上個工作階段還原。這意味著VSCode會開啟你上次最後一個工作狀態。
 - `"workbench.colorTheme"`: 主題色彩。
 - `"files.associations"`: 設定檔案關聯性。可覆寫預設關聯設定。

    以這段`"files.associations": {"*.json": "jsonc"}`為例，VSCode允許將json檔案關聯至jsonc檔案，從而允許在json檔案內以`//`撰寫註釋(在json內撰寫註釋是違反語法的)。
