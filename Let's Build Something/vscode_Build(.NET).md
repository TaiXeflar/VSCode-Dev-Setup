# 以VSCode建置.NET語言專案

## VSCode調用編譯器確認
.NET(Dot NET)為Microsoft的應用程式框架，由Basic開始至Visual Basic，發展.NET框架後VB列入.NET CORE核心一部分，相繼有C#，F#，Q#，PowerShell等.NET框架體系語言。備註:標註`<Target REPL>`為執行REPL直譯互動式的執行器，`<Target Compiler>`為執行編譯之目標編譯器。

 - [PowerShell(pwsh)](vscode_Build(PS1).md): Microsoft基於.NET Core核心的跨平臺語法相容性自動化管理殼層應用程式，基本語法相容CMD/BASH。PowerShell的跨平臺支援可安裝於macOS(UNIX-Like)/Linux(UNIX-Like)/FreeBSD(UNIX-Like)/ReactOS(DOS-Like)/Windows(DOS)等多種作業系統。PowerShell執行殼層，意味著PowerShell是以REPL模式執行互動式，可使用Cmdlet(Command-Let)命令執行PowerShell指令或以PowerShell手稿執行程式。PowerShell核心可以在VSCode內以Polyglot Notebooks延伸模組支援下以Jupyter筆記本形式執行PowerShell程式碼。

    - Unix-Like系統中並不包含PowerShell，但Microsoft有提供[PowerShell跨平臺支援](https://github.com/PowerShell/PowerShell)(PowerShell亦有開放原始碼)，Linux/macOS可透過`apt`，`yum`，`dnf`，`pacman`，`brew`等套件管理員執行套件下載安裝；或由GitHub頁面釋出的發行安裝檔`*.deb`，`*.rpm`，`*.pkg`等由套件管理員執行安裝；或利用`tar`解壓縮`*.tar.gz`的tarball並直接部署原生二進位制檔案。透過該PowerShell安裝位置路徑確認後加入至`PATH`變數以直接調用PowerShell殼層。

    - Windows 10/11內的PowerShell為LTS版本的PowerShell 5.1；目前最新版為PowerShell 7(註:`PATH`標示為該PowerShell核心的路徑位置；`VER`為版本號)。在Windows執行較新版本的PowerShell安裝(PowerShell 6/PowerShell 7)時會獨立安裝於不同路徑以隔離PowerShell Core執行環境，並可透過Windows Update取得PowerShell的最新版本安裝。
        ```
         powershell.exe         <PATH>  "C:\Windows\System32\WindowsPowerShell\v1.0\powershell.exe" <VER>   5.1
         powershell.exe         <PATH>  "C:\Windows\SysWOW64\WindowsPowerShell\v1.0\powershell.exe" <VER>   5.1
         powershell.exe         <PATH>  "C:\Windows\WinSxS\amd64_micro.....\powershell.exe"         <VER>   5.1

         pwsh.exe               <PATH> "C:\Program Files\PowerShell\X\pwsh.exe"                     <VER>   6.X/7.X
        ```
 - [Visual Basic(VB)](vscode_Build(.NET).md): 即為原Basic語法，後以可視覺化發展編程，現如今仍有大多數Windows傳統形式窗應用程式以Visual Basic逕行開發和發佈。現在的Visual Basic為Visual Basic 6世代且不迭代更新，並以長期維護形式透過原Windows本機.NET Core執行環境或以Visual Studio開發人員應用程式發行VB編譯器；一部分.NET框架的新式語法(例如C# ASP.NET Razor)亦相容於/可以Visual Basic語法執行。
    ```
     vbc.exe
    ```
 - [Visual C#(C Sharp)](vscode_Build(.NET).md): 微軟基於.NET Framework以C/C++相似語法設計新型的物件導向程式語言。適合建立C#主控台，C#視窗型應用程式，MSIX封包Windows應用程式安裝程式，Web應用程式，Blazor，Razor類型應用，WebAssembly部署，Unity遊戲引擎C#編程等通用型應用程式。請注意C#的名稱是"C Sharp"而不是"C Hashtag"(笑)。
    ```
     csc.exe
     csi.exe
    ```

 - [Visual F#(F Sharp)](vscode_Build(.NET).md): 微軟基於.NET Framework框架全新設計適用於科學計算、數值/函數運算全新設計的程式語言F#。
    ```
     fsc.exe
     fsi.exe
    ```
 - [Q#(Quantum Sharp)](): 微軟基於.NET Framework框架全新設計適用於量子科學計算的全新語言Q#。

## VSCode建置簡單VB.NET主控台專案偵錯

以下定義一個專案位置(資料夾)`myVB`，並有以下內容:
 - Folder
 ```
  |
  ├─> test.vb(VB來源)
  |
  └─> .vscode(資料夾)
         |
         ├─> tasks.json
         |
         └─> launch.json
 ```

### VSCode 建置作業 - tasks.json
VSCode對編譯類型程式進行建置(Build Task)，並會根據所引用條件(包含引用程式庫)執行預處理(pre-processing)->編譯(compilation)->彙編->(assembly)->鏈接(linking)程序。該建置作業由`tasks.json`引導vscode設定原始碼建置編譯信息傳遞作業。

以下是基於使用VB.NET編譯的設定:
 - JSON
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
                 "args": ["/E:ON", "/C", "VsDevCmd.bat", "host_arch=x64", "arch=x64"]
                 }
               }
             },
             "type": "shell",
             "label": "vbnet.exe",
             "command": "vbc.exe",
             "args":[
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
我們逐步介紹`tasks.json`內所有鍵值的傳遞訊息:
  - `version`:  值預設是`"2.0.0"`。
  - `tasks`: JSON陣列物件，且包含一個或多個JSON物件。

      - `windows`: 特殊的鍵值設定。該鍵值透過`"options"`的JSON鍵值建立用來呼叫一個殼層`"shell"`執行環境，此處呼叫Visual Studio環境初始化(`VsDevCmd.bat`)。
          - `executable`: 殼層可執行檔。建議使用`cmd.exe`(例如Intel oneAPI沒有PowerShell的支援)。
          - `args`: 傳遞至該殼層的引數。因為呼叫該殼層並執行建置後需要直接關閉，因此需要`"/E:ON"`、`"/C"`、`"setvars.bat"`、`"intel64 VS2022"`和`"&&"`引數。當中，各引數意義如下:
             - `"/E:ON"`: `cmd.exe`啟用延伸模組。
             - `"/C"`:  執行該殼層所有命令後關閉該`cmd.exe`殼層。
             - `"VsDevCmd.bat"`: 呼叫Visual Studio環境初始化。`"host_arch"`及`"arch"`引數傳遞給`VsDevCmd.bat`。
              
               `VsDevCmd.bat`會設定環境變數並遞迴搜尋所安裝的開發人員工具、SDK、程式庫、標頭程式庫等開發必要元件。透過`VsDevCmd.bat`配置的環境變數可一定程度省略`sysdm.cpl`所設定系統變數或在`c_cpp_properties.json`所手動設定鍵入的程式庫引用路徑。(例如UCRT程式庫位置、include、lib等)
             - `"host_arch"`: 設定本機架構所決定執行的編譯器。因本機架構是x64(Intel 64/AMD64)，故選擇`x64`。
             - `"arch"`: 設定建置目標架構所決定執行的編譯器。因目標是本機架構(建置在本機上執行)，故選擇`x64`。
             - `"&&"`: 傳遞一個後接的命令。

            該殼層的起動命令是:
             - Shell
                ```
                cmd.exe /E:ON /C VsDevCmd.bat -host_arch=x64 -arch=x64 && ...........
                ```
      - `type`: `shell`(因為該VB編譯命令從`cmd.exe`殼層啟動)。
      - `label`: 標籤。你可以叫一個喜歡的名字。
      - `command`:編譯器的檔案名。舉例MSVC就是`cl.exe`.
      - `args`: 傳遞至編譯器內的引數。不同編譯器在`args`JSON清單物件中可有不同引數及排列順序。
        ```
         vbc.exe: ["${file}"]
        ```

        調用VB Compiler`vbc.exe`的命令列為:
         - Shell
            ```
            vbc.exe test.vb
            ```

      - `problemMatcher`: 問題對比器選項。這裡選擇`["$msCompile"]`。
      - `"group"`: 群組定義工作為建置或測試及預設選項。`{"kind": "build", "isDefault": true}`

整體而言，該`tasks.json`呼叫的殼層建置命令為:
 - Shell
    ```
     cmd.exe /E:ON /C VsDevCmd.bat -host_arch=x64 -arch=x64 && vbc.exe test.vb
    ```

### VSCode 偵錯執行 - launch.json
執行程式的偵錯由`launch.json`內的訊息配置完成自定義的偵錯測試。執行程式即為對程式執行偵錯。編譯程式可額外設定透過建置後執行偵錯，直譯程式則直接執行。

本範例執行MSVC的偵錯設定:
 - JSON
    ``` 
    {
        "version": "0.2.0",
        "configurations": [
            {
                "name": "vbnet.exe",
                "type": "cppvsdbg",
                "request": "launch",
                "program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
                "args": [],
                "stopAtEntry": false,
                "cwd": "${workspaceFolder}",
                "environment": [],
                "console": "integratedTerminal",
                "preLaunchTask": "vbnet.exe"
            }
        ]
    }
    ```

當中:

  - `version`: 值預設是`0.2.0`.
  - `configuration`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:

    - `"name"`: 偵錯設定情境的名稱。
    - `"type"`: 選擇`"cppvsdbg"`。因為該執行是執行Fortran專案偵錯，會無視這項設定。
    - `"request"`: 因為是執行，選擇`"launch"`。
    - `"program"`: 偵錯建置的檔案。由`"${fileDirname}/${fileBasenameNoExtension}.exe"`關聯的檔案是經建置出來的目標執行檔(`test.exe`)。
    - `"args"`: 傳遞至該欲偵錯可執行檔的引數。由於沒有引數要傳遞所以為JSON空陣列(`[]`)。
    - `"stopAtEntry"`: 偵錯工具在目標的進入點停止的動作。這裡選擇`false`.
    - `"cwd"`: `"${workspaceFolder}"`
    - `"environment"`: 開啟偵錯時的環境變數設定，例如臨時附加的變數等。由於沒有引數要傳遞所以為JSON空陣列(`[]`)。
    - `"console"`: 取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。有以下的值:
       - `"integratedTerminal"`: 整合式終端機。偵錯結果將在vscode內的終端列印。
       - `"externalTerminal"`: 外部的終端機。該偵錯透過Windows終端機或Windows傳統主控台輸出偵錯。
    - `"preLaunchTask"`: 執行該目標執行檔的偵錯前建置作業。該值必須和tasks.json內的`label`名稱一致或其中一個相符。若有這項設定，則該目標底稿(此處為`test.vb`)會在執行偵錯時，自動先進行建置(依照`tasks.json`)作業。

整體而言，執行對`test.vb`偵錯的流程如下:
 - Shell
    ```
     cmd.exe /E:ON /C VsDevCmd.bat -host_arch=x64 -arch=x64 && vbc.exe test.vb
     .\test.exe                                                                                      
    ```
    當中，第一列是`test.vb`建置的命令列，由`preLaunchTask`呼叫並執行。第二列才是執行建置後目標執行檔`test.exe`的偵錯。

## VSCode建置PowerShell偵錯
VSCode內透過延伸模組[ext:PowerShell](https://marketplace.visualstudio.com/items?itemName=ms-vscode.PowerShell)提供PowerShell底稿的`F5`一鍵偵錯。

若欲利用PowerShell執行筆記本段落式樣偵錯，請參閱[Jupyter的.NET支援方式](vscode_Play(NB).md)。

### 備註
 - VB vs. VBScript(VBS): Visual Basic與VB Script(VBS)並沒有直接關聯，VBS也並非VB的直譯器；VBS為相容於Visual Basic語法的Visual Basic簡單語法解釋型可執行手稿(類似於Python Script)透過Windows本機元件的`cscript.exe`及`wscript.exe`Console直接執行VBS手稿。由於VBS可視為可執行檔，因此VBS執行時系統不會對VBS進行掃毒或威脅隔離。若是需要執行VBS可使用Windows Sandbox執行虛擬機器。