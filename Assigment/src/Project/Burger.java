package Project;

import javafx.beans.property.SimpleStringProperty;

public class Burger  {
	private SimpleStringProperty menuBurger;
	private double price;
	private int quantity;

	public  Burger(String menuBurger,int quantity){
		this.menuBurger=new SimpleStringProperty(menuBurger);
		this.quantity=quantity;
	
	}
	
	public Burger( double price){
		this.price=price;
	}
	
	public String getMenuBurger(){
		return menuBurger.get();
	}
	
	public void setMenuBurger(String menuBurger ){
		this.menuBurger=new SimpleStringProperty(menuBurger);
	}
	
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	
	public String toString(){
		return String.format("%s", menuBurger);
	}
	
}
