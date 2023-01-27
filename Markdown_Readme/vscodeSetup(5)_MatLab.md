# VSCode的Matlab環境部署

## MatLab在線安裝

本章節將說明如何安裝MatLab。

MatLab有分在線安裝及離線安裝兩種部署方式，這裡我們選擇在線安裝。

MatLab的安裝版本號會以檔名形式標註。其有安裝啟動器快取資料夾在同路徑下。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_1.png)

MatLab在線安裝需要你登入已註冊的Mathworks帳號，並同意你的使用條款。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_2.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_3.png)

接著選擇你擁有的MatLab授權憑證，並確定你的使用者身分。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_4.png)
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_5.png)

確認你安裝MatLab的根目錄。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_6.png)

選擇你要安裝的MatLab元件，接著執行安裝即可。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_7.png)

## VSCode調用Matlab互動式命令列

本章節將說明如何在VSCode中調用MatLab以及互動式命令列。

欲實現MatLab互動式命令列的先行條件:
 - Visual C++ Toolkit (Visual Studio)
     - MSVC v143
     - MSVC v143 ALT
     - Windows VC++ Crossmake (Windows C++ CMake)
     - Windows SDK
 - Python
     - Python 3.8/3.9/3.10
 - MatLab
 - VSCode Extentions
     - Matlab Interactive Terminal (Aurélien Pommel)

MatLab調用至VSCode的互動式命令列需要以Python的MatLab Engine API完成實現。因此，我們需要執行PyPl的pip指令:
 - PowerShell
     ```
     PS> pip install matlabengine
     ```

若是執行失敗，則會顯示子程序出現問題，而不是pip指令的問題。此時，你有多個除錯方向:
 - Python版本。
 - pip執行安裝的matlabengine版本。
 - Visual Studio 2022是否正確安裝桌面開發C++套件。
 - MatLab是否正確安裝。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_engineAPI_py_debug.png)

若是執行失敗，則會顯示成功畫面:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_engineAPI_py_0.png)

接著回到VSCode中開啟終端機，應該會出現MatLab選項。這是成功呼叫命令列的樣子:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown_Readme/Fetch_Pics/vscode_matlab_extention_terminal.png)
