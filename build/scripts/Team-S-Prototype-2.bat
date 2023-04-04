@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Team-S-Prototype-2 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and TEAM_S_PROTOTYPE_2_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\Team-S-Prototype-2.jar;%APP_HOME%\lib\javafx-fxml-19-win.jar;%APP_HOME%\lib\javafx-fxml-19-mac.jar;%APP_HOME%\lib\javafx-fxml-19-linux.jar;%APP_HOME%\lib\javafx-fxml-19-mac-aarch64.jar;%APP_HOME%\lib\javafx-controls-19-win.jar;%APP_HOME%\lib\javafx-controls-19-mac.jar;%APP_HOME%\lib\javafx-controls-19-linux.jar;%APP_HOME%\lib\javafx-controls-19-mac-aarch64.jar;%APP_HOME%\lib\javafx-controls-19.jar;%APP_HOME%\lib\javafx-media-19-win.jar;%APP_HOME%\lib\javafx-graphics-19-win.jar;%APP_HOME%\lib\javafx-graphics-19-mac.jar;%APP_HOME%\lib\javafx-graphics-19-linux.jar;%APP_HOME%\lib\javafx-graphics-19-mac-aarch64.jar;%APP_HOME%\lib\javafx-graphics-19.jar;%APP_HOME%\lib\javafx-base-19-win.jar;%APP_HOME%\lib\javafx-base-19-mac.jar;%APP_HOME%\lib\javafx-base-19-linux.jar;%APP_HOME%\lib\javafx-base-19-mac-aarch64.jar;%APP_HOME%\lib\javafx-base-19.jar;%APP_HOME%\lib\materialfx-11.15.0.jar;%APP_HOME%\lib\gesturefx-0.7.1.jar;%APP_HOME%\lib\controlsfx-11.1.2.jar;%APP_HOME%\lib\slf4j-simple-2.0.5.jar;%APP_HOME%\lib\slf4j-api-2.0.5.jar;%APP_HOME%\lib\ucp-21.9.0.0.jar;%APP_HOME%\lib\ojdbc8-21.9.0.0.jar;%APP_HOME%\lib\postgresql-42.5.4.jar;%APP_HOME%\lib\argon2-jvm-2.11.jar;%APP_HOME%\lib\fxsvgimage-1.1.jar;%APP_HOME%\lib\argon2-jvm-nolibs-2.11.jar;%APP_HOME%\lib\jna-5.12.1.jar;%APP_HOME%\lib\virtualizedfx-11.2.6.jar;%APP_HOME%\lib\checker-qual-3.5.0.jar


@rem Execute Team-S-Prototype-2
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TEAM_S_PROTOTYPE_2_OPTS%  -classpath "%CLASSPATH%" edu.wpi.teamname.Main %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TEAM_S_PROTOTYPE_2_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TEAM_S_PROTOTYPE_2_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
