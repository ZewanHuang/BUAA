# SP-01 Linux & vi

<!-- TOC -->

- [SP-01 Linux & vi](#sp-01-linux--vi)
  - [1. Linux 命令](#1-linux-命令)
    - [1.1 路径](#11-路径)
    - [1.2 目录操作](#12-目录操作)
    - [1.3 文件操作](#13-文件操作)
    - [1.4 文件打包和压缩](#14-文件打包和压缩)
    - [1.5 关机和系统管理命令](#15-关机和系统管理命令)
    - [1.6 用户管理](#16-用户管理)
    - [1.7 文件阅读命令](#17-文件阅读命令)
    - [1.8 磁盘管理命令](#18-磁盘管理命令)
    - [1.9 进程管理命令](#19-进程管理命令)
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

**1. shutdown**

功能：关闭或重启Linux系统

语法：shutdown [option] [time]

正确的关机流程：sync > shutdown > reboot > halt

```shell
shutdown -h now         # 立马关机
shutdown -h 20:25       # 在今天20:25关机
shutdown -h +10         # 10分钟后关机
shutdown -r now         # 立马重启
reboot                  # 立马重启
halt                    # = shutdown -h now = poweroff
```

**2. date**

显示和设置系统的日期和时间

**3. who**

查看当前在线的用户情况

### 1.6 用户管理

**1. 增加用户**

| 命令 | 功能 |
| :-: | - |
| passwd | 修改密码 |
| useradd | 建立用户账号和创建用户的起始目录 |
| groupadd | 创建用户组 |

```shell
useradd [-d home_dir] 
groupadd student            # 创建student用户组
useradd tom -g student      # 添加tom用户
passwd tom                  # 设置密码
```

**2. chmod**

修改文件的权限

chmod <权限参数> <文件或目录名称> 例如 `$chmod a+r file.txt` 将 file.txt 设置为全部人可读

* u 表示文件的拥有者，g 表示拥有者同一组的其它用户，o 表示其他人；
* +, - 表示加减权限
* 主要权限有，r(ead)、w(rite)、(e)x(ecutive)

> 关于用户权限，各类用户对应的每一位，1表示有该权限，0表示无。可转换为八进制表示

![20210311143335](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210311143335.png)

假定 demo.c 最初权限为 rwxrwxrwx，连续操作如下

| 命令 | 结果 | 含义 |
| - | - | - |
| chmod a-x demo.c | rw-rw-rw | 收回所有用户执行权限 |
| chmod go-w demo.c | rw-r-r- | 收回组用户和其他用户的写权限 |
| chmod g+w demo.c | rw-rw-r- | 赋予组用户写的权限
| chmod a= demo.c | ------ | 清除所有权限 |
| chmod 666 demo.c | rw-rw-rw- | 赋予所有用户读和写的权限|
| chmod 644 demo.c | rw-r--r-- | 赋予属主读、写权限，其他用户读
权限 |
| chmod 700 demo.c | rwx----- | 赋予属主读、写和执行权限 |
| chmod 660 demo.c | rw-rw---- | 赋予属主、属组读和写的权限 |

**3. chown**

改变文件拥有者，语法：chown <用户账号> <文件或目录名称>

将拥有权赋予新用户之后，原用户就是无权修改或删除该文件了。

### 1.7 文件阅读命令

**1. more**

一次以一个page显示，语法：more <文件名称>

当使用more时，可看到屏幕左下方有一个“--more--”的信息，此时按下回车可显示下一行，按下空格可显示下一页。

**2. less**

与more基本一致，按下b键往上翻一页。

**3. cat**

### 1.8 磁盘管理命令

**1. df**

显示磁盘的使用

```shell
df -h                   # 易读方式，MB为单位
df -k                   # kB为单位
df -l                   # 本地
df -T                   # 显示文件系统类型
```

**2. du**

显示目录的使用情况

* -a：显示全部目录和其次目录下的每个文件所占的磁盘空间
* -b：大小用bytes来表示 (默认值为k bytes)
* -c：最后再加上总计 (默认值)
* -s：只显示各文件大小的总和

### 1.9 进程管理命令

进程管理命令：ps kill pstree at bg fg

**1. ps**

查询正在执行的进程。提供Linux系统中正在发生的事情的一个快照，能显示正在执行进程的进程号、发出该命令的终端、所使用的CPU时间以及正在执行的命令。

例如：`$ps aux` 显示所有包含其他使用者的进程

**2. kill**



**3. pstree**



**4. at**



**5. bg**



**6. fg**

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
| **/查找内容** | 查找指定内容，n 下一个，N 上一个 |
| **:1,$s/word1/word2/g** | 全程将word1替换为word2 |