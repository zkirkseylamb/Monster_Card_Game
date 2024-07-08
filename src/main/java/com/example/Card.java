package com.example;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Card {
    private String color;
    private String name;

    public Card (String color, String name){
        setColor(color);
        setName(name);
    }

    public String getColor() {
        return color;
    }

    public static List<String> getValidColor()
    {
        return Arrays.asList("gray","green","blue","red","purple");
    }
    /**
     * valid colors are "gray","green","blue","red","purple"
     * @param color
     */
    public void setColor(String color) {
      color = color.toLowerCase();
        if (getValidColor().contains(color)) {
            this.color = color;
        } else {

            throw new IllegalArgumentException(color + "invalid, color must be one of" + getValidColor());
        }
    }

    public String getName() {
        return name;
    }

    public static List <String> getValidNames(){
        return Arrays.asList("acorn","alba","leaf","spider","cat","ebi","harm","bird","skele","plastic");
    }
    /**
     * valid names are "acorn","alba","leaf","spider","cat","ebi","harm","bird","skele","plastic"
     * @param name
     */
    public void setName(String name) {
       name = name.toLowerCase();
        if (getValidNames().contains(name)) {
            this.name = name;
        } else {
            throw  new IllegalArgumentException(name + "is invalid, must be one of" + getName());
        }
    }

    public String toString(){
        return name + "of" + color;
    }
    /**
     * this method will return an Image that represents the card
     */

    public Image getImage(){

        String pathName = "C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\" + name + "_card.png";
        return new Image((pathName));
    }

    public Image getBackOfCard(){

        String backPathName = "C:\\Users\\Student\\Desktop\\card-game\\src\\main\\resources\\com\\example\\Images\\Card_Back.png";
        return new Image((backPathName));
    }

}
