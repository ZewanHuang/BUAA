# Lab01 Assignment

> 班级：192115
> 学号：19373257
> 姓名：黄泽桓

## 实验准备

- 请安装一个合适的 Linux 系统，你安装的 Linux 发行版及版本号是什么？内核版本号是什么？

  截图：
  ![20210305233720](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210305233720.png)

  答案：我安装的 Linux 发行版为 Ubuntu，版本号为 20.04，内核版本号为 Linux 5.8.0.

- 查看你的根目录下有哪几个子目录，每个子目录主要用来做什么用的？

  截图：
  ![20210305234209](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210305234209.png)

  答案：我的根目录下有 23 个子目录，下面列出主要架构的作用

  | 子目录 | 作用 |
  | :-: | - |
  | /bin | 二进制可执行命令，多是重要系统文件 |
  | /dev | 存放设备文件 |
  | /root | 超级用户的主目录 |
  | /home | 普通用户主目录的基点，比如 /home/user |
  | /usr | 存放软件 |
  | /opt | 存放可选的安装的软件 |
  | /tmp | 存储临时文件 |
  | /var | 存放比如各种服务的日志文件 |
  | /sbin | 存放标准系统管理程序 |
  | /lib | 标准程序设计库，类似 windows 的 .dll 文件 |

- 查看自己的 ip 地址，并 ping 一下 baidu.com 看网络是否连通？

  命令：`ip addr` and `ping baidu.com`

  截图：
  ip address: 10.136.78.14
  ![20210305235955](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210305235955.png)
  ping baidu.com:
  ![20210306000049](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306000049.png)

- 用软件安装命令下载 build-essential。

  命令：`sudo apt install build-essential`

  截图：
  ![20210306000247](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306000247.png)

## 1. Linux 命令操作

- Linux 命令行操作，请用你学到的 Linux 命令，实现以下操作，给出每一步你的命令行截图。
  - 用 wget 从`https://github.com/BUAA-SE-2021/patpat/releases/download/v0.1.3/patpat-linux-amd64`下载你们的 Linux 版 OOP 课 Java 自助评测机 patpat
  - `https://github.com/BUAA-SE-2021/sp-labs/lab01/lab01.zip`处下载实验压缩包
  - 解压`lab01.zip`。
  - 进入`lab01`目录,进入子目录`etc`，打印当前路径并在当前路径下创建名为`a1`的目录，并在`a1`目录中创建名为`b1`的目录。
  - 进入`b1`目录中，创建两个文件`a.txt`，`b.txt`。
  - 退回子目录`etc`，删除目录`a1`。
  - 将`etc`目录下所有以`tmp`开头的文件移动到`lab01`目录下的`Download`目录下的`tmp`目录中。
  - 查看`tmp`目录下`a1005.cpp`的内容。
  - 查看`tmp`目录下`a1009.cpp`的前十行和后十行。
  - 将`tmp`目录下的所有文件打成一个`tar`包，并命名为并命名为`tmp.tar.gz`。
  - 返回`lab01`目录，列出当前目录下的文件大小。
  - 用命令找出空目录并将空目录删除。

命令：

```shell
# 不完整的部分自行补充，填写必要注释
wget -O patpat https://github.com/BUAA-SE-2021/patpat/releases/download/v0.1.3/patpat-linux-amd64 # 下载
wget -O lab01.zip https://github.com/BUAA-SE-2021/sp-labs/lab01/lab01.zip # 下载实验资料
unzip -n lab01.zip # 解压
cd lab01/etc # 进入目录
pwd # 打印当前路径
mkdir a1 # 创建目录`a1`
mkdir a1/b1 # 创建子目录`b1`
cd a1/b1 # 进入`b1`目录中
touch a.txt # 创建文件`a.txt`
touch b.txt # 创建文件`b.txt`
cd ../../ # 返回子目录`etc`
rm -rf a1 # 删除`a1`
cd c1
mv tmp* ../../Download/tmp # 移动
cd ../../Download/tmp
cat a1005.cpp # 查看
head -n 10 a1009.cpp # 查看前十行
tail -n 10 a1009.cpp # 后十行
tar cvf tmp.tar.gz * # 打包
cd ../../ # 返回`lab01`目录
du -sh # 列出当前目录下的文件大小
find -type d -empty # 用命令找出空目录
rmdir ./upload # 删除空目录
```

必要的实验截图(如查看前十行、查看文件大小的展示效果)

![20210306001448](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306001448.png)
![20210306001844](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306001844.png)
![20210306002256](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306002256.png)
![20210306002753](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306002753.png)
![20210306003453](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306003453.png)
![20210306003625](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306003625.png)
![20210306003851](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306003851.png)
![20210306004110](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306004110.png)
![20210306004355](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306004355.png)
![20210306004556](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306004556.png)
![20210306004752](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306004752.png)

## 2. vi 模式

- vi 编辑器有哪几种模式？简述这几种模式间如何互相切换？

模式：

- 1 命令模式
- 2 插入模式
- 3 末行模式

如何切换：`vi <fileName>` 后进入命令模式，`:` 进入末行模式，输入 `i` 进入插入模式，插入模式 `ESC` 进入命令模式，末行模式回车进入命令模式，命令模式 `:wq` 保存并退出

## 3. vi 命令

> 写出以下⼀系列操作使⽤的**命令**（底⾏模式的命令加上 : 或 / ）：

### 3.1. ⽤ `vi` 在当前⽤户家⽬录下新建⽂件 `testfile` 并打开

```shell
vi ~/testfile
```

### 3.2. 设置显示⾏号

```shell
:set number
```

### 3.3. 进⼊ `insert mode` ，输⼊ `3` ⾏⽂本

```plain
This is the first line.
This is the second line.
This is the third line.
```

![20210306005920](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306005920.png)

### 3.4. 返回到 `command mode` ，将光标移动到第 `2` ⾏，复制这⼀⾏

```shell
yy
```

### 3.5. 移动光标到⽂档最后⼀⾏，将复制内容粘贴到这⼀⾏后⾯

```shell
p
```

![20210306010251](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306010251.png)

### 3.6. 移动光标到第⼀⾏，删除第⼀⾏

```shell
dd
```

![20210306010317](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306010317.png)

### 3.7. 从⽂档开头开始查找 `second` ，然后查找下⼀个

```shell
/second
n
```

### 3.8. 将全部 `second` 替换为 `fourth` ，替换过程不需要询问

```shell
:1,$s/second/fourth/g
```

![20210306010910](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306010910.png)

### 3.9. 取消显示⾏号

```shell
set nonumber
```

![20210306011025](https://cdn.jsdelivr.net/gh/ZewanHuang/Img@master/Images/20210306011025.png)

### 3.10. 保存修改并退出 `vi`

```shell
:wq
```

### 3.11. 再次⽤ `vi` 打开 `testfile` ，另存为 `testfile2`

```shell
:w testfile2
```

## 4. POSIX

- 什么是 POSIX 标准？哪些操作系统支持 POSIX 标准？
  
  可移植操作系统接口，包括了系统调用接口(API)，和实时扩展[C语言]。支持 POSIX 的系统有 Linux,Solaris,Windows 等等。

## 5. LSB

- 什么是 LSB 标准？分析它和 POSIX 标准的异同。
  
  LSB 是保证了操作系统同应用程序之间的良好结合，保证**应用程序在系统间迁移时不用重新编译**，且保持稳定；而 POSIX 规定了系统调用接口，为的是一个系统编写的程序，能够在**其他支持 POSIX 的系统上编译执行**。

## 6. 实验感想

以前我所掌握的 Linux 使用技巧较为零碎，通过本次课程、实验和自我整理总结，我对 Linux 的使用 (包括 vim) 掌握得更加系统、熟练。

> 截图是真的累