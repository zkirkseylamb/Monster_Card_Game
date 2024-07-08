package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Gallery extends Application {

    double x,y = 0;
    @Override
    public void start(Stage primarystage) throws IOException {

        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Gallery.fxml"))));
       // FXMLLoader fxmlLoader = new FXMLLoader(MainMemory.class.getResource("Gallery.fxml"));


        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getY();
        });

        root.setOnMouseDragged(event -> {
            primarystage.setX(event.getSceneX()- x);
            primarystage.setY(event.getSceneY()- y);
        } );
        primarystage.initStyle(StageStyle.UNDECORATED);
        primarystage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
