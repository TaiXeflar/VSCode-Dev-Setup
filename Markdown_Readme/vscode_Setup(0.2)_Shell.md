# VSCode與殼層命令介紹

在VSCode, Visual Studio等整合式IDE中，會加入內建終端機的功能。該終端機的命令列環境即為殼層。

## 殼層

在作業系統中，預設的殼層如下:

  |  作業系統  |  第一優先殼層  |  第二優先殼層  |  其他殼層  |
  |  :----:  |  :----:  |  :----:  |  :----:  |
  |  macOS  |  Z Shell (zsh)  |  BASH (bash)  |  SH (sh)  |
  |  Linux  |  BASH (bash)  |  SH (sh)  |  ZSH  |  ----  |
  |  Windows  |  PowerShell  |  CMD  |  ----  |

由此可見，Windows作業系統內是不帶有符合POSIX規範的UNIX殼層(BASH, ZSH等)。但在Windows上調用這些殼層，有幾種方法:
 - 透過安裝適用於Windows的且符合POSIX規範的UNIX殼層可執行檔實現。例如`Git for Windows`或是`Cygwin`等安裝套件會自解`BASH`。
 - 透過`Windows Subsystem for Linux`(適用於Windows的Linux子系統)呼叫Ubuntu/Debian/Fedora等。

通常而言，SH/BASH等類UNIX殼層底稿(.sh檔案)或單一命令均相容于類UNIX殼層並可執行。

## 啟動殼層
 - VSCode內預設由PowerShell為主要殼層，CMD為第二預設殼層，其他設定檔依照其他安裝元件的整合或透過修改使用者自定義檔`settings.json`加入其他殼層。

## 命令列

  | 殼層命令 | Bash/Zsh | Windows CMD | Windows PowerShell | PowerShell Cmdlet |
  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |
  | 切換目錄 | cd | cd | cd | Set-Location |
  | 路徑物件 | ls | dir | ls/dir | Get-ChildItem |
  | 新增路徑 | mkdir | mkdir | mkdir | New-Item |
  | 新增物件 | touch | cd/echo/type/fsutil | echo | New-Item |
  | 刪除路徑 | rmdir | rmdir | rmdir | Remove-Item |
  | 刪除物件 | rm | del | rm/del | Remove-Item |

cd: 切換目錄(Change Directory)指令。以下是範例命令列。
 - PowerShell 
    ```
    cd /.vscode                                  #在目前目錄下進入.vscode資料夾
    cd /FOLDER/SUBFOLDER                         #在目前目錄下進入FOLDER資料夾後，再進入SUBFOLDER資料夾
    cd ..                                        #上一頁
    cd ../..                                     #上一頁後再上一頁       

    cd ../../ANOTHER/FOLDER                      #上一頁後再上一頁，接著進入ANOTHER資料夾的FOLDER子資料夾

    cd    D:/Games/miHoYo/Honkai Impact 3/       #切換至D槽內Games底下，miHoYo資料夾底下的Honkai Impact 3資料夾
    ```
 - CMD
    ```
    cd /D D:/Games/miHoYo/Genshin Impact         #切換至D槽內Games底下，miHoYo資料夾底下的Genshin Impact資料夾(在CMD中切換硬碟槽位需要 /D 引數)
    ```   

ls/dir: 列印路徑內所有物件(List/Directory)。
 - PowerShell
    ```
    ls                                           #回傳列印當前目錄的全部物件
    ls -a                                        #回傳列印當前目錄的全部物件，包含隱藏物件及隱藏資料夾
    ls D:/Games/Ubi/R6/                          #指定回傳列印 D:/Games/Ubi/R6/ 內的全部物件
    ```

mkdir: 新增路徑(新增資料夾)(Make Directory)。
 - PowerShell
    ```
    mkdir D:/R18/NH/                             #在D槽硬碟新增R18資料夾後，在路徑下再新增一個NH資料夾
    ```

rmdir: 移除路徑(必須是空資料夾)(Remove Directory)。
 - PowerShell
    ```
    rmdir D:/R18/NH/                             #移除D槽硬碟內R18資料夾下的NH資料夾
    ```

rm: 移除物件(Remove)。
 - PowerShell
    ```
    rm D:/R18/secretCode.txt                     #移除D槽硬碟內R18資料夾下的secretCode.txt文字檔
    ```

clear: 清除終端機傾印內容。
 - PowerShell
    ```
    clear                                        #清空終端機紀錄 

    Clear-Host                                   #使用Cmdlet "Clear-Host" 清空終端機紀錄
    ```

執行程式: 執行可執行檔。

Windows作業系統底下的可執行檔為"exe"(例如cmd.exe)，UNIX作業系統底下的可執行檔不帶副檔名，並以星號後綴(例如bash*)。

Windows作業系統底下的殼層命令底稿/批次檔為cmd, bat, ps1(副檔名)，UNIX作業系統底下的殼層命令底稿為sh(副檔名)。
 - PowerShell
   ```
   ./myCompileCPP.exe                            #執行當前目錄底下的 myCompileCPP.exe

   & "C:\Windows\System32\cmd.exe"               #使用呼叫運算子"&"調用cmd.exe

   Invoke-Item "C:\Windows\System32\cmd.exe"     #使用PowerShell Cmdlet "Invoke-Item" 調用cmd.exe
   ```

## 命令列工具
基本上，可執行檔位於使用者/系統PATH變數時可以直接在終端機內呼叫，而不需要透過呼叫可執行檔的完整路徑來調用該應用程式。

### CMD (Windows Command Prompt)

CMD即為Windows命令提示字元(Windows 命令提示符)，由原本的COMMAND.COM演變而來。下列舉一個較常見到的通式:
 - CMD
    ```
    cmd.exe /E:[on/off] /[C/K] <COMMAND LINE: {Command 1} && {Command 2} && ...>
    ```
   當中，

   `/E`參數代表是否啟用延伸模組。 該延伸模組啟用後會影響部分cmd指令。

   `/C`代表該殼層執行後方傳遞的命令後結束並關閉殼層。

   `/K`代表該殼層執行後方傳遞的命令後不結束殼層。

   `<COMMAND LINE>`傳遞欲執行的命令列。

   `&&`代表在{Command N}後追加傳遞{Command N+1}的命令傳遞符號。

我們舉一個建置Visual Studio環境，使用MSVC編譯並結束CMD的例子:
 - CMD
    ```
         cmd.exe /E:ON /C  vsdevcmd.bat -arch=x64  &&  cl.exe /Fe: test.exe test.c     

    ::   cmd.exe /E    /C {vsdevcmd.bat -arch=x64} && {cl.exe /Fe: test.exe test.c}     <--這一行是註解，對照說明組
    ```

我們再舉2個建立符號連結(Symbolic Link)的命令列的範例:
 - CMD
    ```
    cd "C:\Program Files\Powershell\7\"               ::切換至PowerShell 7的安裝目錄下
    cmd.exe /C  mklink powershell.exe pwsh.exe        ::調用CMD呼叫mklink， 建立符號"powershell.exe"與可執行檔"pwsh.exe"的關係
    ```   
 - CMD
    ```
    cmd.exe /C mklink "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\genshin.exe" "D:\Games\miHoYo\Genshin Impact\GenshinImpact.exe"

    ::調用cmd.exe的mklink，在Windows開始選單中建立一個「原神」應用程式的符號連結
    ```

在終端中傾印系統變數後結束殼層:
 - CMD
    ```
    cmd.exe /C set
    ```

在終端中傾印Windows命令提示後結束殼層:
 - CMD
    ```
    cmd.exe /C help
    ```

CMD的可執行手稿稱為Windows命令(.cmd)或Windows批次檔(.bat)。 有2種在CMD命令列中撰寫註釋(Comments)的語法。

第一種是以`REM`開頭:
 - CMD
    ```
    REM This vscode_Setup(0.2)_Shell.md is too hard to read
    ```

第二種是以`::`開頭:
 - CMD
    ```
    :: Write a batch file is too hard
    ```
    
在CMD中呼叫系統變數時以`%__VAR__%`表示。 舉例以檔案總管開啟Minecraft的預設資料夾:
 - CMD
    ```
    explorer.exe %AppData%\.minecraft\
    ```

### PowerShell
PowerShell是基於.NET架構建成的一種任務自動化和組態管理架構殼層，由C#(是C sharp不是C Hashtag)實現。

PowerShell除具備大量白話形式的Cmdlet之外，還兼具與BASH/SH及CMD語法相容性。 當中傳遞命令的引數及參數均以`管線`傳遞。

Windows 10/11預設以PowerShell為主要殼層，預設是Version 5.1的版本，並且會有以下的初始化歡迎說明:
 - PowerShell
    ```
    Windows PowerShell
    著作權（C） Microsoft Corporation。保留擁有權利。

    安裝最新的 PowerShell 以取得新功能和改進功能！https://aka.ms/PSWindows
    ```

我們舉一個例子。呼叫PowerShell但不顯示歡迎說明:
 - PowerShell
    ```
    powershell.exe -nologo
    ```

我們舉一個建置Visual Studio環境的PowerShell殼層:
 - PowerShell
    ```
    powershell.exe -NoExit -Command "&{Import-Module 'C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\Tools\Microsoft.VisualStudio.DevShell.dll'; Enter-VsDevShell 8f5c46dc -SkipAutomaticLocation -DevCmdArguments '-arch=x64 -host_arch=x64'}"
    ```

在PowerShell中，PowerShell Script(.ps1)有兩種撰寫註釋(Comments)的方法:

第一種，以`#`開頭的語句會判定為單行註釋。 以`#`符號後的任何內容均會被判定為註釋。
 - PowerShell
    ```
    # This is a single line PowerShell comments.
    ```
第二種，是以`<##>`概括的區塊註釋。以`<#`符號開頭至`#>`內的全部內容會被判定為註釋。
 - PowerShell
    ```
    <# This is a single line comments too #>

    <#      Hey There
            This is a whole
            block of PowerShell Comments
    #>
    ```

在PowerShell中，`&`是呼叫運算子， 後面傳遞一個可執行檔/命令手稿/命令列程式。 舉例一個呼叫Python直譯器進入Python Shell的例子:

 - PowerShell
    ```
    & "C:/Program Files/Python39/python.exe"
    ```

PowerShell在呼叫系統變數時以`${env:__VAR__}`表示， 當中`__VAR__`是變數的名稱。 以下舉2個例子:

現設立一個`pyRoot`變數， 值為系統內Python路徑`C:\Program Files\Python39\`。 呼叫Python直譯器可以有以下變化:
 - PowerShell
    ```
    & ${env:pyRoot}/python.exe
    ```

在終端機中切換至Python的系統安裝目錄下:
 - PowerShell
    ```
    cd ${env:pyRoot}
    ```

在終端機中以Cmdlet`Write-Host`傾印系統環境變數(PATH):
 - PowerShell
    ```
    Write-Host ${env:PATH}
    ```

### Shell (BASH, ZSH)
BASH是基於shell的增強版， 普遍見於Linux中， 亦有適用於Windows作業系統的Bash， 由免費且開源的GNU計劃支持維護。

ZSH亦是基於shell及BASH的增強版， 且符合POSIX規範。 ZSH是現macOS的預設殼層。

下列套件有支援安裝BASH:
 - Git for Windows
 - Cygwin

在Windows中， Windows底下的User資料夾`C:/Users/USER/`啟動Bash:
 - Shell
    ```
    bash
    ```

在Windows中， 類UNIX底下的User資料夾`/home/USER/`啟動Bash:
 - Shell
    ```
    bash -l
    bash --login
    ```

若是單一呼叫BASH執行shell來源檔案/shell手稿(.sh)後結束殼層， 則:
 - Shell
    ```
    bash <Shell Script>
    ```
當中， `Shell Script`是你的shell來源檔案/shell手稿， 例如這種形式: `myCommand.sh`。

### Winget (Windows套件管理員)

各作業系統的套件管理員如下:

  |  作業系統  |  預設套件管理員  |  第三方套件管理員  |  第三方套件管理員  |
  |  :----:  |  :----:  |  :----:  |  :----:  |
  |  macOS  |  pkg  |  brew  |  etc.  |
  |  Linux(rpm)  |  yum/dnf  |  brew  |  etc.  |
  |  Linux(deb)  |  apt  |  brew  |  etc.  |
  |  Windows  |  winget / Microsoft Store  |  Chocolatey  |  Cygwin  |

Winget的常用指令如下:
 - PowerShell
    ```
    winget search PACKAGE                         #呼叫winget搜尋PACKAGE的應用程式
    winget install PACKAGE.FULLNAME               #呼叫winget安裝PACKAGE的識別名PACKAGE.FULLNAME安裝檔案
    ```

### VSCode (Visual Studio Code)

VSCode的命令列呼叫如下:
 - PowerShell
    ```
    code                                          #開啟一個新的VSCode視窗(VSCode不載入路徑)
    code .                                        #在目前路徑下開啟VSCode
    code "FOLDER_FULL_PATH"                       #以相對/絕對路徑開啟VSCode
    code -h                                       #開啟code.exe的命令列參數說明
    ```

若在開發人員命令列視窗中呼叫VSCode，則該VSCode及VSCode內建終端機均會繼承開發人員環境的變數。

我們舉例一個繼承Intel oneAPI環境的VSCode:
 - PowerShell
    ```
    & "cmd.exe" /E:ON /K setvars.bat "intel64 vs2022" 
    code .
    ```

### MATLAB (Mathworks Inc. MATLAB)

MATLAB是一種直譯式的數學計算及視覺化語言，現由Java實現，並支援呼叫C， C++， Java， Python， CUDA等語言。

MATLAB在命令列的啟動與在MATLAB圖示雙擊啟動一樣，同為啟動GUI的IDE模式。這個啟動模式會根據終端的位置傳遞至IDE中的檔案總管。
 - PowerShell
    ```
    matlab
    ```

MATLAB的命令列語法支援為:
 - PowerShell
    ```
    matlab -help
    ```

在macOS/Linux中，MATLAB引擎可以直接在終端中呼叫執行，運行MATLAB互動式命令列(Windows不支援):
 - BASH/ZSH
    ```
    matlab -nodisplay
    ```

MATLAB可以作為一個引擎呼叫，傳遞執行稿在背景執行後關閉，類似於`cmd.exe /C <command>`的命令執行模式。該模式由`-batch`引數傳遞執行命令。
 - PowerShell
    ```
    matlab -batch <MATLAB Script>
    ```
當中，`MATLAB Script`為 **"當下路徑"** 或 **"在PATH"** 或 **"在MATLAB程式庫"** 中可呼叫的M檔案(*.m Files)。

以下示範一個命為`Script.m`的MATLAB內容:
 - MATLAB Script
    ```
    peaks
    ```

在終端中執行的過程中，呼叫該MATLAB底稿`Script.m`的檔名(即`Script`，**不需要副檔名**):
 - PowerShell
    ```
    PS C:\Users\TaiXeflar\matlab> ls

    Directory: C:\Users\TaiXeflar\matlab

    Mode                 LastWriteTime         Length Name
    ----                 -------------         ------ ----
    -a---          2023/4/2 上午 02:56              6 Script.m

    PS C:\Users\TaiXeflar\matlab> matlab -batch "Script"

    z =  3*(1-x).^2.*exp(-(x.^2) - (y+1).^2) ...
       - 10*(x/5 - x.^3 - y.^5).*exp(-x.^2-y.^2) ...
       - 1/3*exp(-(x+1).^2 - y.^2)

    PS C:\Users\TaiXeflar\matlab>   
    ```

### Python (Python 3)
Python是一種直譯式的程式語言， 具備直譯器解釋Python語句， 並可以以自訂的呼叫方式匯入模組。

以下是2種呼叫Python直譯器方法，進入Python殼層:
 - PowerShell
    ```
    python                 #呼叫Python直譯器
    py                     #呼叫建立於System的Python執行器(安裝時"py launcher"選項)
    ```

Python在macOS中有Python 2以及Python 3兩種不同世代的Python直譯器，因此在Shell中呼叫的行為是:
 - Bash/Zsh
    ```
    python3                #呼叫Python 3的Python直譯器
    ```

Python在呼叫時會有可用的引數傳遞改變其執行模式。 執行命令以列印所有可用的引數選項:
 - PowerShell
    ```
    python -h
    ```

執行Python底稿偵錯時的命令列如下。`Python Script`請填入該Python底稿的檔名:
 - PowerShell
    ```
    python <Python Script>
    ```

舉例現有一個Python來源檔案`hello.py`:
 - Python
    ```
    print("Hello World")
    ```

則偵錯Python底稿時:
 - PowerShell
    ```
    python hello.py
    ```

執行Python模組時， `-m`引數行為是以執行Python Script的方法傳遞一個Python函式庫的Python模組(Python Module)執行程式。該傳遞的`Python Module`名稱不帶有副檔名(`.py`)。
 - PowerShell
    ```
    python -m <Python Module>
    ```

最常見的例子是這個， 呼叫`pip`執行Python套件管理員pip的更新:
 - PowerShell
    ```
    python.exe -m pip install --upgrade pip
    ```


