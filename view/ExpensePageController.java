package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.ImageController;
import model.Person;


public class ExpensePageController implements Initializable {

	@FXML
	private CheckBox dipeshCheckbox;

	@FXML
	private CheckBox prashantCheckbox;
	    
	@FXML
	private CheckBox sumanCheckbox;

	@FXML
	private CheckBox biswasCheckbox;
	    
    @FXML
    private Button homeButton;
    
	@FXML
	private TextField expenseTitle;

	@FXML
	private TextField amountPaid;

	@FXML
	private ChoiceBox<String> cBox;
	    
	@FXML
	private ImageView image4;

	@FXML
	private ImageView image1;

	@FXML
	private ImageView image3;

	@FXML
	private ImageView image2;
	
	private static ExpensePageController controller = null;
	
	public static ExpensePageController getInstance() 
	{ 
	    if (controller == null) 
	        controller = new ExpensePageController(); 
	  
	    return controller; 
	} 
	
	public static Person prashant = new Person();
	public static Person biswash = new Person();
	public static Person suman = new Person();
	public static Person dipesh = new Person();
	
	public float moneyPaid;
	
	
	/**
     * A helper function to initialize the value inside view.fxml.
     */
    public void loadData()
    {   
    	cBox.getItems().add("Prashant");
    	cBox.getItems().add("Biswash");
    	cBox.getItems().add("Dipesh");
    	cBox.getItems().add("Suman");

    }
    
    @FXML
    void homeButtonClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/nextPage.fxml"));
		Parent view1 = loader.load();
 		Scene scene1 = new Scene(view1);
    	Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
 		window1.setScene(scene1);
    	window1.show();


    }
    
    void saveExpenseData(String fileName) throws IOException
	{
    	String Prashant = "";
    	String Biswash = "";
    	String Suman = "";
    	String Dipesh = "";
    	String title = expenseTitle.getText();
    	String amount = amountPaid.getText();  
    	String paidBy = cBox.getSelectionModel().getSelectedItem().toString();

    	if(prashantCheckbox.isSelected())
    	{
    		Prashant = "Prashant,";
    	}
    	
    	if(biswasCheckbox.isSelected())
    	{
    		Biswash = "Biswash,";
    	}
    	
    	if(sumanCheckbox.isSelected())
    	{
    		Suman = "Suman,";
    	}
    	
    	if(dipeshCheckbox.isSelected())
    	{
    		Dipesh = "Dipesh";
    	}
    	appendUsingPrintWriter(fileName, paidBy + "," + title + "," + amount + "," + Prashant + Biswash + Suman + Dipesh);
        
	}
    
    /**
     * This function uses FileWriter to append the user desired questions and options to the text file.
     * @param filePath FileName where the data is written to.
     * @param text Text gathered from UI to be appended to the file.
     */
	private static void appendUsingPrintWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


    
    @FXML
    void addButtonClicked(ActionEvent event) throws IOException
    {
    	saveExpenseData("expense.txt");
    }
    
    public void loadBands(String fileName)
	{
		File file = new File(fileName);

		try {
			Scanner input = new Scanner(file);
			String[] tokens = null;
			int numberOfPerson = 0;
			String paidBy = "";

			
			while(input.hasNextLine())
			{
				String line = input.nextLine();
				tokens = line.split(",");
				
				moneyPaid = Integer.parseInt(tokens[2]);
				System.out.println("Paid amount is: " + moneyPaid);
				paidBy = tokens[0];
				numberOfPerson = findNumberOfPerson(tokens);
				System.out.println("No of person is "+ numberOfPerson);
				for(int iterator = 3; iterator < tokens.length; iterator++)
				{
					calculatePrashant(tokens, iterator, paidBy, numberOfPerson);
					calculateDipesh(tokens, iterator, paidBy, numberOfPerson);
					calculateBiswash(tokens, iterator, paidBy, numberOfPerson);
					calculateSuman(tokens, iterator, paidBy, numberOfPerson);

				}
				
				System.out.println("Prashant owes Biswash " + prashant.getOweBiswash());
				
				
			}
			
				input.close();
			}
		
			catch (FileNotFoundException e) {
			e.printStackTrace();
			
			}
		
	}
    
    public void calculateBiswash(String tokens[], int iterator, String paidBy, int numberOfPerson)
    {
		if(tokens[iterator].equals("Biswash"))
		{
			float newAmount = 0;
			if(paidBy.equals("Prashant"))
			{
				newAmount = biswash.getOwePrashant();
				newAmount += moneyPaid/numberOfPerson;				
				biswash.setOwePrashant(newAmount);
			}
			
			else if(paidBy.equals("Suman"))
			{
				newAmount = biswash.getOweSuman();
				newAmount += moneyPaid/numberOfPerson; 
				biswash.setOweSuman(newAmount);
			}
			
			else if(paidBy.equals("Dipesh"))
			{
				newAmount = biswash.getOweDipesh();
				newAmount += moneyPaid/numberOfPerson; 
				biswash.setOweDipesh(newAmount);
			}
			
		}
    }
    
    public void calculateSuman(String tokens[], int iterator, String paidBy, int numberOfPerson)
    {
		if(tokens[iterator].equals("Suman"))
		{
			float newAmount = 0;
			if(paidBy.equals("Prashant"))
			{
				newAmount = suman.getOwePrashant();
				newAmount += moneyPaid/numberOfPerson;				
				suman.setOwePrashant(newAmount);
			}
			
			else if(paidBy.equals("Biswash"))
			{
				newAmount = suman.getOweBiswash();
				newAmount += moneyPaid/numberOfPerson; 
				suman.setOweBiswash(newAmount);
			}
			
			else if(paidBy.equals("Dipesh"))
			{
				newAmount = suman.getOweDipesh();
				newAmount += moneyPaid/numberOfPerson; 
				suman.setOweDipesh(newAmount);
			}
			
		}
    }
    
    public void calculatePrashant(String tokens[], int iterator, String paidBy, int numberOfPerson)
    {
    	if(tokens[iterator].equals("Prashant"))
		{
			float newAmount = 0;
			if(paidBy.equals("Biswash"))
			{
				newAmount = prashant.getOweBiswash();
				newAmount += moneyPaid/numberOfPerson;				
				prashant.setOweBiswash(newAmount);
			}
			
			else if(paidBy.equals("Suman"))
			{
				newAmount = prashant.getOweSuman();
				newAmount += moneyPaid/numberOfPerson; 
				prashant.setOweSuman(newAmount);
			}
			
			else if(paidBy.equals("Dipesh"))
			{
				newAmount = prashant.getOweDipesh();
				newAmount += moneyPaid/numberOfPerson; 
				prashant.setOweDipesh(newAmount);
			}
			
		}
    }
    
    public void calculateDipesh(String tokens[], int iterator, String paidBy, int numberOfPerson)
    {
    	if(tokens[iterator].equals("Dipesh"))
		{
			float newAmount = 0;
			if(paidBy.equals("Biswash"))
			{
				newAmount = dipesh.getOweBiswash();
				newAmount += moneyPaid/numberOfPerson;				
				dipesh.setOweBiswash(newAmount);
			}
			
			else if(paidBy.equals("Suman"))
			{
				newAmount = dipesh.getOweSuman();
				newAmount += moneyPaid/numberOfPerson; 
				dipesh.setOweSuman(newAmount);
			}
			
			else if(paidBy.equals("Prashant"))
			{
				newAmount = dipesh.getOwePrashant();
				newAmount += moneyPaid/numberOfPerson; 
				dipesh.setOwePrashant(newAmount);
			}
			
		}
    }
    
    

    
    @FXML
    void generateResultsClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/summaryPage.fxml"));
		Parent view1 = loader.load();
 		Scene scene1 = new Scene(view1);
    	Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
 		window1.setScene(scene1);
    	window1.show();
    	loadBands("expense.txt");
    	

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadData();
		ImageController controller  = new ImageController();
		ArrayList <String> imageList = controller.addImages("roommates.csv");
    	for(int i = 0; i < imageList.size(); i++)
    	{
    		String imageName = "/Images/" + imageList.get(i).toString();
			Image image = new Image(imageName, 175, 175, false, false);
			
			if(i == 0)
			{
				System.out.println("Image name is " + imageName);
				image1.setImage(image);
			}
			
			if(i == 1)
			{
				image2.setImage(image);
			}
			
			if(i == 2)
			{
				image3.setImage(image);
			}
			if(i == 3)
			{
				image4.setImage(image);
			}
			
		
			
    	}
		
	}
	
	public int findNumberOfPerson(String tokens[])
	{
		if(tokens.length == 7)
			return 4;
		if(tokens.length == 6)
			return 3;
		if(tokens.length == 5)
			return 2;
		
		return 0;
		
		
	}

}
