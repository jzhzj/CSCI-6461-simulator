# Welcome to GWU CS_6461 Computer Systems Architecture Class Project (Spring 2018)
This project is to build a Java simulator of a small processor with performance improvements.

Please kindly be reminded to follow [GW Academic Integrity Code](https://studentconduct.gwu.edu/code-academic-integrity).

## Team member contact info
- [Cao Wuchen](mailto:caowuchen@gwu.edu) (a.k.a. Warren)
- [Yang Tong](mailto:)
- [Hou YanBing](mailto:)

## A few notes for developers

1. The project is managed by [Apache Maven](https://maven.apache.org/), 
it is highly recommend to use [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/download/) (with built-in Maven v2 & v3 and plugin, zero configuration).

2. As requested in [syllabus](http://www.mslcourses.com/CSCI6461Section11Spring2018/),
JDK 8+ should be used. The default compiler level has been set to 9 (JDK 1.9), please revise pom.xml
accordingly if you are using JDK 1.8.

3. The implementation of UI is powered by [JavaFX](http://www.oracle.com/technetwork/java/javase/overview/javafx-overview-2158620.html), which supports MVC.
4. __Please do not commit anything but source code and resource files to this repository, also please make modifications based on the
latest version of code to avoid conflict.__
5. __Please do include a message for every commit.__
6. __Please inform all team members before commit any change regarding to pom.xml, .gitignore and simulator.iml.__ 

## Usage
Revise pom.xml if you are using JDK 1.8
```
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```
Delete target folder
```
mvn clean
```
Build artifact
```
mvn install
```
Find simulator-1.0-SNAPSHOT.jar in target folder after install success.