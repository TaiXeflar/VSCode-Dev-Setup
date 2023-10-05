# VSCode執行GMT工具列 
GMT為一款以繪製地圖的命令列工具，因其專案遵守GNU LGPL協議而為自由軟體供所有使用者開放。GMT團隊亦將其開源在[GitHub](https://github.com/GenericMappingTools/gmt)上。GMT的主流使用形式有[命令列形式的GMT工具](https://github.com/GenericMappingTools/gmt)以及適用於Python作為模組(module)的[PyGMT專案](https://github.com/GenericMappingTools/pygmt)。

## [GMT命令列工具安裝](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Let's%20Do%20Setup/vscode_Setup(5)_GMT.md)

## GMT命令列工具調用
GMT工具為命令列工具，因此需要CLI執行程式(即以終端機執行gmt命令)。

官方文件建議使用BASH([Cygwin](https://github.com/TaiXeflar/VSCode-Dev-Setup/blob/main/Let's%20Do%20Setup/vscode_Setup(4)_Cygwin.md)環境的BASH)來執行。但因為gmt的可執行程式在PATH環境變數內，所以任何殼層都能呼叫:
 - Shell
    ```
        gmt
    ```

若出現下列結果即代表有成功加入PATH:
 - Shell
    ```

            GMT - The Generic Mapping Tools, Version 6.4.0 [64-bit] [MP] [16 cores]
            (c) 1991-2022 The GMT Team (https://www.generic-mapping-tools.org/team.html).

            Supported in part by the US National Science Foundation (http://www.nsf.gov/)
            and volunteers from around the world.

            GMT is distributed under the GNU LGPL License (http://www.gnu.org/licenses/lgpl.html).
            Dependencies: netCDF, GDAL, PCRE, FFTW, LAPACK, ZLIB, Ghostscript, GraphicsMagick, FFmpeg.

    usage: gmt [options]
        gmt <module name> [<module-options>]

    options:
    --help              List descriptions of available GMT modules.
    --new-script[=L]    Write GMT modern mode script template to standard output.
                        Optionally specify bash|csh|batch [Default is current shell].
    --new-glue=name     Write C code for external supplements to glue them to GMT.
    --show-bindir       Show directory with GMT executables.
    --show-citation     Show the most recent citation for GMT.
    --show-classic      Show all classic module names.
    --show-classic-core Show all classic module names (core only).
    --show-cores        Show number of available cores.
    --show-datadir      Show directory/ies with user data.
    --show-dataserver   Show URL of the remote GMT data server.
    --show-dcw          Show the DCW data version used.
    --show-doi          Show the DOI for the current release.
    --show-gshhg        Show the GSHHG data version used.
    --show-library      Show path of the shared GMT library.
    --show-modules      Show all modern module names.
    --show-modules-core Show all modern module names (core only).
    --show-plugindir    Show directory for plug-ins.
    --show-sharedir     Show directory for shared GMT resources.
    --show-userdir      Show full path of user's ~/.gmt dir
    --version           Print GMT version number.

    if <module-options> is '=' we call exit (0) if module exist and non-zero otherwise.
    ```

## GMT命令列呼叫

GMT有兩種寫法:

 - 經典模式。以直接呼叫gmt工具執行GMT繪圖，例如:
     - Shell
        ```
        psxy 1a.txt -R0/12/0/8 -JM15c -Ba -BWSne -Sb24p -Gblue -W1 > set1.ps
        ```
    該命令列執行結束後會輸出PostScript檔案(\*.ps)，需要以GhostView開啟。

 - 現代模式。這種呼叫方式需要全部以`gmt`開頭呼叫gmt工具列，例如:
     - Shell
        ```
        gmt begin set1
        gmt psxy 1a.txt -R0/12/0/8 -JM15c -Ba -BWSne -Sb24p -Gblue -W1
        gmt end
        ```
        
    該命令列執行結束後會輸出可攜式文件檔案(\*.pdf)，需要以Adobe Acrobat開啟。

## 以VSCode建置GMT作業

我們將以GMT現代語法在VSCode中使用batch腳本執行GMT繪圖，並以PDF預覽繪圖成果。

首先，我們需要VSCode的兩個延伸模組(Extensions):
 - VSCode Extensions
     ```
     Batch Runner (Nils Soderman)
     PDF Preview (Analytic Signal Limited)
     ```

以VSCode開啟欲繪製GMT的資料夾:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_ex1.png)

接著新增一個Windows批次檔(Batch File `*.bat`)或一個PowerShell手稿(`*.ps1`)，在手稿中存入gmt指令(**請注意這裡使用的是gmt現代語法**)。本範例的程式碼如下:
 - Batch/PowerShell Script
     ```
     gmtset PS_CHAR_ENCODING         = Standard+

     gmt begin out1
     gmt coast  -R116/134/23/41 -JM6i -B -G#7dc500 -S#5199dd -W0.5p,black -N1	   
     gmt end 
     ```
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_ex2.png)


存檔後選擇右上角，選擇`Run Code`。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_ex3.png)

底下的輸出會列印程式執行結果。執行成功則會有PDF檔案出現。
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_ex4.png)

對檔案總管的pdf檔案雙擊，即會在工作區自動出現:
![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_ex5.png)