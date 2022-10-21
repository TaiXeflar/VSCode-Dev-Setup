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
    若是在安裝Python時，請勾選`Add Python to PATH`這個選項即可。
    
  - 添加`PATH`變數之後，以終端機呼叫該直譯器。
  - 你可以從任何殼層啟動，並從以下指令選擇一個進行測試。本範例以PowerShell啟動:

    - PS> py
    - PS> python

  若出現以下結果代表有成功加入環境變數，進入Python Shell:

  ```
    PS C:\Users\TaiXeflar> py
    Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
    Type "help", "copyright", "credits" or "license" for more information.
    >>>
  ```

    
## VSCode 延伸套件 

在可能的前提下，你需要安裝延伸套件:

  - Python
  - Pylance
  - Jupyter
  - Jupyter Keymap
  - Jupyter Notebook Renders

上述列舉的延伸套件當中，有包含Jupyter的套件必須在本機安裝Jupyter模組後才能順利運行。

## Python模組(Python Module)安裝

依照你的Python安裝路徑不同，則需要不同等級權限執行pip安裝指令。

 - 若你的Python在Program Files資料夾底下(為所有使用者安裝)，則需要以系統管理員`Administrator`身份安裝。
 - 若你的Python在AppData資料夾底下，則不需要系統管理員權限即可安裝。

底下列舉命令列範例。使用Windows終端機(Windows Terminal)進行pip指令安裝。

若以系統管理員安裝則需要以系統管理員開啟Windows終端機。(若本機上有安裝gsudo套件則在pip前加上gsudo或sudo)

  ```
  PS>   pip install `Mod`
  PS>   pip install `Mod1`, `Mod2`, `Mod3`    
  PS>   pip install `Mod` --upgrade                 
  PS>   pip install `Mod`==XX.XX.X                  
  PS>   pip uninstall `Mod`                                 
  ```

以上指令分別代表:

- 安裝名為Mod的模組。 
- 安裝多個模組。
- 安裝該指定模組的新版。
- 安裝該模組的指定版本。
- 解除安裝該模組。

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

這裡舉例一個使用終端機安裝py2exe套件的實際過程:

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
  
  這個錯誤會看起來非常的長:
  
    ```
    PS C:\Users\TaiXeflar> pip install google.colab
    Collecting google.colab
      Downloading google-colab-1.0.0.tar.gz (72 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 72.9/72.9 kB 1.3 MB/s eta 0:00:00
      Preparing metadata (setup.py) ... done
    Collecting google-auth~=1.4.0
      Downloading google_auth-1.4.2-py2.py3-none-any.whl (64 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 64.2/64.2 kB ? eta 0:00:00
    Collecting ipykernel~=4.6.0
      Downloading ipykernel-4.6.1-py3-none-any.whl (104 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 104.5/104.5 kB ? eta 0:00:00
    Collecting ipython~=5.5.0
      Downloading ipython-5.5.0-py3-none-any.whl (758 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 758.9/758.9 kB 9.6 MB/s eta 0:00:00
    Collecting notebook~=5.2.0
      Downloading notebook-5.2.2-py2.py3-none-any.whl (8.0 MB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 8.0/8.0 MB 11.2 MB/s eta 0:00:00
    Collecting six~=1.12.0
      Downloading six-1.12.0-py2.py3-none-any.whl (10 kB)
    Collecting pandas~=0.24.0
      Downloading pandas-0.24.2.tar.gz (11.8 MB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 11.8/11.8 MB 11.5 MB/s eta 0:00:00
      Preparing metadata (setup.py) ... done
    Collecting portpicker~=1.2.0
      Downloading portpicker-1.2.0.tar.gz (17 kB)
      Preparing metadata (setup.py) ... done
    Collecting requests~=2.21.0
      Downloading requests-2.21.0-py2.py3-none-any.whl (57 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 58.0/58.0 kB 3.0 MB/s eta 0:00:00
    Collecting tornado~=4.5.0
      Downloading tornado-4.5.3.tar.gz (484 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 484.2/484.2 kB 14.8 MB/s eta 0:00:00
      Preparing metadata (setup.py) ... done
    Requirement already satisfied: rsa>=3.1.4 in c:\program files\python39\lib\site-packages (from google-auth~=1.4.0->google.colab) (4.9)
    Requirement already satisfied: cachetools>=2.0.0 in c:\program files\python39\lib\site-packages (from google-auth~=1.4.0->google.colab) (5.2.0)
    Requirement already satisfied: pyasn1-modules>=0.2.1 in c:\program files\python39\lib\site-packages (from google-auth~=1.4.0->google.colab) (0.2.8)
    Requirement already satisfied: jupyter-client in c:\program files\python39\lib\site-packages (from ipykernel~=4.6.0->google.colab) (7.4.3)
    Requirement already satisfied: traitlets>=4.1.0 in c:\program files\python39\lib\site-packages (from ipykernel~=4.6.0->google.colab) (5.5.0)
    Requirement already satisfied: pygments in c:\program files\python39\lib\site-packages (from ipython~=5.5.0->google.colab) (2.13.0)
    Requirement already satisfied: setuptools>=18.5 in c:\program files\python39\lib\site-packages (from ipython~=5.5.0->google.colab) (57.4.0)
    Requirement already satisfied: colorama in c:\program files\python39\lib\site-packages (from ipython~=5.5.0->google.colab) (0.4.5)
    Requirement already satisfied: decorator in c:\program files\python39\lib\site-packages (from ipython~=5.5.0->google.colab) (5.1.1)
    Collecting simplegeneric>0.8
      Downloading simplegeneric-0.8.1.zip (12 kB)
      Preparing metadata (setup.py) ... done
    Requirement already satisfied: pickleshare in c:\program files\python39\lib\site-packages (from ipython~=5.5.0->google.colab) (0.7.5)
    Collecting prompt-toolkit<2.0.0,>=1.0.4
      Downloading prompt_toolkit-1.0.18-py3-none-any.whl (245 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 245.4/245.4 kB 14.7 MB/s eta 0:00:00
    Requirement already satisfied: jupyter-core in c:\program files\python39\lib\site-packages (from notebook~=5.2.0->google.colab) (4.11.2)
    Requirement already satisfied: jinja2 in c:\program files\python39\lib\site-packages (from notebook~=5.2.0->google.colab) (3.1.2)
    Requirement already satisfied: ipython-genutils in c:\program files\python39\lib\site-packages (from notebook~=5.2.0->google.colab) (0.2.0)
    Requirement already satisfied: nbconvert in c:\program files\python39\lib\site-packages (from notebook~=5.2.0->google.colab) (7.2.2)
    Requirement already satisfied: nbformat in c:\program files\python39\lib\site-packages (from notebook~=5.2.0->google.colab) (5.7.0)
    Requirement already satisfied: python-dateutil>=2.5.0 in c:\program files\python39\lib\site-packages (from pandas~=0.24.0->google.colab) (2.8.2)
    Requirement already satisfied: pytz>=2011k in c:\program files\python39\lib\site-packages (from pandas~=0.24.0->google.colab) (2022.5)
    Requirement already satisfied: numpy>=1.12.0 in c:\program files\python39\lib\site-packages (from pandas~=0.24.0->google.colab) (1.23.4)
    Collecting chardet<3.1.0,>=3.0.2
      Downloading chardet-3.0.4-py2.py3-none-any.whl (133 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 133.4/133.4 kB 7.7 MB/s eta 0:00:00
    Collecting idna<2.9,>=2.5
      Downloading idna-2.8-py2.py3-none-any.whl (58 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 58.6/58.6 kB 3.0 MB/s eta 0:00:00
    Requirement already satisfied: certifi>=2017.4.17 in c:\program files\python39\lib\site-packages (from requests~=2.21.0->google.colab) (2022.9.24)
    Collecting urllib3<1.25,>=1.21.1
      Downloading urllib3-1.24.3-py2.py3-none-any.whl (118 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 118.8/118.8 kB 6.8 MB/s eta 0:00:00
    Requirement already satisfied: wcwidth in c:\program files\python39\lib\site-packages (from prompt-toolkit<2.0.0,>=1.0.4->ipython~=5.5.0->google.colab) (0.2.5)
    Requirement already satisfied: pyasn1<0.5.0,>=0.4.6 in c:\program files\python39\lib\site-packages (from pyasn1-modules>=0.2.1->google-auth~=1.4.0->google.colab) (0.4.8)
    Requirement already satisfied: MarkupSafe>=2.0 in c:\program files\python39\lib\site-packages (from jinja2->notebook~=5.2.0->google.colab) (2.1.1)
    Requirement already satisfied: entrypoints in c:\program files\python39\lib\site-packages (from jupyter-client->ipykernel~=4.6.0->google.colab) (0.4)
    Requirement already satisfied: pyzmq>=23.0 in c:\program files\python39\lib\site-packages (from jupyter-client->ipykernel~=4.6.0->google.colab) (24.0.1)
    Collecting jupyter-client
      Downloading jupyter_client-7.4.2-py3-none-any.whl (132 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.2/132.2 kB 8.1 MB/s eta 0:00:00
      Downloading jupyter_client-7.4.1-py3-none-any.whl (132 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.1/132.1 kB ? eta 0:00:00
      Downloading jupyter_client-7.4.0-py3-none-any.whl (132 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.2/132.2 kB 7.6 MB/s eta 0:00:00
      Downloading jupyter_client-7.3.5-py3-none-any.whl (132 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.1/132.1 kB ? eta 0:00:00
      Downloading jupyter_client-7.3.4-py3-none-any.whl (132 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.1/132.1 kB 7.6 MB/s eta 0:00:00
      Downloading jupyter_client-7.3.3-py3-none-any.whl (131 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.0/132.0 kB 7.6 MB/s eta 0:00:00
      Downloading jupyter_client-7.3.2-py3-none-any.whl (131 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 131.9/131.9 kB 8.1 MB/s eta 0:00:00
      Downloading jupyter_client-7.3.1-py3-none-any.whl (130 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 131.0/131.0 kB 7.5 MB/s eta 0:00:00
      Downloading jupyter_client-7.3.0-py3-none-any.whl (130 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 130.9/130.9 kB 8.0 MB/s eta 0:00:00
      Downloading jupyter_client-7.2.2-py3-none-any.whl (130 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 130.6/130.6 kB 7.5 MB/s eta 0:00:00
      Downloading jupyter_client-7.2.1-py3-none-any.whl (130 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 130.4/130.4 kB 8.0 MB/s eta 0:00:00
      Downloading jupyter_client-7.2.0-py3-none-any.whl (130 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 130.5/130.5 kB 7.5 MB/s eta 0:00:00
    Requirement already satisfied: nest-asyncio>=1.5.1 in c:\program files\python39\lib\site-packages (from jupyter-client->ipykernel~=4.6.0->google.colab) (1.5.6)
      Downloading jupyter_client-7.1.2-py3-none-any.whl (130 kB)
        ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 130.3/130.3 kB 8.0 MB/s eta 0:00:00
    Requirement already satisfied: pywin32>=1.0 in c:\program files\python39\lib\site-packages (from jupyter-core->notebook~=5.2.0->google.colab) (304)
    Requirement already satisfied: defusedxml in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (0.7.1)
    Requirement already satisfied: jupyterlab-pygments in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (0.2.2)
    Requirement already satisfied: nbclient>=0.5.0 in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (0.7.0)
    Requirement already satisfied: pandocfilters>=1.4.1 in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (1.5.0)
    Requirement already satisfied: tinycss2 in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (1.2.1)
    Requirement already satisfied: bleach in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (5.0.1)
    Requirement already satisfied: beautifulsoup4 in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (4.11.1)
    Requirement already satisfied: packaging in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (21.3)
    Requirement already satisfied: mistune<3,>=2.0.3 in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (2.0.4)
    Requirement already satisfied: importlib-metadata>=3.6 in c:\program files\python39\lib\site-packages (from nbconvert->notebook~=5.2.0->google.colab) (5.0.0)
    Requirement already satisfied: jsonschema>=2.6 in c:\program files\python39\lib\site-packages (from nbformat->notebook~=5.2.0->google.colab) (4.16.0)
    Requirement already satisfied: fastjsonschema in c:\program files\python39\lib\site-packages (from nbformat->notebook~=5.2.0->google.colab) (2.16.2)
    Requirement already satisfied: zipp>=0.5 in c:\program files\python39\lib\site-packages (from importlib-metadata>=3.6->nbconvert->notebook~=5.2.0->google.colab) (3.9.0)
    Requirement already satisfied: pyrsistent!=0.17.0,!=0.17.1,!=0.17.2,>=0.14.0 in c:\program files\python39\lib\site-packages (from jsonschema>=2.6->nbformat->notebook~=5.2.0->google.colab) (0.18.1)
    Requirement already satisfied: attrs>=17.4.0 in c:\program files\python39\lib\site-packages (from jsonschema>=2.6->nbformat->notebook~=5.2.0->google.colab) (22.1.0)
    Requirement already satisfied: soupsieve>1.2 in c:\program files\python39\lib\site-packages (from beautifulsoup4->nbconvert->notebook~=5.2.0->google.colab) (2.3.2.post1)
    Requirement already satisfied: webencodings in c:\program files\python39\lib\site-packages (from bleach->nbconvert->notebook~=5.2.0->google.colab) (0.5.1)
    Requirement already satisfied: pyparsing!=3.0.5,>=2.0.2 in c:\program files\python39\lib\site-packages (from packaging->nbconvert->notebook~=5.2.0->google.colab) (3.0.9)
    Building wheels for collected packages: google.colab, pandas, portpicker, tornado, simplegeneric
      Building wheel for google.colab (setup.py) ... done
      Created wheel for google.colab: filename=google_colab-1.0.0-py2.py3-none-any.whl size=102294 sha256=416ccb8a9b5e48612c7809c74cf9cb0609d5c16e3e3e7eebef004d325ed9b1ad
      Stored in directory: c:\users\taixeflar\appdata\local\pip\cache\wheels\cf\81\3b\a50a90282756a5257b8885aeb7d22de09c3bfbf31d66ff455e
      Building wheel for pandas (setup.py) ... error
      error: subprocess-exited-with-error

      × python setup.py bdist_wheel did not run successfully.
      │ exit code: 1
      ╰─> [995 lines of output]
          running bdist_wheel
          running build
          running build_py
          creating build
          creating build\lib.win-amd64-3.9
          creating build\lib.win-amd64-3.9\pandas
          copying pandas\conftest.py -> build\lib.win-amd64-3.9\pandas
          copying pandas\testing.py -> build\lib.win-amd64-3.9\pandas
          copying pandas\_version.py -> build\lib.win-amd64-3.9\pandas
          copying pandas\__init__.py -> build\lib.win-amd64-3.9\pandas
          creating build\lib.win-amd64-3.9\pandas\api
          copying pandas\api\__init__.py -> build\lib.win-amd64-3.9\pandas\api
          creating build\lib.win-amd64-3.9\pandas\arrays
          copying pandas\arrays\__init__.py -> build\lib.win-amd64-3.9\pandas\arrays
          creating build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\chainmap.py -> build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\chainmap_impl.py -> build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\pickle_compat.py -> build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\__init__.py -> build\lib.win-amd64-3.9\pandas\compat
          creating build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\accessor.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\algorithms.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\api.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\apply.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\base.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\categorical.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\common.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\config.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\config_init.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\frame.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\generic.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\index.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\indexing.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\missing.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\nanops.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\ops.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\panel.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\resample.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\series.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\sorting.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\strings.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\window.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\__init__.py -> build\lib.win-amd64-3.9\pandas\core
          creating build\lib.win-amd64-3.9\pandas\errors
          copying pandas\errors\__init__.py -> build\lib.win-amd64-3.9\pandas\errors
          creating build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\api.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\clipboards.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\common.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\date_converters.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\excel.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\feather_format.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\gbq.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\gcs.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\html.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\packers.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\parquet.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\parsers.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\pickle.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\pytables.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\s3.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\sql.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\stata.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\__init__.py -> build\lib.win-amd64-3.9\pandas\io
          creating build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_compat.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_converter.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_core.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_misc.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_style.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_timeseries.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_tools.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\__init__.py -> build\lib.win-amd64-3.9\pandas\plotting
          creating build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_algos.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_base.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_common.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_compat.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_config.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_downstream.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_errors.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_expressions.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_join.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_lib.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_multilevel.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_nanops.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_register_accessor.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_strings.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_take.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_window.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\__init__.py -> build\lib.win-amd64-3.9\pandas\tests
          creating build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\api.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\converter.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\frequencies.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\holiday.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\offsets.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\plotting.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\__init__.py -> build\lib.win-amd64-3.9\pandas\tseries
          creating build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\testing.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_decorators.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_depr_module.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_doctools.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_exceptions.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_print_versions.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_tester.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_test_decorators.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_validators.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\__init__.py -> build\lib.win-amd64-3.9\pandas\util
          creating build\lib.win-amd64-3.9\pandas\_libs
          copying pandas\_libs\__init__.py -> build\lib.win-amd64-3.9\pandas\_libs
          creating build\lib.win-amd64-3.9\pandas\api\extensions
          copying pandas\api\extensions\__init__.py -> build\lib.win-amd64-3.9\pandas\api\extensions
          creating build\lib.win-amd64-3.9\pandas\api\types
          copying pandas\api\types\__init__.py -> build\lib.win-amd64-3.9\pandas\api\types
          creating build\lib.win-amd64-3.9\pandas\compat\numpy
          copying pandas\compat\numpy\function.py -> build\lib.win-amd64-3.9\pandas\compat\numpy
          copying pandas\compat\numpy\__init__.py -> build\lib.win-amd64-3.9\pandas\compat\numpy
          creating build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\array_.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\base.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\categorical.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\datetimelike.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\datetimes.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\integer.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\interval.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\numpy_.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\period.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\sparse.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\timedeltas.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\_ranges.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\__init__.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          creating build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\align.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\api.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\check.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\common.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\engines.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\eval.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\expr.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\expressions.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\ops.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\pytables.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\scope.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\__init__.py -> build\lib.win-amd64-3.9\pandas\core\computation
          creating build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\api.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\base.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\cast.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\common.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\concat.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\dtypes.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\generic.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\inference.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\missing.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\__init__.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          creating build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\base.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\categorical.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\generic.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\groupby.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\grouper.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\ops.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\__init__.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          creating build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\accessors.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\api.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\base.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\category.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\datetimelike.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\datetimes.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\frozen.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\interval.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\multi.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\numeric.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\period.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\range.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\timedeltas.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\__init__.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          creating build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\arrays.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\blocks.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\concat.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\construction.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\managers.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\__init__.py -> build\lib.win-amd64-3.9\pandas\core\internals
          creating build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\api.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\concat.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\melt.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\merge.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\pivot.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\reshape.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\tile.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\util.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\__init__.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          creating build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\api.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\frame.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\scipy_sparse.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\series.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\__init__.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          creating build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\datetimes.py -> build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\numeric.py -> build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\timedeltas.py -> build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\__init__.py -> build\lib.win-amd64-3.9\pandas\core\tools
          creating build\lib.win-amd64-3.9\pandas\core\util
          copying pandas\core\util\hashing.py -> build\lib.win-amd64-3.9\pandas\core\util
          copying pandas\core\util\__init__.py -> build\lib.win-amd64-3.9\pandas\core\util
          creating build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\clipboards.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\exceptions.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\windows.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\__init__.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          creating build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\console.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\css.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\csvs.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\excel.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\format.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\html.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\latex.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\printing.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\style.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\terminal.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\__init__.py -> build\lib.win-amd64-3.9\pandas\io\formats
          creating build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\json.py -> build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\normalize.py -> build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\table_schema.py -> build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\__init__.py -> build\lib.win-amd64-3.9\pandas\io\json
          creating build\lib.win-amd64-3.9\pandas\io\msgpack
          copying pandas\io\msgpack\exceptions.py -> build\lib.win-amd64-3.9\pandas\io\msgpack
          copying pandas\io\msgpack\_version.py -> build\lib.win-amd64-3.9\pandas\io\msgpack
          copying pandas\io\msgpack\__init__.py -> build\lib.win-amd64-3.9\pandas\io\msgpack
          creating build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sas7bdat.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sasreader.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sas_constants.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sas_xport.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\__init__.py -> build\lib.win-amd64-3.9\pandas\io\sas
          creating build\lib.win-amd64-3.9\pandas\tests\api
          copying pandas\tests\api\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\api
          copying pandas\tests\api\test_types.py -> build\lib.win-amd64-3.9\pandas\tests\api
          copying pandas\tests\api\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\api
          creating build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_datetime64.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_object.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_timedelta64.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          creating build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_array.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_datetimes.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_integer.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_numpy.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_timedeltas.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          creating build\lib.win-amd64-3.9\pandas\tests\computation
          copying pandas\tests\computation\test_compat.py -> build\lib.win-amd64-3.9\pandas\tests\computation
          copying pandas\tests\computation\test_eval.py -> build\lib.win-amd64-3.9\pandas\tests\computation
          copying pandas\tests\computation\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\computation
          creating build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_concat.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_generic.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_inference.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          creating build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_categorical.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_external_block.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_integer.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_sparse.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          creating build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\common.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_alter_axes.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_asof.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_axis_select_reindex.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_block_internals.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_combine_concat.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_constructors.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_convert_to.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_duplicates.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_join.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_mutate_columns.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_nonunique_indexes.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_operators.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_quantile.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_query_eval.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_rank.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_replace.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_repr_info.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_sort_values_level_as_str.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_subclass.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_timeseries.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_to_csv.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_validate.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          creating build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_frame.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_generic.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_label_or_level_utils.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_series.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          creating build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_bin_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_categorical.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_counting.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_filters.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_function.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_grouping.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_index_as_string.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_nth.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_rank.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_timegrouper.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_transform.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_value_counts.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_whitelist.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          creating build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\common.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_base.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_category.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_frozen.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          creating build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\common.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_callable.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_categorical.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_chaining_and_caching.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_coercion.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_floats.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_iloc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_indexing_engines.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_indexing_slow.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_ix.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_loc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_partial.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_scalar.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          creating build\lib.win-amd64-3.9\pandas\tests\internals
          copying pandas\tests\internals\test_internals.py -> build\lib.win-amd64-3.9\pandas\tests\internals
          copying pandas\tests\internals\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\internals
          creating build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\generate_legacy_storage_files.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_clipboard.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_compression.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_date_converters.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_excel.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_feather.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_gbq.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_gcs.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_html.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_packers.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_parquet.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_pickle.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_pytables.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_s3.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_sql.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_stata.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io
          creating build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\common.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_boxplot_method.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_converter.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_frame.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_hist_method.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_misc.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_series.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          creating build\lib.win-amd64-3.9\pandas\tests\reductions
          copying pandas\tests\reductions\test_reductions.py -> build\lib.win-amd64-3.9\pandas\tests\reductions
          copying pandas\tests\reductions\test_stat_reductions.py -> build\lib.win-amd64-3.9\pandas\tests\reductions
          copying pandas\tests\reductions\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\reductions
          creating build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_base.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_datetime_index.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_period_index.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_resampler_grouper.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_resample_api.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_time_grouper.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          creating build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_concat.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_cut.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_melt.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_pivot.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_qcut.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_union_categoricals.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_util.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          creating build\lib.win-amd64-3.9\pandas\tests\scalar
          copying pandas\tests\scalar\test_nat.py -> build\lib.win-amd64-3.9\pandas\tests\scalar
          copying pandas\tests\scalar\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar
          creating build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\common.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_alter_axes.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_asof.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_block_internals.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_combine_concat.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_constructors.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_datetime_values.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_duplicates.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_internals.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_io.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_operators.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_quantile.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_rank.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_replace.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_repr.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_subclass.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_timeseries.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_validate.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\series
          creating build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\common.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_combine_concat.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_pivot.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          creating build\lib.win-amd64-3.9\pandas\tests\tools
          copying pandas\tests\tools\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\tools
          copying pandas\tests\tools\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tools
          creating build\lib.win-amd64-3.9\pandas\tests\tseries
          copying pandas\tests\tseries\test_frequencies.py -> build\lib.win-amd64-3.9\pandas\tests\tseries
          copying pandas\tests\tseries\test_holiday.py -> build\lib.win-amd64-3.9\pandas\tests\tseries
          copying pandas\tests\tseries\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tseries
          creating build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_array_to_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_ccalendar.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_conversion.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_libfrequencies.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_liboffsets.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_normalize_date.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_parse_iso8601.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_parsing.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_period_asfreq.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_timedeltas.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          creating build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_almost_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_categorical_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_extension_array_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_frame_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_index_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_interval_array_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_numpy_array_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_series_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_deprecate.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_deprecate_kwarg.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_hashing.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_locale.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_move.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_safe_import.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_util.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_validate_args.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_validate_args_and_kwargs.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_validate_kwargs.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\util
          creating build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\common.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_algos.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_constructors.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_operators.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_repr.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_subclass.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_warnings.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          creating build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          copying pandas\tests\arrays\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          copying pandas\tests\arrays\interval\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          copying pandas\tests\arrays\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          creating build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_arithmetics.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_array.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_dtype.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_libsparse.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          creating build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_construct_from_scalar.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_construct_ndarray.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_construct_object_arr.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_convert_objects.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_downcast.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_find_common_type.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_infer_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_infer_dtype.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          creating build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          copying pandas\tests\extension\arrow\bool.py -> build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          copying pandas\tests\extension\arrow\test_bool.py -> build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          copying pandas\tests\extension\arrow\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          creating build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\base.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\casting.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\constructors.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\dtype.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\getitem.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\groupby.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\interface.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\io.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\methods.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\missing.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\ops.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\printing.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\reduce.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\reshaping.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\setitem.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          creating build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          copying pandas\tests\extension\decimal\array.py -> build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          copying pandas\tests\extension\decimal\test_decimal.py -> build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          copying pandas\tests\extension\decimal\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          creating build\lib.win-amd64-3.9\pandas\tests\extension\json
          copying pandas\tests\extension\json\array.py -> build\lib.win-amd64-3.9\pandas\tests\extension\json
          copying pandas\tests\extension\json\test_json.py -> build\lib.win-amd64-3.9\pandas\tests\extension\json
          copying pandas\tests\extension\json\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\json
          creating build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\test_numpy.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\test_numpy_nested.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          creating build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\test_aggregate.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\test_cython.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\test_other.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_date_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_misc.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_partial_slicing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_scalar_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_setops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_tools.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval_new.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval_tree.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_constructor.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_contains.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_conversion.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_copy.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_drop.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_duplicates.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_equivalence.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_get_set.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_integrity.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_join.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_monotonic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_names.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_partial_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_reindex.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_set_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_asfreq.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_partial_slicing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_period_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_scalar_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_setops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_tools.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_partial_slicing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_scalar_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_setops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_timedelta_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_tools.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          creating build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          copying pandas\tests\indexing\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          copying pandas\tests\indexing\interval\test_interval_new.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          copying pandas\tests\indexing\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          creating build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_chaining_and_caching.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_getitem.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_iloc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_indexing_slow.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_ix.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_loc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_multiindex.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_partial.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_setitem.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_set_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_slice.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_sorted.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_xs.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          creating build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_console.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_css.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_eng_formatting.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_printing.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_style.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_csv.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_excel.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_html.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_latex.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          creating build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_compression.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_json_table_schema.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_normalize.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_pandas.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_readlines.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_ujson.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          creating build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\common.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_buffer.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_case.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_except.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_extension.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_limits.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_newspec.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_obj.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_pack.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_read_size.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_seq.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_sequnpack.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_subtype.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_unpack.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_unpack_raw.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          creating build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_comment.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_compression.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_converters.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_c_parser_only.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_dialect.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_header.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_index_col.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_mangle_dupes.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_multi_thread.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_na_values.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_network.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_parse_dates.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_python_parser_only.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_quoting.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_read_fwf.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_skiprows.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_textreader.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_unsupported.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_usecols.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          creating build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\test_sas.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\test_sas7bdat.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\test_xport.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          creating build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_join.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge_asof.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge_index_as_string.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge_ordered.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_multi.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          copying pandas\tests\scalar\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          copying pandas\tests\scalar\interval\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          copying pandas\tests\scalar\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\period
          copying pandas\tests\scalar\period\test_asfreq.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\period
          copying pandas\tests\scalar\period\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\period
          copying pandas\tests\scalar\period\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\period
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_comparisons.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_rendering.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_timestamp.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_unary_ops.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          creating build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_alter_index.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_boolean.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_callable.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_iloc.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_loc.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          creating build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_frame.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_to_csv.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_to_from_scipy.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          creating build\lib.win-amd64-3.9\pandas\tests\sparse\series
          copying pandas\tests\sparse\series\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\series
          copying pandas\tests\sparse\series\test_series.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\series
          copying pandas\tests\sparse\series\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\series
          creating build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\common.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_fiscal.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_offsets.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_offsets_properties.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_ticks.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_yqm_offsets.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          creating build\lib.win-amd64-3.9\pandas\_libs\tslibs
          copying pandas\_libs\tslibs\__init__.py -> build\lib.win-amd64-3.9\pandas\_libs\tslibs
          creating build\lib.win-amd64-3.9\pandas\io\formats\templates
          copying pandas\io\formats\templates\html.tpl -> build\lib.win-amd64-3.9\pandas\io\formats\templates
          UPDATING build\lib.win-amd64-3.9\pandas/_version.py
          set build\lib.win-amd64-3.9\pandas/_version.py to '0.24.2'
          running build_ext
          building 'pandas._libs.algos' extension
          creating build\temp.win-amd64-3.9
          creating build\temp.win-amd64-3.9\Release
          creating build\temp.win-amd64-3.9\Release\pandas
          creating build\temp.win-amd64-3.9\Release\pandas\_libs
          C:\Program Files\Microsoft Visual Studio\2022\VC\Tools\MSVC\14.33.31629\bin\HostX86\x64\cl.exe /c /nologo /Ox /W3 /GL /DNDEBUG /MD -Ipandas/_libs/src/klib -Ipandas/_libs/src -IC:\Program Files\Python39\lib\site-packages\numpy\core\include -IC:\Program Files\Python39\include -IC:\Program Files\Python39\include -IC:\Program Files\Microsoft Visual Studio\2022\VC\Tools\MSVC\14.33.31629\include -IC:\Program Files\Microsoft Visual Studio\2022\VC\Tools\MSVC\14.33.31629\ATLMFC\include -IC:\Program Files\Microsoft Visual Studio\2022\VC\Auxiliary\VS\include -IC:\Program Files (x86)\Windows Kits\10\include\10.0.22621.0\ucrt -IC:\Program Files (x86)\Windows Kits\10\\include\10.0.22621.0\\um -IC:\Program Files (x86)\Windows Kits\10\\include\10.0.22621.0\\shared -IC:\Program Files (x86)\Windows Kits\10\\include\10.0.22621.0\\winrt -IC:\Program Files (x86)\Windows Kits\10\\include\10.0.22621.0\\cppwinrt -IC:\Program Files (x86)\Windows Kits\NETFXSDK\4.8\include\um /Tcpandas\_libs/algos.c /Fobuild\temp.win-amd64-3.9\Release\pandas\_libs/algos.obj
          algos.c
          C:\Program Files\Python39\lib\site-packages\numpy\core\include\numpy\npy_1_7_deprecated_api.h(14) : Warning Msg: Using deprecated NumPy API, disable it with #define NPY_NO_DEPRECATED_API NPY_1_7_API_VERSION
          pandas/_libs/src/klib\khash_python.h(75): warning C4244: '=': 將 'Py_hash_t' 轉換為 'khint_t'，由於類型不同，可能導致資料遺失
          pandas/_libs/src/klib\khash_python.h(81): warning C4244: '=': 將 'Py_hash_t' 轉換為 'khint_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(8770): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(14959): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(15891): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(16739): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(17585): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(18474): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(19322): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(20170): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(21018): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(21866): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(22714): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(23562): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(24410): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(25257): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(26117): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(26584): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(27052): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(27530): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(27997): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(28464): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(28931): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(29398): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(29865): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(30332): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(30799): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(31337): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(32262): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(32823): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(33385): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(33957): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(34518): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(35079): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(35640): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(36201): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(36762): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(37323): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(37884): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(38451): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(39384): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(40250): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(41114): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(42026): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(42892): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(43758): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(44624): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(45490): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(46356): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(47222): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(48088): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(48952): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(49810): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(50273): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(50737): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(51211): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(51674): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(52137): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(52600): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(53063): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(53526): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(53989): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(54452): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(54988): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(55911): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(56468): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(57026): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(57594): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(58151): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(58708): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(59265): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(59822): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(60379): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(60936): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(61493): warning C4244: '=': 將 'Py_ssize_t' 轉換為 'int'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(62057): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(66332): warning C4244: '=': 將 'long' 轉換為 'char'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(76282): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(76381): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(76492): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(76591): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(76973): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(77072): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(77183): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(77282): warning C4244: '=': 將 'int' 轉換為 '__pyx_t_5numpy_float32_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(78355): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(78454): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(78565): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(78664): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(82508): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(82542): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(82599): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(82642): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(84410): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(84472): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(84557): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(84628): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(86065): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(86099): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(86133): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(86167): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(86210): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(87751): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(87813): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(87875): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(87937): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(88008): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(89208): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(89242): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(89276): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(89310): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(89353): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(90651): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(90713): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(90775): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(90837): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(90908): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(92432): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(92466): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(92500): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(92534): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(92577): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(94146): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(94208): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(94270): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(94332): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(94403): warning C4244: '=': 將 'Py_ssize_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(126307): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(126643): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(126862): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(127227): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(127456): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(127848): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(128261): warning C4244: '=': 將 '__pyx_t_5numpy_int64_t' 轉換為 '__pyx_t_5numpy_float64_t'，由於類型不同，可能導致資料遺失
          pandas\_libs/algos.c(158842): error C2039: 'tp_print': 並非 '_typeobject' 的成員
          C:\Program Files\Python39\include\cpython/object.h(193): note: 請參閱 '_typeobject' 的宣告
          pandas\_libs/algos.c(158850): error C2039: 'tp_print': 並非 '_typeobject' 的成員
          C:\Program Files\Python39\include\cpython/object.h(193): note: 請參閱 '_typeobject' 的宣告
          pandas\_libs/algos.c(158855): error C2039: 'tp_print': 並非 '_typeobject' 的成員
          C:\Program Files\Python39\include\cpython/object.h(193): note: 請參閱 '_typeobject' 的宣告
          pandas\_libs/algos.c(158870): error C2039: 'tp_print': 並非 '_typeobject' 的成員
          C:\Program Files\Python39\include\cpython/object.h(193): note: 請參閱 '_typeobject' 的宣告
          pandas\_libs/algos.c(158883): error C2039: 'tp_print': 並非 '_typeobject' 的成員
          C:\Program Files\Python39\include\cpython/object.h(193): note: 請參閱 '_typeobject' 的宣告
          pandas\_libs/algos.c(164747): warning C4996: '_PyUnicode_get_wstr_length': deprecated in 3.3
          pandas\_libs/algos.c(164763): warning C4996: '_PyUnicode_get_wstr_length': deprecated in 3.3
          pandas\_libs/algos.c(167625): warning C4996: 'PyUnicode_FromUnicode': deprecated in 3.3
          error: command 'C:\\Program Files\\Microsoft Visual Studio\\2022\\VC\\Tools\\MSVC\\14.33.31629\\bin\\HostX86\\x64\\cl.exe' failed with exit code 2
          [end of output]

      note: This error originates from a subprocess, and is likely not a problem with pip.
      ERROR: Failed building wheel for pandas
      Running setup.py clean for pandas
      Building wheel for portpicker (setup.py) ... done
      Created wheel for portpicker: filename=portpicker-1.2.0-py3-none-any.whl size=13384 sha256=c16ca4d342ffbdbc4bcde3a2f048b0b0b1f92ba1f2b59407861b65a8a4da058b
      Stored in directory: c:\users\taixeflar\appdata\local\pip\cache\wheels\d3\dc\cc\bace7ffe874129f722f8eee56e162461907e1976cf1102d84c
      Building wheel for tornado (setup.py) ... done
      Created wheel for tornado: filename=tornado-4.5.3-cp39-cp39-win_amd64.whl size=425807 sha256=ae5d29b7c92b83f272357a8017cd396b50d1332a80670abbac2b95a5e44cc2e9
      Stored in directory: c:\users\taixeflar\appdata\local\pip\cache\wheels\ae\3b\7c\05b9d47da5eba9d22cbba0207676ef11072f119db2ff797352
      Building wheel for simplegeneric (setup.py) ... done
      Created wheel for simplegeneric: filename=simplegeneric-0.8.1-py3-none-any.whl size=5078 sha256=8b34e76a77d2ca1277308fda1fe62f42b4eb3f47fd42d9da0ca3990710eae411
      Stored in directory: c:\users\taixeflar\appdata\local\pip\cache\wheels\57\40\23\f22872052dd8633ca3672b2cc424fd116564dcee8a187710a1
    Successfully built google.colab portpicker tornado simplegeneric
    Failed to build pandas
    Installing collected packages: tornado, simplegeneric, portpicker, chardet, urllib3, six, idna, requests, prompt-toolkit, google-auth, pandas, jupyter-client, ipython, ipykernel, notebook, google.colab
      Attempting uninstall: tornado
        Found existing installation: tornado 6.2
        Uninstalling tornado-6.2:
          Successfully uninstalled tornado-6.2
      Attempting uninstall: urllib3
        Found existing installation: urllib3 1.26.12
        Uninstalling urllib3-1.26.12:
          Successfully uninstalled urllib3-1.26.12
      Attempting uninstall: six
        Found existing installation: six 1.16.0
        Uninstalling six-1.16.0:
          Successfully uninstalled six-1.16.0
      Attempting uninstall: idna
        Found existing installation: idna 3.4
        Uninstalling idna-3.4:
          Successfully uninstalled idna-3.4
      Attempting uninstall: requests
        Found existing installation: requests 2.28.1
        Uninstalling requests-2.28.1:
          Successfully uninstalled requests-2.28.1
      Attempting uninstall: prompt-toolkit
        Found existing installation: prompt-toolkit 3.0.31
        Uninstalling prompt-toolkit-3.0.31:
          Successfully uninstalled prompt-toolkit-3.0.31
      Attempting uninstall: google-auth
        Found existing installation: google-auth 2.13.0
        Uninstalling google-auth-2.13.0:
          Successfully uninstalled google-auth-2.13.0
      Attempting uninstall: pandas
        Found existing installation: pandas 1.5.1
        Uninstalling pandas-1.5.1:
          Successfully uninstalled pandas-1.5.1
      Running setup.py install for pandas ... error
      error: subprocess-exited-with-error

      × Running setup.py install for pandas did not run successfully.
      │ exit code: 1
      ╰─> [877 lines of output]
          running install
          running build
          running build_py
          creating build
          creating build\lib.win-amd64-3.9
          creating build\lib.win-amd64-3.9\pandas
          copying pandas\conftest.py -> build\lib.win-amd64-3.9\pandas
          copying pandas\testing.py -> build\lib.win-amd64-3.9\pandas
          copying pandas\_version.py -> build\lib.win-amd64-3.9\pandas
          copying pandas\__init__.py -> build\lib.win-amd64-3.9\pandas
          creating build\lib.win-amd64-3.9\pandas\api
          copying pandas\api\__init__.py -> build\lib.win-amd64-3.9\pandas\api
          creating build\lib.win-amd64-3.9\pandas\arrays
          copying pandas\arrays\__init__.py -> build\lib.win-amd64-3.9\pandas\arrays
          creating build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\chainmap.py -> build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\chainmap_impl.py -> build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\pickle_compat.py -> build\lib.win-amd64-3.9\pandas\compat
          copying pandas\compat\__init__.py -> build\lib.win-amd64-3.9\pandas\compat
          creating build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\accessor.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\algorithms.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\api.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\apply.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\base.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\categorical.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\common.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\config.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\config_init.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\frame.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\generic.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\index.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\indexing.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\missing.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\nanops.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\ops.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\panel.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\resample.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\series.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\sorting.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\strings.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\window.py -> build\lib.win-amd64-3.9\pandas\core
          copying pandas\core\__init__.py -> build\lib.win-amd64-3.9\pandas\core
          creating build\lib.win-amd64-3.9\pandas\errors
          copying pandas\errors\__init__.py -> build\lib.win-amd64-3.9\pandas\errors
          creating build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\api.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\clipboards.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\common.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\date_converters.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\excel.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\feather_format.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\gbq.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\gcs.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\html.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\packers.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\parquet.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\parsers.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\pickle.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\pytables.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\s3.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\sql.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\stata.py -> build\lib.win-amd64-3.9\pandas\io
          copying pandas\io\__init__.py -> build\lib.win-amd64-3.9\pandas\io
          creating build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_compat.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_converter.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_core.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_misc.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_style.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_timeseries.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\_tools.py -> build\lib.win-amd64-3.9\pandas\plotting
          copying pandas\plotting\__init__.py -> build\lib.win-amd64-3.9\pandas\plotting
          creating build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_algos.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_base.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_common.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_compat.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_config.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_downstream.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_errors.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_expressions.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_join.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_lib.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_multilevel.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_nanops.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_register_accessor.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_strings.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_take.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\test_window.py -> build\lib.win-amd64-3.9\pandas\tests
          copying pandas\tests\__init__.py -> build\lib.win-amd64-3.9\pandas\tests
          creating build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\api.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\converter.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\frequencies.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\holiday.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\offsets.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\plotting.py -> build\lib.win-amd64-3.9\pandas\tseries
          copying pandas\tseries\__init__.py -> build\lib.win-amd64-3.9\pandas\tseries
          creating build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\testing.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_decorators.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_depr_module.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_doctools.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_exceptions.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_print_versions.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_tester.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_test_decorators.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\_validators.py -> build\lib.win-amd64-3.9\pandas\util
          copying pandas\util\__init__.py -> build\lib.win-amd64-3.9\pandas\util
          creating build\lib.win-amd64-3.9\pandas\_libs
          copying pandas\_libs\__init__.py -> build\lib.win-amd64-3.9\pandas\_libs
          creating build\lib.win-amd64-3.9\pandas\api\extensions
          copying pandas\api\extensions\__init__.py -> build\lib.win-amd64-3.9\pandas\api\extensions
          creating build\lib.win-amd64-3.9\pandas\api\types
          copying pandas\api\types\__init__.py -> build\lib.win-amd64-3.9\pandas\api\types
          creating build\lib.win-amd64-3.9\pandas\compat\numpy
          copying pandas\compat\numpy\function.py -> build\lib.win-amd64-3.9\pandas\compat\numpy
          copying pandas\compat\numpy\__init__.py -> build\lib.win-amd64-3.9\pandas\compat\numpy
          creating build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\array_.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\base.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\categorical.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\datetimelike.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\datetimes.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\integer.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\interval.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\numpy_.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\period.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\sparse.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\timedeltas.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\_ranges.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          copying pandas\core\arrays\__init__.py -> build\lib.win-amd64-3.9\pandas\core\arrays
          creating build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\align.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\api.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\check.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\common.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\engines.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\eval.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\expr.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\expressions.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\ops.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\pytables.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\scope.py -> build\lib.win-amd64-3.9\pandas\core\computation
          copying pandas\core\computation\__init__.py -> build\lib.win-amd64-3.9\pandas\core\computation
          creating build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\api.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\base.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\cast.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\common.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\concat.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\dtypes.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\generic.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\inference.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\missing.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          copying pandas\core\dtypes\__init__.py -> build\lib.win-amd64-3.9\pandas\core\dtypes
          creating build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\base.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\categorical.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\generic.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\groupby.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\grouper.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\ops.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          copying pandas\core\groupby\__init__.py -> build\lib.win-amd64-3.9\pandas\core\groupby
          creating build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\accessors.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\api.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\base.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\category.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\datetimelike.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\datetimes.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\frozen.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\interval.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\multi.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\numeric.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\period.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\range.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\timedeltas.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          copying pandas\core\indexes\__init__.py -> build\lib.win-amd64-3.9\pandas\core\indexes
          creating build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\arrays.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\blocks.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\concat.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\construction.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\managers.py -> build\lib.win-amd64-3.9\pandas\core\internals
          copying pandas\core\internals\__init__.py -> build\lib.win-amd64-3.9\pandas\core\internals
          creating build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\api.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\concat.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\melt.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\merge.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\pivot.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\reshape.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\tile.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\util.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          copying pandas\core\reshape\__init__.py -> build\lib.win-amd64-3.9\pandas\core\reshape
          creating build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\api.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\frame.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\scipy_sparse.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\series.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          copying pandas\core\sparse\__init__.py -> build\lib.win-amd64-3.9\pandas\core\sparse
          creating build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\datetimes.py -> build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\numeric.py -> build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\timedeltas.py -> build\lib.win-amd64-3.9\pandas\core\tools
          copying pandas\core\tools\__init__.py -> build\lib.win-amd64-3.9\pandas\core\tools
          creating build\lib.win-amd64-3.9\pandas\core\util
          copying pandas\core\util\hashing.py -> build\lib.win-amd64-3.9\pandas\core\util
          copying pandas\core\util\__init__.py -> build\lib.win-amd64-3.9\pandas\core\util
          creating build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\clipboards.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\exceptions.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\windows.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          copying pandas\io\clipboard\__init__.py -> build\lib.win-amd64-3.9\pandas\io\clipboard
          creating build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\console.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\css.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\csvs.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\excel.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\format.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\html.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\latex.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\printing.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\style.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\terminal.py -> build\lib.win-amd64-3.9\pandas\io\formats
          copying pandas\io\formats\__init__.py -> build\lib.win-amd64-3.9\pandas\io\formats
          creating build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\json.py -> build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\normalize.py -> build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\table_schema.py -> build\lib.win-amd64-3.9\pandas\io\json
          copying pandas\io\json\__init__.py -> build\lib.win-amd64-3.9\pandas\io\json
          creating build\lib.win-amd64-3.9\pandas\io\msgpack
          copying pandas\io\msgpack\exceptions.py -> build\lib.win-amd64-3.9\pandas\io\msgpack
          copying pandas\io\msgpack\_version.py -> build\lib.win-amd64-3.9\pandas\io\msgpack
          copying pandas\io\msgpack\__init__.py -> build\lib.win-amd64-3.9\pandas\io\msgpack
          creating build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sas7bdat.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sasreader.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sas_constants.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\sas_xport.py -> build\lib.win-amd64-3.9\pandas\io\sas
          copying pandas\io\sas\__init__.py -> build\lib.win-amd64-3.9\pandas\io\sas
          creating build\lib.win-amd64-3.9\pandas\tests\api
          copying pandas\tests\api\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\api
          copying pandas\tests\api\test_types.py -> build\lib.win-amd64-3.9\pandas\tests\api
          copying pandas\tests\api\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\api
          creating build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_datetime64.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_object.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\test_timedelta64.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          copying pandas\tests\arithmetic\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arithmetic
          creating build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_array.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_datetimes.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_integer.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_numpy.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\test_timedeltas.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          copying pandas\tests\arrays\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays
          creating build\lib.win-amd64-3.9\pandas\tests\computation
          copying pandas\tests\computation\test_compat.py -> build\lib.win-amd64-3.9\pandas\tests\computation
          copying pandas\tests\computation\test_eval.py -> build\lib.win-amd64-3.9\pandas\tests\computation
          copying pandas\tests\computation\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\computation
          creating build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_concat.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_generic.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_inference.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          copying pandas\tests\dtypes\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes
          creating build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_categorical.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_external_block.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_integer.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\test_sparse.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          copying pandas\tests\extension\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension
          creating build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\common.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_alter_axes.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_asof.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_axis_select_reindex.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_block_internals.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_combine_concat.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_constructors.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_convert_to.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_duplicates.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_join.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_mutate_columns.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_nonunique_indexes.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_operators.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_quantile.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_query_eval.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_rank.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_replace.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_repr_info.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_sort_values_level_as_str.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_subclass.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_timeseries.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_to_csv.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\test_validate.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          copying pandas\tests\frame\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\frame
          creating build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_frame.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_generic.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_label_or_level_utils.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\test_series.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          copying pandas\tests\generic\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\generic
          creating build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_bin_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_categorical.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_counting.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_filters.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_function.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_grouping.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_index_as_string.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_nth.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_rank.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_timegrouper.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_transform.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_value_counts.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\test_whitelist.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          copying pandas\tests\groupby\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\groupby
          creating build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\common.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_base.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_category.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_frozen.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\test_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          copying pandas\tests\indexes\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes
          creating build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\common.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_callable.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_categorical.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_chaining_and_caching.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_coercion.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_floats.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_iloc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_indexing_engines.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_indexing_slow.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_ix.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_loc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_partial.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_scalar.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          copying pandas\tests\indexing\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexing
          creating build\lib.win-amd64-3.9\pandas\tests\internals
          copying pandas\tests\internals\test_internals.py -> build\lib.win-amd64-3.9\pandas\tests\internals
          copying pandas\tests\internals\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\internals
          creating build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\generate_legacy_storage_files.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_clipboard.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_compression.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_date_converters.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_excel.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_feather.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_gbq.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_gcs.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_html.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_packers.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_parquet.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_pickle.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_pytables.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_s3.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_sql.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\test_stata.py -> build\lib.win-amd64-3.9\pandas\tests\io
          copying pandas\tests\io\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io
          creating build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\common.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_boxplot_method.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_converter.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_frame.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_hist_method.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_misc.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\test_series.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          copying pandas\tests\plotting\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\plotting
          creating build\lib.win-amd64-3.9\pandas\tests\reductions
          copying pandas\tests\reductions\test_reductions.py -> build\lib.win-amd64-3.9\pandas\tests\reductions
          copying pandas\tests\reductions\test_stat_reductions.py -> build\lib.win-amd64-3.9\pandas\tests\reductions
          copying pandas\tests\reductions\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\reductions
          creating build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_base.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_datetime_index.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_period_index.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_resampler_grouper.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_resample_api.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\test_time_grouper.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          copying pandas\tests\resample\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\resample
          creating build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_concat.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_cut.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_melt.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_pivot.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_qcut.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_union_categoricals.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\test_util.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          copying pandas\tests\reshape\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\reshape
          creating build\lib.win-amd64-3.9\pandas\tests\scalar
          copying pandas\tests\scalar\test_nat.py -> build\lib.win-amd64-3.9\pandas\tests\scalar
          copying pandas\tests\scalar\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar
          creating build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\common.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_alter_axes.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_asof.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_block_internals.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_combine_concat.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_constructors.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_datetime_values.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_duplicates.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_internals.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_io.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_operators.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_quantile.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_rank.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_replace.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_repr.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_subclass.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_timeseries.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\test_validate.py -> build\lib.win-amd64-3.9\pandas\tests\series
          copying pandas\tests\series\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\series
          creating build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\common.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_combine_concat.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_groupby.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_pivot.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          copying pandas\tests\sparse\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\sparse
          creating build\lib.win-amd64-3.9\pandas\tests\tools
          copying pandas\tests\tools\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\tools
          copying pandas\tests\tools\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tools
          creating build\lib.win-amd64-3.9\pandas\tests\tseries
          copying pandas\tests\tseries\test_frequencies.py -> build\lib.win-amd64-3.9\pandas\tests\tseries
          copying pandas\tests\tseries\test_holiday.py -> build\lib.win-amd64-3.9\pandas\tests\tseries
          copying pandas\tests\tseries\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tseries
          creating build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_array_to_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_ccalendar.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_conversion.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_libfrequencies.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_liboffsets.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_normalize_date.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_parse_iso8601.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_parsing.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_period_asfreq.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_timedeltas.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          copying pandas\tests\tslibs\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tslibs
          creating build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_almost_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_categorical_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_extension_array_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_frame_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_index_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_interval_array_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_numpy_array_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_assert_series_equal.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_deprecate.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_deprecate_kwarg.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_hashing.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_locale.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_move.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_safe_import.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_util.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_validate_args.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_validate_args_and_kwargs.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\test_validate_kwargs.py -> build\lib.win-amd64-3.9\pandas\tests\util
          copying pandas\tests\util\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\util
          creating build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\common.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_algos.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_api.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_constructors.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_operators.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_repr.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_subclass.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\test_warnings.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          copying pandas\tests\arrays\categorical\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\categorical
          creating build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          copying pandas\tests\arrays\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          copying pandas\tests\arrays\interval\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          copying pandas\tests\arrays\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\interval
          creating build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_arithmetics.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_array.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_dtype.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\test_libsparse.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          copying pandas\tests\arrays\sparse\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\arrays\sparse
          creating build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_construct_from_scalar.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_construct_ndarray.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_construct_object_arr.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_convert_objects.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_downcast.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_find_common_type.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_infer_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\test_infer_dtype.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          copying pandas\tests\dtypes\cast\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\dtypes\cast
          creating build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          copying pandas\tests\extension\arrow\bool.py -> build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          copying pandas\tests\extension\arrow\test_bool.py -> build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          copying pandas\tests\extension\arrow\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\arrow
          creating build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\base.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\casting.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\constructors.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\dtype.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\getitem.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\groupby.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\interface.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\io.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\methods.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\missing.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\ops.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\printing.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\reduce.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\reshaping.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\setitem.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          copying pandas\tests\extension\base\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\base
          creating build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          copying pandas\tests\extension\decimal\array.py -> build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          copying pandas\tests\extension\decimal\test_decimal.py -> build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          copying pandas\tests\extension\decimal\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\decimal
          creating build\lib.win-amd64-3.9\pandas\tests\extension\json
          copying pandas\tests\extension\json\array.py -> build\lib.win-amd64-3.9\pandas\tests\extension\json
          copying pandas\tests\extension\json\test_json.py -> build\lib.win-amd64-3.9\pandas\tests\extension\json
          copying pandas\tests\extension\json\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\json
          creating build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\test_numpy.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\test_numpy_nested.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          copying pandas\tests\extension\numpy_\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\extension\numpy_
          creating build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\test_aggregate.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\test_cython.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\test_other.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          copying pandas\tests\groupby\aggregate\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\groupby\aggregate
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_datetimelike.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_date_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_misc.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_partial_slicing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_scalar_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_setops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\test_tools.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          copying pandas\tests\indexes\datetimes\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\datetimes
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval_new.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\test_interval_tree.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          copying pandas\tests\indexes\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\interval
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_constructor.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_contains.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_conversion.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_copy.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_drop.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_duplicates.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_equivalence.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_get_set.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_integrity.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_join.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_missing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_monotonic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_names.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_partial_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_reindex.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_reshape.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_set_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\test_sorting.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          copying pandas\tests\indexes\multi\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\multi
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_asfreq.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_partial_slicing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_period_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_scalar_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_setops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\test_tools.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          copying pandas\tests\indexes\period\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\period
          creating build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_astype.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_partial_slicing.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_scalar_compat.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_setops.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_timedelta_range.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\test_tools.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          copying pandas\tests\indexes\timedeltas\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexes\timedeltas
          creating build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          copying pandas\tests\indexing\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          copying pandas\tests\indexing\interval\test_interval_new.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          copying pandas\tests\indexing\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\interval
          creating build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_chaining_and_caching.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_getitem.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_iloc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_indexing_slow.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_ix.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_loc.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_multiindex.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_panel.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_partial.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_setitem.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_set_ops.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_slice.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_sorted.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\test_xs.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          copying pandas\tests\indexing\multiindex\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\indexing\multiindex
          creating build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_console.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_css.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_eng_formatting.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_printing.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_style.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_csv.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_excel.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_html.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\test_to_latex.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          copying pandas\tests\io\formats\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\formats
          creating build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_compression.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_json_table_schema.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_normalize.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_pandas.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_readlines.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\test_ujson.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          copying pandas\tests\io\json\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\json
          creating build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\common.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_buffer.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_case.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_except.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_extension.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_format.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_limits.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_newspec.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_obj.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_pack.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_read_size.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_seq.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_sequnpack.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_subtype.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_unpack.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\test_unpack_raw.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          copying pandas\tests\io\msgpack\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\msgpack
          creating build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_comment.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_common.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_compression.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_converters.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_c_parser_only.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_dialect.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_dtypes.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_header.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_index_col.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_mangle_dupes.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_multi_thread.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_na_values.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_network.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_parse_dates.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_python_parser_only.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_quoting.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_read_fwf.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_skiprows.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_textreader.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_unsupported.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\test_usecols.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          copying pandas\tests\io\parser\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\parser
          creating build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\test_sas.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\test_sas7bdat.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\test_xport.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          copying pandas\tests\io\sas\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\io\sas
          creating build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_join.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge_asof.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge_index_as_string.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_merge_ordered.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\test_multi.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          copying pandas\tests\reshape\merge\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\reshape\merge
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          copying pandas\tests\scalar\interval\test_interval.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          copying pandas\tests\scalar\interval\test_ops.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          copying pandas\tests\scalar\interval\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\interval
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\period
          copying pandas\tests\scalar\period\test_asfreq.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\period
          copying pandas\tests\scalar\period\test_period.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\period
          copying pandas\tests\scalar\period\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\period
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_construction.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_formats.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\test_timedelta.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          copying pandas\tests\scalar\timedelta\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timedelta
          creating build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_arithmetic.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_comparisons.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_rendering.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_timestamp.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_timezones.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\test_unary_ops.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          copying pandas\tests\scalar\timestamp\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\scalar\timestamp
          creating build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_alter_index.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_boolean.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_callable.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_datetime.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_iloc.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_loc.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\test_numeric.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          copying pandas\tests\series\indexing\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\series\indexing
          creating build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_analytics.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_apply.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_frame.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_to_csv.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\test_to_from_scipy.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          copying pandas\tests\sparse\frame\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\frame
          creating build\lib.win-amd64-3.9\pandas\tests\sparse\series
          copying pandas\tests\sparse\series\test_indexing.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\series
          copying pandas\tests\sparse\series\test_series.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\series
          copying pandas\tests\sparse\series\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\sparse\series
          creating build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\common.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\conftest.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_fiscal.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_offsets.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_offsets_properties.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_ticks.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\test_yqm_offsets.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          copying pandas\tests\tseries\offsets\__init__.py -> build\lib.win-amd64-3.9\pandas\tests\tseries\offsets
          creating build\lib.win-amd64-3.9\pandas\_libs\tslibs
          copying pandas\_libs\tslibs\__init__.py -> build\lib.win-amd64-3.9\pandas\_libs\tslibs
          creating build\lib.win-amd64-3.9\pandas\io\formats\templates
          copying pandas\io\formats\templates\html.tpl -> build\lib.win-amd64-3.9\pandas\io\formats\templates
          UPDATING build\lib.win-amd64-3.9\pandas/_version.py
          set build\lib.win-amd64-3.9\pandas/_version.py to '0.24.2'
          running build_ext
          Traceback (most recent call last):
            File "<string>", line 2, in <module>
            File "<pip-setuptools-caller>", line 34, in <module>
            File "C:\Users\TaiXeflar\AppData\Local\Temp\pip-install-9kom5cz8\pandas_37ef1188460242d6a9d51efe37e10ee5\setup.py", line 730, in <module>
              setup(name=DISTNAME,
            File "C:\Program Files\Python39\lib\site-packages\setuptools\__init__.py", line 153, in setup
              return distutils.core.setup(**attrs)
            File "C:\Program Files\Python39\lib\distutils\core.py", line 148, in setup
              dist.run_commands()
            File "C:\Program Files\Python39\lib\distutils\dist.py", line 966, in run_commands
              self.run_command(cmd)
            File "C:\Program Files\Python39\lib\distutils\dist.py", line 985, in run_command
              cmd_obj.run()
            File "C:\Program Files\Python39\lib\site-packages\setuptools\command\install.py", line 61, in run
              return orig.install.run(self)
            File "C:\Program Files\Python39\lib\distutils\command\install.py", line 546, in run
              self.run_command('build')
            File "C:\Program Files\Python39\lib\distutils\cmd.py", line 313, in run_command
              self.distribution.run_command(command)
            File "C:\Program Files\Python39\lib\distutils\dist.py", line 985, in run_command
              cmd_obj.run()
            File "C:\Program Files\Python39\lib\distutils\command\build.py", line 135, in run
              self.run_command(cmd_name)
            File "C:\Program Files\Python39\lib\distutils\cmd.py", line 313, in run_command
              self.distribution.run_command(command)
            File "C:\Program Files\Python39\lib\distutils\dist.py", line 985, in run_command
              cmd_obj.run()
            File "C:\Program Files\Python39\lib\distutils\command\build_ext.py", line 340, in run
              self.build_extensions()
            File "C:\Users\TaiXeflar\AppData\Local\Temp\pip-install-9kom5cz8\pandas_37ef1188460242d6a9d51efe37e10ee5\setup.py", line 372, in build_extensions
              self.check_cython_extensions(self.extensions)
            File "C:\Users\TaiXeflar\AppData\Local\Temp\pip-install-9kom5cz8\pandas_37ef1188460242d6a9d51efe37e10ee5\setup.py", line 366, in check_cython_extensions
              raise Exception("""Cython-generated file '{src}' not found.
          Exception: Cython-generated file 'pandas\_libs/algos.c' not found.
                          Cython is required to compile pandas from a development branch.
                          Please install Cython or download a release package of pandas.

          pandas._libs.algos: -> [['pandas\\_libs/algos.c']]
          [end of output]

      note: This error originates from a subprocess, and is likely not a problem with pip.
      Rolling back uninstall of pandas
      Moving to c:\program files\python39\lib\site-packages\pandas-1.5.1.dist-info\
      from C:\Program Files\Python39\Lib\site-packages\~andas-1.5.1.dist-info
      Moving to c:\program files\python39\lib\site-packages\pandas\
      from C:\Program Files\Python39\Lib\site-packages\~andas
    error: legacy-install-failure

    × Encountered error while trying to install package.
    ╰─> pandas

    note: This is an issue with the package mentioned above, not pip.
    hint: See above for output from the failure.
    ```

## Jupyter Notebook 注意事項

 - Jupyter筆記本可以執行Python核心或Julia核心。請妥善選擇執行的本地端核心(Kernel)以避免出現程式執行錯誤。
 - Jupyter筆記本可以選擇具有Conda環境的Python。若有Conda環境選擇需求請改選base的Conda Python。
 - 每一個可執行Python/Julia或是註記(Markdown)的儲存格被稱為cell。執行cell的熱鍵是`Shift + Enter`。
 - 請注意該筆記本內每一個cell的執行時間序。若有被刪除的cell影響到後續cell的執行，請在該時間序之後的cell重新執行。
 - 當遇到不可預期的錯誤時(例如程式報錯不符合預期內的錯誤)，試試看重新啟動核心(kernel)並全部重新執行一次。
 - 使用VSCode開啟的Jupyter不需要以終端機掛載ipykernel就能正常執行筆記本的Python互動式偵錯。
 - ipynb是Jupyter筆記本的副檔名，內容為json格式。
 - 請注意，在VSCode內以SSH連線執行遠端Google Colabatory的Python偵錯有可能會被視為違反Google Colabatory使用條款。