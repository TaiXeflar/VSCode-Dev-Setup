# VSCode 建置及作業應用 v2.0.3


## 歡迎使用VSCode !

VSCode全名是Microsoft Visual Studio Code，為微軟開發且開源的程式編輯器，由Chronium核心、HTML、CSS以及JavaScript實現。

VSCode為一種輕量化架構(約352MB)的文字編輯器。藉由延伸套件(Extentions)，VSCode可以藉由使用者的自訂配置，讓VSCode成為史上最強的IDE。

使用VSCode，讓你的程式編輯更輕鬆快速，自定義使用者環境，還能與Git控制套件互動。

本VSCode建置說明有程式庫環境配置以及VSCode調用程式開發套件，以及範例配置程式。

 - 程式環境配置/安裝: 請參照[vscode_setup](Let's%20Do%20Setup/vscode_Setup(VSCode_1_Setup).md)的說明檔。
 - 範例配置程式: 
     - [自定義配置](Let's%20Do%20Setup/vscode_Setup(VSCode_2_Config).md): VSCode的客製化均以JSON信息配置。請參閱[JSON語法](Let's%20Do%20Setup/vscode_Setup(VSCode_2_Config).md#json%E8%AA%9E%E6%B3%95)及VSCode`settings.json`[配置說明](Let's%20Do%20Setup/vscode_Setup(VSCode_2_Config).md#%E4%BB%A5json%E7%B7%A8%E8%BC%AFvscode%E7%9A%84%E5%80%8B%E4%BA%BA%E5%8C%96%E8%A8%AD%E5%AE%9A)。
     - 編譯式/解釋型程式: 參閱[Let's Build Something](https://github.com/TaiXeflar/VSCode-Dev-Setup/tree/main/Let's%20Build%20Something)路徑底下的檔案。
Happy Coding!
 - 程式自生成建置: 以專案原始碼生成檔案並逕行安裝。參閱[Let's CMake Something](https://github.com/TaiXeflar/VSCode-Dev-Setup/tree/main/Let's%20CMake%20Something)。

## Markdown(*.md) Readme Files

有關開發應用程式/命令列執行的應用程式安裝說明讀我檔均以Markdown寫成，並有圖片以及全中譯編寫。本存放庫內有提供以下工具的建置:
 - [VSCode](Let's%20Do%20Setup/vscode_Setup(VSCode_1_Setup).md) (Microsoft Visual Studio Code)
 - [VS2022](Let's%20Do%20Setup/vscode_Setup(VS2022).md) (Microsoft Visual Studio 2022)
 - [oneAPI](Let's%20Do%20Setup/vscode_Setup(OneAPI_CUDA).md#intel-oneapi-%E5%AE%89%E8%A3%9D) (Intel oneAPI 2023.0)
 - [CUDA](Let's%20Do%20Setup/vscode_Setup(OneAPI_CUDA).md#nvidia-cuda%E5%AE%89%E8%A3%9D) (NVIDIA CUDA 11.7/12.0)
 - [MATLAB](Let's%20Do%20Setup/vscode_Setup(MATLAB).md) (R2022a)
 - [Python](Let's%20Do%20Setup/vscode_Setup(Python).md) (Python 3.9.7)
 - [GMT](Let's%20Do%20Setup/vscode_Setup(GMT).md) (Generic Mapping Tools 6.4.0)
 - [Git](Let's%20Do%20Setup/vscode_Setup(Git).md) (2.36.1)
 - [Gsudo](Let's%20Do%20Setup/vscode_Setup(Gsudo).md) (Administrator Privilege Tools)
 - [Cygwin](Let's%20Do%20Setup/vscode_Setup(Cygwin).md) (Re-Master in Progress)
 - [Office](Let's%20Do%20Setup/InstallOffice.md) (Microsoft Office Deployment Tool)

有關本範例建置的程式語言支援包含:
 - [C/C++](Let's%20Build%20Something/vscode_Setup(Build%20C%2B%2B).md) (MSVC, Intel Classic C/C++ & DPCPP/CPP, NVIDIA CUDA C/C++, GCC/G++)
 - [Fortran](Let's%20Build%20Something/vscode_Setup(Build%20Fortran).md) (Intel Visual Fortran, GFortran)
 - [.NET](Let's%20Build%20Something/vscode_Build(.NET).md) Based Language (Visual Basic, Visual C#, Visual F#)
 - [Python3](Let's%20Build%20Something/vscode_Build(Python).md) (Python 3.9.7)
 - [MATLAB](Let's%20Build%20Something/vscode_Build(MATLAB).md)
 - [GMT](Let's%20Build%20Something/vscode_Build(GMT).md)
 - [JSON](Let's%20Do%20Setup/vscode_Setup_(VSCode_2_Config).md) (JavaScript Option Notation)

我們提交了Jupyter筆記本的應用:
 - [Jupyter](Let's%20Build%20Something/vscode_Play(NB).md) Notebook

未來可能會加入以下程式語言/開發套件支援:
 - SH/BASH(Shell Script)
 - Julia
 - Java
 - JavaScript/TypeScript
 - CMake (CrossMake)
 - PowerShell
 - CMD Batch

## Shell

當說明文件提示Shell的命令列時，該指令是以終端機操作。Windows底下預設使用PowerShell做為預設命令列殼層。
 - 在Windows 10中，請開啟`Windows PowerShell`或`命令提示字元`開啟Windows主控台並輸入命令。
 - 在Windows 11中，請開啟`Windows終端機`並在PowerShell/CMD中直接輸入命令。
 - 在VSCode中，以`Ctrl`+`Shift`+`‵`執行內建終端機。

請注意，當說明文件內的命令列有`sudo`或`su`的命令時，該命令需要提升權限的終端機執行。你有兩種解決方法：
 - 重新以系統管理員身份運行`Windows PowerShell`/`命令提示字元`/`Windows終端機`。
 - 使用[gsudo](Let's%20Do%20Setup/vscode_Setup(Gsudo).md)套件提升權限(提升至系統管理員權限)。

## 環境變數`PATH`

本存放庫所提示的`PATH`、`%PATH%`、`${env:PATH}`均指示為Windows的PATH變數。

Windows會根據在`PATH`變數下內的所有路徑作遞迴搜尋所有可執行的程式和可執行手稿。例如:
 - 可執行應用程式`*.exe`；
 - 可執行手稿`*.cmd`/`*.bat`；
 - VBS手稿`*.vbs`；
 - PowerShell手稿`*.ps1`(限在PowerShell殼層內執行)。

### Windows作業系統添加使用者PATH變數
若欲手動添加應用程式至`PATH`清單內，使用`⊞`+`R`熱鍵執行`sysdm.cpl`程式選擇進階的系統變數。
    
![image](Markdown%20Image/sysdm_cpl(1).png)

Windows的PATH變數字串定義是以`;`符號連結存入的路徑；以圖形介面定義則是以各行分開表示。
 - 以字串傳遞: 
  
![image](Markdown%20Image/sysdm_cpl(2).png)
 - 以字行傳遞:
  
![image](Markdown%20Image/sysdm_cpl(3).png)

新增的PATH有2種傳遞方式:
 1. 直接加入到PATH內。這種做法省事，但可能會超出PATH字元上限。
     - PATH
        ```
         ......;PATH_0;PATH_1;NEW_PATH;......
        ```
 2. 新建變數並存入添加路徑，再將該新添加的變數添加至PATH內(以CMD形式的變數`%__myVAR__%`傳遞)。這做法費事但易於管理，且能縮短字元數量。
     - PATH
        ```
         ......;PATH_0;PATH_1;%VAR_0%;%VAR_1%;......
        ```
     - VAR_0
        ```
         D:/miHoYo/Games/Genshin Impact/
        ```
     - VAR_1
        ```
         C:/programs/gmt6/bin
        ```

## macOS/Linux作業系統添加使用者PATH變數
使用者變數增加PATH的方法是透過修改Shell rc實現。若預設殼層是Bash則修改`~/.bashrc`；ZSH修改`~/.zshrc`；以此類推。`$PATH`變數是以字串傳遞，並以`:`符號分隔。

這裡設定一個情境: 部署適用於Linux/macOS的PowerShell可執行檔案不逕行安裝，而是解壓縮至`/home/USERNAME/PS7/bin`下，並透過使用者殼層設定把PowerShell加入PATH當中。

則`~/.bashrc`的修改如下:
 - `~/.bashrc`
   ```
    # .bashrc檔案的最後面

    export PS7="/home/USERNAME/PS7/"
    export PATH="$PATH:$PS7/bin"
   ```

