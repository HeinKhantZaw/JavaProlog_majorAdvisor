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

public class InterestLevel_CS_Controller implements Initializable {
	
	int il_b, il_mp, il_mldv, il_sce, il_is, il_rs, il_btit, il_pc;

    @FXML
    private Button continue_Btn;

    @FXML
    private JFXComboBox<String> IL_cs_b; //business

    @FXML
    private JFXComboBox<String> IL_cs_mp; // marketing principle

    @FXML
    private JFXComboBox<String> IL_cs_mldv; // machine learning with data visualization

    @FXML
    private JFXComboBox<String> IL_cs_sce; //software construction and evaluation

    @FXML
    private JFXComboBox<String> IL_cs_is; // intelligent system

    @FXML 
    private JFXComboBox<String> IL_cs_rs; // robotic system

    @FXML
    private JFXComboBox<String> IL_cs_btit; // block chain technology and internet of things

    @FXML
    private JFXComboBox<String> IL_cs_pc; // parallel computing

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fill_ComboBoxes();
		Button_Actions();
		
	}
	
	private void Button_Actions() {
		
		continue_Btn.setOnAction( e -> {
			getValue_ComboBox();
			Parent root;
			try {
				String connection = "consult('main.pl')";
	            Query con = new Query(connection);
	            System.out.println(connection + "" + (con.hasMoreSolutions() ? "Success" : "Fail"));
	           
	            String connection1 = "consult('calculate_threshold.pl')";
	            Query con1 = new Query(connection1);
	            System.out.println(connection1 + "" + (con1.hasMoreSolutions() ? "Success" : "Fail"));
	            
	            String connection2 = "consult('kb.pl')";
	            Query con2 = new Query(connection2);
	            System.out.println(connection2 + "" + (con2.hasMoreSolutions() ? "Success" : "Fail"));
	           
	            String connection3 = "consult('major_description.pl')";
	            Query con3 = new Query(connection3);
	            System.out.println(connection3 + "" + (con3.hasMoreSolutions() ? "Success" : "Fail"));
	           
	            String connection4 = "consult('tree.pl')";
	            Query con4 = new Query(connection4);
	            System.out.println(connection4 + "" + (con4.hasMoreSolutions() ? "Success" : "Fail"));
	           
	            String connection5 = "consult('user_input.pl')";
	            Query con5 = new Query(connection5);
	            System.out.println(connection5 + "" + (con5.hasMoreSolutions() ? "Success" : "Fail"));
	            
	            
	            String interest1 = "assert(interest(business"+","+il_b+")).";
	            String interest2 = "assert(interest(analyzing_data"+","+il_mp+")).";
	            String interest3 = "assert(interest(programming"+","+il_mldv+")).";
	            String interest4 = "assert(interest(ood"+","+il_sce+")).";
	            String interest5 = "assert(interest(expert_system"+","+il_is+")).";
	            String interest6 = "assert(interest(algorithms"+","+il_rs+")).";
	            String interest7 = "assert(interest(linux_os"+","+il_btit+")).";
	            String interest8 = "assert(interest(parallel_computing"+","+il_pc+")).";
	            
	            String test = "confirm_specific_interest(business"+","+il_b+")";
	            String test1 = "confirm_specific_interest(analyzing_data"+","+il_mp+")";
	            String test2 = "confirm_specific_interest(programming"+","+il_mldv+")";
	            String test3 = "confirm_specific_interest(ood"+","+il_sce+")";
	            String test4 = "confirm_specific_interest(expert_system"+","+il_is+")";
	            String test5 = "confirm_specific_interest(algorithms"+","+il_rs+")";
	            String test6 = "confirm_specific_interest(linux_os"+","+il_btit+")";
	            String test7 = "confirm_specific_interest(parallel_computing"+","+il_pc+")";
	            
	            Query testing = new Query(test);
	            Query testing1 = new Query(test1);
	            Query testing2 = new Query(test2);
	            Query testing3 = new Query(test3);
	            Query testing4 = new Query(test4);
	            Query testing5 = new Query(test5);
	            Query testing6 = new Query(test6);
	            Query testing7 = new Query(test7);
	            
	            testing.hasSolution();
	            testing1.hasSolution();
	            testing2.hasSolution();
	            testing3.hasSolution();
	            testing4.hasSolution();
	            testing5.hasSolution();
	            testing6.hasSolution();
	            testing7.hasSolution();
	            
	            Query execution1 = new Query(interest1);
	            Query execution2 = new Query(interest2);
	            Query execution3 = new Query(interest3);
	            Query execution4 = new Query(interest4);
	            Query execution5 = new Query(interest5);
	            Query execution6 = new Query(interest6);
	            Query execution7 = new Query(interest7);
	            Query execution8 = new Query(interest8);
	            Query save = new Query("save");
	            
	            if (execution1.hasSolution() && execution2.hasSolution() && execution3.hasSolution() && execution4.hasSolution() && execution5.hasSolution() && execution6.hasSolution()
		            	&& execution7.hasSolution() && execution8.hasSolution() && save.hasSolution() ) {
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
		
		IL_cs_b.getItems().add(none);
		IL_cs_b.getItems().add(low);
		IL_cs_b.getItems().add(medium);
		IL_cs_b.getItems().add(high);
		IL_cs_b.getItems().add(verHigh);
		
		IL_cs_mp.getItems().add(none);
		IL_cs_mp.getItems().add(low);
		IL_cs_mp.getItems().add(medium);
		IL_cs_mp.getItems().add(high);
		IL_cs_mp.getItems().add(verHigh);
		
		IL_cs_mldv.getItems().add(none);
		IL_cs_mldv.getItems().add(low);
		IL_cs_mldv.getItems().add(medium);
		IL_cs_mldv.getItems().add(high);
		IL_cs_mldv.getItems().add(verHigh);
		
		IL_cs_sce.getItems().add(none);
		IL_cs_sce.getItems().add(low);
		IL_cs_sce.getItems().add(medium);
		IL_cs_sce.getItems().add(high);
		IL_cs_sce.getItems().add(verHigh);
		
		IL_cs_is.getItems().add(none);
		IL_cs_is.getItems().add(low);
		IL_cs_is.getItems().add(medium);
		IL_cs_is.getItems().add(high);
		IL_cs_is.getItems().add(verHigh);
		
		IL_cs_rs.getItems().add(none);
		IL_cs_rs.getItems().add(low);
		IL_cs_rs.getItems().add(medium);
		IL_cs_rs.getItems().add(high);
		IL_cs_rs.getItems().add(verHigh);
		
		IL_cs_btit.getItems().add(none);
		IL_cs_btit.getItems().add(low);
		IL_cs_btit.getItems().add(medium);
		IL_cs_btit.getItems().add(high);
		IL_cs_btit.getItems().add(verHigh);
		
		IL_cs_pc.getItems().add(none);
		IL_cs_pc.getItems().add(low);
		IL_cs_pc.getItems().add(medium);
		IL_cs_pc.getItems().add(high);
		IL_cs_pc.getItems().add(verHigh);		
	}
	
	private void getValue_ComboBox() {	// clicking continue btn, get value of comboxes and store in string
		
		String dummy = IL_cs_b.getValue(); // get string value from combo
		String [] arr1 = dummy.split("-");	// split string when "-" is found
		il_b = Integer.parseInt(arr1[1].trim()); //take the numeric value and remove whitespace from that string 
		
		dummy = IL_cs_mp.getValue();
		String [] arr2 = dummy.split("-");
		il_mp = Integer.parseInt(arr2[1].trim());
		
		dummy = IL_cs_mldv.getValue();
		String [] arr3 = dummy.split("-");
		il_mldv = Integer.parseInt(arr3[1].trim());
		
		dummy = IL_cs_sce.getValue();
		String [] arr4 = dummy.split("-");
		il_sce = Integer.parseInt(arr4[1].trim());
		
		dummy = IL_cs_is.getValue();
		String [] arr5 = dummy.split("-");
		il_is = Integer.parseInt(arr5[1].trim());
		
		dummy = IL_cs_rs.getValue();
		String [] arr6 = dummy.split("-");
		il_rs = Integer.parseInt(arr6[1].trim());
		
		dummy = IL_cs_btit.getValue();
		String [] arr7 = dummy.split("-");
		il_btit = Integer.parseInt(arr7[1].trim());
		
		dummy = IL_cs_pc.getValue();
		String [] arr8 = dummy.split("-");
		il_pc = Integer.parseInt(arr8[1].trim());
		

	}
}
