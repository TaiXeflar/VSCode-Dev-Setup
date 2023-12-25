# Symbolic Form

FORM是一種符號操作系統，藉由Form來源檔案`*.frm`內的符號列式進行符號/數字轉換操作而獲得數學表示式。
 - Form依靠儲存空間(Storage Space/ROM - SSD/HDD)儲存計算資料，而不是依靠動態記憶體(DRAM/SRAM/VRAM)。
 - Form本質是數學代數系統，但更適用於大規模處理符號表示式。

## 在Cygwin環境以Mingw64 GCC及Automake建置Form

Cygwin環境下安裝的套件如下。 
   ```
    automake
    make
    mingw64-x86_64-gcc-core      (GCC for Win64 Toolchain)
    mingw64-x86_64-gcc-g++       (GCC for Win64 Toolchain)
    mingw64-x86_64-gcc-zlib          (for Win64 Toolchain)
    wget
   ```

接著從GitHub下載Form的釋出版本原始碼壓縮包並解壓縮:

 - Bash(Cygwin)
   ```
    cd ~/Desktop; 
    tar -xvzf https://github.com/vermaseren/form/archive/refs/tags/v4.3.1.tar.gz
    cd form-4.3.1
   ```


解壓縮並進入到原始碼資料夾中，可以觀察到存放庫內有`Configure.ac`和`Makefile.am`兩個檔案。因此可以確定Form專案需要使用Automake執行專案建置。

觀察部分原始碼可以發現原始碼依賴`sys/wait.h`等標頭檔。這些標頭檔是類UNIX系統內的標頭檔，因此可以確認，Form專案需要依賴MSYS2/Cygwin API環境內執行Automake建置Form。 執行`autoreconf`生成`configure`檔案:
 - BASH(Cygwin)
   ```
    autoreconf -i
   ``` 

接著執行`configure`檔案:
 - BASH(Cygwin)
   ```
    ./configure --prefix=<PATH> --with-api="<API>"
   ```
當中:
 - `configure`在BASH中是可執行手稿，可以直接執行。
 - `prefix`傳遞安裝路徑，類似於CMAKE的`CMAKE_INSTALL_PREFIX`安裝路徑引數傳遞。
 - `CC`: C語言前端，類似於CMAKE的`CMAKE_C_COMPILER`參數選擇的C語言編譯器。
 - `CXX`: C++語言前端，類似於CMAKE的`CMAKE_CXX_COMPILER`參數選擇的C++語言編譯器。
 - `with-api`傳遞應用程式介面選項。
     - `posix`選項為Cygwin API， 需要GNU GCC編譯器，依賴Cygwin環境，但建置專案可有最優化的POSIX標準體驗。
     - `windows`選項為Windows API。 需要MinGW GCC for windows編譯器， 不依賴Cygwin即可執行。

最後，執行建置生成:
 - BASH(Cygwin)
   ```
    make 
   ```
