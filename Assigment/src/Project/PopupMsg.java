package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PopupMsg extends Application {

	public static void main(String[] args) { 
  launch(args); 
  }
  
  @Override 
  public void start(final Stage primaryStage) { 
	  
  MainPage Popup = new MainPage();	  
  HBox pane = new HBox(20); 
  pane.setAlignment(Pos.CENTER);
	  
  Button dineIn = new Button("Dine In");
  Button takeAway = new Button("  Take Away\n(extra +RM2)");
  dineIn.setPrefHeight(75);
  dineIn.setPrefWidth(125);
  takeAway.setPrefHeight(75);
  takeAway.setPrefWidth(125);
  pane.getChildren().addAll(dineIn, takeAway);
  
  Scene scene = new Scene(pane, 300, 150);
  primaryStage.setX(800);
  primaryStage.setY(450);
  primaryStage.setTitle("Food Ordering System "); 
  primaryStage.setScene(scene); 
  primaryStage.show();
  

  
  dineIn.setOnAction(new EventHandler<ActionEvent>() {
  @Override 
  public void handle(ActionEvent event) {
	  try {
		Popup.start(primaryStage);
	} catch (Exception e) {

		e.printStackTrace();
	}
  }
  });
  
  takeAway.setOnAction(new EventHandler<ActionEvent>() {
  @Override 
  public void handle(ActionEvent event) {
	  
	  Menu.calculateOrder(2.00);
	  try {
		Popup.start(primaryStage);
	} catch (Exception e) {

		e.printStackTrace();
	}
  }
  });

  }
}