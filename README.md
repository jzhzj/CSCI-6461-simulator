# Welcome to CS_6461 Team Project (Spring 2018)
This project is to build a Java simulator of the von Neumann Architecture.

Please kindly be reminded to follow [GW Academic Integrity Code](https://studentconduct.gwu.edu/code-academic-integrity).

## Team Attitude
<p align="center">
  <img src="https://media.giphy.com/media/DeOa0SqsDH5sc/giphy.gif">
</p>


## Table of Contents

- Deliverable
  * [Releases (jar and source code zip)](https://github.com/1988warren/csa_simulator/releases)
  * [User Guide](https://github.com/1988warren/csa_simulator/wiki/User-Guide)
  * [Design Notes](https://github.com/1988warren/csa_simulator/wiki/Design-Notes)
- For developers
  * [Notes](#notes)
  * [Contributing](#contributing)
  * [Usage](#usage)
  * [About Maven](#about-maven)
- [Contacts](#contacts)

## Notes

1. The project is managed by [Apache Maven](https://maven.apache.org/), 
it is highly recommend to use [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/download/) (with built-in Maven v2 & v3 plugin, zero configuration).

2. As requested in [official course guide](http://www.mslcourses.com/CSCI6461Section11Spring2018/),
JDK 8+ should be used. The default compiler level has been set to 9 (JDK 1.9), please revise pom.xml
accordingly if you are using JDK 1.8.

3. The implementation of UI is powered by JavaFX, Idea has included a WYSIWYG layout editor in case you need one.

## Contributing
1. __Please do not commit anything but source code and resource files to this repository, also please make modifications based on the
latest version of code to avoid conflict.__
2. __Please do include a message for every commit.__
3. __Please inform all team members before commit any change regarding to pom.xml, .gitignore and simulator.iml.__ 

## Usage
Revise pom.xml if you are using JDK 1.8
```xml
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```
Delete target folder
```sh
$ mvn clean
```
Build artifact
```sh
$ mvn install
```
Run / Debug
```sh
$ mvn verify
```
Run Unit Test
```sh
$ mvn test
```
## About Maven
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/300046/16313672/881e4a8e-3937-11e6-8af5-1c3b93b9caef.jpg">
</p>

## Contacts
- [Cao Wuchen](mailto:caowuchen@gwu.edu) (a.k.a. Warren)
- [Yang Tong](mailto:yangtong@gwu.edu)
- [Hou Yanbing](mailto:hou_yanbing@gwu.edu)
- [Qi Jiuzhi](mailto:qijiuzhi@gwu.edu)