# C/C++ language test with VSCode Setup 


## Compilers information:

  - This Article uses 5 C/C++ compiler and running on Windows as test samples:

  1. MSVC (Microsoft Visual C++) requires Microsoft Visual Studio 2015 and later version.

     - If you want to use msvc, you have to build enviroment via `VsDevCmd.bat`.
     - At least C++ Build tools must be installed (e.g. MSVC v143 - VS2022 C++ x86-64 Build tools).

  2. ICL and Intel DPCPP requires Intel oneAPI toolkit (Intel DPC++/C++ and Intel Classic C/C++ Compilers).

     - If you attempting use Intel Compilers, you have to build enviroment via `setvars.bat`.

  3. NVCC (NVIDIA CUDA Compiler) requires NVIDIA CUDA Toolkit installation.

     - Run CUDA needs NVIDIA GPU, GeForce Game Ready / Studio driver, nvcc compiler and CUDA runtime.
     - You may be need import other headers, dlls and libs to CUDA toolkit location. (e.g. NVIDIA cuDNN)


  4. GCC uses Dev-CPP MinGW64 GCC/G++ compiler as example.

## PATH settings

  - All compilers can be found at these path. Please copy which compilers and batch files' folder locations listed below into `PATH` variables.

    - Microsoft Visual C/C++ compiler:

      `PATH`:

      - VsDevCmd.bat : "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/Tools/VsDevCmd.bat"
      - cl.exe : "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/`Version Number`/bin/HostX64/x64/cl.exe"

        Change the `Version Number` if you notice that your selection tools version numbers via installation.

        - VS2022: `14.33.31629`, VS2019: `14.29.30133`, VS2017: `14.16.27023`.

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

## PATH Variables setup

  - You have to add the executable's folder path into PATH variables. Whatever User PATH or System PATH. May requires reboot.
    - `PATH` = "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/`Version Number`/bin/HostX64/x64/"
    
  - Test the exe call in Windows Terminal by enter the exe's name after `PATH` added. For cl.exe(VS2022 v143) as example:
    - PS> cl
    

## VSCode Extention 

You may need install these Extentions:

  - C/C++
  - C/C++ Themes
  - C/C++ Extention Pack

## .vscode folder configuration

JSON Files: You need to add 3 json files for C/C++ setup.
Remember, when you're type file's path/location, you have to type `/` or `\\` instrad of  `\`.
  - `c_cpp_properties.json`: C/C++ Intellisense mode in VSCode. Enables faster select key words select and standard notice. This option is sync with C/C++ properties(UI) from Microsoft C/C++ extention pack. 
  - `tasks.json`: C/C++ script/file compile to executable task settings. This is the most important section while do the build.
  - `launch.json`: Debug C/C++ compiled executable.
  
1. c_cpp_properties.json : 
  -  
    - `version`: Default is `4`.
    - `configurations`: JSON List object (`[]`) contains json object (`{}`). Just like this: `configurations: [{}]`

    Inside json object (`{}`) will have these key-pair values:
    - `name`: `Win32`. You can call whatever you like, but like `Win32`, `Linux`, `Mac` is special value based on your OS.
    `includePath`: json object list (`[]`). If you wish include headers saved in your workspace root, then fill`"${workspaceFolder}/**"`。`/**` means do recursive search in target sub directory.
    - `defines`: json list object (`[]`) with these values: `_DEBUG`, `UNICODE`, `_UNICODE`.
    - `WindowsSDKVersion`: `10.0.22000.0`. You can select other version value you've installed.
    - `compilerPath`: Enter the compiler's `PATH`with `""`as string value. 
    - `cStandard`: Various compiler has each C standard version. If you don't know the compiler's standard then use `${Default}`.
    - `cppStandard`: Same compiler C++ standard version settings as `cStandard`. This Key value can deploy on g++ or dpcpp.

2. tasks.json:
  - 
    - `version`:  Default is `"2.0.0"`.
    - `tasks`: json list object.
    - `windows`: json object to callout emv batch file via terminal console if you use msvc, icl, icx, dpcpp compiler. gcc and nvcc can skip this.
        Clone`"options": {"shell": {}}` into the `windows` json object. Two key-pair values need to setup:
        - `executable`: Either `cmd.exe` or `powershell.exe` can be your choice.
        - `args`: `["/C", "__DEV.bat__", "&&"]`. Replace `__DEV.bat__` as `VsDevCmd.bat` if you use msvc, `setvars.bat` if you use icl, icx, dpcpp. 
    - `type`: `shell`.
    - `label`: You can set a name you like.
    - `command`: compiler's file name. For msvc is `cl.exe`.
    - `args`: Flags import to compiler. Different compiler uses different args and orders in `args` json list object:
      - MSVC cl.exe: `["/Fe:", "${fileDirname}\\${fileBasenameNoExtension}.exe", "${file}"]`
      -  dpcpp.exe: `["-o", "${fileDirname}\\${fileBasenameNoExtension}.exe","/Zi","/EHsc", "${file}"]`
      - Intel icl.exe: `["-o", "${fileDirname}\\${fileBasenameNoExtension}.exe", "${file}"]`
      - CUDA nvcc.exe: `["-g", "${file}", "-o", "${fileDirname}\\${fileBasenameNoExtension}"]`
      - GCC gcc.exe: `["-g", "-o", "${fileDirname}\\${fileBasenameNoExtension}.exe", "${file}"]`
      - 
    - `problemMatcher`: `["$msCompile"]`,
    - `"group"`: `{"kind": "build", "isDefault": true}`
  
3. launch.json:
  - 
    - `version`: Default is `0.2.0`.
    - `configuration`: JSON List object (`[]`) contains json object (`{}`). Inside Key-pair values are:
      - `"name"`: launch task name.
      - `"type"`: `"cppvsdbg"`.
      - `"request"`: `"launch"`.
      - `"program"`: `"${fileDirname}/${fileBasenameNoExtension}.exe"`.
      - `"args"`: [],
      - `"stopAtEntry"`: `false`.
      - `"cwd"`: `"${workspaceFolder}"`
      - `"environment"`: [],
      - ` "console"`: `"integratedTerminal"` or `externalTerminal`. Decide on Terminal which you want to show in vscode or a jump out console.
      - `"preLaunchTask"`: You have to pair `label` which you set in **tasks.json**.


## Hot Keys Tips

You can use common hot keys to accelerate your efficiency.

  - `Ctrl + C`: Clone/Duplicate/Copy codes.
  - `Ctrl + V`: Paste cloned codes.
  - `Ctrl + X`: Cut codes.
  - `Ctrl + S`: Save files. This can fast save your original files and save `COMMIT_EDITMSG` when you're sync to GitHub repos.
  - `Ctrl + Shift + S`: Save the file as another file.
  - `Ctrl + Shift + P`: Find vscode settings.
  - `Ctrl + Shift + B`: Do Build tasks.
  - `F5`: Do Debug/Launch tasks.
  - `Ctrl + F`: Find targets in your file.
  - `Ctrl + H`: Find targets and replace in your file.
  - `Ctrl + K` + `Ctrl + O`: Open folder.
  - `Ctrl + K` + `F`: Close folder.

## Troubleshooting

Some develop enviroment should consider hardware/software cause errors:

  - DPCPP: You need Intel Arc (Discrete GPU) or Intel UHD/Iris Xe Graphics (Integrated GPU).

    On Notebook, you should turn to **NVIDIA Optimus** mode via MUX Switch (If your notebook has it).
    On Desktop, You need enable iGPU (via BIOS/UEFI) or screen output via motherboard.
    Your CPU type must not be F series Intel Core CPU. (e.g. Intel i7-12700KF)

  - ICL: You should deploy Intel Classic C/C++ Compilers on **"Intel Inside"** Desktop or Notebook.
  
    ICL run on AMD series processors may cause unexpected architecture compatibility level errors.
    If you're using AMD CPUs, please consider change to MSVC, GCC, or AMD Optimized C/C++ compilers vis WSL2.

  - NVCC: You pc should contain a CUDA supported NVIDIA GPU.

    You cannot run CUDA program on Intel and AMD graphics.
    CUDA version may effect supported CUDA GPUs by GPUs architecture.

  - MSVC: MSVC only can run at Windows System (AMD64/ARM64).

    If you can't run compile enviroment, please check pre-compile action with calling `VsDevCmd.bat` in **tasks.json**.
    If you wish use clang compilers, please install Windows compatable Clang tools via Visual Studio Installer. 


## References

  Configure MSVC on windows: https://code.visualstudio.com/docs/cpp/config-msvc

  Configure GCC on windows: https://code.visualstudio.com/docs/cpp/config-mingw

  Intel DPCPP example cpp script: From VS2022 DPCPP Project auto build example code.

  NVIDIA CUDA example kernel.cu script: From VS2022 CUDA Project auto build example code.
  
