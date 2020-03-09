package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpl7.Query;

import com.jfoenix.controls.JFXTextArea;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Output_Controller implements Initializable {
	
	
	@FXML private JFXTextArea majors_TArea;

    @FXML private Label major1_label;

    @FXML private JFXTextArea major1_descrp_TArea;

    @FXML private Label major2_label;

    @FXML private JFXTextArea major2_descrp_TArea;

    @FXML private Label major3_label;

    @FXML private JFXTextArea major3_descrp_TArea;

    @FXML private Label major4_label;

    @FXML private JFXTextArea major4_descrp_TArea;

    @FXML private Button restart_Btn;

    @FXML private Button done_Btn;

	@Override public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
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
        
        String showMajor = "show_majors.";
        Query execSM = new Query(showMajor);
        execSM.hasSolution();
		String analyze = "tree_cs";
        Query exec = new Query(analyze);
        if (exec.hasSolution())
        {
        	System.out.println(true);
        }
		Button_Actions();
		
	}
	
	
	private void Button_Actions() {
		done_Btn.setOnAction(e -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Close confirmation");
			alert.setContentText("Are you sure do you want to exit?");

			alert.showAndWait().ifPresent(type -> {
				if (type == ButtonType.CANCEL) {
					e.consume();
				} else if (type == ButtonType.OK) {
					Platform.exit();
				}
			});
			
		});
		
		restart_Btn.setOnAction( e -> {
			Parent root;
			try {
				root = FXMLLoader.load(Menu_Controller.class.getResource("Menu.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle("Major Advisor");
				stage.setMaximized(true);
				stage.setResizable(false);
				restart_Btn.getScene().getWindow().hide();
				stage.setX(350);
				stage.show();
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
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		});
	}

}
