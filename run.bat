@echo off
echo Compiling JavaFX Drawing App...

REM Update this path to match your JavaFX installation
set JAVAFX_PATH=C:\javafx-sdk-21\lib

REM Compile all Java files
javac --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.fxml *.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Running DrawingApp...
    echo.
    java --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.fxml DrawingApp
) else (
    echo Compilation failed! Please check your JavaFX installation and update the JAVAFX_PATH variable.
    echo.
    echo Current JAVAFX_PATH: %JAVAFX_PATH%
    echo.
    echo Please edit this batch file and set the correct path to your JavaFX lib directory.
    pause
)