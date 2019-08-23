package model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {
	
    private SimpleStringProperty title;
    private SimpleFloatProperty amount;
    private SimpleStringProperty paidBy;
    private SimpleStringProperty included;
    private SimpleFloatProperty balance;
    
    public Data(String s1, double d, String s3, String s4, float balance)
    {
        title = new SimpleStringProperty(s1);
        amount = new SimpleFloatProperty();
        paidBy = new SimpleStringProperty(s3);
        included = new SimpleStringProperty(s4);
        this.balance = new SimpleFloatProperty(balance);
    }
    
	public SimpleStringProperty getTitle() {
		return title;
	}
	public void setTitle(SimpleStringProperty title) {
		this.title = title;
	}
	public SimpleFloatProperty getAmount() {
		return amount;
	}
	public void setAmount(SimpleFloatProperty amount) {
		this.amount = amount;
	}
	public SimpleStringProperty getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(SimpleStringProperty paidBy) {
		this.paidBy = paidBy;
	}
	public SimpleStringProperty getIncluded() {
		return included;
	}
	public void setIncluded(SimpleStringProperty included) {
		this.included = included;
	}
	public SimpleFloatProperty getBalance() {
		return balance;
	}
	public void setBalance(SimpleFloatProperty balance) {
		this.balance = balance;
	}

}
