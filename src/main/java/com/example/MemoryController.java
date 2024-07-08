package com.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;


import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MemoryController implements Initializable {
    public Label guessesLabel;
    @FXML
    private Label CorrectLabel;

    @FXML
    private FlowPane imagesFlowPane;

    private ArrayList <MemoryCard> cardsInGame;

    private MemoryCard card1, card2;

    private int numOfGuess;

    private int numOfMatches;



    @FXML
    void playAgain(){
        card1 = null;
        card2 = null;
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for (int i=0; i< imagesFlowPane.getChildren().size()/2; i++){
            Card cardDealt = deck.dealTopCard();
            cardsInGame.add(new MemoryCard(cardDealt.getColor(),cardDealt.getName()));
            cardsInGame.add(new MemoryCard(cardDealt.getColor(),cardDealt.getName()));

        }
        Collections.shuffle(cardsInGame);
        flipAllCards();
        numOfGuess = 0;
        numOfMatches = 0;

        CorrectLabel.setText("0");
        guessesLabel.setText("0");


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       initializeImageView();
       playAgain();

    }

    /**
     * this will ad a number to each image view and set the image to be the back of a card
     */
    private void initializeImageView(){

        for (int i= 0; i<imagesFlowPane.getChildren().size(); i++){
           //cast node to image view
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image ("C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\Card_Back.png"));
            imageView.setUserData(i);

            //register click
            imageView.setOnMouseClicked(mouseEvent -> {
                flipCard((int)imageView.getUserData());

            });
        }
    }

    /**
     * flip all unmatched cards
     */
    private void flipAllCards(){
        for (int i = 0; i< cardsInGame.size(); i++){
            ImageView imageView = (ImageView)  imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);
            if (card.isMatched()){
                imageView.setImage(card.getImage());
            } else {
                imageView.setImage(card.getBackOfCard());
            }
        }


    }
    private void flipCard(int indexOfCard){

       if (card1 == null && card2 == null) {
           flipAllCards();
       }
        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if (card1 == null){
            card1 = cardsInGame.get(indexOfCard);
            imageView.setImage(card1.getImage());

        } else if (card2 == null){
            numOfGuess ++;
            card2 =  cardsInGame.get(indexOfCard);
            imageView.setImage(card2.getImage());
            checkForMatch();
            CorrectLabel.setText(Integer.toString(numOfMatches));
            guessesLabel.setText(Integer.toString(numOfGuess));
        }

    }


    private void checkForMatch(){
        if (card1.isSameCard(card2)){
            numOfMatches++;
            card1.setMatched(true);
            card2.setMatched(true);
        }
        card1 = null;
        card2 = null;
    }


}
