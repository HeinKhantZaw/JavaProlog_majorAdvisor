package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class InterestLevel_CT_Controller implements Initializable  {
	
	int il_nos, il_bcmn, il_cvdip, il_se;
	
 	@FXML
    private Button continue_Btn;

    @FXML
    private JFXComboBox<String> IL_ct_nos; // networking operating system

    @FXML
    private JFXComboBox<String> IL_ct_bcmn; // broadband communication and mobile networking

    @FXML
    private JFXComboBox<String> IL_ct_cvdip; //computer vision with digital image processing
    
    @FXML
    private JFXComboBox<String> IL_ct_se; //sensors and electronics
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fill_ComboBoxes();
		Button_Actions();
		
	}
	
	private void Button_Actions() {
		
		continue_Btn.setOnAction( e -> {
			getValue_ComboBoxes();
			Parent root;
			try {
				root = FXMLLoader.load(Analyzing_Loader_Controller.class.getResource("Analyzing_Loader.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Major Advisor");
				stage.setMaximized(true);
				stage.setResizable(false);
				stage.setX(350);
				continue_Btn.getScene().getWindow().hide();
				stage.setOnCloseRequest(event -> {

					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Close confirmation");
					alert.setContentText("Are you sure do you want to exit?");

					alert.showAndWait().ifPresent(type -> {
						if (type == ButtonType.CANCEL) {
							event.consume();
						}
					});
				});
				stage.show();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		});
	}
	
	private void fill_ComboBoxes() {
		
		String none = "None - 0";
		String low = "Low - 1";
		String medium = "Medium - 2";
		String high = "High - 3";
		String verHigh = "Very High - 4";
		
		IL_ct_nos.getItems().add(none);
		IL_ct_nos.getItems().add(low);
		IL_ct_nos.getItems().add(medium);
		IL_ct_nos.getItems().add(high);
		IL_ct_nos.getItems().add(verHigh);
		
		IL_ct_bcmn.getItems().add(none);
		IL_ct_bcmn.getItems().add(low);
		IL_ct_bcmn.getItems().add(medium);
		IL_ct_bcmn.getItems().add(high);
		IL_ct_bcmn.getItems().add(verHigh);
		
		IL_ct_cvdip.getItems().add(none);
		IL_ct_cvdip.getItems().add(low);
		IL_ct_cvdip.getItems().add(medium);
		IL_ct_cvdip.getItems().add(high);
		IL_ct_cvdip.getItems().add(verHigh);
		

		IL_ct_se.getItems().add(none);
		IL_ct_se.getItems().add(low);
		IL_ct_se.getItems().add(medium);
		IL_ct_se.getItems().add(high);
		IL_ct_se.getItems().add(verHigh);
		
		
	}

	private void getValue_ComboBoxes() {
		
		String dummy = IL_ct_nos.getValue(); // get string value from combo
		String [] arr1 = dummy.split("-");	// split string when "-" is found
		il_nos = Integer.parseInt(arr1[1].trim()); //take the numeric value and remove whitespace from that string 
		
		dummy = IL_ct_bcmn.getValue();
		String [] arr2 = dummy.split("-");
		il_bcmn = Integer.parseInt(arr2[1].trim());
		
		dummy = IL_ct_cvdip.getValue();
		String [] arr3 = dummy.split("-");
		il_cvdip = Integer.parseInt(arr3[1].trim());
		
		dummy = IL_ct_se.getValue();
		String [] arr4 = dummy.split("-");
		il_se = Integer.parseInt(arr4[1].trim());
		
	}

}
