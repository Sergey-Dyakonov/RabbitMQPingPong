# Rabbit MQ Ping Pong
**A program represents a classic multithreading task with sequential message exchanging between several thread aka _'Ping pong'_. _Rabbit MQ_ was used for message sending and receiving between several threads.**

###### Used tools:
- [Lombok](https://projectlombok.org/) - @Getter, @Setter and other useful annotations
- [Rabbit MQ](https://www.rabbitmq.com/) - Message queue
---

## How to install and run
#### Using Intellij IDEA
1. Download the project (you can do it in several ways, but I'd recommend to use `git copy`)
2. File -> Open -> pom.xml (choose pom.xml from downloaded project) -> Open as project
3. Choose **Main.java** in IDE
4. Run it using 'Run' button or pressing Shift+F10.

***Note:*** _don't forget to resolve required dependencies! (Open **pom.xml** in Intellij, press Ctrl + Shift + O)._
#### Using Maven (includes *.jar* building)
1. `mvn clean verify` (or press appropriate operations in IDE)
2. `java -jar target/ImageComparator-1.0-SNAPSHOT.jar`

## How to use
1. [Run](#how-to-install-and-run) the app.
2. Observe message exchanging between threads in console.

---
Please, contact me if you have any ideas or questions
Email: *sergeidyakonov222@gmail.com*