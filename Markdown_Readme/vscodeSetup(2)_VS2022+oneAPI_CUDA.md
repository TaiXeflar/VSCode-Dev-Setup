# Visual Studio 協力廠商套件
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

※ 請注意，Intel oneAPI各套件皆有提供在線/離線安裝版本。請依照您是否需要連線至網路選擇部署模式。

這裡以執行Intel oneAPI Math Kernel Library的Standalone Installer為例。

Intel oneAPI預設會安裝在以下路徑: `C:\Program Files (x86)\Intel\oneAPI\`

首先，會有快取解壓縮的路徑確認，直接預設就好並執行安裝程式。

安裝第一步會有確認產品信息及安裝路徑的畫面出現:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_oneAPI_1.png)

接著是確認整合至Visual Studio版本的選擇。這裡我們選擇VS2022:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_oneAPI_2.png)

下一步，確認是否加入開發人員回饋計劃(Software Improvement Program)後進行安裝，安裝時須注意**在安裝完全結束前勿隨意結束安裝程式**。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_oneAPI_4.png)

你可以查看Intel oneAPI的安裝產品信息。執行Intel oneAPI Installer以查看已安裝的Intel oneAPI套件清單:
 - Intel oneAPI Installer: `C:\Program Files (x86)\Intel\oneAPI\Installer\installer.exe`
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_oneAPI_tools.png)


以下是成功安裝Intel Visual Fortran以及Intel DPCPP/CPP後，在Visual Studio中看起來的樣子:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_oneAPI_ifort.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_oneAPI_dpcpp.png)

## NVIDIA CUDA安裝
本章節將會教學如何部署NVIDIA CUDA套件。

NVIDIA現在已公開CUDA Runtime供開發者免費下載(不需要NVIDIA帳號)，直接前往NVIDIA開發者網站即可下載。
 - https://developer.nvidia.com/cuda-zone

NVIDIA CUDA安裝程式包含以下內容:
 - CUDA Runtime
 - CUDA Libraries
 - CUDA C/C++ Compiler
 - Nsight System
 - GeForce Experience
 - Visual Studio integration

請注意，NVIDIA Developer安裝程式有分在線/離線安裝版本。請依照您是否需要連線至網路選擇部署模式。

請注意，NVIDIA CUDA套件運行時，需要有支援CUDA的NVIDIA圖形處理器(GPU)及NVIDIA顯示驅動程式(顯卡驅動)。

首先，會有快取解壓縮的路徑確認，直接預設就好並執行安裝程式。安裝快取在安裝完成後會自動清除。

NVIDIA CUDA會安裝在以下路徑: `C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA`

安裝第一步，需要同意軟體授權協議同意書:

   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_cuda_1.png)

再來可以選擇預設或自訂選擇元件安裝:

   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_cuda_2.png)

我們選擇CUDA套件:

   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_cuda_3.png)

安裝的Nsight會自動偵測並整合至Visual Studio。

   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_cuda_4.png)

這是可以建立NVIDIA CUDA Runtime看起來的樣子:
   ![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vs_cuda_VS2022.png)