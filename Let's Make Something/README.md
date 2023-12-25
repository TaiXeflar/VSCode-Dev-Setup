# Make Something
這是一個新的說明文件(*.md)託管區域。這裡的文件包含由命令列或程式執行專案生成(Make)的方法。以下是正在實現或已完成建置的目標:

 - [LLVM/Clang](./LLVM.md)

Low Level Vitural Machine (LLVM)Compiler Infastructure，一種強大的編譯器架構設施底層工具。包含中間段代碼優化器工具鏈，以及基於LLVM架構的C/C++語言前端Clang編譯器。LLVM專案由Apache 2.0授權條款免費釋出。

 - [Cling](./Cling.md)

由CERN組織底下ROOT專案(統計及資料分析框架應用程式)的其中一個專案，LLVM/Clang基底的C++ REPL直譯器。

 - [GMT(Generic Mapping Tools)](建置偵錯中)

通用製圖工具，採GNU GPL v3.0公用自由授權條款免費釋出。

 - [Swift](等候建置測試)

由Apple開發基於LLVM/Clang基底建置，Objective-C/C++實現的Swift語言編譯器。

 - [Form(Symbolic Form)](./FORM.md)

一種符號運算系統分析工具，透過運算符處理而能逕行超複雜微積分/工程數學/高能物理公式運算的工具。

 - [CPython](./CPython.md)

以Automake或是CMake專案編譯C語言基底Python直譯器工作階段。

## CMake

CMake全名Crossmake，由Kitware開發並公開原始碼。CMake適用於C/C++/Fortran/Rust等編譯式基底原始碼進行建置跨平臺程式生成。CMake在程式開發的建置專案相對於為少數但功能更強大。

CMake有其獨立語法，並會依照專案建置規則調用編譯器(Compiler)、程式庫相依性(Dependeces)、生成器(Generator)執行生成檔案(Makefile)，生成後進行建置。CMake專案建置的程式不需要依賴環境相依性，其專案原始碼會有Windows平台建置的相容性程度，例如LLVM/Clang。


## Automake

Automake是GNU體系下的自動生成工具，以確認清單`Configure.ac`和生成清單`Makefile.am`執行專案建置目標，並調用GNU GCC編譯器`gcc`/`g++`、`make`執行生成。

Automake廣泛應用於類UNIX作業系統上(macOS/Linux最為常見)，在專案生成工具上站比很高，但對Windows環境不支援；Windows平台上執行Automake需要依賴MinGW/MSYS2/Cygwin環境執行Automake，且生成的應用程式具備GNU環境相依性(生成的程式須依賴`msysXXXX.dll`或`cygwinXXXX.dll`)。

## Stay tuned