#!/bin/sh
find . -name "*.class" -type f -delete
javac -d bin/ --source-path src/ src/SudokuApp.java --module-path lib/ --add-modules=javafx.controls,javafx.fxml