# SpringSessionDemo

Demonstrate 4 applications share sesssion by using Spring Session

1. Run H2 DB in server mode (Other applications can share the same H2 DB):
java -jar h2-1.4.200.jar -webAllowOthers -tcpAllowOthers

2. build.bat

3. Start Tomcat

4. Access applications in Tomcat:

http://localhost:8080/SpringSessionApp1/

http://localhost:8080/SpringSessionApp2/

http://localhost:8080/SpringSessionApp3_SpringMVC/

http://localhost:8080/SpringSessionApp4_Servlet/

5. Use http://localhost:8082 to access H2 console in browser when H2 DB is running in server mode:
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:~/data/SpringSessionDB
User Name: sa
Password: sa
 
