# 以VSCode建置Python專案 


## 直譯器確認:  

  - 本存放庫以Windows執行Python直譯器:

    Python Foundation. Python 3.9.7


## PATH 路徑確認

  - Python直譯器可在預設安裝的路徑下找到。請把列出的編譯器路徑的資料夾添加至環境變數中(PATH)。

    - 若安裝限安裝在使用者路徑:

      `PATH`:

            "C:\Users\YOUR_NAME\AppData\Roaming\Python\Python39\Scripts"
            "C:\Users\YOUR_NAME\AppData\Roaming\Python\Python39\"

        或

            "C:\Users\YOUR_NAME\AppData\Local\Python\Python39\Scripts"
            "C:\Users\YOUR_NAME\AppData\Local\Python\Python39\"

    - 若安裝在系統路徑(為所有使用者安裝):

      `PATH`:

            "C:\Program Files\Python39"
            "C:\Program Files\Python39\Scripts"


## 設定PATH變數

  - 請把直譯器路徑所在路徑添加至使用者/系統環境變數中。可能需要重新開機。
    若是在安裝Python時，請勾選`Add Python to PATH`這個選項。
    
  - 添加`PATH`變數之後以終端機(Powershell/CMD)呼叫該直譯器。從以下指令選擇一個進行測試:
    - PS> py
    - PS> python

    
## VSCode 延伸套件 

在可能的前提下，你需要安裝延伸套件:

  - Python
  - Pylance
  - Jupyter
  - Jupyter Keymap
  - Jupyter Notebook Renders

上述列舉的延伸套件當中，有包含Jupyter的套件必須在本機安裝Jupyter模組後才能順利運行。

## Python模組安裝

依照你的Python安裝路徑不同，則需要不同等級權限執行pip安裝指令。

 - 若你的Python在Program Files資料夾底下(為所有使用者安裝)，則需要以系統管理員權限安裝。
 - 若你的Python在AppData資料夾底下，則不需要系統管理員權限即可安裝。

底下列舉命令列範例。使用Windows終端機進入CLI殼層介面:

- PS>   pip install `Mod`                                   
- PS>   pip install `Mod1`, `Mod2`, `Mod3`    
- PS>   pip install `Mod` --upgrade                 
- PS>   pip install `Mod`==XX.XX.X                  
- PS>   pip uninstall `Mod`                                 

以上指令分別代表:

- 安裝名為Mod的模組。 
- 安裝多個模組。
- 安裝該指定模組的新版。
- 安裝該模組的指定版本。
- 解除安裝該模組。

## 專案根目錄定義

本範例定義在一個名為pytest的專案資料夾底下，有以下內容:
 - .vscode (資料夾)
 - test.py (Python底稿)
 - example.ipynb (Jupyter筆記本)

## .vscode資料夾設定

  - JSON檔案: 你需要1個JSON檔案完成Python底稿偵錯設定。
    
    - `launch.json`: 偵錯Python底稿.
  
  - launch.json: 
    - `version`: 值預設是`0.2.0`.
    - `configurations`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:
      - `"name"`: `"Python: Current"`。
      - `"type"`: `"python"`.
      - `"request"`: `"launch"`.
      - `"program"`: `"${file}"`.
      - ` "console"`: `"integratedTerminal"`或`externalTerminal`.取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。
      - `"justMyCode"`: `true`

## VSCode偵錯Python

  - Python底稿偵錯

    該專案底稿下建立一個.vscode資料夾並建立一個launch.json檔案，以`F5`一鍵偵錯。

  - Jupyter筆記本

    `Ctrl+Shift+P`鍵入Jupyter，找到"Create: New Jupyter Notebook"選項並點選，建立一個新的筆記本。

    VSCode建立筆記本的優點是能快速建立Markdown及無須開啟終端機掛載ipykernel核心。

## Jupyter 注意事項

 - Jupyter筆記本可以執行Python核心或Julia核心。請妥善選擇執行的本地端核心(Kernel)以避免出現程式執行錯誤。
 - Jupyter筆記本可以選擇具有Conda環境的Python。若有選擇需求請改選base的Conda Python。
 - 每一個可執行Python/Julia或是註記(Markdown)的儲存格被稱為cell。執行cell的熱鍵是`Shift + Enter`。
 - 當遇到不可預期的錯誤時(例如程式報錯不符合預期內的錯誤)，請注意該筆記本內每一個cell的執行時間序。若有被刪除的cell影響到後續cell的執行，請重新啟動核心(kernel)並全部重新執行一次。
 - 使用VSCode開啟的Jupyter不需要以終端機掛載ipykernel就能正常執行筆記本的Python互動式偵錯。
 - ipynb是Jupyter筆記本的副檔名，內容為json格式。