package com.avatarduel.gui;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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

public class Main extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";

  public void loadCards() throws IOException, URISyntaxException {
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    for (String[] row : landRows) {
      Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
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