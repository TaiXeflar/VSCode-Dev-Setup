# Visual Studio 協力廠商 Intel oneAPI套件
## Intel oneAPI 安裝
本章節將會教學如何部署Intel oneAPI套件。

Intel現在已將前身Parallel Studio內的各開發套件公開，供開發者免費下載(但也有整合的付費版)。你可以自行選擇整合式的套組(Toolkit)或單一獨立(Standalone)的工具下載。

Intel oneAPI Toolkit的套組選擇網址:
 - https://www.intel.com/content/www/us/en/developer/tools/oneapi/toolkits.html

Intel oneAPI Standalone Compoment的選擇網址:
 - https://www.intel.com/content/www/us/en/developer/articles/tool/oneapi-standalone-components.html

Intel有提供以下開發工具:
 - Intel DPCPP/CPP & Intel CPP Compiler Classic (Intel DPCPP及 Intel C/CPP編譯器)
 - Intel DPCPP Compatability tool (適用於CUDA移植的相容性工具)
 - Intel Visual Fortran (前身即為Microsoft Visual Fortran)
 - Intel Graphics Offline compiler for OpenCL 
 - Intel Distribution for Python (具備Conda環境)
 - Intel oneMKL 
 - Intel MPI Library
 - Intel oneDNN Library 
 - Intel oneTBB
 - Intel oneVPL
 - e.t.c.

※ 請注意，各套件皆有提供在線/離線安裝版本。請依照您是否需要連線至網路選擇部署模式。

這裡以執行Intel oneAPI Math Kernel Library的Standalone Installer為例。

Intel oneAPI預設會安裝在以下路徑: `C:\Program Files (x86)\Intel\oneAPI\`

首先，會有快取解壓縮的路徑確認，直接預設就好並執行安裝程式。

安裝第一步會有確認產品信息及安裝路徑的畫面出現:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vs_oneAPI_1.png)

接著是確認整合至Visual Studio版本的選擇。這裡我們選擇VS2022:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vs_oneAPI_2.png)

下一步，確認使用條款後進行安裝，安裝時須注意**在安裝完全結束前勿隨意結束安裝程式**。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vs_oneAPI_4.png)

你可以查看Intel oneAPI的安裝產品信息。執行Intel oneAPI Installer以查看已安裝的Intel oneAPI套件清單:
 - Intel oneAPI Installer: `C:\Program Files (x86)\Intel\oneAPI\Installer\installer.exe`
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vs_oneAPI_tools.png)