# VSCode Git套件設定

## Git for Windows套件安裝

Git for Windows套件為開源免費軟體。安裝時須同意GNU授權條款:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst1.png)

選擇增加至Windows的功能。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst2.png)

接著是編輯git的編輯器預設選擇。通常由`Vim`或`Nano`等GNU協議開源的文字編輯器做為預設，這裡改選為VSCode。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst3.png)

接著是存放庫初始化後主要分支的名稱預設設定。預設是`master`。
 - `Let Git deside`: 這會將主要分支名稱設為`master`。
 - `Override the default branch name for new repositories`: 這會更改預設主要分支的名稱，預設是`main`。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst4.png)

再來是加入至PATH的設定。預設是最低限度的git套件加入PATH變數(第2個選項)。
 - `Use Git from Bash Only`: Git命令只能從Git Bash呼叫。這意味著必須開啟Git Bash才能呼叫git命令。
 - `Git from the command line and also from 3rd-party software`: 最低限度的git工具被加入至PATH中，以便PowerShell、Windows CMD等其他殼層呼叫git命令，並避免部分原本的Windows命令呼叫時被UNIX工具覆蓋掉。
 - `Use Git optional UNIX tools from the Command prompt`: Git及其他的UNIX工具加入至PATH中。這可能會覆蓋掉`find`或`sort`等Windows內建命令。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst5.png)

接著是SSH連線的SSH可執行檔的設定。
 - `Use bundled OpenSSH`: 使用安裝檔自帶解壓縮後的SSH。
 - `Use external OpenSSH`: 使用其他的SSH。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst6.png)

接著是SSH連線的程式庫設定，有`OpenSSH`或`Windows Secure Channel`兩個選項。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst7.png)

接著是Line Ending設定，選擇第一個即可。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst8.png)

接著是終端機的預設設定。
 - `Mintty`:Git Bash將使用Mintty，GNU協議開源適用於Windows的終端機視窗。這也會在Cygwin中自帶。
 - `Windows' default console window`: Git Bash將使用傳統Windows主控台視窗。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst9.png)

接著是執行`git pull`指令的預設設定。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst10.png)

接著是憑證小幫手的設定。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst11.png)

最後是實驗性功能的選擇。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_git_inst12.png)


## Git Bash套件使用

Git可以做為GitHub控制套件，並有自帶BASH做為UNIX Shell執行bash檔。

若在終端機內執行`git`則會出現git的說明檔。要調用或呼叫Bash請在添加環境變數後以命令列`bash`(可以加附帶引數`-i`,  `-l`)呼叫bash。成功畫面如下:
 - Shell
    ```
    PS C:\Users\TaiXeflar> bash -i -l

    TaiXeflar@TaiXeflar MINGW64 ~
    $ 
    ```
進入bash以後，請以UNIX語法/Linux語法與BASH互動。(e.g: `cd`, `ls`等。)

## Git 控制套件使用

- Git Config

    首先，你需要具備一個GitHub帳號。你設定的名稱(Name)即為你的User Name，你登錄的電子信箱即為Email.

    在創建完GitHub帳號後，在本VSCode上開啟終端機(任何殼層都可以)，並輸入git命令列:
    - Shell
        ```
        git config --global user.name USERNAME
        git config --global user.email USER@mail.com
        ```
     - `--global`引數會廣域設定，這代表僅這一次的設定即啟用git控制套件的個人信息預設綁定。
     - `USERNAME`及`USER@mail.com`為你在GitHub上的使用者名稱及電子信箱。

    待完成GitHub帳號綁定後，在VSCode內左下角完成GitHub帳號連動。

- Git Clone

    若是你要複製存放庫，請在目的地資料夾以終端執行git:
     - Shell
        ```
         git clone __URL__
        ```
       `__URL__`為該git存放庫的URL網址。
    
    以終端機執行在桌面上git複製 **`VSCode-Dev-Setup`** 的結果如下:

     - PowerShell(Output)
        ```
         PS C:\Users\TaiXeflar> cd Desktop
         PS C:\Users\TaiXeflar\Desktop> git clone https://github.com/TaiXeflar/VSCode-Dev-Setup.git
         Cloning into 'VSCode-Dev-Setup'...
         remote: Enumerating objects: 601, done.
         remote: Counting objects: 100% (26/26), done.
         remote: Compressing objects: 100% (21/21), done.
         remote: Total 601 (delta 12), reused 19 (delta 5), pack-reused 575
         /s
         Receiving objects: 100% (601/601), 4.67 MiB | 2.28 MiB/s, done.
         Resolving deltas: 100% (331/331), done.
         PS C:\Users\TaiXeflar\Desktop>
        ```
    桌面上將會出現一個vscode_build_sample_repos的資料夾。其中，該存放庫的所有檔案都在該資料夾內，並有一個隱藏的.git資料夾存放該存放庫的git基本訊息。

## 初始化推送你的專案

 1. 首先以檔案總管開啟專案資料夾，選擇以VSCode開啟。
 2. 開啟VSCode後，在原始檔控制功能標籤中選擇"將存放庫初始化"。請注意，這相當於在專案資料夾底下執行指令:
     - Shell
        ```
         git init
        ```
 - 初始化完成後，你可以提交推送版本信息，VSCode會跳出一個名為"**COMMIT_EDITMSG**"的視窗，請在開頭不含#字號的字行上輸入你的提交信息。
     - 每執行更新存檔/刪檔/更改/改名而存檔進行提交時，不能提交空白的信息。
 - 因為你尚未發佈Branch在GitHub上，在推送同步處理之後會跳出提示視窗，選擇你要Private或Public推送至GitHub上。
     - 你發佈的Branch是main的主要版本。
 - 你可以在專案資料夾的根目錄下新增一個名為`LICENSE`且**不含副檔名**的文字內容，並在該檔案中加入授權條款的信息。
     - 授權條款可以從GitHub提供的參考網頁選擇你想要發佈的的授權條款: https://choosealicense.com/
