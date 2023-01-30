# VSCode的Matlab環境部署

## MATLAB在線安裝

本章節將說明如何安裝MATLAB。

MATLAB有分在線安裝及離線安裝兩種部署方式，這裡我們選擇在線安裝。

MATLAB的安裝版本號會以檔名形式標註。其有安裝啟動器快取資料夾在同路徑下。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_1.png)

MATLAB在線安裝需要你登入已註冊的Mathworks帳號，並同意你的使用條款。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_2.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_3.png)

接著選擇你擁有的MATLAB授權憑證，並確定你的使用者身分。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_4.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_5.png)

確認你安裝MATLAB的根目錄。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_6.png)

選擇你要安裝的MATLAB元件，接著執行安裝即可。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_7.png)

## VSCode調用Matlab互動式命令列

本章節將說明如何在VSCode中調用MATLAB以及互動式命令列。

欲實現MATLAB互動式命令列的先行條件:
 - Visual C++ Toolkit (Visual Studio)
     - MSVC v143
     - MSVC v143 ALT
     - Windows VC++ Crossmake (CMake)
     - Windows SDK
 - Python
     - Python 3.8/3.9/3.10
 - MATLAB
 - VSCode Extentions
     - Matlab Interactive Terminal (Aurélien Pommel)

MATLAB調用至VSCode的互動式命令列需要以Python的MATLAB Engine API完成實現。因此，我們需要執行PyPl的pip指令:
 - PowerShell
     ```
     PS> pip install matlabengine
     ```

若是執行失敗，則會顯示子程序出現問題，而不是pip指令的問題。此時，你有多個除錯方向:
 - Python版本。
 - pip執行安裝的matlabengine版本。
 - Visual Studio 2022是否正確安裝桌面開發C++套件。
 - MATLAB是否正確安裝。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_engineAPI_py_debug.png)

若是執行成功，則會顯示成功畫面:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_engineAPI_py_0.png)

接著回到VSCode中開啟終端機，應該會出現MATLAB選項。這是成功呼叫命令列的樣子:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Image/vscode_matlab_extention_terminal.png)

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