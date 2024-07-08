package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;
import java.net.URI;
import java.nio.file.Paths;

public class MainMemory extends Application {




    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;

    private static File file = new File("C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\background.mp4");
    private static URI newURI = file.toURI();
    private static Media media = new Media(newURI.toString());


    public static void main(String[] args) {
        launch();
    }

    // plays music
    MediaPlayer mediaPlayerSound;
    public void music(){
        String s = "C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\05 - Wood Temple.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayerSound = new MediaPlayer(h);
        mediaPlayerSound.play();
        mediaPlayerSound.setCycleCount(MediaPlayer.INDEFINITE);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMemory.class.getResource("Memory.fxml"));
        Scene sceneGame = new Scene (fxmlLoader.load());

        window = primaryStage;

        music();

        // background Animation
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView();
        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setFitHeight(850);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        // Scene 1 BUTTONS--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************


        // NEW GAME BUTTON--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************

        Button button1 = new Button ("New Game");
        button1.setFont(Font.font ("Times New Roman", 30));
        button1.setTextFill(Color.ROSYBROWN);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                window.setScene(scene2);
            }
        });


        // RULES BUTTON--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************

        Button button2 = new Button ("Rules");
        button2.setFont(Font.font ("Times New Roman", 30));
        button2.setTextFill(Color.ROSYBROWN);

        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                window.setScene(scene3);
            }
        });


        // Gallery BUTTON--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************

        Button button3 = new Button ("Gallery");
        button3.setFont(Font.font ("Times New Roman", 30));
        button3.setTextFill(Color.ROSYBROWN);

        // CREDITS BUTTON--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************

        Button button4 = new Button ("Credits");
        button4.setFont(Font.font ("Times New Roman", 30));
        button4.setTextFill(Color.ROSYBROWN);

        button4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                window.setScene(scene5);
            }
        });


        // Scene 1 MENU--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************


        // Scroll image
        Image scroll = new Image("C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\scroll.png");
        ImageView scrollView = new ImageView();
        scrollView.setImage(scroll);
        scrollView.setFitHeight(800);
        scrollView.setFitWidth(800);

        //title image
        Image title = new Image("C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\logo.png");
        ImageView titleView = new ImageView();
        titleView.setImage(title);
        titleView.setFitWidth(400);
        titleView.setFitHeight(100);


        VBox buttonBox = new VBox();
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(titleView,button1,button2,button3,button4);

        StackPane paneStack = new StackPane();
        paneStack.getChildren().addAll(mediaView,scrollView, buttonBox);
        buttonBox.setTranslateX(paneStack.getWidth()+15);
        buttonBox.setTranslateY(paneStack.getWidth()-35);

        scene1 = new Scene(paneStack, 850,850);

        // Scene 2 Game --------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************

        scene2 = sceneGame;

        // Scene 3 Rules--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************
        //return to menu button
        Button returnToMenuFromRules = new Button("Menu");
        returnToMenuFromRules.setFont(Font.font ("Times New Roman", 20));
        returnToMenuFromRules.setTextFill(Color.ROSYBROWN);
        returnToMenuFromRules.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                window.setScene(scene1);
            }
        });

        VBox returnBoxFromMenu = new VBox(returnToMenuFromRules);
        returnBoxFromMenu.setAlignment(Pos.BOTTOM_CENTER);
        Image rules = new Image("C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\Rules_Image.png");
        ImageView rulesView =new ImageView(rules);
        rulesView.setFitHeight(850);
        rulesView.setFitWidth(850);

        StackPane rulesStack = new StackPane();
        rulesStack.getChildren().addAll(rulesView,returnBoxFromMenu);
        scene3 =new Scene(rulesStack, 850,850);

        // Scene 4 Gallery--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************



        // Scene 5 Credits--------------------------------------------------------------------------------------------------------------------
        //**********************************************************************************************************************************

        //return to menu button
        Button returnToMenu = new Button("Menu");
        returnToMenu.setFont(Font.font ("Times New Roman", 20));
        returnToMenu.setTextFill(Color.ROSYBROWN);
        returnToMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                window.setScene(scene1);
            }
        });

        Image background = new Image("C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\background_cred.png");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitHeight(850);
        backgroundView.setFitWidth(850);

        VBox returnBox = new VBox(returnToMenu);
        returnBox.setAlignment(Pos.BOTTOM_CENTER);


        StackPane creditsStack = new StackPane();
        creditsStack.getChildren().addAll(backgroundView,returnBox);
        scene5 =new Scene(creditsStack, 850,850);


        window.setScene(scene1);
        window.setTitle("Creature Index");
        window.show();

    }


    public void goToMain(ActionEvent event) {
    }

    public void playAgain(ActionEvent event) {
    }


}
