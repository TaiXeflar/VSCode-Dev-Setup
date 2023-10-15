
# VSCode執行PowerShell偵錯階段
本範例以PowerShell 7為偵錯執行環境。

## PowerShell的VSCode偵錯環境
安裝[PowerShell延伸模組](vscode:extension/ms-vscode.PowerShell)後以`F5`鍵偵錯即可解決(一勞永逸)。筆記本形式Polyglot執行PowerShell段落式偵錯參閱[這裡](vscode_Play(NB).md#jupyter筆記本執行net-repl)。

## PowerShell Script定義
Script在此說明的中譯為:「手稿」、「底稿」、「腳本」；在程式語言中通常解釋為具備人類可閱讀性的直譯式可執行程式。例如:
 - 可在Shell(BASH/ZSH/tcsh)執行的Shell Script(`*.sh`/`*.bash`/`*.csh`):
 - Windows命令提示字元CMD的批次檔及命令程式(`*bat`/`*cmd`)；
 - Python程式語言底稿(`*.py`)；
 - MATLAB程式語言底稿M Files(`*.m`)；
 - VBS可執行手稿VBScript(`*.vbs`)；
 - 適用於PowerShell執行的PowerShell手稿(`*.ps1`)等。

## 什麼是PowerShell?

PowerShell是Microsoft基於.NET框架以C#語言實現，執行輕量化命令Cmdlet自動化管理及組態架構管理等一系列擴充功能實作的直譯式殼層語言，支援跨平臺執行並適應多種作業系統。

PowerShell在Windows XP時加入為Windows元件，現已為Windows 10/11的第一預設殼層。Windows內安裝的PowerShell元件為LTS的5.1版本。

| Windows | 第一殼層 | 第二殼層 | 第三殼層 |
| :----: | :----: | :----: | :----: |
| Win 11 | PowerShell 5.1 | CMD | Azure Cloud Shell |
| Win 10 | PowerShell 5.1| CMD | WSL2 |
| Win 8 | PowerShell | CMD | -- |
| Win 7 | CMD | Powershell | -- |
| Vista | CMD | PowerShell | -- |
| Win XP | CMD | PowerShell | -- |

PowerShell的可執行手稿副檔名是`*.ps1`，PowerShell模組是`*.psm1`及`*.psd1`。執行PowerShell手稿需在PowerShell殼層內執行；或執行PowerShell時傳遞欲執行手稿。

## PowerShell的特性
PowerShell有以下特性:
 - PowerShell 支援不檢查大小寫。(這很重要! 因為BASH或CMD都要檢查大小寫；這可以增加程式碼的容錯率)
 - PowerShell 支援路徑符號`/`及`\`的通用性。(這很重要! 因為BASH規定使用`/`；CMD規定`\`。這可以增加程式碼的容錯率)
 - PowerShell 7 支援基於智慧鍵入Intellisense的`TAB`鍵快速鍵入，以及「程式執行歷程紀錄」的Intellisense功能。(這很重要! 因為這是懶人Coding的必備之一)
 - PowerShell 7 支援色彩設定檔。配合支援的終端機時，可以在例如`Get-ChildItem`(Alias:`ls`/`dir`)等命令執行時回傳檔案類型標示等色彩辨識功能。
 - PowerShell 是以管道"Pipeline"的形式傳遞子命令/接續命令或參數。這很適合試錯。
 - etc.

## PowerShell執行程式及手稿
在PowerShell殼層中，直接執行PowerShell手稿時以呼叫運算子`&`傳遞:
 - PowerShell
   ```
     & "PS1_FILE_PATH"
   ```
若當前目錄底下的PowerShell手稿被`TAB`鍵傳遞至終端機內時，該PowerShell會以絕對路徑傳遞。
 - PowerShell
   ```
    & "X:\PS1\FILE\ABSOLUTE\PATH\NAME.ps1"
   ```

在其他殼層中，PowerShell手稿不是殼層可執行程式。解決方案是透過執行PowerShell程式並傳遞手稿執行。(就像你不一定會在Python Shell執行Script一樣。)
 - CMD
    ```
     && pwsh.exe "PS1_File_Name"
    ```
 - Shell(BASH/ZSH from MSYS2/Cygwin)
    ```
     pwsh.exe "PS1_File_Name"
    ```
 - Shell(BASH/ZSH on macOS/Linux)
    ```
     pwsh "PS1_File_Name"
    ```

## PowerShell 傳遞可執行程式

若欲在PowerShell殼層中傳遞一個可執行程式不在`${env:PATH}`變數中，呼叫運算子`&`傳遞該程式時以完全路徑傳遞。
 - PowerShell
   ```
    & "D:/Games/miHoYo/Genshin Impact/GenshinImpact.exe"
   ```

欲在PowerShell殼層中傳遞一個已在`${env:PATH}`變數中的可執行程式時，可同樣使用呼叫運算子`&`:
 - PowerShell
   ```
    & cmd /E:ON /C setvars "intel64 VS2022" && ifort ifx_test.f90 
   ```
該範例中傳遞了`cmd.exe`，`setvars.bat`，`ifort.exe`。



## PowerShell 註解
PowerShell手稿撰寫註解(Comments)時有2種方法。當標註PowerShell程式碼為註解時，PowerShell解釋器不會執行註解內容並直接忽略(Ignore)，不會回傳為字串列印。

第一種是行註解，在該行開頭以`#`符號開頭。
 - PowerShell
   ```
    # This is PowerShell Script Line Comments
   ```
第2種是區塊註解，在區塊開始及結束分別以`<#`和`#>`穿插於程式碼段落前後。
 - PowerShell
   ```
    <# This is PowerShell Script Line Comments #>

    <#
       This is PowerShell Script Block Comments
    #>
   ```
## PowerShell的Cmdlet

PowerShell Cmdlet常見對應的Alias如下:
| Cmdlet | BASH Alias | CMD Alias | BASH/CMD params | Cmdlet Params |
| :----: | :----: | :----: | :----: | :----: |
| Set-Location | cd | cd |
| Get-location | pwd | | | |
| Move-Item | mv | move |
| Copy-Item | cp | copy |
| Remove-Item | rm | del | -r | -Recurse |
| Get-ChildItem | ls | dir |
| Write-Host | echo | echo |
| Read-Host | read | set | -p(bash); /p(CMD) |
| Set-Variable | export | set | /A(CMD) |
| Invoke-WebRequest(iwr) | wget | curl | -o(CMD) | -OutFile | 

舉例一個從本機磁碟D複製指定資料夾及其子資料夾內容至本機磁碟C的目前使用者桌面路徑下。由BASH語法轉譯成PowerShell像這樣:
 - Bash
   ```
    cp "D:/NHENTAI/BlueArhive" "C:/Users/USERNAME/Desktop" -r
   ```
 - PowerShell
   ```
    Copy-Item -Path "D:\NHENTAI\BlueArchive" -Destination "~/Desktop" -Recurse
   ```

## PowerShell變數
PowerShell以`$VAR`傳遞本地變數，`${env:VAR}`傳遞環境變數。
| Variable | PowerShell | Bash | CMD |
| :----: | :----: | :----: | :----: |
| 本地變數 | $VAR | $VAR | %VAR% |
| 環境變數 | ${env:VAR} | $envVAR | %envVAR% |

傾印執行中PowerShell的PowerShell應用程式詳細內容:
 - PowerShell
   ```
    Write-Host $PSVersionTable
   ```

在PowerShell中傾印本機系統環境變數`PATH`:
 - PowerShell
   ```
    Write-Host ${env:PATH}
   ```

使用`Foreach`函數，對`$myPath`路徑內所有內容遞迴呼叫成`$item`變數並執行傾印:
 - PowerShell
   ```
    $myPath = "D:/NHENTAI/BlueArchive"

    foreach($item in $myPath){
      Write-Host $myPath
    }
   ```
## PowerShell執行網路請求`Invoke-WebRequest`
PowerShell可透過Cmdlet`Invoke-WebRequest`執行HTTP/HTTPS網路請求，並回傳URL信息。可透過`Invoke-WebRequest`傳遞`-Outfile`管線以執行下載作業，達成近似於`curl`或`wget`的網路請求命令。

`Invoke-WebRequest`的Alias是`iwr`、`curl`以及`wget`(Microsoft已於PowerShell 7中移除Alias`wget`。)
 - PowerShell
   ```
    Invoke-WebRequest -Uri <URL>                   # 回傳URL詳細訊息
    Invoke-WebRequest -Uri <URL> -Outfile <FILE>   # 執行網址的下載請求並存檔為<FILE>
   ```

這裡舉一個例子。執行`Invoke-WebRequest`請求下載多個華碩應用程式至桌面下`asusAPP`資料夾:
 - PowerShell
   ```
    Clear-Host                #清空終端機

    <# 定義下載連結的字串陣列 #>
    $url=   "https://dlsvr04.asus.com.cn/pub/ASUS/GamingNB/Image/Software/SoftwareandUtility/15308/TXMascot_V3.1.1_15308_1.zip",
            "https://dlcdnets.asus.com/pub/ASUS/GamingNB/Image/Software/SoftwareandUtility/14726/VirtualPet-UltimateEdition_V2.3.7_14726_1.zip",
            "https://dlcdnets.asus.com/pub/ASUS/GamingNB/Image/Software/SoftwareandUtility/15352/ArmouryCrate&AuraCreatorInstaller_V3.2.9.1_15352_1.zip";

    <# 定義下載的檔案名稱 #>
    $save=  "$pkg/TXInstaller.exe",          # 華碩虛擬桌面寵物天選姬
            "$pkg/OmniInstaller.exe",        # 華碩虛擬桌面寵物Omni
            "$pkg/ACInstaller.exe";          # ASUS ROG Armoury Crate(華碩ROG奧創中心)
    
    <# 檢測並建立安裝路徑 #>
    if (!(Test-Path $pkg)){
         mkdir $pkg; 
    }

    <# 迴圈執行檔案下載 #>
    for (($i=0); $i -le $url.Count; $i++){
         Invoke-WebRequest -Uri $url[$i] -OutFile $save[$i]
    }
   ```
該範例執行下載下列應用程式: 華碩虛擬桌面寵物天選系列天選姬；華碩虛擬桌面寵物ROG系列Omni；以及華碩筆電控制中心應用程式Armoury Crate。


## PowerShell執行原則`ExecutionPolicy`
PowerShell殼層可設定執行的安全原則，以是否啟用未經受信任的數位簽署的PowerShell手稿。(當你知道VBScript沒有執行的安全原則時就知道有多危險......)

PowerShell有以下的本機執行原則`<POLICY>`: (若本機執行原則為`Default`，則代表該類型電腦套用Windows預設原則。)
| Windows預設原則 | 本機執行原則 | 個別命令 | 本地腳本(未簽署) | 本地腳本(已簽署) | 遠端腳本(未簽署) | 遠端腳本(已簽署) |
| :----: | :----: | :----: | :----: | :----: | :----: | :----: |
| ᗜ ˰ ᗜ | Default | ᗜ ˰ ᗜ | ᗜ ˰ ᗜ | ᗜ ˰ ᗜ | ᗜ ˰ ᗜ | ᗜ ˰ ᗜ |
| Windows 用戶端 | Restricted | V | X | X | X | X |
|| AllSigned | V | X | V | X | V |
| Windows 伺服端 | RemoteSigned | V | V | V | X | V |
|| ByPass | -- | -- | -- | -- | -- |
|| Undefined | -- | -- | -- | -- | -- |
| 非 Windows 系統 | Unrestricted | V | V | V | V | V |

若電腦中的執行原則皆為`Undefined`，則在Windows用戶端會指定為`Restricted`；Windows伺服端會指定為`RemoteSigned`。

非Windows電腦中的`ExecutionPolicy`指定為`Unrestricted`，且無法更改。
 - Windows 用戶端: Windows Home，Windows Professional，Windows Education，Windows Pro Workstation，Windows Enterprise，Windows IoT
 - Windows 伺服端: Windows Server，Windows Datacenter
 - 非 Windows 系統: macOS，chromeOS，Debian，Ubuntu，Fedora，CentOS，RHEL，SUSE，KALI，ARCH Linux，GNU Linux，Android，Harmony OS

獲得PowerShell目前狀態的使用者執行原則的命令為`Get-ExecutionPolicy`。
 - PowerShell
   ```
    Get-ExecutionPolicy
   ```
該指令會回傳目前使用者`CurrentUser`的執行原則狀態`<POLICY>`。欲獲得全部群組執行原則狀態的命令則加入`-List`後綴:
 - PowerShell
   ```
    Get-ExecutionPolicy -List
   ```

在PowerShell中執行更改執行原則的命令為`Set-ExecutionPolicy`:
 - PowerShell
   ```
    Set-ExecutionPolicy -ExecutionPolicy <POLICY> -Scope <GROUP>
   ```
這會變更指定群組`<GROUP>`的執行原則為新的`<POLICY>`。若未傳遞`-Scope`參數，則受到變更執行原則的群組為`CurrentUser`(即目前使用者)。

若是要移除指定的`<POLICY>`，則指派`<POLICY>`為`Undefined`。

## References

 Updating References...

 - `ExecutionPolicy`:
    - https://learn.microsoft.com/zh-tw/powershell/module/microsoft.powershell.core/about/about_execution_policies?view=powershell-7.3
    - https://learn.microsoft.com/zh-tw/powershell/module/microsoft.powershell.security/set-executionpolicy?view=powershell-7.3
  


## Stay Tuned
Continue Uploading New things