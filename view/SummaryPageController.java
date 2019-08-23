package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Data;

public class SummaryPageController implements Initializable{

	
	private ObservableList<Data> data = FXCollections.observableArrayList(
            new Data("HEB",89.2, "Biswash", "Yes", 89),
            new Data("HEB",89, "Biswash", "Yes", 89));
	
		@FXML
		private TableView<Data> tableView;
		
		@FXML
	    private TableColumn<Data, SimpleFloatProperty> amount;

	    @FXML
	    private TableColumn<Data, SimpleFloatProperty> balance;

	    @FXML
	    private TableColumn<Data, String> paidBy;


	    @FXML
	    private TableColumn<Data, String> title;

	    @FXML
	    private TableColumn<Data, String> included;
	    
	    @FXML
	    private Text fieldA;

	    @FXML
	    private Text fieldC;

	    @FXML
	    private Text fieldB;
	    

		@FXML
	    void prashantButtonClicked(ActionEvent event) {
	    	
	    	float amountA = ExpensePageController.biswash.getOwePrashant();
	    	float amountB = ExpensePageController.prashant.getOweBiswash();
	    	
	    	if(amountA > amountB)
		    	fieldA.setText("Biswash owes Prashant $" + (amountA - amountB) );
	    	else
	    		fieldA.setText("Prashant owes Biswash $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.dipesh.getOwePrashant();
	    	amountB = ExpensePageController.prashant.getOweDipesh();
	    	
	    	if(amountA > amountB)
	    	{
		    	fieldB.setText("Dipesh owes Prashant $" + (amountA - amountB) );
		    	System.out.println("Was here");
	    	}
	    	else
	    		fieldB.setText("Prashant owes Dipesh $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.suman.getOwePrashant();
	    	amountB = ExpensePageController.prashant.getOweSuman();
	    	
	    	if(amountA > amountB)
		    	fieldC.setText("Suman owes Prashant $" + (amountA - amountB) );
	    	else
		    	fieldC.setText("Prashant owes Suman $" + (amountB - amountA) );
	    	
	    }

	    @FXML
	    void dipeshButtonClicked(ActionEvent event) {
	    	
	    	float amountA = ExpensePageController.biswash.getOweDipesh();
	    	float amountB = ExpensePageController.dipesh.getOweBiswash();
	    	
	    	if(amountA > amountB)
		    	fieldA.setText("Biswash owes Dipesh $" + (amountA - amountB) );
	    	else
	    		fieldA.setText("Dipesh owes Biswash $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.dipesh.getOwePrashant();
	    	amountB = ExpensePageController.prashant.getOweDipesh();
	    	
	    	if(amountA > amountB)
		    	fieldB.setText("Dipesh owes Prashant $" + (amountA - amountB) );
	    	
	    	else
	    		fieldB.setText("Prashant owes Dipesh $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.suman.getOweDipesh();
	    	amountB = ExpensePageController.dipesh.getOweSuman();
	    	
	    	if(amountA > amountB)
		    	fieldC.setText("Suman owes Dipesh $" + (amountA - amountB) );
	    	else
		    	fieldC.setText("Dipesh owes Suman $" + (amountB - amountA) );
	    	

	    }

	    @FXML
	    void biswashButtonClicked(ActionEvent event) {
	    	
	    	float amountA = ExpensePageController.biswash.getOweDipesh();
	    	float amountB = ExpensePageController.dipesh.getOweBiswash();
	    	
	    	if(amountA > amountB)
		    	fieldA.setText("Biswash owes Dipesh $" + (amountA - amountB) );
	    	else
	    		fieldA.setText("Dipesh owes Biswash $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.biswash.getOwePrashant();
	    	amountB = ExpensePageController.prashant.getOweBiswash();
	    	
	    	if(amountA > amountB)
		    	fieldB.setText("Biswash owes Prashant $" + (amountA - amountB) );
	    	
	    	else
	    		fieldB.setText("Prashant owes Biswash $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.biswash.getOweSuman();
	    	amountB = ExpensePageController.suman.getOweBiswash();
	    	
	    	if(amountA > amountB)
		    	fieldC.setText("Biswash owes Suman $" + (amountA - amountB) );
	    	else
		    	fieldC.setText("Suman owes Biswash $" + (amountB - amountA ));
	    }
	    

	    @FXML
	    void sumanButtonClicked(ActionEvent event) {
	    	
	    	float amountA = ExpensePageController.suman.getOweDipesh();
	    	float amountB = ExpensePageController.dipesh.getOweSuman();
	    	
	    	if(amountA > amountB)
		    	fieldA.setText("Suman owes Dipesh $" + (amountA - amountB) );
	    	else
	    		fieldA.setText("Dipesh owes Suman $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.suman.getOwePrashant();
	    	amountB = ExpensePageController.prashant.getOweSuman();
	    	
	    	if(amountA > amountB)
		    	fieldB.setText("Suman owes Prashant $" + (amountA - amountB) );
	    	
	    	else
	    		fieldB.setText("Prashant owes Suman $" + (amountB - amountA));
	    	
	    	amountA = ExpensePageController.suman.getOweDipesh();
	    	amountB = ExpensePageController.dipesh.getOweSuman();
	    	
	    	if(amountA > amountB)
		    	fieldC.setText("Suman owes Dipesh $" + (amountA - amountB) );
	    	else
		    	fieldC.setText("Dipesh owes Suman $" + (amountB - amountA ));

	    }
	    
	   
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			System.out.println("washereeeeeeeeeeeeeeeeeeee");
			title.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
	        amount.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
	        paidBy.setCellValueFactory(new PropertyValueFactory<>("LastName"));
			tableView.setItems(data);
		}

}
