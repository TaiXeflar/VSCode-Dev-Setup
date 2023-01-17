# Visual Studio環境安裝

## Visual Studio 2022在線下載安裝檔
本章節會教學如何在線安裝Visual Studio 2022。
 - 您必須擁有的先行條件: 
     - 硬體配置: 您執行的電腦處理器必須是64位元的x86處理器，且有以下的建議配置:

         |  配置等級  |  CPU  |  GPU  |  RAM  |  SSD  |  OS  |
         |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |
         |  基本配置  |  4C8T  |  iGPU  |  8GB  |  128GB  |  Windows 10/11  |
         |  建議配置  |  6C12T  |  dGPU, 2GB  |  16GB  |  256GB  |  Windows 10/11  |
         |  高階配置  |  6C12T  |  dGPU, 6GB  |  32GB  |  512GB  |  Windows 10/11  |

     - 網路配置: 至少50MB/s的下載(下行)網速頻寬，以避免下載等待過久。
     - 微軟帳號: Microsoft會對使用VS2022 Community的開發人員要求有微軟帳號連結(即可)。

Visual Studio可謂開發程式套件寶庫。但也因為容量龐大，所以需要較大硬碟空間儲存。以下是有提供的程式語言開發環境:
 - Visual C/C++, CMake跨平台開發C++(不依賴sln/vxproj), 適用於Windows的Clang等
 - Visual VB/C#/F#, XAML, dotNET環境, Roslyn編譯器
 - JavaScript, NodeJs, TypeScript
 - WEB
 - Python(不含Conda環境)
 - Visual Studio Extention

以下是協力廠商有開發並整合至Visual Studio的SDK:
 - Intel oneAPI套件 (所有Intel oneAPI)
 - NVIDIA CUDA套件

首先，需要下載Visual Studio的安裝檔。個人使用只需要Community授權版本即可免費下載安裝。 

 - 下載網址: https://visualstudio.microsoft.com/zh-hant/thank-you-downloading-visual-studio/?sku=Community&channel=Release&version=VS2022&source=VSLandingPage&cid=2030&passive=false

接著點擊安裝檔，初始化Visual Studio安裝程式後會進入安裝版本的修改頁面。你應該可以看到Visual Studio的版本選擇:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInst1.png)

選擇你要的工作負載，預設有選取的內容項是Visual Studio的建議安裝選項。右邊可以選擇提供建議的安裝元件選擇。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInst2.png)

若有特殊程式庫跟工具的需求，有可自由選擇可擴充的個別元件:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInst3.png)

你可以自定義Visual Studio的安裝位置。預設是在`C:\Program Files\Microsoft Visual Studio\2022`底下。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInst4.png)

接著進行在線下載及安裝。

## Visual Studio 2022製作離線安裝檔
### 內容施工中
Visual Studio 2022的離線安裝檔需要在網路環境下完成檔案快取的下載及安裝檔的生成。

這種離線安裝包的方式可以自定義Visual Studio的大量部署作業。

我們需要下載Visual Studio啟動載入器，至微軟官方線上文件下載:
 - https://learn.microsoft.com/zh-tw/visualstudio/install/create-an-offline-installation-of-visual-studio?view=vs-2022

找到啟動載入器，下載Community版本:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInstOff_1.png)

建立一個啟動載入器的安裝包資料夾，命名為vsBuild並設定在桌面。此處範例路徑為: `C:\Users\TaiXeflar\Desktop\vsBuild`

啟動一個終端機(PowerShell/CMD/BASH都可以)，更改目錄至該安裝包資料夾中。
```
$> cd "C:\Users\TaiXeflar\Desktop\vsBuild"
```
 - 建議使用字串的方式呼叫整個路徑，可以避免路徑中有空格的問題。

該資料夾內需要有我們剛剛下載的啟動載入器(`vs_community.exe`)。

接著以命令列的方式呼叫啟動載入器。這裡我們的安裝包有以下設定:
 - 安裝包語言是繁體中文。
 - 安裝包有包含所有工作負載。
 - 執行安裝包生成時輸出監控顯示畫面。

因此，我們要執行的命令列是:
```
$> .\vs_community.exe --layout --lang zh-TW
```

你的操作介面看起來會像這樣:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInstOff_2.png)

之後靜待元件下載安裝，時長約30分鐘至1小時(等待時間真的很久，你可以打一場5v5的LOL)。

下載完之後會出現一個`packages`的資料夾，所有元件和工具都會以安裝檔(.msi)和封包檔(.cab)整合在裡面。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vsInstOff_3.png)

將這個包含元件資料夾及啟動載入器的安裝包資料夾部署至任何一台欲離線安裝的電腦上，使用終端機執行指令:
```
$> .\vs_community.exe --noweb
```

