# 以VSCode建置Python專案 

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
  - 請注意，在Windows上支援GPU運算的套件僅限適用於CUDA架構。因此，dGPU建議配置為支援CUDA的NVIDIA GPU。在消費級平台上所支援的CUDA GPU包含NVIDIA GeForce MX, GTX, RTX顯示卡。
  - 請注意，適用於Windows的AMD Radeon顯示卡(包含iGPU及dGPU)不支援CUDA GPU。


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

 - 若你的Python安裝在`C:/Users/USER/AppData/Local/Python/Python39/`，則可以直接安裝。
    ```
    PS>  pip install `Mod`
    ```
    
 - 若你的Python安裝在`C:/Program Files/Python39`，則需要以系統管理員`Administrator`身份安裝。(可使用gsudo套件提升權限)
    ```
    PS>  sudo pip install `Mod`
    ```

底下列舉命令列範例。使用Windows終端機(Windows Terminal)進行pip指令安裝。

  ```
  PS>   pip install `Mod`                                                   # 安裝名為Mod的模組。
  PS>   pip install `Mod1`, `Mod2`, `Mod3`                    # 安裝多個模組。
  PS>   pip install `Mod` --upgrade                                  # 安裝該指定模組的新版。
  PS>   pip install `Mod`==XX.XX.X                                 # 安裝該模組的指定版本。
  PS>   pip uninstall `Mod`                                               # 解除安裝該模組。
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

以下是Python模組調用MatLab引擎:

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


## 專案根目錄定義

本範例定義在一個名為pytest的專案資料夾底下，有以下內容:

 - .vscode (資料夾)
 - test.py (Python底稿)
 - example.ipynb (Jupyter筆記本)


## .vscode資料夾設定

  - JSON檔案: 你需要1個JSON檔案完成Python底稿偵錯設定。
    
    - `launch.json`: 偵錯Python底稿.
  
  - launch.json: 

    以下是建立一個Python底稿的執行偵錯設定範例:

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
      - `"type"`: `"python"`.
      - `"request"`: `"launch"`.
      - `"program"`: `"${file}"`. 該鍵值`"${file}"`對應至欲偵錯的Python底稿(對應至本存放庫即為 **test.py** )。
      - ` "console"`: `"integratedTerminal"`或`externalTerminal`。取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。
      - `"justMyCode"`: `true`

## VSCode偵錯Python

  - Python底稿偵錯

    該專案底稿下建立一個.vscode資料夾並建立一個launch.json檔案，以`F5`一鍵偵錯。

  - Jupyter筆記本

    `Ctrl + Shift + P`組合鍵開啟設定搜尋，鍵入Jupyter，找到`Create: New Jupyter Notebook`選項並點選，建立一個新的筆記本。

    VSCode建立筆記本的優點是能快速建立Markdown及無須開啟終端機掛載ipykernel核心、以及在未存檔筆記本的情況下執行筆記本。

  - Julia語言

    Julia核心是基於Python演變而來，因此可以套用前述方法執行Julia語言偵錯。

## Python Module 注意事項

  - 請注意，在某些特定的情況下，會有Module間不相容導致程式執行中出現不可預期的錯誤。
  - google.colab及drive套件為限定在Google Colabatory提供，特殊Linux基底的Python容器的雲端環境使用。因此，`drive.mount("__LOCATION__")`指令僅限在Colab上執行。若強制在本機執行指令安裝則會出現非基於pip指令導致的不可預期錯誤。
  
## Jupyter Notebook 注意事項

 - Jupyter筆記本可以執行Python核心或Julia核心。請妥善選擇執行的本地端核心(Kernel)以避免出現程式執行錯誤。
 - Jupyter筆記本可以選擇具有Conda環境的Python。若有Conda環境選擇需求請改選base的Conda Python。
 - 每一個可執行Python/Julia或是註記(Markdown)的儲存格被稱為cell。執行cell的熱鍵是`Shift + Enter`。
 - 請注意該筆記本內每一個cell的執行時間序。若有被刪除的cell影響到後續cell的執行，請在該時間序之後的cell重新執行。
 - 當遇到不可預期的錯誤時(例如程式報錯不符合預期內的錯誤)，試試看重新啟動核心(kernel)並全部重新執行一次。
 - 使用VSCode開啟的Jupyter不需要以終端機掛載ipykernel就能正常執行筆記本的Python互動式偵錯。
 - ipynb是Jupyter筆記本的副檔名，內容為json格式。
 - 請注意，在VSCode內以SSH連線執行遠端Google Colabatory的Python偵錯有可能會被視為違反Google Colabatory使用條款。