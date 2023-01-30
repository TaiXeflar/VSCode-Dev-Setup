# VSCode的GMT命令列工具部署

## GMT離線安裝
本章節將敘述如何安裝GMT(Generic Mapping Tools)。

GMT安裝檔為自解壓縮的安裝程式，因此點擊即可執行:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_inst1.png)

接著是將GMT命令列工具加入PATH變數的選項:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_inst2.png)

接著是指定安裝位置，預設在`C:\programs\gmt6`下。這裡指定安裝在`C:\Program Files\GMT64\`下:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_inst3.png)

再來是指定GMT命令列工具的開始選單設定。

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_inst4.png)

最後，是附加元件項的安裝選擇:

![image](https://github.com/TaiXeflar/vscode_build_sample_repos/blob/main/Markdown%20Image/vscode_gmt_inst5.png)

安裝完成後即可關閉安裝程式。

## GMT命令列調用
GMT工具為命令列工具，因此需要CLI執行程式(即以終端機執行gmt命令)。

官方文件建議使用BASH(Cygwin環境的BASH)來執行。但因為gmt的可執行程式在PATH環境變數內，所以任何殼層都能呼叫:
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
    該命令列執行結束後會輸出postscript檔案(.ps)，需要以GhostView開啟。

 - 現代模式。這種呼叫方式需要全部以`gmt`開頭呼叫gmt工具列，例如:
     - Shell
        ```
        gmt begin set1
        gmt psxy 1a.txt -R0/12/0/8 -JM15c -Ba -BWSne -Sb24p -Gblue -W1
        gmt end
        ```
        
    該命令列執行結束後會輸出可攜式文件檔案(.pdf)，需要以Adobe Acrobat開啟。
