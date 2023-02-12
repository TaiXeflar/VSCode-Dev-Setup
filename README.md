# VSCode 建置及作業應用 v2.0


## 歡迎使用VSCode !

VSCode全名是Microsoft Visual Studio Code，為微軟開發且開源，由Chronium核心、HTML、CSS以及JavaScript實現。

VSCode一種輕量化架構(約352MB)的文字編輯器。藉由延伸套件(Extentions)，VSCode可以藉由使用者的自訂配置，讓VSCode成為史上最強的IDE。

使用VSCode，讓你的程式編輯更輕鬆快速，自定義使用者環境，還能與Git控制套件互動。

本VSCode建置說明有程式庫環境配置以及VSCode調用程式開發套件，以及範例配置程式。

 - 程式環境配置: 請參照`vscode_setup`1~7的說明檔。
 - 範例配置程式: 
     - 自定義配置: VSCode的客製化均以JSON信息配置。請參閱`vscode_setup(Build 0)_JSON_config.md`。
     - 編譯式程式(C/C++，Fortran，VB/C#/F#)請參照`vscode_setup(build)`1~3。

Happy Coding!

## Markdown_Readme

有關程式開發的說明讀我檔均以Markdown寫成，並有圖片以及全中譯編寫。本存放庫內有提供以下工具的建置:
 - Microsoft Visual Studio Code (VSCode)
 - Microsoft Visual Studio 2022 (VS2022)
 - Intel oneAPI (2023.0)
 - NVIDIA CUDA (CUDA 11.7/12.0)
 - MATLAB (R2022a)
 - Python (Python 3.9.7)
 - Cygwin
 - Generic Mapping Tools (6.4.0)
 - Git for Windows (2.36.1)
 - Gsudo (Administrator Privilege Tools)

有關本範例建置的程式語言支援包含:
 - C/C++ (MSVC, Intel Classic C/C++ & DPCPP/CPP, NVIDIA CUDA C/C++, GCC/G++)
 - Fortran (Intel Visual Fortran, GFortran)
 - .NET Based Language (Visual Basic, Visual C#, Visual F#)
 - Python 3 (Python 3.9.7)
 - MATLAB
 - GMT
 - JSON (JavaScript Option Notation)

未來可能會加入以下程式語言/開發套件支援:
 - Julia
 - Java
 - JavaScript/TypeScript
 - C/C++ : Clang/LLVM
 - CMake (Cross Make)
 - PowerShell

## Shell

當說明文件提示Shell的命令列時，該指令是以終端機操作。Windows底下預設使用PowerShell做為預設命令列殼層。
 - 在Windows 10中，請開啟`Windows PowerShell`或`命令提示字元`開啟Windows主控台並輸入命令。
 - 在Windows 11中，請開啟`Windows終端機`並在PowerShell中直接輸入命令。
 - 在VSCode中，以`Ctrl`+`Shift`+`‵`執行內建終端機。

請注意，當說明文件內的命令列有`sudo`或`su`的命令時，該命令需要提升權限的終端機執行。你有兩種解決方法：
 - 重新以系統管理員身份運行`Windows PowerShell`/`命令提示字元`/`Windows終端機`。
 - 使用`gsudo`套件提升權限(提升至系統管理員權限)。
