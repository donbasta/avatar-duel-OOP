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

/**
 * Main Program
 *
 * @author 
 */
public class Main extends Application {
  private static final String LAND_CSV_FILE_PATH = "../card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "../card/data/character.csv";
  private static final String SKILL_CSV_FILE_PATH = "../card/data/skill.csv";

  private ArrayList<Card> cardData1, cardData2;
  private ArrayList<Card> landCardData1; 
  private ArrayList<Card> landCardData2;
  private ArrayList<Card> skillCardData1; 
  private ArrayList<Card> skillCardData2; 
  private ArrayList<Card> characterCardData1; 
  private ArrayList<Card> characterCardData2; 
  private Player hojun, qila;
  private State state;
  public static Scene mainScene;
  private Controller controller;

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
    
    landCardData1 = new ArrayList<Card>();
    landCardData2 = new ArrayList<Card>();
    skillCardData1 = new ArrayList<Card>();
    skillCardData2 = new ArrayList<Card>();
    characterCardData1 = new ArrayList<Card>();
    characterCardData2 = new ArrayList<Card>();

    for(String[] row : landRows) {
    	landCardData1.add(new LandCard(row[1], row[3], Element.valueOf(row[2]), row[4]));
    	landCardData2.add(new LandCard(row[1], row[3], Element.valueOf(row[2]), row[4]));
    }

    for(String[] row : characterRows){
    	characterCardData1.add(new CharacterCard(row[1], row[3], Element.valueOf(row[2]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]), row[4]));
    	characterCardData2.add(new CharacterCard(row[1], row[3], Element.valueOf(row[2]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]), row[4]));
    }

    for(String[] row : skillRows){
    	skillCardData1.add(new SkillCard(row[1], row[3], Element.valueOf(row[2]), row[5], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[8]), row[4]));
    	skillCardData2.add(new SkillCard(row[1], row[3], Element.valueOf(row[2]), row[5], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[8]), row[4]));
    }
  }

  @Override
  public void start(Stage stage) throws Exception {
	  
    try {
      this.loadCards();
    } catch (Exception e) {
    	e.printStackTrace();
      System.out.println(e);
    }
	  
	qila = new Player();
    hojun = new Player();
     
    Collections.shuffle(landCardData1);
    for(int i=0; i<25; i++) {
    	qila.getDecks().addToDeck(landCardData1.get(i));
    }
    Collections.shuffle(skillCardData1);
    for(int i=0; i<20; i++) {
    	qila.getDecks().addToDeck(skillCardData1.get(i));
    }
    Collections.shuffle(characterCardData1);
    for(int i=0; i<30; i++) {
    	qila.getDecks().addToDeck(characterCardData1.get(i));
    }
    Collections.shuffle(qila.getDecks().getDeck());
    Collections.shuffle(landCardData2);
    for(int i=0; i<25; i++) {
    	hojun.getDecks().addToDeck(landCardData2.get(i));
    }
    Collections.shuffle(skillCardData2);
    for(int i=0; i<20; i++) {
    	hojun.getDecks().addToDeck(skillCardData2.get(i));
    }
    Collections.shuffle(characterCardData2);
    for(int i=0; i<30; i++) {
    	hojun.getDecks().addToDeck(characterCardData2.get(i));
    }
    Collections.shuffle(hojun.getDecks().getDeck());
    
    DrawPhase a = new DrawPhase();
    state = new State(1, qila, hojun, a);	  
	  
	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("tes.fxml"));
	
    // Load outer outermost element from the FXML file
    Parent root = loader.load();
    
    //set initial variables
	controller = loader.<Controller>getController();
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