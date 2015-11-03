@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\springframework\spring-core\4.1.5.RELEASE\spring-core-4.1.5.RELEASE.jar;"%REPO%"\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;"%REPO%"\org\springframework\spring-web\4.1.5.RELEASE\spring-web-4.1.5.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\4.1.5.RELEASE\spring-aop-4.1.5.RELEASE.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\org\springframework\spring-beans\4.1.5.RELEASE\spring-beans-4.1.5.RELEASE.jar;"%REPO%"\org\springframework\spring-webmvc\4.1.5.RELEASE\spring-webmvc-4.1.5.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\4.1.5.RELEASE\spring-expression-4.1.5.RELEASE.jar;"%REPO%"\org\springframework\spring-context\4.1.5.RELEASE\spring-context-4.1.5.RELEASE.jar;"%REPO%"\org\springframework\data\spring-data-jpa\1.8.2.RELEASE\spring-data-jpa-1.8.2.RELEASE.jar;"%REPO%"\org\springframework\data\spring-data-commons\1.10.2.RELEASE\spring-data-commons-1.10.2.RELEASE.jar;"%REPO%"\org\springframework\spring-orm\4.0.9.RELEASE\spring-orm-4.0.9.RELEASE.jar;"%REPO%"\org\springframework\spring-tx\4.0.9.RELEASE\spring-tx-4.0.9.RELEASE.jar;"%REPO%"\org\aspectj\aspectjrt\1.8.6\aspectjrt-1.8.6.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.12\slf4j-api-1.7.12.jar;"%REPO%"\org\slf4j\jcl-over-slf4j\1.7.12\jcl-over-slf4j-1.7.12.jar;"%REPO%"\javax\servlet\jsp\jsp-api\2.2\jsp-api-2.2.jar;"%REPO%"\taglibs\standard\1.1.2\standard-1.1.2.jar;"%REPO%"\javax\servlet\jstl\1.2\jstl-1.2.jar;"%REPO%"\javax\servlet\javax.servlet-api\3.1.0\javax.servlet-api-3.1.0.jar;"%REPO%"\javax\javaee-api\7.0\javaee-api-7.0.jar;"%REPO%"\com\sun\mail\javax.mail\1.5.0\javax.mail-1.5.0.jar;"%REPO%"\postgresql\postgresql\9.1-901-1.jdbc4\postgresql-9.1-901-1.jdbc4.jar;"%REPO%"\javax\persistence\persistence-api\1.0\persistence-api-1.0.jar;"%REPO%"\org\hibernate\hibernate-entitymanager\4.1.4.Final\hibernate-entitymanager-4.1.4.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.1.0.GA\jboss-logging-3.1.0.GA.jar;"%REPO%"\org\jboss\spec\javax\transaction\jboss-transaction-api_1.1_spec\1.0.0.Final\jboss-transaction-api_1.1_spec-1.0.0.Final.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\org\javassist\javassist\3.15.0-GA\javassist-3.15.0-GA.jar;"%REPO%"\org\hibernate\common\hibernate-commons-annotations\4.0.1.Final\hibernate-commons-annotations-4.0.1.Final.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.0-api\1.0.1.Final\hibernate-jpa-2.0-api-1.0.1.Final.jar;"%REPO%"\org\hibernate\hibernate-core\4.1.4.Final\hibernate-core-4.1.4.Final.jar;"%REPO%"\antlr\antlr\2.7.7\antlr-2.7.7.jar;"%REPO%"\org\jsoup\jsoup\1.7.2\jsoup-1.7.2.jar;"%REPO%"\com\google\guava\guava\18.0\guava-18.0.jar;"%REPO%"\org\apache\commons\commons-lang3\3.4\commons-lang3-3.4.jar;"%REPO%"\org\jboss\resteasy\resteasy-jaxrs\2.2.1.GA\resteasy-jaxrs-2.2.1.GA.jar;"%REPO%"\org\jboss\resteasy\jaxrs-api\2.2.1.GA\jaxrs-api-2.2.1.GA.jar;"%REPO%"\org\scannotation\scannotation\1.0.3\scannotation-1.0.3.jar;"%REPO%"\javassist\javassist\3.12.1.GA\javassist-3.12.1.GA.jar;"%REPO%"\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;"%REPO%"\javax\activation\activation\1.1\activation-1.1.jar;"%REPO%"\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar;"%REPO%"\commons-codec\commons-codec\1.2\commons-codec-1.2.jar;"%REPO%"\org\apache\httpcomponents\httpclient\4.0.3\httpclient-4.0.3.jar;"%REPO%"\org\apache\httpcomponents\httpcore\4.0.1\httpcore-4.0.1.jar;"%REPO%"\net\jcip\jcip-annotations\1.0\jcip-annotations-1.0.jar;"%REPO%"\com\sun\jersey\jersey-client\1.9.1\jersey-client-1.9.1.jar;"%REPO%"\com\sun\jersey\jersey-core\1.9.1\jersey-core-1.9.1.jar;"%REPO%"\com\owlike\genson\0.99\genson-0.99.jar;"%REPO%"\org\glassfish\javax.json\1.0.4\javax.json-1.0.4.jar;"%REPO%"\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar;"%REPO%"\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.2.2\jackson-databind-2.2.2.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.2.2\jackson-annotations-2.2.2.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.2.2\jackson-core-2.2.2.jar;"%REPO%"\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar;"%REPO%"\commons-fileupload\commons-fileupload\1.2.1\commons-fileupload-1.2.1.jar;"%REPO%"\com\google\code\gson\gson\2.2.2\gson-2.2.2.jar;"%REPO%"\org\springframework\spring-jdbc\4.0.3.RELEASE\spring-jdbc-4.0.3.RELEASE.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\7.0.57\tomcat-embed-core-7.0.57.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-logging-juli\7.0.57\tomcat-embed-logging-juli-7.0.57.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-jasper\7.0.57\tomcat-embed-jasper-7.0.57.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-el\7.0.57\tomcat-embed-el-7.0.57.jar;"%REPO%"\org\eclipse\jdt\core\compiler\ecj\4.4\ecj-4.4.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper\7.0.57\tomcat-jasper-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-servlet-api\7.0.57\tomcat-servlet-api-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-juli\7.0.57\tomcat-juli-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-el-api\7.0.57\tomcat-el-api-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-api\7.0.57\tomcat-api-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-util\7.0.57\tomcat-util-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-jasper-el\7.0.57\tomcat-jasper-el-7.0.57.jar;"%REPO%"\org\apache\tomcat\tomcat-jsp-api\7.0.57\tomcat-jsp-api-7.0.57.jar;"%REPO%"\com\sun\el\el-ri\1.0\el-ri-1.0.jar;"%REPO%"\22UA\22UA\1.0-SNAPSHOT\22UA-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" launch.Main %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
