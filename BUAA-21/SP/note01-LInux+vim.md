# SP-01 Linux & vi

## 1. Linux Command

### 1.1 Path

Absolute path and Relative path.

`/home/huan/` is absolute path, while `./test/hello.c` = `test/hello.c` or `../user/test/hello.c` are relative path.

### 1.2 File Operator

#### Directory

| Command | Intro |
| - | - |
| `ls` | list the dir and file |
| `pwd` | check the present path |
| `mkdir` | make up a dir |
| `cd` | change dir |
| `rmdir` | remove a dir |

Extensions

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