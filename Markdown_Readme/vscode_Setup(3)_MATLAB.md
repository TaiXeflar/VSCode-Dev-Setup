# VSCode的Matlab環境部署

## MATLAB在線安裝

本章節將說明如何安裝MATLAB。

MATLAB有分在線安裝及離線安裝兩種部署方式，這裡我們選擇在線安裝。

MATLAB的安裝版本號會以檔名形式標註。其有安裝啟動器快取資料夾在同路徑下。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_1.png)

MATLAB在線安裝需要你登入已註冊的Mathworks帳號，並同意你的使用條款。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_2.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_3.png)

接著選擇你擁有的MATLAB授權憑證，並確定你的使用者身分。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_4.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_5.png)

確認你安裝MATLAB的根目錄。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_6.png)

選擇你要安裝的MATLAB元件，接著執行安裝即可。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_7.png)

## VSCode調用Matlab互動式命令列(MATLAB Command Window) [OS= macOS]
在macOS內，可以用終端機執行MATLAB引擎:
 - Z Shell(ZSH)
 ```
 matlab -nodisplay
 ```

我們可以根據這個特性，在使用者設定的終端機選項(鍵值`"terminal.integrated.profiles.osx"`)內加入這組鍵值:
 - JSON
 ```
 "MATLAB Interactive":{
    "path": "matlab",
    "args": ["-nodisplay"]
 }
 ```

## VSCode調用Matlab互動式命令列(MATLAB Command Window) [OS= Windows]
由於MATLAB不支援在Windows上執行終端模式(`-nodisplay`)，因此我們以`Matlab Interactive Terminal (Aurélien Pommel)`實現。

欲實現MATLAB互動式命令列的先行條件:
 - Visual C++ Toolkit (Visual Studio)
     - MSVC v143
     - MSVC v143 ALT
     - Windows VC++ Crossmake (CMake)
     - Windows SDK
 - Python
     - Python 3.8/3.9/3.10
 - MATLAB
 - VSCode Extentions (VSCode 延伸模組)
     - Matlab Interactive Terminal (Aurélien Pommel)

MATLAB調用至VSCode的互動式命令列需要以Python的MATLAB Engine API完成實現。因此，我們需要執行PyPl的pip指令:
 - Shell
     ```
     pip install matlabengine
     ```

若是執行失敗，則會顯示子程序出現問題，而不是pip指令的問題。此時，你有多個除錯方向:
 - Python版本。
 - pip執行安裝的matlabengine版本(會需要對應的MATLAB版本)。
 - Visual Studio 2022是否正確安裝桌面開發C++套件。
 - MATLAB是否正確安裝。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_engineAPI_py_debug.png)

若是執行成功，則會顯示成功畫面:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_engineAPI_py_0.png)

接著回到VSCode中開啟終端機，應該會出現MATLAB選項。這是成功呼叫命令列的樣子:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_matlab_extention_terminal.png)


## VSCode建置Matlab手稿偵錯

偵錯方式有兩種:
 - 第一種，需要額外的2個延伸模組:
     - Code Runner (Jun Han)
     - Matlab (Xavier Hahn)

    以熱鍵 "`Ctrl`+`Shift`+`P`" 啟動命令選擇區，找到 `喜好設定: 開啟使用者設定(JSON)` 並按 `Enter` 確認進入`settings.json`。

    加入以下鍵值:
     - JSON
         ```
            "code-runner.executorMap": {
                "matlab": "cd $dir && matlab.exe -batch $fileNameWithoutExt"
            },
            "matlab.matlabpath": "C:/Program Files/MATLAB/R2022a/bin/matlab.exe",
            "matlab.mlintpath": "C:/Program Files/MATLAB/R2022a/bin/win64/mlint.exe",
            "matlab.linterEncoding": "gb2312"
         ```

    在加入的JSON鍵值當中:
    
     - `matlab.matlabpath`: MATLAB延伸模組所指定的`matlab.exe`的路徑。
     - `matlab.mlintpath`: MATLAB延伸模組所指定的`mlint.exe`的路徑。
     - `matlab.linterEncoding`: MATLAB延伸模組所指定該專案的編碼形式。若為萬國碼則選`utf8`。若為中文可選`gb2312`或`big5`等。

     - `code-runner.executorMap`: Code Runner延伸模組所指定程式偵錯指令的廣域設定。該JSON鍵值可指定任意受支援的程式語言。
         - `"matlab"`為MATLAB程式語言的偵錯設定內容，由字串值傳遞命令列。
         - `cd`為切換目錄至指定路徑(資料夾)，由`$dir`傳遞目前路徑(即`cd`的目標路徑)。
         - `&&`為繼`cd`命令之後傳遞一個子命令(即後續欲執行的`matlab`命令列)。
         - `matlab.exe`為MATLAB主程式可執行檔。
         - `-batch`引數為在MATLAB啟動時不顯示MATLAB圖標，且讓MATLAB在背景執行。
         - `$fileNameWithoutExt`:該目標MATLAB底稿。因為MATLAB命令列是呼叫執行底稿時不加入副檔名(Without Extention)，故傳遞至該命令列的是該底稿的主檔名。

    接著回到欲偵錯的Matlab底稿，以熱鍵 "`Ctrl`+`Alt`+`N`"偵錯，此時會出現輸出視窗，由Code Runner執行matlab底稿內全部程式。

 - 第二種，需要以建置工作(Build Tasks)的方式實現執行MATLAB底稿:
    
    在該底稿同路徑下建立`.vscode`資料夾後，在內部建立一個`tasks.json`檔案。

    接著對`tasks.json`加入建置的命令配置:

    - JSON
       ```
        {
            "version": "2.0.0",
            "tasks": [
                {
                    "windows":{
                        "options": {
                            "shell": { "executable": "powershell.exe", "args": [] }
                        }
                    },
                    "type": "shell",
                    "label": "matlab.exe",
                    "command": "matlab.exe",
                    "args": [ "-batch", "${fileBasenameNoExtension};exit" ],
                    "problemMatcher": ["$msCompile"],
                    "group": { "kind": "build", "isDefault": true }
                }
            ]
        }
       ```
    完成後，以建置工作(熱鍵: `Ctrl`+`Shift`+`B`)執行MATLAB建置。