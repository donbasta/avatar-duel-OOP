package com.avatarduel.gui;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

import com.avatarduel.cards.Card;
import com.avatarduel.cards.CharacterCard;
import com.avatarduel.cards.LandCard;
import com.avatarduel.cards.SkillCard;

public class Main extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SKILL_CSV_FILE_PATH = "card/data/skill.csv";

  private ArrayList<Card> cardData;

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

    for (String[] row : landRows) {
      LandCard a = new LandCard(row[1], row[3], Element.valueOf(row[2]), row[4]);
      cardData.add(a);
    }
  }

  @Override
  public void start(Stage stage) throws Exception {
	  
	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("tes.fxml"));

      // Load outer outermost element from the FXML file
    Parent root = loader.load();

      // Setup new scene
    Scene scene = new Scene(root, 1200, 720);

      // Set stage to the scene
    stage.setTitle("Avatar the legend of jun");
    stage.setScene(scene);
    stage.show();

    try {
      this.loadCards();
      System.out.println("yey");
//      text.setText("Avatar Duel!");
    } catch (Exception e) {
//      text.setText("Failed to load cards: " + e);
    	System.out.println("yah");
    }
  }

  public static void main(String[] args) {
    launch();
  }
}