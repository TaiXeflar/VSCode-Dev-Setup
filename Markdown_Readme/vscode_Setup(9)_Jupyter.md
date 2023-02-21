# 以VSCode配置Jupyter筆記本環境

## Jupyter筆記本介紹

Jupyter筆記本是基於Web以Jupyter、PyZMQ、Jinja、iPython、iPyKernel等眾多Python模組實現。

正如前言所述，Jupyter是Python模組。因此，安裝需要透過pip指令安裝:
 - Shell
   ```
    pip install jupyter
   ```

Jupyter會一次性安裝多個Python模組，以提供基於Web的支援。

我們以終端機執行Jupyter:
 - Shell
   ```
   jupyter notebook
   ```

Jupyter會以終端機掛載核心執行。終端內會出現執行於本地端(或127.0.0.1:8080)的一串Token，由HTML表示。點擊連結後會開啟瀏覽器，重新導向至Jupyter的本地端網頁。

開啟Jupyter時，Jupyter會根據你在的終端位置為根目錄執行筆記本。

## 以VSCode執行Jupyter筆記本

在VSCode中，Microsoft也有基於VSCode提供Jupyter筆記本的延伸模組支援，優點是能快速建立Code/Markdown及無須開啟終端機掛載ipykernel核心、以及在未存檔筆記本的情況下執行筆記本。

請在VSCode中安裝以下延伸模組:
 - VSCode Extentions
   ```
   Jupyter (Microsoft)
   Jupyter Keymap (Microsoft)
   Jupyter Notebook Renderers (Microsoft)
   ```

`Ctrl + Shift + P`組合鍵開啟設定搜尋，鍵入Jupyter，找到`Create: New Jupyter Notebook`選項並點選，建立一個新的筆記本。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter1.png)

開啟新的筆記本後，會自動轉化成模擬Web的筆記本格式，並預設開啟第一個執行格(cell)為Python程式碼。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter2.png)

你可以選擇不同的核心。VSCode會依據電腦上實際存在的Python核心選擇哪一種Python環境。可以看到有出現多個不同且包含Conda環境的核心。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter3.png)

在鍵入程式碼的時候，會依照Intellisense而給予智慧選字。出現下拉式選單時，使用方向鍵`←`, `→`, `↑`, `↓`進行選擇，以`Tab`鍵選字。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter4.png)
 
Jupyter可執行的直譯式偵錯核心如下:
 - Python
 - Julia
 - .NET 互動式
 - MATLAB (Python基底)

 - 其他直譯式語言的互動式核心

### Python
對於Python程式語言，可偵測原Python版本或具備Conda環境的Python發行版本。

此處範例為:
  - Global Env: Python Software Foundation Python 3.9.7
  - Conda Env: Intel Distribution of Python 3.9.15。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter_python.png)

### Julia
對於Julia程式語言，同樣可以調用Julia核心並應用在VSCode上。該目標透過VSCode的延伸模組解決。
 - VSCode Extentions
   ```
   Julia (julialang)
   ```
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter_julia.png)

### MATLAB
對於MATLAB而言，MATLAB已有對Jupyter的內嵌式模組支援。MATLAB官方文件說明，該MATLAB核心需在Jupyter Web版開啟調用，但該功能同樣能在VSCode上執行。

需要額外的Python模組安裝，並重新啟動VSCode:
 - Shell
   ```
   pip install matlab-kernel, jupyter-matlab-proxy
   ```
選擇MATLAB(Connection)的Jupyter Kernel。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter_matlab.png)

### .NET REPL
對於.NET環境支援的語言有直譯器支援(需要安裝VS2022的.NET桌面開發):
 - VSCode Extentions
   ```
   .NET Extention Pack
   .NET Install Tool for Extention Authors
   .NET Education Bundle SDK Install Tool
   ```
選擇具備REPL直譯式核心的.NET解譯器。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_jupyter_.net.png)

## Jupyter Notebook 注意事項
 - 每一個可執行區塊或是註記(Markdown)的儲存格被稱為cell。執行cell的熱鍵是`Shift + Enter`。
 - 請注意該筆記本內每一個cell的執行時間序。若有被刪除的cell影響到後續cell的執行，請在該時間序之後的cell重新執行。
 - 當遇到不可預期的錯誤時(例如程式報錯不符合預期內的錯誤)，試試看重新啟動核心(kernel)並全部重新執行一次。
 - 使用VSCode開啟的Jupyter不需要以終端機掛載ipykernel就能正常執行筆記本的Python互動式偵錯。
 - ipynb是Jupyter筆記本的副檔名，內容為json格式。

  - google.colab及drive套件為限定在Google Colabatory提供，特殊Linux基底的Python容器的雲端環境使用。因此，`drive.mount("__LOCATION__")`指令僅限在Colab上執行。若強制在本機執行指令安裝則會出現非基於pip指令導致的不可預期錯誤。
 - 請注意，在VSCode內以SSH連線執行遠端Google Colabatory的Python偵錯有可能會被視為違反Google Colabatory使用條款。