package com.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    
    Text titleText = new Text("Mengelola Array");
    Label addLabel = new Label("Tambah data : ");
    Label sortLabel = new Label("Proses Bubble Sort");
    TextField addField = new TextField();
    TextField dataField = new TextField();
    TextArea allData = new TextArea();
    Button addButton = new Button("Add");
    Button processButton = new Button("Process Bubble");
    Button closeButton = new Button("Close");
    Button deleteButton = new Button("Delete");
    HBox addBox = new HBox();
    HBox procesBox = new HBox();

    public static void errorDisplay(String message) {
        // tampilkan error, buang data error, cleartextfield
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("An error has occured");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void cleartextfield() {
        addField.clear();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        titleText.setFont(Font.font("Arial", 28));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setVgap(3);
        grid.setHgap(10);
        grid.setGridLinesVisible(true);
        grid.add(titleText, 0, 0);
        addBox.getChildren().addAll(addLabel,addField,addButton);
        addBox.setSpacing(10);
        addBox.setAlignment(Pos.CENTER);
        grid.add(addBox, 0, 1);
        grid.add(dataField, 0, 2);
        grid.add(deleteButton,1,2);
        procesBox.getChildren().addAll(sortLabel,processButton);
        procesBox.setSpacing(10);
        procesBox.setAlignment(Pos.CENTER_LEFT);
        grid.add(procesBox, 0, 3);
        grid.add(allData,0,4,2,1);
        grid.add(closeButton,1,5);
        GridPane.setHalignment(closeButton, HPos.RIGHT);

        Bilangan list = new Bilangan(1);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                list.add(Double.parseDouble(addField.getText()));
                dataField.setText(list.getArray());
                addField.clear();
                addField.requestFocus();
            }
        });

        processButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                list.bubbleSort();
                allData.setText(list.getProses());
            }
        });
        
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                list.deleteData();
                dataField.setText(list.getArray());
            }
        });

        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });
        // grid.setGridLinseVisible(true);
        Scene scene = new Scene(grid, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Mahasiswa");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}