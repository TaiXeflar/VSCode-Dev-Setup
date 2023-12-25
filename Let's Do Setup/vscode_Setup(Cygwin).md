# VSCode的Cygwin環境部署

Cygwin由Red Hat的Cygnus Solution主持及維護，全名為Cygnus on Windows。Cygwin為在Windows平台上執行完整POSIX標準的類UNIX執行環境，並具備標準GNU工具提供適用於Window x86-64平台的Unix平臺開發。

標準適用於Windows的GNU工具庫有以下比較:
| GNU環境 | Cygwin | MSYS2 | MinGW |
| :----: |  :----: |  :----: | :----: | 
| 硬碟容量需求 | 較高 | 較低 | 較低 |
| POSIX相容性 | 完全 | 標準 | -- |
| 套件管理員 | GUI/apt-cyg | pacman | GUI |

## Cygwin 在線安裝
本章節將詳細說明Cygwin的套件整合部署及安裝。

Cygwin為一整合式開發套件管理的部署工具，其內部包含符合GNU GPLv3.0協議開源且免費使用的工具可以使用。
 - 下載網址: https://www.cygwin.com/

Cygwin安裝程式為`setup-x86_64.exe`。

![image](../Markdown%20Image/vscode_cygwin_1.png)

接著進行在線下載安裝。因為我們沒有快取，所以需要選擇一個Cygwin的鏡像網站下載安裝快取。

![image](../Markdown%20Image/vscode_cygwin_2.png)

首先確定安裝於本機上的位置。預設是安裝於`C:\cygwin\`。由於此處範例選擇安裝於`C:\Program Files\Cygwin`，因此出現警告提示:

![image](../Markdown%20Image/vscode_cygwin_3.png)

接著確定安裝的下載快取位置，預設在`setup-x86_64.exe`同資料夾底下。這個快取資料不會自動清除，以備未來手動更新/重新安裝使用。

![image](../Markdown%20Image/vscode_cygwin_4.png)

接著是確認連線方式(因為我們選擇在線安裝)。直接自動選擇代理伺服器即可:

![image](../Markdown%20Image/vscode_cygwin_5.png)

Cygwin並沒有一個官方代表的鏡像下載網站，而是由志願託管服務。此處我們選擇鏡像於國立台灣大學的FTP網站(選擇一個即可):

![image](../Markdown%20Image/vscode_cygwin_6.png)

接著選擇我們要安裝的檔案和套件。Cygwin預設會安裝以下套件:(以下必選，後面套件示範可自行選擇)
 - vi (文字編輯器)
 - bash (POSIX BASH)
 - mintty (Cygwin Terminal)

由於vi/vim編輯器的編輯指令較為陌生，需要手動查詢或背誦。筆者推薦GNU nano文字編輯器較為友善: (可選可不選)
![image](../Markdown%20Image/vscode_cygwin_7(0_nano).png)

UNIX Like Shell並非只有BASH，你亦可選擇Fish(Friendly Interactive Shell)或ZSH(Z Shell): (可選可不選)
![image](../Markdown%20Image/vscode_cygwin_7(1_shell).png)

部署[MinGW](#Cygwin環境配置適用於windows-api的mingw64-gcc)的GNU C compiler(gcc/g++/gfortran)套件: (可選可不選)
![image](../Markdown%20Image/vscode_cygwin_7(2_gcc).png)

部署Clang-LLVM套件: (可選可不選)
![image](../Markdown%20Image/vscode_cygwin_7(4_clang).png)
![image](../Markdown%20Image/vscode_cygwin_7(4_llvm).png)

最後，Cygwin會確認你要安裝的套件:

![image](../Markdown%20Image/vscode_cygwin_8.png)

## Cygwin 套件及VSCode調用
本章節將詳細說明Cygwin部署套件的調用(Invoke)至VSCode。

首先，Cygwin的可執行檔路徑必須加入至環境變數中。本範例的安裝路徑是`C:\Program Files\Cygwin\`，則:
 - 可執行程式路徑: `C:\Program Files\Cygwin\bin\`

在該路徑中，包含`bash`，`gcc`/`g++`，`gfortran`/`f77`，`gawk`，`clang`，`nano`，`vi`，`zsh`等套件的可執行檔都在這個路徑底下。

若你的安裝路徑為預設路徑`C:\cygwin`，則:
 - Cygwin可執行檔路徑: `C:\cygwin\bin\`

加入環境變數後，使用終端機確認是否成功加入。我們以調用Cygwin環境的BASH為示範:
 - Shell
    ```
    & "C:\Program Files\Cygwin\bin\bash.exe" --login -i
    ```

若終端機的PowerShell的命令列消失，換成這個樣子代表調用BASH成功:
 - Bash
    ```
    TaiXeflar@TaiXeflar ~
    $
    ```

## Cygwin套件管理員apt-cyg

Cygwin套件管理是以Cygwin發行的`setup-x86_64.exe`執行圖形介面的安裝/移除作業。在GitHub上有[第三方開發者](https://github.com/transcode-open/apt-cyg/)提交了可作用於Cygwin的套件管理員`apt-cyg`，以命令列形式模擬Linux系統Debian/Ubuntu的套件管理員`apt`執行命令列控制安裝程式套現的下載及安裝。

在Cygwin的BASH中執行命令:
 - BASH
    ```
     wget https://raw.githubusercontent.com/transcode-open/apt-cyg/master/apt-cyg /bin
     chmod +x /bin/apt-cyg
    ```

指定你的Cygwin映像託管後用`apt-cyg`執行安裝:
 - BASH
    ```
     apt-cyg mirror https://ftp.ntu.edu.tw/pub/cygwin/
     apt-cyg install <TOOLS_YOU_WANT_TO_INSTALL>
    ```

### Cygwin BASH
在Cygwin的Shell中，會有一個類UNIX的資料樹系統:
 - Bash(Output)
    ```
    TaiXeflar@TaiXeflar ~
    $ cd ../..

    TaiXeflar@TaiXeflar /
    $ ls
    bin  cygdrive  Cygwin.bat  Cygwin.ico  Cygwin-Terminal.ico  dev  etc  home  lib  proc  sbin  tmp  usr  var
    ```
當中，`cygdrive`即是實際當前Windows所擁有的硬碟槽。
 - Bash(Output)
    ```
    TaiXeflar@TaiXeflar /
    $ cd cygdrive

    TaiXeflar@TaiXeflar /cygdrive
    $ ls
    c  d  e
    ```
欲切換至實際的硬碟下位置，皆在Cygwin根目錄(/)底下的`cygdrive`，接續實際的Windows絕對位置。
 - BASH
    ```
     cd /cygdrive/<DRIVE_CODE>/<WIN_PATH>
    ```

## Cygwin環境配置適用於Windows API的MINGW64 GCC

Cygwin環境下安裝的MinGW64 C/C++開發套件如下。 
   ```
    mingw64-x86_64-gcc-core      (GCC for Win64 Toolchain)
    mingw64-x86_64-gcc-g++       (GCC for Win64 Toolchain)
   ```
請注意，若先前有任何gcc套件而非`mingw64`開頭的套件，則需要解除安裝。使用MinGW64 GCC套件的方式是以Windows API呼叫gcc/g++編譯專案，這可以擺脫Cygwin環境的POSIX相依性直接在Windows上運行； 


啟動Cygwin環境Bash。為了繞過GCC編譯器檢查，我們需要以MinGW64的編譯器設為預設的C/C++編譯器:
 - Bash(Cygwin) 
   ```
    cd /bin

    ln -s x86_64-w64-mingw32-ar.exe ar.exe
    ln -s x86_64-w64-mingw32-as.exe as.exe
    ln -s x86_64-w64-mingw32-c++.exe c++.exe
    ln -s x86_64-w64-mingw32-gcc.exe gcc.exe
    ln -s ln -s x86_64-w64-mingw32-g++.exe g++.exe
    ln -s x86_64-w64-mingw32-ld.exe ld.exe
   ```



### VSCode 調用 Cygwin BASH
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
