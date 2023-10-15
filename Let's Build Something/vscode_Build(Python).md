# 以VSCode執行Python偵錯

## 專案執行環境

我們建議在以下硬體配置中，執行基於Windows 10/11環境的Python專案:

  |  配置等級  |  CPU  |  GPU  |  RAM  |  SSD  |  OS  |
  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |  :----:  |
  |  基本配置  |  4C8T  |  iGPU  |  8GB  |  128GB  |  Windows 10/11  |
  |  建議配置  |  6C12T  |  dGPU, 2GB  |  16GB  |  256GB  |  Windows 10/11  |
  |  高階配置  |  6C12T  |  dGPU, 6GB  |  32GB  |  512GB  |  Windows 10/11  |

  - CPU配置建議應支援超執行緒(Hyper-Threading)。
  - 請注意，Intel第12代處理器(Intel Core 12th Gen)後採用大小核設計，其中效能核心(P-Core)支援超執行緒，效率核心(E-Core)則不支援。因此可能出現執行緒數量不等於原雙倍核心數量的結果。
  - 例如在 Intel Core i7-12700H中，核心分配為 6P8E， 執行緒最大數量 = 6x2 + 8x1 = 12+8 = 20。
  - 請注意，在Windows上支援GPU運算的套件僅限適用於CUDA架構。因此，dGPU建議配置為支援CUDA的NVIDIA GPU。在消費級平台上所支援的CUDA GPU包含NVIDIA GeForce MX, GTX, RTX顯示卡。
  - 請注意，適用於Windows的AMD Radeon顯示卡(包含iGPU及dGPU)不支援CUDA GPU。

## .vscode資料夾設定

以下定義一個專案位置(資料夾)`pytest`，並有以下內容:
 - Folder
 ```
  |
  ├─> test.py(Python語言來源)
  |
  └─> .vscode(資料夾)
         |
         └─> launch.json
 ```
## VSCode執行Python偵錯 - launch.json
執行程式的偵錯由`launch.json`內的訊息配置完成自定義的偵錯測試。執行程式即為對程式執行偵錯。Python的直譯式特性會則直接執行。以下是建立一個Python底稿的執行偵錯設定範例:
 - JSON
    ```
      {
        "version": "0.2.0",
        "configurations": [
            {
                "name": "Python: Current File",
                "type": "python",
                "request": "launch",
                "program": "${file}",
                "console": "integratedTerminal",
                "justMyCode": true
            }
        ]
      }
    ```
    當中:

    - `version`: 值預設是`0.2.0`.
    - `configurations`: JSON清單物件，且包含一個或多個JSON物件。內部的鍵值為:
      - `"name"`: `"Python: Current"`。
      - `"type"`: `"python"`.
      - `"request"`: `"launch"`.
      - `"program"`: `"${file}"`. 該鍵值`"${file}"`對應至欲偵錯的Python底稿(對應至本存放庫即為 **test.py** )。
      - ` "console"`: `"integratedTerminal"`或`externalTerminal`。取決於你要用VSCode內鍵終端機或是跳出一個主控台視窗。
      - `"justMyCode"`: `true`

該Python偵錯的殼層傳遞形式是:
 - Shell
    ```
     python.exe test.py
    ```

## VSCode執行Jupyter筆記本偵錯
參閱[vscode_Play(NB).md](vscode_Play(NB).md)的VSCode Framework形式Jupyter筆記本建立及偵錯方式。