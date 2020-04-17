package com.avatarduel.gui;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.LandCard;
import com.avatarduel.cards.SkillCard;

import com.avatarduel.model.Element;
import com.avatarduel.state.Player;
import com.avatarduel.state.State;
import com.avatarduel.util.CSVReader;

import com.avatarduel.phase.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  private static final String LAND_CSV_FILE_PATH = "../card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "../card/data/character.csv";
  private static final String SKILL_CSV_FILE_PATH = "../card/data/skill.csv";

  private ArrayList<Card> cardData;
  private Player hojun, qila;
  private State state;

  public void loadCards() throws IOException, URISyntaxException {

    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, ";");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();

    File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
    CSVReader characterReader = new CSVReader(characterCSVFile, ";");
    characterReader.setSkipHeader(true);
    List<String[]> characterRows = characterReader.read();

    File skillCSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
    CSVReader skillReader = new CSVReader(skillCSVFile, ";");
    skillReader.setSkipHeader(true);
    List<String[]> skillRows = skillReader.read();
    
    cardData = new ArrayList<Card>();

    for(String[] row : landRows) {
      LandCard a = new LandCard(row[1], row[3], Element.valueOf(row[2]), row[4]);
      cardData.add(a);
    }

    for(String[] row : characterRows){
      CharacterCard a = new CharacterCard(row[1], row[3], Element.valueOf(row[2]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]), row[4]);
      cardData.add(a);
    }

    for(String[] row : skillRows){
      SkillCard a = new SkillCard(row[1], row[3], Element.valueOf(row[2]), row[5], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[8]), row[4]);
      cardData.add(a);
    }
  }

  @Override
  public void start(Stage stage) throws Exception {
	  
    try {
      this.loadCards();
    } catch (Exception e) {
      System.out.println(e);
    }
	  
	qila = new Player();
    hojun = new Player();
      
    Collections.shuffle(cardData);
    for(Card card : cardData) {
    	qila.getDecks().addToDeck(card);
    }
    Collections.shuffle(cardData);
    for(Card card : cardData) {
    	hojun.getDecks().addToDeck(card);
    }
    DrawPhase a = new DrawPhase(1);
    state = new State(1, qila, hojun, a);	  
	  
	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("tes.fxml"));
	
    // Load outer outermost element from the FXML file
    Parent root = loader.load();
    
    //set initial variables
	Controller controller = loader.<Controller>getController();
	controller.setPlay(qila, hojun, state);

    // Setup new scene
    Scene scene = new Scene(root, 1200, 720);

    // Set stage to the scene
    stage.setTitle("Avatar the legend of jun");
    stage.setScene(scene);
    stage.show();    

  }

  public static void main(String[] args) {
    launch();
  }
}