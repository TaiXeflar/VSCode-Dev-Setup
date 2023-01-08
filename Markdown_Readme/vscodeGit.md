# VSCode Git套件設定

## Git套件安裝

我們使用VSCode為Git的預設編輯器。因此請先安裝VSCode後再行安裝Git。
安裝VSCode請參閱`vscodeSetup.md`。

 - 在開始安裝時，Git for Windows的安裝程式(Installer)會詢問Git的預設編輯器，並以Vim作為默認選項。請下拉至VSCode選項。 
 - 你可以選擇新增至Windows Terminal選項 (Add a profile to Windows Terminal)。這個功能會影響Windows終端機(Windows 11)。
 - Git安裝路徑在`C:\Program Files\Git`。你可以添加`C:\Program Files\Git\bin`為**環境變數**以呼叫bash。

## Git Bash套件使用

Git可以做為GitHub控制套件，並有自帶BASH做為UNIX Like Shell執行bash檔。

若在終端機內執行`git`則會出現git的說明檔。要調用或呼叫Bash請在添加環境變數後以命令列`bash`(可以加附帶引數`-i`,  `-l`)呼叫bash。成功畫面如下:

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
    ```
    git config --global user.name __USERNAME__
    git config --global user.email __USEREMAIL__
    ```
     - `--global`引數會廣域設定，這代表僅這一次的設定即啟用git控制套件的個人信息預設綁定。
     - `__USERNAME__`及`__USEREMAIL__`請替換成你在GitHub上的使用者名稱及電子信箱。

    待完成GitHub帳號綁定後，在VSCode內左下角完成GitHub帳號連動。

- Git Clone

    若是你要複製存放庫，請在目的地資料夾以終端執行git:

    ```
    git clone __URL__
    ```
     - `__URL__`為該git存放庫的HTTPS網址。
    
    以終端機執行在桌面上git複製 **`vscode_build_sample_repos`** 的結果如下:

    ```
    PS C:\Users\TaiXeflar> cd Desktop
    PS C:\Users\TaiXeflar\Desktop> git clone https://github.com/TaiXeflar/vscode_build_sample_repos.git
    Cloning into 'vscode_build_sample_repos'...
    remote: Enumerating objects: 601, done.
    remote: Counting objects: 100% (26/26), done.
    remote: Compressing objects: 100% (21/21), done.
    remote: Total 601 (delta 12), reused 19 (delta 5), pack-reused 575
    /s
    Receiving objects: 100% (601/601), 4.67 MiB | 2.28 MiB/s, done.
    Resolving deltas: 100% (331/331), done.
    PS C:\Users\TaiXeflar\Desktop>
    ```
    桌面上將會出現一個vscode_build_sample_repos的資料夾。其中，該存放庫的所有檔案都在該資料夾內，並有一個隱藏的.git資料夾存放該存放庫的基本訊息。

- 初始化推送你的專案

 1. 首先以檔案總管開啟專案資料夾，選擇以VSCode開啟。
 2. 開啟VSCode後，在原始檔控制功能標籤中選擇"將存放庫初始化"。請注意，這相當於在專案資料夾底下執行`git init`指令。
 3. 初始化完成後，你可以提交推送版本信息，VSCode會跳出一個名為"**COMMIT_EDITMSG**"的視窗，請在開頭不含#字號的字行上輸入你的提交信息。
     - 每執行更新存檔/刪檔/更改/改名而存檔進行提交時，不能提交空白的信息。
 4. 因為你尚未發佈Branch在GitHub上，在推送同步處理之後會跳出提示視窗，選擇你要Private或Public推送至GitHub上。
     - 你發佈的Branch是main的主要版本。
 5. 你可以在專案資料夾的根目錄下新增一個名為`LICENSE`且**不含副檔名**的文字內容，並在該檔案中加入授權條款的信息。
     - 授權條款可以從GitHub提供的參考網頁選擇你想要發佈的的授權條款: https://choosealicense.com/
