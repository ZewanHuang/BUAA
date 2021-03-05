## 第一周

> 个人答案，不一定十分准确

1. 开发Java应用程序需要经过哪些主要步骤？
   
   答案：抽象，建类，测试

2. Java源文件是由什么组成的？一个源文件中必须要有public类吗？
   
   答案：包声明、库引用、类定义；对

3. 如果JDK的安装目录为 D:\jdk，怎样设置path和classpath的值？
   
   答案：用户设置 `JAVA_HOME: D:\jdk`
   环境变量 `%JAVA_HOME%\bin`, `%JAVA_HOME%\jre\bin`

4. Java源文件的扩展名是什么？Java字节码的扩展名是什么？
   
   答案：.java; .class

5. 如果Java应用程序主类的名字是Bird，编译之后应当怎样运行该程序？
   
   答案：
   ```shell
   $ javac Bird.java
   $ java Bird
   ```

6. JDK和JRE有什么区别？
   
   答案：
   * JDK(Java Development Kit)，Java的开发工具包，面向开发成员，主要包含各类库和工具，当然也包含了另一个JRE；
   * JRE(Java Runtime Environment)，Java的运行环境，包含JVM，也就是Java虚拟机。
  
7. float 和 double 在表示上有什么区别？
   
   答案：Java默认浮点数为double类型，float类型需在后面加f，例如 `1.0f`

8. 怎么样获取一维数组的长度？
   
   答案：array.length

9.  if 语句中的条件表达式的值是否可以是 int 型？
    
    答案：不能

10. 如何跳出多重循环？
    
    答案：三种方法

    ```java
    // 01
    here:
    while(true) {
        while(true) {
            break here;
        }
    }
    // 02
    Boolean flag = true;
    for(int i = 1; i <= 4 && flag; i++) {
        for(int j = 1; j <= 4 && flag; j++) {
            if(i == 2 && j == 2)
                flag = false;
        }
    }
    // 03
    try {
        while(true) {
            while(true) {
                throw new Exception();
            }
        }
    } catch (Exception e) {
        System.out.println("here you will break");
    }
    ```