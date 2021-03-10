# SP-01 Linux & vi

<!-- TOC -->

- [SP-01 Linux & vi](#sp-01-linux--vi)
  - [1. Linux 命令](#1-linux-命令)
    - [1.1 路径](#11-路径)
    - [1.2 目录操作](#12-目录操作)
    - [1.3 文件操作](#13-文件操作)
    - [1.4 文件打包和压缩](#14-文件打包和压缩)
    - [1.5 关机和系统管理命令](#15-关机和系统管理命令)
  - [2. VI编辑器](#2-vi编辑器)
    - [2.1 命令模式 (command mode)](#21-命令模式-command-mode)
    - [2.2 插入模式 (insert mode)](#22-插入模式-insert-mode)
    - [2.3 底行模式 (last line mode)](#23-底行模式-last-line-mode)

<!-- /TOC -->

## 1. Linux 命令

### 1.1 路径

- `/home/huan/` = `~/`
- `./test/hello.c` = `test/hello.c` = `../user/test/hello.c`

### 1.2 目录操作

| 命令 | 说明 |
| - | - |
| `ls` | 列出文件夹和文件信息 |
| `pwd` | 列出当前目录路径 |
| `mkdir` | 新建一个空文件夹 |
| `cd` | 切换路径 |
| `rmdir` | 删除一个空文件夹 |

```shell
ls -a               # list all
ls -d               # list dir
ls -l               # list details
```
```shell
cd /usr/bin         # into /usr/bin
cd ~/               # into home dir of user
cd -                # into the last dir
```
```shell
rmdir               # can only remove empty dir
rmdir -p a/b        # remove a if a is empty after b has been removed
```

### 1.3 文件操作

| 命令 | 说明 |
| - | - |
| `cat` | 显示文本文件内容 |
| `cp` | 拷贝文件，cp <文件> <目的地> |
| `mv` | 文件更名或移动，mv <文件名称> <目的地或新名> |
| `rm` | 删除文件 |
| `find` | 搜寻符合条件的文件，find <目录名> <选项> |
| `grep` | 在文件中查找字符串，grep <字符串> <文件名> |

```shell
cat file1 file2>file3               # 把 file1 和 file2 的内容输入到 file3 中
```
```shell
cp /root/* /temp                    # 拷贝不包含隐藏文件的所有文件
```
```shell
find -name "*.c"                    # 列举当前目录及其子目录下所有扩展名是c的文件
find -name "*.xml" -print           # 将匹配文件输出到标准输出
find -name "*.c" -exec ls -l {} \;  # 搜索符合的文件并执行命令，注意空格和分号
```
```shell
grep "big pig" file1                # 在file1中查找"big pig"
grep -v -n printf 2.6.c             # -v表示从文件中查找不包含printf的行，-n将该行的序号显示出来
```

关于 `cp` `mv` `rm` 的 options：
- -f 强制执行，如果目标文件存在则进行覆盖或不提示进行删除
- -i 交互式执行命令，上述情况提示用户
- -r 递归删除、拷贝，mv 没有该选项

> f: force; i: interactive; r: recursion

关于查看文件内容，补充 `head` 和 `tail`，`head -n 10 readme.txt` 为查看前十行，`tail -n 10 readme.txt` 为查看末十行。

### 1.4 文件打包和压缩

**1. tar**

对文件目录进行**打包备份**

```shell
tar [cvf] [打包的文件名] [被打包的文件名]
tar cvf text.tar *.txt              # 将当前目录下所有.txt文件保存到文件包text.tar中
tar xvf FileName.tar                # 解包
```

- -c：create，建立新的 tar 文件
- -r：向已有的tar文件追加文件
- -x：释放tar中文件
- -v：verbose
- -f：普通文件操作

**2. gzip**

压缩文件

```shell
gzip -v /mnt/lgx/a1.doc             # 压缩文件
gzip -d FileName.gz                 # 解压文件
```

**3. tar.gz**

```shell
tar zxvf FileName.tar.gz            # 解压
tar zcvf FileName.tar.gz DirName    # 压缩
```

**4. zip&rar**

```shell
unzip FileName.zip                  # 解压zip
zip FileName.zip DirName            # 压缩zip
rar x FileName.rar                  # 解压rar
rar a FileName.rar DirName          # 压缩rar
```

### 1.5 关机和系统管理命令



## 2. VI编辑器

三种模式：命令模式，插入模式，底行模式

![20210310123244](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210310123244.png)

### 2.1 命令模式 (command mode)

**1. 移动光标**

|  级别  | 操作符 |             说明             |
| :----: | :----: | -------------------------- |
| 字符级 | **← 或 h** |     光标向左移动一个字符     |
| 字符级 | **→ 或 l** |     光标向右移动一个字符     |
|  行级  | **↑ 或 k** | 光标移动到上一行相同位置字符 |
|  行级  | **↓ 或 j** | 光标移动到下一行相同位置字符 |
| 单词级 |   b    |   光标移动到本单词的首字符   |
| 单词级 |   e    |   光标移动到本单词的尾字符   |
| 单词级 |   w    | 光标移动到下一个单词的首字符 |
|  行级  |   0    |    光标移动到当前行首字符    |
|  行级  |   $    |    光标移动到当前行尾字符    |
| 段落级 |   {    |     光标移动到段落首字符     |
| 段落级 |   }    |     光标移动到段落尾字符     |
| 屏幕级 |   H    |   光标移动到屏幕首行首字符   |
| 屏幕级 |   L    |   光标移动到屏幕尾行首字符   |
| 屏幕级 |  **Ctrl+b** | 上滚一屏 |
| 屏幕级 | **Ctrl+f** | 下滚一屏 |
| 屏幕级 | Ctrl+d | 下滚半屏 |
| 屏幕级 | Ctrl+u | 上滚半屏 |
| 文档级 | **n**G | 光标移动到文档第 n 行首字符  |
| 文档级 |   G    |   光标移动到文档尾行首字符   |

**2. 复制**

|  级别  |  操作符  |                   说明                   |
| :----: | :------: | -------------------------------------- |
| 字符级 | y← 或 yh |              复制前一个字符              |
| 字符级 | **y→ 或 yl** |               复制当前字符               |
| 单词级 |    yb    | 从单词首字符开始复制直到当前字符(不包括) |
| 单词级 | ye 或 yw |  从当前字符开始复制直到单词尾字符(包括)  |
|  行级  |    y0    |  从行首字符开始复制直到当前字符(不包括)  |
|  行级  |    y$    |   从当前字符开始复制直到行尾字符(包括)   |
|  行级  |    **yy**    |                复制当前行                |
|  行级  | y↑ 或 yk |            复制上一行和当前行            |
|  行级  | y↓ 或 yj |            复制当前行和下一行            |
|  行级  | **n**yy  |      复制包括当前行在内的后面 n 行       |
| 段落级 |    y{    | 从段落首字符开始复制直到当前字符(不包括) |
| 段落级 |    y}    |  从当前字符开始复制直到段落尾字符(包括)  |
| 屏幕级 |    yH    |    从屏幕首行开始复制直到当前行(包括)    |
| 屏幕级 |    yL    |    从当前行开始复制直到屏幕尾行(包括)    |
| 文档级 |    yG    |    从当前行开始复制直到文档尾行(包括)    |
| 文档级 | y**n**G  |    从第 n 行开始复制直到当前行(包括)     |

**3. 粘贴**

p: 将复制的内容粘贴到当前字符的下一个位置

**4. 删除**

| 操作符  |             说明              |
| :-----: | :---------------------------: |
|    **x**    |         删除当前字符          |
|   **dd**    |          删除当前行           |
| **n**dd | 删除包括当前行在内的后面 n 行 |

**5. 撤销**

u: 撤销命令

### 2.2 插入模式 (insert mode)

重要的记住，`a` 光标后移一位进入编辑模式，`i` 光标移动到当前行行首进入编辑模式，`esc` 从编辑模式返回命令模式。

### 2.3 底行模式 (last line mode)

**1. 编辑器设置**

|      设置       |      说明       |
| :-------------: | :-------------: |
|   set number    |    设置行号     |
|   set nonumber  |    取消设置行号  |
| set autoindent  |    自动对齐     |
| set smartindent |    智能对齐     |
|   set cindent   | C 语言格式对齐  |
|  set showmatch  |    括号匹配     |
|  set tabstop=4  | Tab 为 4 个空格 |
|   set mouse=a   |    鼠标支持     |

底行模式下对 vi 编辑器的设置只对本次操作有效，vi 编辑器的用户配置信息放在 `~/.vimrc` 文件中，可以通过修改该文件进行长久有效的配置。

```shell
$ vi ~/.vimrc
```

**2. 保存与退出**

|    操作符     |       说明       |
| :-----: | :---------------------: |
|  :w [文件名]  |           保存文件        |
|      :q       |           退出编辑器         |
| :wq [文件名]  |      保存文件并退出编辑器          |
| :w! [文件名]  | 对于没有修改权限的用户强行保存对文件的修改，<br>修改后的所有者和所属组发生变化 |
|      :q!      |     强行退出编辑器，不保存修改       |
| :wq! [文件名] |         强行保存修改并退出编辑器      |


**3. 文件操作**

|  操作符   |               说明               |
| :-------: | --------- |
|  :**n**   |        光标移动到第 n 行         |
| /查找内容 | 查找指定内容，n 下一个，N 上一个 |