# 以VSCode配置Jupyter筆記本偵錯環境

## Jupyter筆記本介紹

Jupyter筆記本是基於Web以Jupyter、PyZMQ、Jinja、iPython、iPyKernel等眾多Python模組實現。

正如前言所述，Jupyter是Python模組。因此，安裝需要透過pip指令安裝:
 - PowerShell
   ```
    pip install jupyter
   ```

Jupyter會一次性安裝多個Python模組，以提供基於Web的支援。

我們以終端機執行Jupyter:
 - PowerShell
   ```
   jupyter notebook
   ```

Jupyter本地伺服器需要終端機掛載核心執行在本機`localhost`或本機IP位址`127.0.0.1`，並預設以`8888`埠監聽筆記本(即`localhost:8888`或`127.0.0.1:8888`)執行伺服器。執行時Jupyter會提供1~2組包含token的URL連結至本機Jupyter，該WEB連結開啟會瀏覽器並重新導向至Jupyter的本地端網頁。

開啟筆記本時，Jupyter會根據你在終端機執行Jupyter指令的路徑為根目錄執行筆記本(例如你在桌面路徑底下`~/Desktop`執行，則根目錄即為你的桌面資料夾`~/Desktop`)。

## 以VSCode開啟Jupyter筆記本

在VSCode中，Microsoft也有基於VSCode提供Jupyter筆記本的延伸模組支援，優點是能快速建立Code/Markdown及無須開啟終端機掛載Jupyter伺服器核心、以及在未存檔筆記本的情況下執行筆記本。

請在VSCode中安裝以下延伸模組:
 - VSCode Extentions
   ```
   Jupyter (Microsoft)
   Jupyter Keymap (Microsoft)
   Jupyter Notebook Renderers (Microsoft)
   ```

`Ctrl + Shift + P`組合鍵開啟設定搜尋，鍵入Jupyter，找到`Create: New Jupyter Notebook`選項並點選，建立一個新的筆記本。

  ![image](../Markdown%20Image/vscode_jupyter1.png)

開啟新的筆記本後，會自動轉化成模擬Web的筆記本格式，並預設開啟第一個執行格(cell)為Python程式碼。在鍵入程式碼的時候，會依照IntelliSense而給予智慧選字。出現下拉式選單時，使用方向鍵`←`, `→`, `↑`, `↓`進行選擇，以`Tab`鍵選字。
 
Jupyter可執行的直譯式偵錯核心如下:
  - Python
  - Julia
  - .NET 互動式(限VSCode Polygon Notebooks)
  - MATLAB (Python基底)
  - 其他直譯式語言的互動式核心


### Jupyter筆記本執行Python
對於Python程式語言，可執行的Python直譯器包含本地端安裝的Python直譯器，虛擬環境的Python直譯器(venv Python)，以及Conda環境基底的Python。

1. 選擇本地端的原生安裝Python或原生安裝Conda Python:

    ![image](../Markdown%20Image/vscode_jupyter2.png)

    ![image](../Markdown%20Image/vscode_jupyter3.png)

2. 根據該路徑建立自定義venv Python:

    ![image](../Markdown%20Image/vscode_jupyter4.png)

    ![image](../Markdown%20Image/vscode_jupyter5.png)

    ![image](../Markdown%20Image/vscode_jupyter6.png)

3. 根據該路徑建立自定義Conda Python:

    ![image](../Markdown%20Image/vscode_jupyter4.png)

    ![image](../Markdown%20Image/vscode_jupyter7.png)

    ![image](../Markdown%20Image/vscode_jupyter8.png)

### Jupyter筆記本執行MATLAB
對於MATLAB而言，MATLAB已有對Jupyter的內嵌式模組支援。MATLAB官方文件說明，該MATLAB核心需在Jupyter Web版開啟調用，但該功能同樣能在VSCode上執行。

1. 安裝需要額外的Python模組，並重新啟動VSCode:
 - PowerShell
   ```
   pip install matlab-kernel, jupyter-matlab-proxy
   ```
2. 選擇MATLAB(Connection)的Jupyter Kernel。

   ![image](../Markdown%20Image/vscode_jupyter9.png)

   ![image](../Markdown%20Image/vscode_jupyter10.png)

   ![image](../Markdown%20Image/vscode_jupyter11.png)

### Jupyter筆記本執行Julia

對於Julia程式語言，同樣可以調用Julia核心並應用在VSCode上。該目標透過VSCode的延伸模組解決。
 - VSCode Extentions
   ```
   Julia (julialang)
   ```
   選擇其他核心。Julia核心會獨立於Python選項。

    ![image](../Markdown%20Image/vscode_jupyter12.png)

    ![image](../Markdown%20Image/vscode_jupyter13.png)

### Jupyter筆記本執行.NET REPL
對於.NET環境支援的語言有直譯器支援(需要安裝VS2022的.NET桌面開發):
 - VSCode Extentions
   ```
   .NET Extention Pack
   Polyglot Notebooks
   ```

 - Visual Studio Installer:
   ```
    .NET 桌面開發        #註記: 自動安裝獨立於.NET開發套件的Roslyn編譯器組件 
   ```
   選擇具備REPL直譯式核心的.NET解譯器。

   ![image](../Markdown%20Image/vscode_jupyter14.png)

   選擇.NET框架的語言。 請注意，.NET框架程式語言中，Visual Basic並沒有REPL的支援。

   ![image](../Markdown%20Image/vscode_jupyter15.png)


## Jupyter Notebook 注意事項
 - 每一個可執行區塊或是註記(Markdown)的儲存格被稱為cell。執行cell的熱鍵是`Shift + Enter`。
 - 請注意該筆記本內每一個cell的執行時間序。若有被刪除的cell影響到後續cell的執行，請在該時間序之後的cell重新執行。
 - 當遇到不可預期的錯誤時(例如程式報錯不符合預期內的錯誤)，試試看重新啟動核心(kernel)並全部重新執行一次。
 - 使用VSCode開啟的Jupyter不需要以終端機掛載ipykernel就能正常執行筆記本的Python互動式偵錯。
 - ipynb是Jupyter筆記本的副檔名，內容為JSON格式。

 - google.colab及drive套件為限定在Google Colabatory提供，特殊Linux基底的Python容器的雲端環境使用。因此，`drive.mount("__LOCATION__")`指令僅限在Colab上執行。若強制在本機執行指令安裝則會出現非基於pip指令導致的不可預期錯誤。
 - 請注意，在VSCode內以SSH連線執行遠端Google Colabatory的Python偵錯有可能會被視為違反Google Colabatory使用條款。

 ## Future Targets
 - Adding ROOT-Project Cling C++ Interpreter support: 
    ```
     Resolving Jupyter-Cling-Kernel 403 ENOENT Error
    ```
 - Adding LFortran Support