# 安裝Python(PyPI)環境 
 
## 直譯器確認及安裝:  

  - 本教學範例以Windows執行Python 3.9.7直譯器:  Python Software Foundation. Python 3.9.7

  
  Python官網的下載連結[請點這裡](https://www.python.org/downloads/) 。
   - 注意: Python 3.9.7版本已經不在官方的安全性支援列表內。建議下載Python 3.11.9或3.12.X以上版本。Python官方給予的Python版本支援生命週期[請點這裡](https://devguide.python.org/versions/)查看。

  對於PC/NB使用者搭載Intel Core/AMD Ryzen處理器的Windows使用者，請選擇64位元的安裝檔:

   ![image](../Markdown%20Image/vscode_python_inst0.png)

   - 注意: 若你是macOS使用者，請選擇適用於macOS的Universal2 Installer。
   - 若你是搭載Qualcomm Snapdragon Elite X的Windows用戶，請選擇ARM64版本安裝程式。
  
  我們開始進行Python安裝。請務必把PATH選項打勾:
   
   ![image](../Markdown%20Image/vscode_python_inst1.png)

  接著，在選擇性頁面中，保持預設選項即可:
    
   ![image](../Markdown%20Image/vscode_python_inst2.png)

  接著，在進階選項中，請依照你的Python安裝需求選擇安裝在使用者路徑或系統路徑下。
   - 使用者路徑(即使用者安裝):
    
   ![image](../Markdown%20Image/vscode_python_inst3_user.png)

   - 系統路徑(即系統管理員安裝):

   ![image](../Markdown%20Image/vscode_python_inst3_sudo.png)

  最後即安裝完成。若有`Disable PATH Limit`選項則請選擇。  
    
## VSCode 延伸套件 

在可能的前提下，你需要安裝延伸套件:

  - Python
  - Pylance
  - Jupyter
  - Jupyter Keymap
  - Jupyter Notebook Renders

上述列舉的延伸套件當中，有包含Jupyter的套件必須在本機安裝Jupyter模組後才能順利運行。

## Python模組(Python Module)的pip指令安裝

依照你的Python安裝路徑不同，則需要不同等級權限執行`pip`安裝指令。在VSCode中以快捷鍵`Ctrl + ‵`呼叫終端機(Terminal)。

若你的Python安裝在`C:/Users/USER/AppData/Local/Python/Python39/`，則可以直接安裝。
 - PowerShell
    ```
    pip install <Mod>
    ```
    
若你的Python安裝在`C:/Program Files/Python39`，則需要以系統管理員`Administrator`身份安裝。(可使用gsudo套件提升權限)
 - PowerShell
    ```
    sudo pip install <Mod>
    ```

底下列舉命令列範例。使用Windows終端機(Windows Terminal)進行`pip`指令安裝。
 - PowerShell
    ```
    pip install <Mod>                                      # 安裝名為Mod的模組。
    pip install <Mod> <Mod2> <Mod3>                        # 安裝多個模組。
    pip install <Mod> --upgrade                            # 安裝該指定模組的新版。
    pip install <Mod>==XX.XX.X                             # 安裝該模組的指定版本。
    pip uninstall <Mod>                                    # 解除安裝該模組。
    ```

若你的Python是具備Conda環境的套件管理，則將`pip`換成`conda`:
 - PowerShell
   ```
   Conda install <Mod>
   ```


以下是常用於資料科學的模組:
  - Matplotlib
  - Pandas
  - NumPy

以下是常用於機器學習/深度學習的模組:
  - Scikit-Learn
  - TensorFlow
  - Torch

以下是常用於微網站架構的模組:
  - Flask
  - Bottle

以下是Web架構互動式偵錯:
  - Jupyter

以下是Python調用MatLab引擎模組:
  - MatlabEngine


## Python Module 注意事項

  - 請注意，在某些特定的情況下，會有Module間不相容導致程式執行中出現不可預期的錯誤。
  - google.colab及drive套件為限定在Google Colabatory提供，特殊Linux基底的Python容器的雲端環境使用。因此，`drive.mount("__LOCATION__")`指令僅限在Colab上執行。若強制在本機執行指令安裝則會出現非基於pip指令導致的不可預期錯誤。
  
