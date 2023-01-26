# VSCode的Cygwin環境部署

## Cygwin 在線安裝
本章節將詳細說明Cygwin的套件整合部署及安裝。

Cygwin為一整合式開發套件管理的部署工具，其內部包含開源且免費使用的工具可以使用。
 - 下載網址: https://www.cygwin.com/

Cygwin安裝程式為`setup-x86_64.exe`。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_1.png)

接著進行在線下載安裝。因為我們沒有快取，所以需要選擇一個Cygwin的鏡像網站下載安裝快取。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_2.png)

首先確定安裝於本機上的位置。預設是安裝於`C:\cygwin\`。由於此處範例選擇安裝於`C:\Program Files\Cygwin`，因此出現警告提示:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_3.png)

接著確定安裝的下載快取位置，預設在`setup-x86_64.exe`同資料夾底下。這個快取資料不會自動清除，以備未來手動更新/重新安裝使用。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_4.png)

接著是確認連線方式(因為我們選擇在線安裝)。直接自動選擇代理伺服器即可:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_5.png)

Cygwin並沒有一個官方代表的鏡像下載網站，而是由志願託管服務。此處我們選擇鏡像於國立台灣大學的FTP網站(選擇一個即可):

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_6.png)

接著選擇我們要安裝的檔案和套件。Cygwin預設會安裝以下套件:(以下必選，後面套件示範可自行選擇)
 - vi (文字編輯器)
 - bash (POSIX BASH)
 - mintty (Cygwin Terminal)

由於vi編輯器的編輯指令較為陌生，需要手動查詢或背誦。筆者推薦GNU nano文字編輯器較為友善: (可選可不選)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_7(0_nano).png)

UNIX Like Shell並非只有BASH，你亦可選擇Fish(Friendly Interactive Shell)或ZSH(Z Shell): (可選可不選)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_7(1_shell).png)

部署MinGW的GNU C compiler(gcc/g++)套件: (可選可不選)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_7(2_gcc).png)

部署MinGW的GNU Fortran compiler(gfortran)套件: (可選可不選)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_7(3_gfort).png)

部署Clang-LLVM套件: (可選可不選)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_7(4_clang).png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_7(4_llvm).png)

最後，Cygwin會確認你要安裝的套件:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_cygwin_8.png)

## Cygwin 套件及VSCode調用
    本章節將詳細說明Cygwin部署套件的調用(Invoke)至VSCode。

    首先，Cygwin的可執行檔路徑必須加入至環境變數中。本範例的安裝路徑是`C:\Program Files\Cygwin\`，則:
    - 可執行程式路徑: `C:\Program Files\Cygwin\bin\`
    在該路徑中，包含`bash`，`gcc`/`g++`，`gfortran`/`f77`，`gawk`，`clang`，`nano`，`vi`，`zsh`等套件的可執行檔都在這個路徑底下。

    若你的安裝路徑為預設路徑`C:\cygwin`，則:
    - Cygwin可執行檔路徑: `C:\cygwin\bin\`

    加入環境變數後，使用終端機確認是否成功加入。我們以調用Cygwin環境的BASH為示範:
    - PowerShell
        ```
        PS> & "C:\Program Files\Cygwin\bin\bash.exe" --login -i
        ```

    若終端機的PowerShell的命令列消失，換成這個樣子代表調用BASH成功:
    - Bash
        ```
        TaiXeflar@TaiXeflar ~
        $
        ```

### Cygwin BASH
    在Cygwin的Shell中，會有一個類UNIX的資料樹系統:
    - Bash
        ```
        TaiXeflar@TaiXeflar ~
        $ cd ../..

        TaiXeflar@TaiXeflar /
        $ ls
        bin  cygdrive  Cygwin.bat  Cygwin.ico  Cygwin-Terminal.ico  dev  etc  home  lib  proc  sbin  tmp  usr  var
        ```
    當中，`cygdrive`即是實際當前Windows所擁有的硬碟槽。
    - Bash
        ```
        TaiXeflar@TaiXeflar /
        $ cd cygdrive

        TaiXeflar@TaiXeflar /cygdrive
        $ ls
        c  d  e
        ```
    欲切換至實際的硬碟位置，皆在Cygwin根目錄(/)底下的`cygdrive`，接續實際的Windows絕對位置。

### VSCode Invoke Cygwin BASH
    在VSCode中，BASH不一定要執行WSL呼叫BASH，可以直接調用Cygwin的BASH。

    以熱鍵 "`Ctrl`+`Shift`+`P`" 啟動命令選擇區，找到 `喜好設定: 開啟使用者設定(JSON)` 並按 `Enter` 確認進入`settings.json`。

    找到`"terminal.integrated.profiles.windows"`這個鍵值(如果沒有就新增)，在底下建立鍵值:
    - JSON
        ```
        "Cygwin": 
                {            
                    "path": ["C:/Program Files/Cygwin/bin/bash.exe"],
                    "args": [],
                    "icon": "console"
                }
        ```
