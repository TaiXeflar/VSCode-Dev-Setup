# VSCode 建置及作業應用 v2.0.1


## 歡迎使用VSCode !

VSCode全名是Microsoft Visual Studio Code，為微軟開發且開源的程式編輯器，由Chronium核心、HTML、CSS以及JavaScript實現。

VSCode為一種輕量化架構(約352MB)的文字編輯器。藉由延伸套件(Extentions)，VSCode可以藉由使用者的自訂配置，讓VSCode成為史上最強的IDE。

使用VSCode，讓你的程式編輯更輕鬆快速，自定義使用者環境，還能與Git控制套件互動。

本VSCode建置說明有程式庫環境配置以及VSCode調用程式開發套件，以及範例配置程式。

 - 程式環境配置: 請參照`vscode_setup`1~7的說明檔。
 - 範例配置程式: 
     - 自定義配置: VSCode的客製化均以JSON信息配置。請參閱[vscode_setup(Build 0)_JSON_config.md](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(Build%200)_JSON_config.md)。
     - 編譯式程式(C/C++，Fortran，VB/C#/F#)請參照`vscode_setup(build)`1~3。

Happy Coding!

## Markdown_Readme

有關程式開發的說明讀我檔均以Markdown寫成，並有圖片以及全中譯編寫。本存放庫內有提供以下工具的建置:
 - [VSCode](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(0.0)_vscode.md) (Microsoft Visual Studio Code)
 - [VS2022](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(1)_VS2022.md) (Microsoft Visual Studio 2022)
 - [oneAPI](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(2)_VS2022%2BoneAPI_CUDA.md) (Intel oneAPI 2023.0)
 - [CUDA](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(2)_VS2022%2BoneAPI_CUDA.md) (NVIDIA CUDA 11.7/12.0)
 - [MATLAB](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(3)_MATLAB.md) (R2022a)
 - [Python](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(7)_Python.md) (Python 3.9.7)
 - [GMT](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(5)_GMT.md) (Generic Mapping Tools 6.4.0)
 - [Git](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(6)_Git.md) (2.36.1)
 - [Gsudo](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(0.1)_gsudo.md) (Administrator Privilege Tools)

有關本範例建置的程式語言支援包含:
 - [C/C++](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(Build%201)_VC%2B%2B_ICL_DPCPP_CUDA_GCC.md) (MSVC, Intel Classic C/C++ & DPCPP/CPP, NVIDIA CUDA C/C++, GCC/G++)
 - [Fortran](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(Build%203)_Visual_Fortran.md) (Intel Visual Fortran, GFortran)
 - [.NET](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(Build%202)_Visual_dotNET_Basic_C%23_F%23.md) Based Language (Visual Basic, Visual C#, Visual F#)
 - [Python3](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(7)_Python.md) (Python 3.9.7)
 - [MATLAB](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(3)_MATLAB.md)
 - [GMT](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(5)_GMT.md)
 - [JSON](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(Build%200)_JSON_config.md) (JavaScript Option Notation)

我們提交了Jupyter筆記本的應用:
 - [Jupyter](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(9)_Jupyter.md) Notebook

未來可能會加入以下程式語言/開發套件支援:
 - [Cygwin](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(4)_Cygwin.md) (Re-Making)
 - Julia
 - Java
 - JavaScript/TypeScript
 - CMake (CrossMake)
 - PowerShell

## [Shell](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(0.2)_Shell.md)

當說明文件提示Shell的命令列時，該指令是以終端機操作。Windows底下預設使用PowerShell做為預設命令列殼層。
 - 在Windows 10中，請開啟`Windows PowerShell`或`命令提示字元`開啟Windows主控台並輸入命令。
 - 在Windows 11中，請開啟`Windows終端機`並在PowerShell/CMD中直接輸入命令。
 - 在VSCode中，以`Ctrl`+`Shift`+`‵`執行內建終端機。

請注意，當說明文件內的命令列有`sudo`或`su`的命令時，該命令需要提升權限的終端機執行。你有兩種解決方法：
 - 重新以系統管理員身份運行`Windows PowerShell`/`命令提示字元`/`Windows終端機`。
 - 使用[gsudo](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Markdown_Readme/vscode_Setup(0.1)_gsudo.md)套件提升權限(提升至系統管理員權限)。
