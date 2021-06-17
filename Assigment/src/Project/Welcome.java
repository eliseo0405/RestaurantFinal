package Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Welcome extends Application {
  
  Image image = new Image("file:background.jpg");
  
  public static void main(String[] args) {
	  launch(args);
	  }
  
  @Override
  public void start(Stage primaryStage) {

    HBox pane = new HBox(20);
    pane.setAlignment(Pos.CENTER);

    ImageView iv = new ImageView();
    iv.setImage(image);
    pane.getChildren().add(iv);
   
    Button btOrder = new Button("Order");
    btOrder.setPrefHeight(50);
    btOrder.setPrefWidth(100);
    
    Button btExit = new Button(" Exit ");
    btExit.setPrefHeight(50);
    btExit.setPrefWidth(100);

    pane.getChildren().addAll(btOrder, btExit);
    
    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll(iv,pane);
    
    Scene scene = new Scene(stackPane, 1000, 600);
    primaryStage.setTitle("Food Ordering System ");
    primaryStage.setScene(scene); 
    primaryStage.show(); 
 
    btOrder.setOnAction(new EventHandler<ActionEvent>() {
	@Override 
	public void handle(ActionEvent event) {
		PopupMsg Popup = new PopupMsg();
		Popup.start(primaryStage);
	  }
	  });

   btExit.setOnAction(new EventHandler<ActionEvent>() {
   @Override 
   public void handle(ActionEvent event) {
	  	System.exit(0);
	  }
	  });
} 
}



