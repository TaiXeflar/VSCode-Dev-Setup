# VSCode建置WSL偵錯環境

本文會對Windows平台的Linux子系統平台建置開發環境。

## WSL部署
WSL以虛擬化技術執行實體Linux核心，使得Windows可基於本機訪問並執行基於Linux系統的二進位可執行檔案。

現在，Windows提供WSL2為預設Linux子系統，可直接透過終端機安裝。(提升權限可直接使用`gsudo`)

本範例提供安裝Ubuntu(替換其他發行版本在`<dist>`填入發行版本):
- PowerShell
  ```
    wsl.exe --install                           # 安裝WSL (預設發行版本為Ubuntu)
    wsl.exe --install -d ubuntu                 # 安裝WSL (指定發行版本為Ubuntu)
    wsl.exe --install -d <dist>                 # 安裝WSL (指定發行版本為<dist>)
  ```

若有需要，執行`dism`以啟用虛擬機器平台(提升權限時可使用`gsudo`):
- PowerShell
  ```
   dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
  ```


當WSL安裝成功會提示輸入新的UNIX使用者名稱以及新的密碼。在類UNIX系統中，必須要有使用者名稱以及非空白的有效密碼。
![image]

到目前為止僅使用者擁有帳密權限，未指派超級使用者`root`的密碼。可先行確保Switch User`su`切換超級使用者指令正常運作:
- BASH
  ```
   sudo -i          # 以使用者身份登入Super User
   
   passwd           # 更換密碼

   su               # 切換至Super User

## WSL 開發套件部署

Linux作業系統的套件下載透過套件管理員(Package Manager)或是其他下載軟體進行套件安裝。

先從Ubuntu的套件管理員`apt`開始更新套件管理員本身:
- BASH
  ```
   sudo apt update
  ```

接著是重要的`wget`套件:
- BASH
  ```
   sudo apt install wget
  ```

部分GNU開發工具為晶片開發廠商協力應用程式需要具備的基礎程式建立工具。包含GCC等一系列開發工具:
- BASH
  ```
   # GCC = GNU C/C++ Compiler, make = makefile

   sudo apt install gcc
   sudo apt install make

   # 其他開發者工具選項自定義: 

   sudo apt install <OPTIONS>

      <OPTIONS> = gfortran
                  cmake
                  clang
                  llvm
                  python3
                  python3-pip
                   
  ```

殼層可有以下選擇:
- BASH
  ```
   # BASH 更新:

   sudo apt install bash --upgrade

   # 選擇其他殼層:

   sudo apt install <OPTIONS>

     #  <OPTIONS> = zsh           # Z Shell
     #              tcsh          # TEXNEX C Shell
     #              fish          # Friendly Interactive Shell

若是在WSL中部署PowerShell，則執行`wget`搜尋:
- BASH
  ```
   cd ~/
   mkdir temp/
   cd temp/
   wget <PWSH_URL>          
                                  # PowerShell v7.3.4 Debian/Ubuntu: 
                                  # https://github.com/PowerShell/PowerShell/releases/download/v7.3.4/powershell_7.3.4-1.deb_amd64.deb
   sudo dpkg -i <PWSH_PKG.deb>
                                  # PowerShell install Package : powershell_7.3.4-1.deb_amd64.deb
命令列當中，`<PWSH_URL>`是PowerShell在GitHub託管的下載網址，依作業系統/微處理器架構/發行版本迭代而有不同。下載的安裝包以`sudo`使用`dpkg`安裝檔案至Linux系統。

更改登入系統預設殼層，需要修改`.bashrc`:
- BASH
  ```
   cd ~/                          # 切換目錄至 /home/User/  
   sudo nano .bashrc              # 以超級使用者編輯.bashrc設定
   source .bashrc                 # 立即套用.bashrc更新
  ```

修改登入殼層選項時，將游標移至`.bashrc`檔案最下處，新增以下內容(**需要確保這些內容均在**`.bashrc`**檔案最下層**):
- .bashrc
  ```
   if [ -t 1 ];then
       exec <SHELL_EXECUTABLE>     # zsh, pwsh, tcsh, fish, etc.
   fi
  ```
當中，`<SHELL_EXECUTABLE>`是殼層的可執行檔。若殼層執行檔在Linux規定的PATH中，則直接呼叫該執行檔。

## WSL 部署 NVIDIA HPC SDK

NVIDIA HPC SDK包含原CUDA C/C++ SDK及CUDA框架的Fortran。此處以下載v23.5且包含CUDA 12.1版本的Tarball解壓縮安裝為例:

- BASH
  ```
   cd ~/
   wget <NVHPC_SDK_URL>     # NVHPC23.5 with CUDA 12.1: https://developer.download.nvidia.com/hpc-sdk/23.5/nvhpc_2023_235_Linux_x86_64_cuda_12.1.tar.gz
   tar -xpzf <NVHPC_SDK.tar.gz>
   cd ./<NVHPC_SDK_unzip_folder>
   sudo ./install
  ```
當中，`<NVHPC_SDK_URL>`是NVIDIA Developer官網提供適用於Linux系統下載Tarball形式的下載網址，`<NVHPC_SDK.tar.gz>`是你利用`wget`下載至`~/`底下的tar.gz檔案，
`<NVHPC_SDK_unzip_folder>`是`tar`指令解壓縮並新建出來的資料夾。注意，需要以`sudo`執行`install`可執行程式以指定安裝至`/opt/nvidia`或是`/usr/bin/`等位置。此處安裝是以`/opt/nvidia`為安裝範例。

接著需要新增NVIDIA HPC SDK的內容至PATH中以利直接呼叫。在`.bashrc`中添加以下內容:
- .bashrc
  ```
   export nvPATH="/opt/nvidia/hpc_sdk/Linux_x86_64/23.5/compilers/bin"
   export nvMANPATH="/opt/nvidia/hpc_sdk/Linux_x86_64/23.5/comm_libs/mpi/man"
  
   export PATH="$PATH:$nvPATH"
   export MANPATH="$MANPATH:$nvMANPATH"
  ```
當中，我們以新建`nvPATH`變數儲存編譯器的位置，`nvMANPATH`變數儲存編譯器說明檔的位置，縮短直接填入`PATH`及`MANPATH`中的長度。

直接套用包含最新變數的`.bashrc`:
- BASH
  ```
   source .bashrc
  ```

測試PATH是否加入，呼叫以下編譯器其中之一:
- BASH
  ```
   nvcc
   nvc++
   nvfortran
  ```
 
若呼叫nvfortran名稱太長，可以用link建立符號連結(此處以`nvfort`建立對`nvfortran`的符號連結):
- BASH
  ```
   cd $nvPATH
   sudo ln -s nvfortran nvfort
  ```
當中，`$nvPATH`已在`.bashrc`中被宣告為包含路徑的字串變數，使用`cd`指令可以接續變數名稱以直接切換至變數的指定路徑。



