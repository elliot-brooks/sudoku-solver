#!/bin/sh
cd bin/
java --class-path ./ --module-path ../lib/ --add-modules=javafx.controls,javafx.fxml SudokuGame