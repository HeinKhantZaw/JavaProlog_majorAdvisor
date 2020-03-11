package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpl7.Query;

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
	
	int il_nos, il_bcmn, il_cvdip, il_se, il_sm, il_nid, il_mc, il_cd;
	
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
    
    @FXML
    private JFXComboBox<String> IL_ct_sm; // server management

    @FXML
    private JFXComboBox<String> IL_ct_nid; // network infrastructure development

    @FXML
    private JFXComboBox<String> IL_ct_mc; //micro-controllers
    
    @FXML
    private JFXComboBox<String> IL_ct_cd; // circuit_design
    
    

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
				String connection = "consult('resource/main.pl')";
	            Query con = new Query(connection);
	            System.out.println(connection + "" + (con.hasMoreSolutions() ? "Success" : "Fail"));
	         
				String interest1 = "assert(interest(telecom_network"+","+il_nos+")).";
	            String interest2 = "assert(interest(data_trans"+","+il_bcmn+")).";
	            String interest3 = "assert(interest(digital_signal"+","+il_cvdip+")).";
	            String interest4 = "assert(interest(sensors_electronics"+","+il_se+")).";
	            String interest5 = "assert(interest(server_management"+","+il_sm+")).";
	            String interest6 = "assert(interest(developing_network_infrastructure"+","+il_nid+")).";
	            String interest7 = "assert(interest(microcontrollers"+","+il_mc+")).";
	            String interest8 = "assert(interest(circuit_design"+","+il_cd+")).";
	            
	            Query execution1 = new Query(interest1);
	            Query execution2 = new Query(interest2);
	            Query execution3 = new Query(interest3);
	            Query execution4 = new Query(interest4);
	            Query execution5 = new Query(interest5);
	            Query execution6 = new Query(interest6);
	            Query execution7 = new Query(interest7);
	            Query execution8 = new Query(interest8);
	            
	            if (execution1.hasSolution() && execution2.hasSolution() && execution3.hasSolution() && execution4.hasSolution()
	            	&& execution5.hasSolution() && execution6.hasSolution() && execution7.hasSolution() && execution8.hasSolution()) {
				
				root = FXMLLoader.load(Analyzing_Loader_Controller.class.getResource("Analyzing_Loader.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Major Advisor");
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.setX(350);
				stage.setY(-10);
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
	            }
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Please fill correct information");
				alert.showAndWait();
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
		
		
		IL_ct_sm.getItems().add(none);
		IL_ct_sm.getItems().add(low);
		IL_ct_sm.getItems().add(medium);
		IL_ct_sm.getItems().add(high);
		IL_ct_sm.getItems().add(verHigh);
		
		
		IL_ct_nid.getItems().add(none);
		IL_ct_nid.getItems().add(low);
		IL_ct_nid.getItems().add(medium);
		IL_ct_nid.getItems().add(high);
		IL_ct_nid.getItems().add(verHigh);
		
		
		IL_ct_cd.getItems().add(none);
		IL_ct_cd.getItems().add(low);
		IL_ct_cd.getItems().add(medium);
		IL_ct_cd.getItems().add(high);
		IL_ct_cd.getItems().add(verHigh);
		
		
		IL_ct_mc.getItems().add(none);
		IL_ct_mc.getItems().add(low);
		IL_ct_mc.getItems().add(medium);
		IL_ct_mc.getItems().add(high);
		IL_ct_mc.getItems().add(verHigh);
		
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
		
		dummy = IL_ct_sm.getValue();
		String [] arr5 = dummy.split("-");
		il_sm = Integer.parseInt(arr5[1].trim());
		
		dummy = IL_ct_nid.getValue();
		String [] arr6 = dummy.split("-");
		il_nid = Integer.parseInt(arr6[1].trim());
		
		dummy = IL_ct_cd.getValue();
		String [] arr7 = dummy.split("-");
		il_cd = Integer.parseInt(arr7[1].trim());
		
		dummy = IL_ct_mc.getValue();
		String [] arr8 = dummy.split("-");
		il_mc = Integer.parseInt(arr8[1].trim());
	}

}