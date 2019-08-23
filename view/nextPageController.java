package view;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ImageController;


public class nextPageController implements Initializable{

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private Text titleText;
    
    @FXML
    private Button logoutButton;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private GridPane pane;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			ImageController controller = new ImageController();
			titleText.setText("APT 101 APP");
			controller.addImages("roommates.csv");
	    	
	    	for(int i = 0; i < controller.images.size(); i++)
	    	{
	    		String imageName = "/Images/" + controller.images.get(i).toString();
	    		//System.out.println("Image name is " + imageName);
	    		String memberName = controller.roommateNames.get(i).toString();
    			Image image = new Image(imageName, 175, 175, false, false);
    			
    			if(i == 0)
    			{
    				image1.setImage(image);
    				label1.setText(memberName);
    			}
    			
    			if(i == 1)
    			{
    				image2.setImage(image);
    				label2.setText(memberName);
    			}
    			
    			if(i == 2)
    			{
    				image3.setImage(image);
    				label3.setText(memberName);
    			}if(i == 3)
    			{
    				image4.setImage(image);
    				label4.setText(memberName);
    			}if(i == 4)
    			{
    				image5.setImage(image);
    				label5.setText(memberName);
    			}
    			
    			if(i == 5)
    			{
    				image6.setImage(image);
    				label6.setText(memberName);
    			}
    			
	    	}
			
		}
		
		@FXML
	    void continueButtonClicked(ActionEvent event) throws IOException
		{
	    	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/view/expensePage.fxml"));
    		Parent view1 = loader.load();
     		Scene scene1 = new Scene(view1);
        	Stage window1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
     		window1.setScene(scene1);
        	window1.show();

		}
	}
