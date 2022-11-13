# 以VSCode建置C/C++專案 

## 專案執行環境

我們建議在以下硬體配置中，執行基於Windows 10/11環境的Python專案:

  |  配置等級  |  CPU  |  GPU  |  RAM  |  SSD  |  OS  |
  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |
  |  基本配置  |  4C8T  |  iGPU  |  8GB  |  128GB  |  Windows 10/11  |
  |  建議配置  |  6C12T  |  dGPU, 2GB  |  16GB  |  256GB  |  Windows 10/11  |
  |  高階配置  |  6C12T  |  dGPU, 6GB  |  32GB  |  512GB  |  Windows 10/11  |

  - CPU配置建議應支援超執行緒(Hyper-Threading)。
  - 請注意，Intel第12代處理器(Intel Core 12th Gen)後採用大小核設計，其中效能核心(P-Core)支援超執行緒，效率核心(E-Core)則不支援。因此可能出現執行緒數量不等於原雙倍核心數量的結果。
  - 例如在 Intel Core i7-12700H中，核心分配為 6P8E， 執行緒最大數量 = 6x2 + 8x1 = 12+8 = 20。
  - 請注意，在Windows上支援GPU運算的套件僅限適用於CUDA架構。因此，dGPU建議配置為支援CUDA的NVIDIA GPU。在消費級平台上所支援的CUDA GPU包含NVIDIA GeForce MX, GTX, RTX顯示卡。
  - 請注意，適用於Windows的AMD Radeon顯示卡(包含iGPU及dGPU)不支援CUDA GPU。

## 編譯器確認:  

  - 本存放庫以Windows執行5種不同的C/C++編譯器:  

  1. MSVC (Microsoft Visual C++). 

     - 如果你要使用微軟的編譯器， 專案內編譯環境需要以`VsDevCmd.bat`啟動。
     - 至少一個Visual C++編譯器套件需要安裝。 (e.g. MSVC v143 - VS2022 C++ x64/x86 建置工具)。

  2. Intel ICL和Intel DPCPP需要以Intel oneAPI套件安裝。(Intel DPC++/C++ and Intel Classic C/C++ Compilers).

     - 如果你要使用Intel的編譯器, 專案內編譯環境需要以`setvars.bat`啟動.

  3. NVCC (NVIDIA CUDA 編譯器) 需要NVIDIA CUDA Toolkit安裝程式。

     - 執行CUDA需要NVIDIA CUDA GPU， GeForce Game Ready / Studio 顯示驅動和NVIDIA CUDA Toolkit安裝。
     - 可能有額外的標頭檔(.h)、應用程式擴充檔(.dll)及程式庫(.lib)檔需自行添加至CUDA套件路徑底下(例如NVIDIA cuDNN)。

  4. GCC以Dev-CPP MinGW64 GCC/G++為編譯器。

## 編譯器安裝

本安裝範例以預設路徑為標準。

 - Visual C/C++限定由Visual Studio環境安裝。在Visual Studio Installer中，勾選 "**使用C++桌面開發**"並選擇:

   - MSVC v143 - VS 2022 C++ x64/x86 建置工具 (Windows MSVC編譯器)

   - Windows 10 SDK (適用於MSVC建置Windows應用程式的程式庫及標頭檔。例如 stdio.h)

   - 適用於Windows的C++ CMAKE工具 (若有CMake需求請選擇)

   - 適用於Windows的C++ Clang工具 (若有Clang編譯環境專案需求請選擇)

 - Intel Classic C/C++ Compiler及 DPC++/C++ Compiler需要由Intel oneAPI套件安裝，可選擇Standalone版本單獨下載。

 - NVIDIA CUDA需要由NVIDIA CUDA Toolkit Installer套件安裝，在NVIDIA安裝程式中，勾選"**CUDA**"並選擇:

   - Development
     - Compiler
     - Tools

   - Runtime
     - Libraries

   - Visual Studio Integration (若有VS2022整合需求請選擇)

 - Dev C++會自帶GCC編譯器，在安裝選擇時選擇"**Minimum**"選項即可 (至少要有GCC)。

## PATH 路徑確認

範例提及的所有編譯器可在預設安裝的路徑下找到。請把列出的編譯器路徑的資料夾添加至環境變數中(PATH)。

  - Microsoft Visual C/C++ compiler:

    `PATH`:

    - VsDevCmd.bat : "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/Tools/VsDevCmd.bat"
    - cl.exe : "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/`Version Number`/bin/HostX64/x64/cl.exe"
    - clang.exe : "C:/Program Files/Microsoft Visual Studio/2022/VC/Tools/Llvm/bin/clang.exe"

      在 cl.exe 的路徑中，將`Version Number`換成你想要的編譯器版本號。

      - VS2022: `14.33.31629`
      - VS2019: `14.29.30133`
      - VS2017: `14.16.27023`.

  - Intel DPC++/C++ and Intel classic C/C++ Compiler:

    `PATH`:

    - setvars.bat: "C:/Program Files (x86)/Intel/oneAPI/setvars.bat"
    - dpcpp.exe: "C:/Program Files (x86)/Intel/oneAPI/compiler/latest/windows/bin/dpcpp.exe"
    - icl.exe: "C:/Program Files (x86)/Intel/oneAPI/compiler/latest/windows/bin/intel64/icl.exe"

  - NVIDIA CUDA C/C++ compiler:

    `PATH`:

    - nvcc.exe: "C:/Program Files/NVIDIA GPU Computing Toolkit/CUDA/v11.7/bin/nvcc.exe"

  - GNU C/C++ compiler (from Dev-C++):

    `PATH`:

    - gcc.exe: "C:/Program Files (x86)/Dev-Cpp/MinGW64/bin/gcc.exe"

## 設定PATH變數

  - 請把編譯器路徑所在路徑添加至使用者/系統環境變數中。可能需要重新開機。以MSVC的cl.exe(VS2022 v143)為例:
    - `PATH` = "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/`Version Number`/bin/HostX64/x64/"

  - 添加`PATH`變數之後以終端機呼叫該編譯器。以MSVC的cl.exe(VS2022 v143)為例: 
    - PS> cl

    若成功的話會在終端機看到以下內容:
    ```
    PS C:\Users\TaiXeflar> cl
    Microsoft (R) C/C++ Optimizing Compiler Version 19.33.31630 for x64
    Copyright (C) Microsoft Corporation.  著作權所有，並保留一切權利。

    使用方式: cl [ option... ] filename... [ /link linkoption... ]
    ```
    
## VSCode 延伸套件 

在可能的前提下，你可能需要安裝延伸套件:

  - C/C++
  - C/C++ Themes
  - C/C++ Extention

## 專案根目錄定義

本範例在ctest路徑下，定義在一個名為msvc的專案資料夾中有以下內容:
 - .vscode (資料夾)
 - test.c (C來源底稿)

## .vscode資料夾設定

  - 請注意，在VSCode中編輯路徑的時候，使用`/`或`\\`替代`\`.
  - JSON檔案: 你需要3個JSON檔案完成C/C++環境設定。
    - `c_cpp_properties.json`: C/C++的Intellisense模式。 支援編譯器標準的查詢核對、Intellisense選字。該設定與C/C++延伸套件互關聯。
    - `tasks.json`: C/C++底稿進行編譯的設定。
    - `launch.json`: 偵錯C/C++已編譯的偵錯執行檔.
  
 1. c_cpp_properties.json : 

 - 以下是MSVC的C/C++ properties示範:

  ```
    {
        "version": 4,
        "configurations": [
            {
                "name": "Win32",
                "includePath": [
                    "${workspaceFolder}/**"
                ],
                "defines": 
                [
                    "_DEBUG",
                    "UNICODE",
                    "_UNICODE"
                ],
                "windowsSdkVersion": "10.0.22000.0",
                "compilerPath": "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.29.30133/bin/HostX64/x64/cl.exe",
                "cStandard": "c17",
                "cppStandard": "c++17",
                "intelliSenseMode": "windows-msvc-x64"
            }
        ]
    }
  ```
  當中:
  - `version`: 值預設是`4`。
  - `configurations`: JSON清單物件(`[]`)，且包含一個或多個JSON物件(`{}`)。鍵值就像這樣: `"configurations": [{}]`

  在JSON物件(`{}`)有以下鍵值:
  - `name`: `Win32`.你要叫甚麼都可以，但像`Win32`, `Linux`, `Mac`是特殊識別態，依照你的作業系統為準。
  - `includePath`: JSON清單物件(`[]`)。若是有包含在專案根目錄底下的標頭檔(headers)則填入`"${workspaceFolder}/**"`。其中，`/**`代表對該路徑下的遞迴搜尋。
  - `defines`:JSON清單物件(`[]`)。當中包含這些值: `"_DEBUG"`, `"UNICODE"`, `"_UNICODE"`.
  - `WindowsSDKVersion`: `10.0.22000.0`. 你可以換成其他的版本號。
  - `compilerPath`: 編譯器的`PATH`路徑。記得用雙引號`""`當成字串值. 
  - `cStandard`: C編譯器的標準。若是不知道則以`${Default}`替代。
  - `cppStandard`: C++編譯器的標準。若是不知道則以`${Default}`替代。這個鍵值可以部署在g++或是dpcpp上。

 2. tasks.json:

 - 以下是MSVC的build tasks示範:
  ```
  {
    "version": "2.0.0",
    "tasks": 
    [
      {
        "windows":{
          "options": {
            "shell": {
              "executable": "cmd.exe",
              "args": ["/C", "VsDevCmd.bat", "&&"]
              }
            }
          },
          "type": "shell",
          "label": "cl.exe",
          "command": "cl.exe",
          "args": [
                    "/Fe:", 
                    "${fileDirname}\\${fileBasenameNoExtension}.exe", 
                    "${file}"
          ],
          "problemMatcher": ["$msCompile"],
          "group": {
            "kind": "build",
            "isDefault": true
          }
      }
    ]
  }
  ```
  當中:
  - `version`:  值預設是`"2.0.0"`。
  - `tasks`: ，JSON清單物件，且包含一個或多個JSON物件。鍵值就像這樣: `"tasks": [{}]`

      - `windows`: 這個鍵值可以在VSCode終端內呼叫環境設定Batch檔。如果你使用MSVC或Intel oneAPI的編譯器才需要呼叫這個鍵值。
          複製`"options": {"shell": {}}`到`windows`鍵值內。有2個鍵值需要設定:
          - `executable`: `cmd.exe`或`powershell.exe`兩個都可以。
          - `args`: `["/C", "__DEV.bat__", "&&"]`. 將`__DEV.bat__`取代成`VsDevCmd.bat`(使用MSVC), `setvars.bat`(使用oneAPI)。 
      - `type`: `shell`.
      - `label`: 標籤。你可以叫一個喜歡的名字。
      - `command`:編譯器的檔案名。舉例MSVC就是`cl.exe`.
      - `args`: 傳遞至編譯器內的引數。不同編譯器在`args`JSON清單物件中有不同引數及排列順序:
        - MSVC cl.exe: `["/Fe:", "${fileDirname}\\${fileBasenameNoExtension}.exe", "${file}"]`
        -  dpcpp.exe: `["-o", "${fileDirname}\\${fileBasenameNoExtension}.exe","/Zi","/EHsc", "${file}"]`
        - Intel icl.exe: `["-o", "${fileDirname}\\${fileBasenameNoExtension}.exe", "${file}"]`
        - CUDA nvcc.exe: `["-g", "${file}", "-o", "${fileDirname}\\${fileBasenameNoExtension}"]`
        - GCC gcc.exe: `["-g", "-o", "${fileDirname}\\${fileBasenameNoExtension}.exe", "${file}"]`
      - `problemMatcher`: `["$msCompile"]`,
      - `"group"`: `{"kind": "build", "isDefault": true}`
  
 3. launch.json:

  - 以下是MSVC的launch tasks示範:
  ```
  {
      "version": "0.2.0",
      "configurations": [
          {
              "name": "cl.exe",
              "type": "cppvsdbg",
              "request": "launch",
              "program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
              "args": [],
              "stopAtEntry": false,
              "cwd": "${workspaceFolder}",
              "environment": [],
              "console": "integratedTerminal",
              "preLaunchTask": "cl.exe"
          }
      ]
  }
  ```
  當中:

  - `version`: 值預設是`0.2.0`.
  - `configuration`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:

    - `"name"`: 偵錯設定情境的名稱。
    - `"type"`: `"cppvsdbg"`.
    - `"request"`: `"launch"`.
    - `"program"`: `"${fileDirname}/${fileBasenameNoExtension}.exe"`.
    - `"args"`: [],
    - `"stopAtEntry"`: `false`.
    - `"cwd"`: `"${workspaceFolder}"`
    - `"environment"`: [],
    - ` "console"`: `"integratedTerminal"`或`externalTerminal`.取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。
    - `"preLaunchTask"`: 你必須和tasks.json內的`label`名稱一致。

## C/C++ 注意事項

 - AMD Optimized C/C++ Compilers (AOCC) 僅限於Linux環境或WSL2底下使用。在Windows作業系統使用會被視為無法開啟的可執行檔。
 - 若本機所搭載的中央處理器(CPU)為Intel Core處理器時，可以選擇MSVC、Intel C/C++或GCC編譯器。若為AMD Ryzen處理器，請避免安裝Intel C/C++編譯器，以避免處理器架構及優化不相容。
 - 若本機所搭載的圖形處理器(GPU)為NVIDIA GeForce圖形晶片時，可以選擇使用CUDA開發。請注意CUDA套件相容性會隨NVIDIA GPU架構迭代而有支援差異性。
 - 若本機所搭載的圖形處理器(GPU)為Intel Arc, Intel Iris Xe及Intel UHD Graphics圖形晶片時，可以選擇使用Intel DPCPP開發。
 - 若本機所搭載的圖形處理器(GPU)為AMD Radeon Graphics圖形晶片時，不支援GPU的C/C++語言開發。
 - 使用MSVC編譯C語言底稿時，必須在`tasks.json`以`VsDevCmd.bat`初始化開發編譯環境，否則會出現"終止代碼為1"，並回報以下錯誤訊息之一:
    - fatal error C1034: stdio.h: 沒有設定 Include 路徑
    - fatal error LNK1104: 無法開啟檔案 'LIBCMT.lib'
  - 使用ICL, ICX, DPCPP編譯C語言底稿時，必須在`tasks.json`以`setvars.bat`初始化開發編譯環境。

## 後言

- 本專案對Visual Studio/Intel oneAPI的建置方法是採建置時以殼層呼叫`VsDevCmd.bat`/`setvars.bat` 初始化環境後再以殼層呼叫編譯器本體。這其實是一種偷吃步的做法，能直接在VSCode內重新初始化環境並完成建置動作。

- 這裡示範一個原本基礎的做法。欲在桌面上以MSVC新建一個名為ctest的專案:

  - 先在 "開始>所有應用程式" 中找到`Developer Command Prompt for Visual Studio 2022`。
  - 接著在該終端中輸入以下指令 (請將TaiXeflar替換你的使用者名稱):
    ```
    cd C:\Users\TaiXeflar\Desktop
    mkdir ctest
    cd ctest
    mkdir .vscode
    code .
    ```
 - 每欲以`VsDevCmd.bat`環境開啟新專案時，必須依照此類指令建置新專案資料夾。
 - 在VsDevCmd.bat環境底下開啟ctest時亦需要以`Developer Command Prompt for Visual Studio 2022`開啟 (請將TaiXeflar替換你的使用者名稱):

    ```
    cd C:\Users\TaiXeflar\Desktop\ctest
    code .
    ``` 
  - 因此，我們在tasks中呼叫`"windows"`中的`"options"`的`"shell"`項時，可以直接在VSCode內呼叫`VsDevCmd.bat`初始化，而不用必須手動開啟外部終端初始化後再呼叫VSCode。


## 參考出處

  Configure MSVC on windows: https://code.visualstudio.com/docs/cpp/config-msvc

  Configure GCC on windows: https://code.visualstudio.com/docs/cpp/config-mingw
  
  Intel DPCPP 範例 cpp 檔案:VS2022 DPCPP專案自動生成.

  NVIDIA CUDA 範例 kernel.cu 檔案: VS2022 CUDA Runtime專案自動生成.
  
