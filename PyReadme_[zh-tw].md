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

這裡舉例一個使用終端機安裝多個套件的實際過程:

 ```
PS C:\Users\TaiXeflar> pip install Numpy, Matplotlib, pandas, numba, bs4, flask, discord, scikit-learn, tensorflow-gpu, torch torchvision torchaudio --extra-index-url https://download.pytorch.org/whl/cu116, jupyter
Looking in indexes: https://pypi.org/simple, https://download.pytorch.org/whl/cu116
Collecting Numpy
  Downloading numpy-1.23.4-cp39-cp39-win_amd64.whl (14.7 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 14.7/14.7 MB 11.3 MB/s eta 0:00:00
Collecting Matplotlib
  Downloading matplotlib-3.6.1-cp39-cp39-win_amd64.whl (7.2 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 7.2/7.2 MB 11.5 MB/s eta 0:00:00
Collecting pandas
  Downloading pandas-1.5.1-cp39-cp39-win_amd64.whl (10.9 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 10.9/10.9 MB 11.5 MB/s eta 0:00:00
Collecting numba
  Downloading numba-0.56.3-cp39-cp39-win_amd64.whl (2.5 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 2.5/2.5 MB 12.1 MB/s eta 0:00:00
Collecting bs4
  Downloading bs4-0.0.1.tar.gz (1.1 kB)
  Preparing metadata (setup.py) ... done
Collecting flask
  Downloading Flask-2.2.2-py3-none-any.whl (101 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 101.5/101.5 kB ? eta 0:00:00
Collecting discord
  Downloading discord-2.0.0-py3-none-any.whl (1.1 kB)
Collecting scikit-learn
  Downloading scikit_learn-1.1.2-cp39-cp39-win_amd64.whl (7.4 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 7.4/7.4 MB 11.6 MB/s eta 0:00:00
Collecting tensorflow-gpu
  Downloading tensorflow_gpu-2.10.0-cp39-cp39-win_amd64.whl (455.9 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 455.9/455.9 MB 5.3 MB/s eta 0:00:00
Collecting torch
  Downloading https://download.pytorch.org/whl/cu116/torch-1.12.1%2Bcu116-cp39-cp39-win_amd64.whl (2388.0 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 2.4/2.4 GB 1.7 MB/s eta 0:00:00
Collecting torchvision
  Downloading https://download.pytorch.org/whl/cu116/torchvision-0.13.1%2Bcu116-cp39-cp39-win_amd64.whl (2.6 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 2.6/2.6 MB 8.2 MB/s eta 0:00:00
Collecting torchaudio
  Downloading https://download.pytorch.org/whl/cu116/torchaudio-0.12.1%2Bcu116-cp39-cp39-win_amd64.whl (1.2 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.2/1.2 MB 5.4 MB/s eta 0:00:00
Collecting jupyter
  Downloading jupyter-1.0.0-py2.py3-none-any.whl (2.7 kB)
Collecting python-dateutil>=2.7
  Downloading python_dateutil-2.8.2-py2.py3-none-any.whl (247 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 247.7/247.7 kB 2.6 MB/s eta 0:00:00
Collecting pillow>=6.2.0
  Downloading Pillow-9.2.0-cp39-cp39-win_amd64.whl (3.3 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 3.3/3.3 MB 11.6 MB/s eta 0:00:00
Collecting kiwisolver>=1.0.1
  Downloading kiwisolver-1.4.4-cp39-cp39-win_amd64.whl (55 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 55.4/55.4 kB 2.8 MB/s eta 0:00:00
Collecting fonttools>=4.22.0
  Downloading fonttools-4.37.4-py3-none-any.whl (960 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 960.8/960.8 kB 12.2 MB/s eta 0:00:00
Collecting cycler>=0.10
  Downloading cycler-0.11.0-py3-none-any.whl (6.4 kB)
Collecting contourpy>=1.0.1
  Downloading contourpy-1.0.5-cp39-cp39-win_amd64.whl (161 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 162.0/162.0 kB 10.1 MB/s eta 0:00:00
Collecting packaging>=20.0
  Downloading packaging-21.3-py3-none-any.whl (40 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 40.8/40.8 kB 1.9 MB/s eta 0:00:00
Collecting pyparsing>=2.2.1
  Downloading pyparsing-3.0.9-py3-none-any.whl (98 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 98.3/98.3 kB 5.9 MB/s eta 0:00:00
Collecting pytz>=2020.1
  Downloading pytz-2022.5-py2.py3-none-any.whl (500 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 500.7/500.7 kB 15.3 MB/s eta 0:00:00
Requirement already satisfied: setuptools in c:\program files\python39\lib\site-packages (from numba) (57.4.0)
Collecting llvmlite<0.40,>=0.39.0dev0
  Downloading llvmlite-0.39.1-cp39-cp39-win_amd64.whl (23.2 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 23.2/23.2 MB 11.3 MB/s eta 0:00:00
Collecting beautifulsoup4
  Downloading beautifulsoup4-4.11.1-py3-none-any.whl (128 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 128.2/128.2 kB 7.4 MB/s eta 0:00:00
Collecting Jinja2>=3.0
  Downloading Jinja2-3.1.2-py3-none-any.whl (133 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 133.1/133.1 kB 7.7 MB/s eta 0:00:00
Collecting itsdangerous>=2.0
  Downloading itsdangerous-2.1.2-py3-none-any.whl (15 kB)
Collecting click>=8.0
  Downloading click-8.1.3-py3-none-any.whl (96 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 96.6/96.6 kB ? eta 0:00:00
Collecting importlib-metadata>=3.6.0
  Downloading importlib_metadata-5.0.0-py3-none-any.whl (21 kB)
Collecting Werkzeug>=2.2.2
  Downloading Werkzeug-2.2.2-py3-none-any.whl (232 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 232.7/232.7 kB 13.9 MB/s eta 0:00:00
Collecting discord.py>=2.0.0
  Downloading discord.py-2.0.1-py3-none-any.whl (1.1 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.1/1.1 MB 11.2 MB/s eta 0:00:00
Collecting threadpoolctl>=2.0.0
  Downloading threadpoolctl-3.1.0-py3-none-any.whl (14 kB)
Collecting scipy>=1.3.2
  Downloading scipy-1.9.3-cp39-cp39-win_amd64.whl (40.2 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 40.2/40.2 MB 10.7 MB/s eta 0:00:00
Collecting joblib>=1.0.0
  Downloading joblib-1.2.0-py3-none-any.whl (297 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 298.0/298.0 kB 9.3 MB/s eta 0:00:00
Collecting tensorboard<2.11,>=2.10
  Downloading tensorboard-2.10.1-py3-none-any.whl (5.9 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 5.9/5.9 MB 11.0 MB/s eta 0:00:00
Collecting tensorflow-io-gcs-filesystem>=0.23.1
  Downloading tensorflow_io_gcs_filesystem-0.27.0-cp39-cp39-win_amd64.whl (1.5 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.5/1.5 MB 10.5 MB/s eta 0:00:00
Collecting typing-extensions>=3.6.6
  Downloading typing_extensions-4.4.0-py3-none-any.whl (26 kB)
Collecting libclang>=13.0.0
  Downloading libclang-14.0.6-py2.py3-none-win_amd64.whl (14.2 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 14.2/14.2 MB 11.5 MB/s eta 0:00:00
Collecting astunparse>=1.6.0
  Downloading astunparse-1.6.3-py2.py3-none-any.whl (12 kB)
Collecting gast<=0.4.0,>=0.2.1
  Downloading gast-0.4.0-py3-none-any.whl (9.8 kB)
Collecting tensorflow-estimator<2.11,>=2.10.0
  Downloading tensorflow_estimator-2.10.0-py2.py3-none-any.whl (438 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 438.7/438.7 kB 13.8 MB/s eta 0:00:00
Collecting six>=1.12.0
  Downloading six-1.16.0-py2.py3-none-any.whl (11 kB)
Collecting protobuf<3.20,>=3.9.2
  Downloading protobuf-3.19.6-cp39-cp39-win_amd64.whl (895 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 895.9/895.9 kB 11.4 MB/s eta 0:00:00
Collecting google-pasta>=0.1.1
  Downloading google_pasta-0.2.0-py3-none-any.whl (57 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 57.5/57.5 kB 3.1 MB/s eta 0:00:00
Collecting h5py>=2.9.0
  Downloading h5py-3.7.0-cp39-cp39-win_amd64.whl (2.6 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 2.6/2.6 MB 11.2 MB/s eta 0:00:00
Collecting termcolor>=1.1.0
  Downloading termcolor-2.0.1-py3-none-any.whl (5.4 kB)
Collecting keras<2.11,>=2.10.0
  Downloading keras-2.10.0-py2.py3-none-any.whl (1.7 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.7/1.7 MB 12.0 MB/s eta 0:00:00
Collecting flatbuffers>=2.0
  Downloading flatbuffers-22.9.24-py2.py3-none-any.whl (26 kB)
Collecting wrapt>=1.11.0
  Downloading wrapt-1.14.1-cp39-cp39-win_amd64.whl (35 kB)
Collecting absl-py>=1.0.0
  Downloading absl_py-1.3.0-py3-none-any.whl (124 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 124.6/124.6 kB 7.1 MB/s eta 0:00:00
Collecting keras-preprocessing>=1.1.1
  Downloading Keras_Preprocessing-1.1.2-py2.py3-none-any.whl (42 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 42.6/42.6 kB ? eta 0:00:00
Collecting grpcio<2.0,>=1.24.3
  Downloading grpcio-1.50.0-cp39-cp39-win_amd64.whl (3.7 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 3.7/3.7 MB 11.6 MB/s eta 0:00:00
Collecting opt-einsum>=2.3.2
  Downloading opt_einsum-3.3.0-py3-none-any.whl (65 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 65.5/65.5 kB 3.7 MB/s eta 0:00:00
Collecting requests
  Downloading requests-2.28.1-py3-none-any.whl (62 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 62.8/62.8 kB ? eta 0:00:00
Collecting notebook
  Downloading notebook-6.5.1-py3-none-any.whl (439 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 439.1/439.1 kB 13.4 MB/s eta 0:00:00
Collecting ipykernel
  Downloading ipykernel-6.16.1-py3-none-any.whl (138 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 138.5/138.5 kB 8.6 MB/s eta 0:00:00
Collecting ipywidgets
  Downloading ipywidgets-8.0.2-py3-none-any.whl (134 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 134.4/134.4 kB 7.8 MB/s eta 0:00:00
Collecting jupyter-console
  Downloading jupyter_console-6.4.4-py3-none-any.whl (22 kB)
Collecting nbconvert
  Downloading nbconvert-7.2.2-py3-none-any.whl (271 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 271.6/271.6 kB 17.4 MB/s eta 0:00:00
Collecting qtconsole
  Downloading qtconsole-5.3.2-py3-none-any.whl (120 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 120.8/120.8 kB ? eta 0:00:00
Collecting wheel<1.0,>=0.23.0
  Downloading wheel-0.37.1-py2.py3-none-any.whl (35 kB)
Collecting colorama
  Downloading colorama-0.4.5-py2.py3-none-any.whl (16 kB)
Collecting aiohttp<4,>=3.7.4
  Downloading aiohttp-3.8.3-cp39-cp39-win_amd64.whl (323 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 323.5/323.5 kB 9.8 MB/s eta 0:00:00
Collecting zipp>=0.5
  Downloading zipp-3.9.0-py3-none-any.whl (5.8 kB)
Collecting MarkupSafe>=2.0
  Downloading MarkupSafe-2.1.1-cp39-cp39-win_amd64.whl (17 kB)
Collecting markdown>=2.6.8
  Downloading Markdown-3.4.1-py3-none-any.whl (93 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 93.3/93.3 kB ? eta 0:00:00
Collecting tensorboard-data-server<0.7.0,>=0.6.0
  Downloading tensorboard_data_server-0.6.1-py3-none-any.whl (2.4 kB)
Collecting google-auth-oauthlib<0.5,>=0.4.1
  Downloading google_auth_oauthlib-0.4.6-py2.py3-none-any.whl (18 kB)
Collecting tensorboard-plugin-wit>=1.6.0
  Downloading tensorboard_plugin_wit-1.8.1-py3-none-any.whl (781 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 781.3/781.3 kB 12.4 MB/s eta 0:00:00
Collecting google-auth<3,>=1.6.3
  Downloading google_auth-2.13.0-py2.py3-none-any.whl (174 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 174.5/174.5 kB 10.3 MB/s eta 0:00:00
Collecting certifi>=2017.4.17
  Downloading certifi-2022.9.24-py3-none-any.whl (161 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 161.1/161.1 kB ? eta 0:00:00
Collecting idna<4,>=2.5
  Downloading idna-3.4-py3-none-any.whl (61 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 61.5/61.5 kB 3.4 MB/s eta 0:00:00
Collecting urllib3<1.27,>=1.21.1
  Downloading urllib3-1.26.12-py2.py3-none-any.whl (140 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 140.4/140.4 kB ? eta 0:00:00
Collecting charset-normalizer<3,>=2
  Downloading charset_normalizer-2.1.1-py3-none-any.whl (39 kB)
Collecting soupsieve>1.2
  Downloading soupsieve-2.3.2.post1-py3-none-any.whl (37 kB)
Collecting ipython>=7.23.1
  Downloading ipython-8.5.0-py3-none-any.whl (752 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 752.0/752.0 kB 11.8 MB/s eta 0:00:00
Collecting nest-asyncio
  Downloading nest_asyncio-1.5.6-py3-none-any.whl (5.2 kB)
Collecting psutil
  Downloading psutil-5.9.3-cp39-cp39-win_amd64.whl (247 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 247.1/247.1 kB 15.8 MB/s eta 0:00:00
Collecting matplotlib-inline>=0.1
  Downloading matplotlib_inline-0.1.6-py3-none-any.whl (9.4 kB)
Collecting pyzmq>=17
  Downloading pyzmq-24.0.1-cp39-cp39-win_amd64.whl (999 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 999.5/999.5 kB 10.5 MB/s eta 0:00:00
Collecting tornado>=6.1
  Downloading tornado-6.2-cp37-abi3-win_amd64.whl (425 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 425.3/425.3 kB 13.0 MB/s eta 0:00:00
Collecting jupyter-client>=6.1.12
  Downloading jupyter_client-7.4.3-py3-none-any.whl (132 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 132.2/132.2 kB 8.1 MB/s eta 0:00:00
Collecting traitlets>=5.1.0
  Downloading traitlets-5.5.0-py3-none-any.whl (107 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 107.4/107.4 kB 2.1 MB/s eta 0:00:00
Collecting debugpy>=1.0
  Downloading debugpy-1.6.3-cp39-cp39-win_amd64.whl (4.6 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 4.6/4.6 MB 10.9 MB/s eta 0:00:00
Collecting widgetsnbextension~=4.0
  Downloading widgetsnbextension-4.0.3-py3-none-any.whl (2.0 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 2.0/2.0 MB 10.0 MB/s eta 0:00:00
Collecting jupyterlab-widgets~=3.0
  Downloading jupyterlab_widgets-3.0.3-py3-none-any.whl (384 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 384.1/384.1 kB 12.1 MB/s eta 0:00:00
Collecting pygments
  Downloading Pygments-2.13.0-py3-none-any.whl (1.1 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.1/1.1 MB 11.6 MB/s eta 0:00:00
Collecting prompt-toolkit!=3.0.0,!=3.0.1,<3.1.0,>=2.0.0
  Downloading prompt_toolkit-3.0.31-py3-none-any.whl (382 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 382.3/382.3 kB 12.0 MB/s eta 0:00:00
Collecting tinycss2
  Downloading tinycss2-1.2.1-py3-none-any.whl (21 kB)
Collecting jupyterlab-pygments
  Downloading jupyterlab_pygments-0.2.2-py2.py3-none-any.whl (21 kB)
Collecting mistune<3,>=2.0.3
  Downloading mistune-2.0.4-py2.py3-none-any.whl (24 kB)
Collecting nbformat>=5.1
  Downloading nbformat-5.7.0-py3-none-any.whl (77 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 77.1/77.1 kB ? eta 0:00:00
Collecting nbclient>=0.5.0
  Downloading nbclient-0.7.0-py3-none-any.whl (71 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 71.9/71.9 kB 3.9 MB/s eta 0:00:00
Collecting jupyter-core>=4.7
  Downloading jupyter_core-4.11.2-py3-none-any.whl (88 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 88.5/88.5 kB ? eta 0:00:00
Collecting pandocfilters>=1.4.1
  Downloading pandocfilters-1.5.0-py2.py3-none-any.whl (8.7 kB)
Collecting defusedxml
  Downloading defusedxml-0.7.1-py2.py3-none-any.whl (25 kB)
Collecting bleach
  Downloading bleach-5.0.1-py3-none-any.whl (160 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 160.9/160.9 kB 9.4 MB/s eta 0:00:00
Collecting prometheus-client
  Downloading prometheus_client-0.15.0-py3-none-any.whl (60 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 60.1/60.1 kB 3.3 MB/s eta 0:00:00
Collecting terminado>=0.8.3
  Downloading terminado-0.16.0-py3-none-any.whl (16 kB)
Collecting argon2-cffi
  Downloading argon2_cffi-21.3.0-py3-none-any.whl (14 kB)
Collecting Send2Trash>=1.8.0
  Downloading Send2Trash-1.8.0-py3-none-any.whl (18 kB)
Collecting ipython-genutils
  Downloading ipython_genutils-0.2.0-py2.py3-none-any.whl (26 kB)
Collecting nbclassic==0.4.5
  Downloading nbclassic-0.4.5-py3-none-any.whl (9.8 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 9.8/9.8 MB 11.6 MB/s eta 0:00:00
Collecting jupyter-server>=1.8
  Downloading jupyter_server-1.21.0-py3-none-any.whl (346 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 346.5/346.5 kB 10.8 MB/s eta 0:00:00
Collecting notebook-shim>=0.1.0
  Downloading notebook_shim-0.2.0-py3-none-any.whl (13 kB)
Collecting qtpy>=2.0.1
  Downloading QtPy-2.2.1-py3-none-any.whl (82 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 82.6/82.6 kB ? eta 0:00:00
Collecting attrs>=17.3.0
  Downloading attrs-22.1.0-py2.py3-none-any.whl (58 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 58.8/58.8 kB ? eta 0:00:00
Collecting async-timeout<5.0,>=4.0.0a3
  Downloading async_timeout-4.0.2-py3-none-any.whl (5.8 kB)
Collecting aiosignal>=1.1.2
  Downloading aiosignal-1.2.0-py3-none-any.whl (8.2 kB)
Collecting yarl<2.0,>=1.0
  Downloading yarl-1.8.1-cp39-cp39-win_amd64.whl (56 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 56.7/56.7 kB ? eta 0:00:00
Collecting frozenlist>=1.1.1
  Downloading frozenlist-1.3.1-cp39-cp39-win_amd64.whl (34 kB)
Collecting multidict<7.0,>=4.5
  Downloading multidict-6.0.2-cp39-cp39-win_amd64.whl (28 kB)
Collecting cachetools<6.0,>=2.0.0
  Downloading cachetools-5.2.0-py3-none-any.whl (9.3 kB)
Collecting pyasn1-modules>=0.2.1
  Downloading pyasn1_modules-0.2.8-py2.py3-none-any.whl (155 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 155.3/155.3 kB 9.1 MB/s eta 0:00:00
Collecting rsa<5,>=3.1.4
  Downloading rsa-4.9-py3-none-any.whl (34 kB)
Collecting requests-oauthlib>=0.7.0
  Downloading requests_oauthlib-1.3.1-py2.py3-none-any.whl (23 kB)
Collecting jedi>=0.16
  Downloading jedi-0.18.1-py2.py3-none-any.whl (1.6 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.6/1.6 MB 11.0 MB/s eta 0:00:00
Collecting backcall
  Downloading backcall-0.2.0-py2.py3-none-any.whl (11 kB)
Collecting pickleshare
  Downloading pickleshare-0.7.5-py2.py3-none-any.whl (6.9 kB)
Collecting decorator
  Downloading decorator-5.1.1-py3-none-any.whl (9.1 kB)
Collecting stack-data
  Downloading stack_data-0.5.1-py3-none-any.whl (24 kB)
Collecting entrypoints
  Downloading entrypoints-0.4-py3-none-any.whl (5.3 kB)
Collecting pywin32>=1.0
  Downloading pywin32-304-cp39-cp39-win_amd64.whl (12.2 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 12.2/12.2 MB 11.5 MB/s eta 0:00:00
Collecting jsonschema>=2.6
  Downloading jsonschema-4.16.0-py3-none-any.whl (83 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 83.1/83.1 kB 4.6 MB/s eta 0:00:00
Collecting fastjsonschema
  Downloading fastjsonschema-2.16.2-py3-none-any.whl (22 kB)
Collecting wcwidth
  Downloading wcwidth-0.2.5-py2.py3-none-any.whl (30 kB)
Collecting pywinpty>=1.1.0
  Downloading pywinpty-2.0.8-cp39-none-win_amd64.whl (1.4 MB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 1.4/1.4 MB 11.2 MB/s eta 0:00:00
Collecting argon2-cffi-bindings
  Downloading argon2_cffi_bindings-21.2.0-cp36-abi3-win_amd64.whl (30 kB)
Collecting webencodings
  Downloading webencodings-0.5.1-py2.py3-none-any.whl (11 kB)
Collecting parso<0.9.0,>=0.8.0
  Downloading parso-0.8.3-py2.py3-none-any.whl (100 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 100.8/100.8 kB ? eta 0:00:00
Collecting pyrsistent!=0.17.0,!=0.17.1,!=0.17.2,>=0.14.0
  Downloading pyrsistent-0.18.1-cp39-cp39-win_amd64.whl (61 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 61.6/61.6 kB ? eta 0:00:00
Collecting anyio<4,>=3.1.0
  Downloading anyio-3.6.2-py3-none-any.whl (80 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 80.6/80.6 kB 4.7 MB/s eta 0:00:00
Collecting websocket-client
  Downloading websocket_client-1.4.1-py3-none-any.whl (55 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 55.0/55.0 kB ? eta 0:00:00
Collecting pyasn1<0.5.0,>=0.4.6
  Downloading pyasn1-0.4.8-py2.py3-none-any.whl (77 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 77.1/77.1 kB 4.2 MB/s eta 0:00:00
Collecting oauthlib>=3.0.0
  Downloading oauthlib-3.2.2-py3-none-any.whl (151 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 151.7/151.7 kB 9.4 MB/s eta 0:00:00
Collecting cffi>=1.0.1
  Downloading cffi-1.15.1-cp39-cp39-win_amd64.whl (179 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 179.1/179.1 kB 10.6 MB/s eta 0:00:00
Collecting pure-eval
  Downloading pure_eval-0.2.2-py3-none-any.whl (11 kB)
Collecting asttokens
  Downloading asttokens-2.0.8-py2.py3-none-any.whl (23 kB)
Collecting executing
  Downloading executing-1.1.1-py2.py3-none-any.whl (22 kB)
Collecting sniffio>=1.1
  Downloading sniffio-1.3.0-py3-none-any.whl (10 kB)
Collecting pycparser
  Downloading pycparser-2.21-py2.py3-none-any.whl (118 kB)
     ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 118.7/118.7 kB ? eta 0:00:00
Installing collected packages: webencodings, wcwidth, tensorboard-plugin-wit, Send2Trash, pywin32, pytz, pyasn1, pure-eval, pickleshare, mistune, libclang, keras, ipython-genutils, flatbuffers, fastjsonschema, executing, backcall, zipp, wrapt, widgetsnbextension, wheel, websocket-client, urllib3, typing-extensions, traitlets, tornado, tinycss2, threadpoolctl, termcolor, tensorflow-io-gcs-filesystem, tensorflow-estimator, tensorboard-data-server, soupsieve, sniffio, six, rsa, pyzmq, pywinpty, pyrsistent, pyparsing, pygments, pycparser, pyasn1-modules, psutil, protobuf, prompt-toolkit, prometheus-client, pillow, parso, pandocfilters, oauthlib, Numpy, nest-asyncio, multidict, MarkupSafe, llvmlite, kiwisolver, jupyterlab-widgets, jupyterlab-pygments, joblib, itsdangerous, idna, gast, frozenlist, fonttools, entrypoints, defusedxml, decorator, debugpy, cycler, colorama, charset-normalizer, certifi, cachetools, attrs, async-timeout, absl-py, yarl, Werkzeug, torch, terminado, scipy, requests, python-dateutil, packaging, opt-einsum, numba, matplotlib-inline, keras-preprocessing, jupyter-core, jsonschema, Jinja2, jedi, importlib-metadata, h5py, grpcio, google-pasta, google-auth, contourpy, click, cffi, bleach, beautifulsoup4, astunparse, asttokens, anyio, aiosignal, torchvision, torchaudio, stack-data, scikit-learn, requests-oauthlib, qtpy, pandas, nbformat, Matplotlib, markdown, jupyter-client, flask, bs4, argon2-cffi-bindings, aiohttp, nbclient, ipython, google-auth-oauthlib, discord.py, argon2-cffi, tensorboard, nbconvert, ipykernel, discord, tensorflow-gpu, qtconsole, jupyter-server, jupyter-console, ipywidgets, notebook-shim, nbclassic, notebook, jupyter
  DEPRECATION: bs4 is being installed using the legacy 'setup.py install' method, because it does not have a 'pyproject.toml' and the 'wheel' package is not installed. pip 23.1 will enforce this behaviour change. A possible replacement is to enable the '--use-pep517' option. Discussion can be found at https://github.com/pypa/pip/issues/8559
  Running setup.py install for bs4 ... done
Successfully installed Jinja2-3.1.2 MarkupSafe-2.1.1 Matplotlib-3.6.1 Numpy-1.23.4 Send2Trash-1.8.0 Werkzeug-2.2.2 absl-py-1.3.0 aiohttp-3.8.3 aiosignal-1.2.0 anyio-3.6.2 argon2-cffi-21.3.0 argon2-cffi-bindings-21.2.0 asttokens-2.0.8 astunparse-1.6.3 async-timeout-4.0.2 attrs-22.1.0 backcall-0.2.0 beautifulsoup4-4.11.1 bleach-5.0.1 bs4-0.0.1 cachetools-5.2.0 certifi-2022.9.24 cffi-1.15.1 charset-normalizer-2.1.1 click-8.1.3 colorama-0.4.5 contourpy-1.0.5 cycler-0.11.0 debugpy-1.6.3 decorator-5.1.1 defusedxml-0.7.1 discord-2.0.0 discord.py-2.0.1 entrypoints-0.4 executing-1.1.1 fastjsonschema-2.16.2 flask-2.2.2 flatbuffers-22.9.24 fonttools-4.37.4 frozenlist-1.3.1 gast-0.4.0 google-auth-2.13.0 google-auth-oauthlib-0.4.6 google-pasta-0.2.0 grpcio-1.50.0 h5py-3.7.0 idna-3.4 importlib-metadata-5.0.0 ipykernel-6.16.1 ipython-8.5.0 ipython-genutils-0.2.0 ipywidgets-8.0.2 itsdangerous-2.1.2 jedi-0.18.1 joblib-1.2.0 jsonschema-4.16.0 jupyter-1.0.0 jupyter-client-7.4.3 jupyter-console-6.4.4 jupyter-core-4.11.2 jupyter-server-1.21.0 jupyterlab-pygments-0.2.2 jupyterlab-widgets-3.0.3 keras-2.10.0 keras-preprocessing-1.1.2 kiwisolver-1.4.4 libclang-14.0.6 llvmlite-0.39.1 markdown-3.4.1 matplotlib-inline-0.1.6 mistune-2.0.4 multidict-6.0.2 nbclassic-0.4.5 nbclient-0.7.0 nbconvert-7.2.2 nbformat-5.7.0 nest-asyncio-1.5.6 notebook-6.5.1 notebook-shim-0.2.0 numba-0.56.3 oauthlib-3.2.2 opt-einsum-3.3.0 packaging-21.3 pandas-1.5.1 pandocfilters-1.5.0 parso-0.8.3 pickleshare-0.7.5 pillow-9.2.0 prometheus-client-0.15.0 prompt-toolkit-3.0.31 protobuf-3.19.6 psutil-5.9.3 pure-eval-0.2.2 pyasn1-0.4.8 pyasn1-modules-0.2.8 pycparser-2.21 pygments-2.13.0 pyparsing-3.0.9 pyrsistent-0.18.1 python-dateutil-2.8.2 pytz-2022.5 pywin32-304 pywinpty-2.0.8 pyzmq-24.0.1 qtconsole-5.3.2 qtpy-2.2.1 requests-2.28.1 requests-oauthlib-1.3.1 rsa-4.9 scikit-learn-1.1.2 scipy-1.9.3 six-1.16.0 sniffio-1.3.0 soupsieve-2.3.2.post1 stack-data-0.5.1 tensorboard-2.10.1 tensorboard-data-server-0.6.1 tensorboard-plugin-wit-1.8.1 tensorflow-estimator-2.10.0 tensorflow-gpu-2.10.0 tensorflow-io-gcs-filesystem-0.27.0 termcolor-2.0.1 terminado-0.16.0 threadpoolctl-3.1.0 tinycss2-1.2.1 torch-1.12.1+cu116 torchaudio-0.12.1+cu116 torchvision-0.13.1+cu116 tornado-6.2 traitlets-5.5.0 typing-extensions-4.4.0 urllib3-1.26.12 wcwidth-0.2.5 webencodings-0.5.1 websocket-client-1.4.1 wheel-0.37.1 widgetsnbextension-4.0.3 wrapt-1.14.1 yarl-1.8.1 zipp-3.9.0
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