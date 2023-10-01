# Office線上安裝的命令列部署

## Office的命令列安裝

本讀我檔闡述以命令列形式執行Microsoft Office的線上安裝。本範例將透過命令下載連結取得Office的部署工具。

指定在桌面上，開啟一個新的資料夾`officetool`，並且存放後會下載的Office部署工具。開啟[終端機](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Let's%20Do%20Setup/vscode_Setup(0.2)_Shell.md)(PowerShell/CMD)執行以下命令:
 - PowerShell
    ```
     cd ~/Desktop
     mkdir officetool; cd officetool
     winget install Microsoft.OfficeDeploymentTool
    ```

`winget`指令會執行`winget`套件管理員連線至Microsoft Store搜尋下載並啟動安裝程式。但該部署工具執行時為自解指令，因此不會有任何下載及安裝動作。我們可以在終端機內找到`winget`鎖搜尋到Office部署工具的連結:
 - Terminal(Output)
    ```
     找到 Office Deployment Tool [Microsoft.OfficeDeploymentTool] 版本 16.0.16626.20148
     此應用程式已由其擁有者授權給您。
     Microsoft 不負任何責任，也不會授與協力廠商封裝的任何授權。
     正在下載 https://download.microsoft.com/download/2/7/A/27AF1BE6-DD20-4CB4-B154-EBAB8A7D4A7E/officedeploymenttool_16626-20148.exe
     ██████████████████████████████  3.53 MB / 3.53 MB
     已成功驗證安裝程式雜湊
     正在啟動套件安裝...
     已成功安裝
    ```
使用`Ctrl+左鍵`點選該網址形式的程式，重新下載至桌面的`officetool`資料夾內。

執行Office部署工具，開始自解安裝程式和產品確認信息:
 - PowerShell
    ```
     .\officedeploymenttool_16626-20148.exe
    ```
執行資料夾列表命令`ls`/`dir`一覽`officetool`資料夾:
 - PowerShell(Output)
    ```
     PS C:\Users\<USER>\Desktop\officetest> ls

     Directory: C:\Users\<USER>\Desktop\officetest

     Mode                 LastWriteTime         Length Name
     ----                 -------------         ------ ----
     -a---          2023/07/31    07:13           1164 configuration-Office2019Enterprise.xml           ## < Microsoft Office 2019 LTSC >
     -a---          2023/07/31    07:13           1368 configuration-Office2021Enterprise.xml           ## < Microsoft Office 2021 LTSC >
     -a---          2023/07/31    07:13           1014 configuration-Office365-x64.xml                  ## < Microsoft Office 365 64-bit >
     -a---          2023/07/31    07:13           1014 configuration-Office365-x86.xml                  ## < Microsoft Office 365 32-bit >
     -a---          2023/09/26    16:29        3707384 officedeploymenttool_16626-20148.exe                     
     -a---          2023/07/31    07:13        7604576 setup.exe                                        ## < Microsoft Office Installer >
    ```

我們執行"**Office 365**"64位元版本的Office安裝。以`VSCode`啟動產品信息檔案(`*.xml`):
 - PowerShell
    ```
     code ./configuration-Office365-x64.xml
    ```

以下會基於XML格式修改並刪減Office產品內容:
 - XML
    ```
     <Configuration>

     <Add OfficeClientEdition="64" Channel="Current">
        <Product ID="O365ProPlusRetail">
            <Language ID="en-us" />                                     <!  將"en-us" 修改成"zh-tw">
        </Product>
        <Product ID="VisioProRetail">                                   <!  刪除第1行>
            <Language ID="en-us" />                                     <!  刪除第2行>
        </Product>                                                      <!  刪除第3行>
     </Add>

            <!--  <Updates Enabled="TRUE" Channel="Current" /> -->      <!  註解  >

            <!--  <Display Level="None" AcceptEULA="TRUE" />  -->       <!  註解  >

            <!--  <Property Name="AUTOACTIVATE" Value="1" />  -->       <!  註解  >

     </Configuration>
    ```

真正有效的XML安裝信息如下:
 - XML
    ```
     <Configuration>

     <Add OfficeClientEdition="64" Channel="Current">
        <Product ID="O365ProPlusRetail">
            <Language ID="zh-tw" />
        </Product>
     </Add>
     </Configuration>
    ```

最後在終端機執行命令:
 - PowerShell
    ```
     ./setup.exe /configure ./configuration-Office365-x64.xml
    ```

Office安裝完成後，依照你的授權模式類型以Office 365登入帳號授權，或是以KMS主機連線授權啟動Office產品。

## Office產品安裝的XML信息

我們以實際執行的`configuration-Office365-x64.xml`為例:
 - XML
    ```
     <Configuration>

     <Add OfficeClientEdition="64" Channel="Current">
        <Product ID="O365ProPlusRetail">
            <Language ID="zh-tw" />
        </Product>
     </Add>
     </Configuration>
    ```

在這個XML當中:
 - `<Configuration>`和`</Configuration>`為「確認」產品信息的"頭"和"尾"，含括內容為欲增加的信息。
 - `<Add>`和`</Add>`為「增加」信息的"頭"和"尾"，含括內容為欲安裝的Office產品信息。
 - `<Product>`和`</Product>`為「產品」信息的"頭"和"尾"，含括內容為欲安裝的Office產品信息。
     - `Product ID`可指定Microsoft Office的版本。
     - `Language ID`指定Microsoft Office安裝後的語言。
