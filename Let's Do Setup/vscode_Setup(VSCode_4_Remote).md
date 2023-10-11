# VSCode執行遠端工作階段

## Working in progress

## VPN連線

若你的連線主機為私人網域並設有防火牆，請設定本地端電腦的連線已連線至私人網域內的VPN伺服器(VPN Server)再轉連接至遠端主機。

若本機的VPN撥接電話簿選項已存在，則VPN撥接的指令如下:
 - PowerShell
    ```
     rasdial <VPN_NAME> <USER_NAME>
    ```


## OpenSSH連線指令
現今大多數支援遠端通訊協議的伺服器/遠端主機均支援OpenSSH(Open Secure Shell)加密通訊協議，因此透過一行指令即可連線至指定遠端主機。OpenSSH協議已包含在[Git for Windows]()的安裝套件中(因為Git推送連線至GitHub伺服器允許OpenSSH連線協議)並已加入至PATH中，基於此預設設定可直接呼叫SSH。

請務必確認你是否有遠端桌面的操作帳號可供登入；以及目標遠端主機是否需要透過VPN逕行內網連接。

SSH遠端連線工作階段的實現僅需一行指令:
 - PowerShell
    ```
     ssh <USER_NAME>@<IPv4>
    ```

SSH遠端連線工作階段指定監聽埠:
 - PowerShell
    ```
     ssh <USER_NAME>@<IPv4> -p <PORT>
    ```

上述2個指令的參數如下:
 - `ssh`: SSH程式。該SSH為Git for Windows所包含的OpenSSH。
 - `<USER_NAME>`: 目標遠端主機的欲登入使用者名稱。
 - `<IPv4>`: 目標主機的IPv4位址。
 - `-p`: Port參數，傳遞目標遠端主機指定的監聽埠`<PORT>`。若無特殊指定`PORT`(即第一行指令)則不須傳遞此參數。
 - `<PORT>`: 目標遠端主機指定的監聽埠，值為0~65535。

以下制定一個本機-遠端的範例:
| 執行階段 | 本地端 | 遠端 |
| :----: | :----: | :----: |
| 作業系統 | Windows | Linux |
| IPv4 | LocalHost | XXX.XXX.XXX.XXX |
| 監聽埠 | ---- | 54088 |
| 殼層 | PowerShell | BASH |
| 使用者 | userWin | userLinux |

則上述第2個指令範例如下:
 - PowerShell
   ```
    ssh userLinux@XXX.XXX.XXX.XXX -p 54088
   ```
該指令意義是: 以`userLinux`使用者名稱登入IPv4位址為`XXX.XXX.XXX.XXX`的遠端主機，並在`54088`的埠上進行遠端主機的監聽。


## VSCode的遠端主機工作階段設定

首先在VSCode內安裝遠端桌面的延伸套件: (若提示須要重新啟動VSCode則執行重新啟動)
 - [Remote SSH](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-ssh)
 - [Remote Explorer](https://marketplace.visualstudio.com/items?itemName=ms-vscode.remote-explorer)
 - [Remote SSH: Editing Configuration Files](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-ssh-edit)

接著執行遠端連線的選擇:

![Image](../Markdown%20Image/vscode_remote(1).png)

選擇新增SSH主機:

![Image](../Markdown%20Image/vscode_remote(2).png)

輸入SSH連線指令:

![Image](../Markdown%20Image/vscode_remote(3).png)

儲存SSH主機的連線設定檔。這裡將SSH主機信息儲存至`~/.ssh/config`中。

![Image](../Markdown%20Image/vscode_remote(4).png)

SSH主機連線設定已完成。若登入時使用者有帳密則依提示輸入密碼。

若欲更改SSH主機選項，則開啟`~/.ssh/config`檔案。該`config`檔案以YAML格式儲存SSH主機信息:

![Image](../Markdown%20Image/vscode_remote(5).png)