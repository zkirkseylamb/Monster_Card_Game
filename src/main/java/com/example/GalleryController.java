package com.example;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GalleryController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;
    @FXML
    private AnchorPane pane4;
    @FXML
    private AnchorPane pane5;
    @FXML
    private AnchorPane pane6;

    @FXML
    private AnchorPane pane7;
    @FXML
    private AnchorPane pane8;
    @FXML
    private AnchorPane pane9;
    @FXML
    private AnchorPane pane10;


    public void translateAnimation (double duration, Node node, double width) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
        translateTransition.setByX(width);
        translateTransition.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        translateAnimation(0.5,pane2,850);
        translateAnimation(0.5,pane3,850);
        translateAnimation(0.5,pane4,850);



    }
    int show = 0;


    @FXML
    void foward(ActionEvent event){
        if (show==0){
            translateAnimation(0.5,pane2,850);
            show ++;
        } else if (show ==1){
            translateAnimation(0.5,pane3,850);
            show ++;
        } else if (show ==2){
            translateAnimation(0.5,pane4,850);
            show ++;
        }
    }
    @FXML
    void back(ActionEvent event){
        if (show==0){
            translateAnimation(0.5,pane2,850);
            show --;
        } else if (show ==1){
            translateAnimation(0.5,pane3,850);
            show --;
        } else if (show ==2){
            translateAnimation(0.5,pane4,850);
            show --;
        }

    }

}
