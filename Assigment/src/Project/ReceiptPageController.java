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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ReceiptPageController implements Initializable{
	
	@FXML private TableView<Menu> tableView;
    @FXML private TableColumn<Menu, String> orderItemColumn;
    @FXML private TableColumn<Menu, Integer> quantityColumn;
    @FXML private TableColumn<Menu, Double> priceColumn;
    
    @FXML private Button backBtn;
    @FXML private Button exitBtn;
    @FXML private Button proceedBtn;
    @FXML private Button DeleteBtn;
    
    @FXML private Label receiptLabel;
    @FXML private Label totalLabel;
    
    @FXML private TextField Total;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
		
		orderItemColumn.setCellValueFactory(new PropertyValueFactory<Menu, String>("menu"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("quant"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Menu, Double>("price"));
		
		orderItemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		ArrayList<String> menu = new ArrayList<>();
		ArrayList<Integer> quantity = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		
		menu=MainPageController.getMenu();
		quantity=MainPageController.getQuant();
		price=MainPageController.getPrice();
		
		for(int i=0; i<menu.size(); i++)
		{
		Menu receipt = new Menu( menu.get(i), quantity.get(i), price.get(i));
		tableView.getItems().add(receipt);
		}
		
		 Total.setText(Double.toString(Menu.getTotal()));
	}
	
	@FXML
	public void payment(ActionEvent event){
		Alert alert = new Alert (Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Food Ordering System");
		alert.setContentText("Your Order has been Received, Thank You!");
		alert.showAndWait();
	}
	
	@FXML
	private void closeAction(ActionEvent evt){
	    System.exit(0);
	}
	
	@FXML
	public void backBtn(ActionEvent event) throws IOException{
		Parent receiptPage = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene receiptPageScene = new Scene(receiptPage);
		
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(receiptPageScene);
		window.show();
	}
	
    @FXML
    public void deleteButtonPushed()
    {
        ObservableList<Menu> selectedRows1, allOrder1;
        allOrder1 = tableView.getItems();
        
        selectedRows1 = tableView.getSelectionModel().getSelectedItems();
        
        for (Menu menu: selectedRows1)
        {
            allOrder1.remove(menu);
        }
        
   }
    
}
