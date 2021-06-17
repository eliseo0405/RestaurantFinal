package Project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class MainPageController implements Initializable {
	
	static ArrayList<String> menu = new ArrayList<>();
	static ArrayList<Integer> quant = new ArrayList<>();
	static ArrayList<Double> price = new ArrayList<>();
 	
    @FXML private TableView<Burger> tableView1;
    @FXML private TableColumn<Burger, String> OrderItemColumn1;
    @FXML private TableColumn<Burger, Integer> QuantityColumn1;
    
    @FXML private TableView<Drink> tableView2;
    @FXML private TableColumn<Drink, String> OrderItemColumn2;
    @FXML private TableColumn<Drink, Integer> QuantityColumn2;
    
    @FXML private RadioButton CB;
    @FXML private RadioButton BB;
    @FXML private RadioButton DCB;
    @FXML private RadioButton DBB;
    @FXML private RadioButton BM;
    
    @FXML private RadioButton coke;
    @FXML private RadioButton fruit_punch;
    @FXML private RadioButton mojitos;
    @FXML private RadioButton lemonade;
    @FXML private RadioButton ice_tea;
    
    @FXML private Button AddBurger;
    @FXML private Button AddDrink;
    @FXML private Button DeleteBtn;
    @FXML private Button ProceedBtn;
    
    @FXML private TextField quantityBurger;
    @FXML private TextField quantityDrink;
    
    @FXML private Label quantityLabel1;
    @FXML private Label quantityLabel2;
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
		
		OrderItemColumn1.setCellValueFactory(new PropertyValueFactory<Burger, String>("menuBurger"));
		QuantityColumn1.setCellValueFactory(new PropertyValueFactory<Burger, Integer>("quantity"));
		
		OrderItemColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		OrderItemColumn2.setCellValueFactory(new PropertyValueFactory<Drink, String>("menuDrink"));
		QuantityColumn2.setCellValueFactory(new PropertyValueFactory<Drink, Integer>("quantity"));
		
		OrderItemColumn2.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
    
    @FXML
    public void newBurgerButtonPushed()
    {
    	
    	
    	if(CB.isSelected()){
    		 Integer value = Integer.valueOf(quantityBurger.getText());
    		 
    	     Burger newBurger = new Burger("Chicken Burger" ,value);
    	     tableView1.getItems().add(newBurger);
    	     
    	     menu.add("Chicken Burger");
    	     quant.add(value);
    	     price.add(value*8.00);
    	     
    	     Menu.calculateOrder(8.00*value);
    	}
    	
    	else if(BB.isSelected()){
   		 Integer value = Integer.valueOf(quantityBurger.getText());
   		 
   	     Burger newBurger = new Burger("Beef Burger" ,value);
   	     tableView1.getItems().add(newBurger);
   	     
	     menu.add("Beef Burger");
	     quant.add(value);
	     price.add(value*7.00);
	     
	     Menu.calculateOrder(7.00*value);
   	}
    	
    	else if(DCB.isSelected()){
   		 Integer value = Integer.valueOf(quantityBurger.getText());
   		 
   	     Burger newBurger = new Burger("Double Chicken Burger" ,value);
   	     tableView1.getItems().add(newBurger);
   	     
	     menu.add("Double Chicken Burger");
	     quant.add(value);
	     price.add(value*14.00);
	     
	     Menu.calculateOrder(14.00*value);
   	}
    	
    	else if(DBB.isSelected()){
   		 Integer value = Integer.valueOf(quantityBurger.getText());
   		 
   	     Burger newBurger = new Burger("Double Beef Burger" ,value);
   	     tableView1.getItems().add(newBurger);
   	     
	     menu.add("Double Beef Burger");
	     quant.add(value);
	     price.add(value*13.00);
	     
	     Menu.calculateOrder(13.00*value);
   	}
    	
    	else if(BM.isSelected()){
   		 Integer value = Integer.valueOf(quantityBurger.getText());
   		 
   	     Burger newBurger = new Burger("Burger Mix" ,value);
   	     tableView1.getItems().add(newBurger);
   	     
	     menu.add("Burger Mix");
	     quant.add(value);
	     price.add(value*15.00);
	     
	     Menu.calculateOrder(15.00*value);
   	}
}
    @FXML
    public void newDrinkButtonPushed()
    {
    	if(coke.isSelected()){
    		 Integer value = Integer.valueOf(quantityDrink.getText());
    		 
    	     Drink newDrink = new Drink("Coke 325ml" ,value);
    	     tableView2.getItems().add(newDrink);
    	     
    	     menu.add("Coke 325ml");
    	     quant.add(value);
    	     price.add(value*2.00);
    	     
    	     Menu.calculateOrder(2.00*value);
    	}
    	
    	else if(fruit_punch.isSelected()){
   		 Integer value = Integer.valueOf(quantityDrink.getText());
   		 
   	     Drink newDrink = new Drink("Fruit Punch" ,value);
   	     tableView2.getItems().add(newDrink);
   	     
	     menu.add("Fruit Punch");
	     quant.add(value);
	     price.add(value*3.00);
	     
	     Menu.calculateOrder(3.00*value);
   	}
    	else if(mojitos.isSelected()){
   		 Integer value = Integer.valueOf(quantityDrink.getText());
   		 
   	     Drink newDrink = new Drink("Mojitos" ,value);
   	     tableView2.getItems().add(newDrink);
   	     
	     menu.add("Mojitos");
	     quant.add(value);
	     price.add(value*1.50);
	     
	     Menu.calculateOrder(1.50*value);
   	}
    	else if(lemonade.isSelected()){
   		 Integer value = Integer.valueOf(quantityDrink.getText());
   		 
   	     Drink newDrink = new Drink("Iced Lemonade" ,value);
   	     tableView2.getItems().add(newDrink);
   	     
	     menu.add("Iced Lemonade");
	     quant.add(value);
	     price.add(value*1.50);
	     
	     Menu.calculateOrder(1.50*value);
   	}
    	else if(ice_tea.isSelected()){
   		 Integer value= Integer.valueOf(quantityDrink.getText());
   		 
   	     Drink newDrink = new Drink("Lipton Ice Tea 325ml" ,value);
   	     tableView2.getItems().add(newDrink);
   	     
	     menu.add("Lipton Ice Tea 325ml");
	     quant.add(value);
	     price.add(value*1.00);
	     
	     Menu.calculateOrder(1.00*value);
   	}
}
    @FXML
	public void proceedBtn(ActionEvent event) throws IOException{
		Parent receiptPage = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
		Scene receiptPageScene = new Scene(receiptPage);
		
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(receiptPageScene);
		window.show();
	}
    @FXML
    public void deleteButtonPushed()
    {
        ObservableList<Burger> selectedRows1, allOrder1;
        allOrder1 = tableView1.getItems();
        
        selectedRows1 = tableView1.getSelectionModel().getSelectedItems();
        
        for (Burger burger: selectedRows1)
        {
            allOrder1.remove(burger);
        }
        
        ObservableList<Drink> selectedRows2, allOrder2;
        allOrder2 = tableView2.getItems();
        
        selectedRows2 = tableView2.getSelectionModel().getSelectedItems();
        
        for (Drink drink: selectedRows2)
        {
            allOrder2.remove(drink);
        }
    }
    
    public static ArrayList<String> getMenu(){
    	return menu;
    }
    
    public static ArrayList<Integer> getQuant(){
    	return quant;
    }
    
    public static ArrayList<Double> getPrice(){
    	return price;
    }
}