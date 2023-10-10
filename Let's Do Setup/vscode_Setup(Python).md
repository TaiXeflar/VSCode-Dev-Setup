# 安裝Python(PyPI)環境
 
## 直譯器確認及安裝:  

  - 本存放庫範例以Windows執行Python 3.9.7直譯器:  Python Software Foundation. Python 3.9.7

  請選擇64位元的安裝檔:

   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_python_inst0.png)
  
  我們開始進行Python安裝。請務必把PATH選項打勾:
   
   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_python_inst1.png)

  接著，在選擇性頁面中，保持預設選項即可:
    
   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_python_inst2.png)

  接著，在進階選項中，請依照你的Python安裝需求選擇安裝在使用者路徑或系統路徑下。
   - 使用者路徑(即使用者安裝):
    
   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_python_inst3_user.png)

   - 系統路徑(即系統管理員安裝):

   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_python_inst3_sudo.png)

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

依照你的Python安裝路徑不同，則需要不同等級權限執行pip安裝指令。

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

底下列舉命令列範例。使用Windows終端機(Windows Terminal)進行pip指令安裝。
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

這裡舉例一個使用終端機安裝`py2exe`套件的實際過程(pip 22.3.1):

 ```
  PS C:\Users\TaiXeflar> pip install py2exe
  Collecting py2exe
    Downloading py2exe-0.12.0.1-cp39-cp39-win_amd64.whl (151 kB)
      ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 151.8/151.8 kB 3.0 MB/s eta 0:00:00
  Requirement already satisfied: cachetools in c:\program files\python39\lib\site-packages (from py2exe) (5.2.0)
  Collecting pefile
    Downloading pefile-2022.5.30.tar.gz (72 kB)
      ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 72.9/72.9 kB ? eta 0:00:00
    Preparing metadata (setup.py) ... done
  Collecting future
    Downloading future-0.18.2.tar.gz (829 kB)
      ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 829.2/829.2 kB 6.6 MB/s eta 0:00:00
    Preparing metadata (setup.py) ... done
  Building wheels for collected packages: pefile, future
    Building wheel for pefile (setup.py) ... done
    Created wheel for pefile: filename=pefile-2022.5.30-py3-none-any.whl size=69376 sha256=b1e373fb8e3622402e8b6b78916fe1841571421b8b8597e821ff0fb8ce1241f4
    Stored in directory: c:\users\taixeflar\appdata\local\pip\cache\wheels\37\01\46\42ba844d09aad7cf28e9be9cc8f28a071e2fef8f1bfe51edac
    Building wheel for future (setup.py) ... done
    Created wheel for future: filename=future-0.18.2-py3-none-any.whl size=491070 sha256=8071dbb391b557ab5036d5c541e295d9e6c40a2adb3f96917e04f3877b6757bd
    Stored in directory: c:\users\taixeflar\appdata\local\pip\cache\wheels\96\66\19\2de75120f5d0bc185e9d16cf0fd223d8471ed025de08e45867
  Successfully built pefile future
  Installing collected packages: future, pefile, py2exe
  Successfully installed future-0.18.2 pefile-2022.5.30 py2exe-0.12.0.1
  PS C:\Users\TaiXeflar> 
  ```


## Python Module 注意事項

  - 請注意，在某些特定的情況下，會有Module間不相容導致程式執行中出現不可預期的錯誤。
  - google.colab及drive套件為限定在Google Colabatory提供，特殊Linux基底的Python容器的雲端環境使用。因此，`drive.mount("__LOCATION__")`指令僅限在Colab上執行。若強制在本機執行指令安裝則會出現非基於pip指令導致的不可預期錯誤。
  
