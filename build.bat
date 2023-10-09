@echo off

set PROJECT_1=SpringSessionApp1
set PROJECT_2=SpringSessionApp2
set PROJECT_3=SpringSessionApp3_SpringMVC
set PROJECT_4=SpringSessionApp4_Servlet

set MAVEN_HOME=C:\Software\apache-maven-3.8.3
set TOMCAT_HOME=C:\Software\apache-tomcat-9.0.59
set PROJECT_DIR=C:\Projects\SpringSessionDemo
set PROJECT_1_DIR=%PROJECT_DIR%\%PROJECT_1%
set PROJECT_2_DIR=%PROJECT_DIR%\%PROJECT_2%
set PROJECT_3_DIR=%PROJECT_DIR%\%PROJECT_3%
set PROJECT_4_DIR=%PROJECT_DIR%\%PROJECT_4%

set PATH=%MAVEN_HOME%\bin;%PATH%

cd %PROJECT_1_DIR%
call mvn clean package -DskipTests

cd %PROJECT_2_DIR%
call mvn clean package -DskipTests

cd %PROJECT_3_DIR%
call mvn clean package -DskipTests

cd %PROJECT_4_DIR%
call mvn clean package -DskipTests

rem Stop Tomcat if it's running
rem cd %TOMCAT_HOME%\bin
rem call shutdown.bat

rmdir /s /q %TOMCAT_HOME%\webapps\%PROJECT_1%
rmdir /s /q %TOMCAT_HOME%\webapps\%PROJECT_2%
rmdir /s /q %TOMCAT_HOME%\webapps\%PROJECT_3%
rmdir /s /q %TOMCAT_HOME%\webapps\%PROJECT_4%


copy /Y %PROJECT_1_DIR%\target\%PROJECT_1%.war %TOMCAT_HOME%\webapps\
copy /Y %PROJECT_2_DIR%\target\%PROJECT_2%.war %TOMCAT_HOME%\webapps\
copy /Y %PROJECT_3_DIR%\target\%PROJECT_3%.war %TOMCAT_HOME%\webapps\
copy /Y %PROJECT_4_DIR%\target\%PROJECT_4%.war %TOMCAT_HOME%\webapps\

rem cd %TOMCAT_HOME%\bin
rem call startup.bat

echo Deployment to Tomcat completed.
cd %PROJECT_DIR%
