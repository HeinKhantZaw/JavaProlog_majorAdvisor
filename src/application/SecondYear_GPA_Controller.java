package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpl7.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.events.JFXDialogEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SecondYear_GPA_Controller implements Initializable {
	
	@FXML private Button gpa_Btn;
	@FXML private Button continue_Btn;
	
    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;
	
	
 	@FXML
    private JFXTextField secondY1T_os;

    @FXML
    private JFXTextField secondY1T_cal2;

    @FXML
    private JFXTextField secondY1T_sma;

    @FXML
    private JFXTextField secondY1T_bis;

    @FXML
    private JFXTextField secondY1T_bec;

    @FXML
    private JFXTextField secondY1T_elp3;

    @FXML
    private JFXTextField secondY2T_dsa;

    @FXML
    private JFXTextField secondY2T_ds2;

    @FXML
    private JFXTextField secondY2T_hciis;

    @FXML
    private JFXTextField secondY2T_dms;

    @FXML
    private JFXTextField secondY2T_nf;

    @FXML
    private JFXTextField secondY2T_elp4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Button_Actions();
		
	}
	
	
	private void Button_Actions() {
		
		
		gpa_Btn.setOnAction( e -> {
			
			BoxBlur blur = new BoxBlur(1, 1, 1);
			Label l1 = new Label("GPA and Grade Equivalence\n");
			Label l2 = new Label("A+  and  A  = 4\nA-  = 3.67 \nB+  = 3.33\nB  = 3\nB-  = 2.67 \nC+  = 2.33\nC  = 2 \n");
			l1.getStyleClass().add("gpa_sub");
			l2.getStyleClass().add("gpa_label");
		  
			JFXDialogLayout dialogLayout = new JFXDialogLayout();
		    JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.BOTTOM);
		   
		    dialogLayout.getStyleClass().add("gpa_dialog");
		    dialogLayout.setHeading(l1);
		    dialogLayout.setBody(l2);
		   
		    dialog.show();
		    dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
			   anchorPane.setEffect(null);
			   
		   });
		   anchorPane.setEffect(blur);
		});
		

		continue_Btn.setOnAction( e -> {
			Parent root;
			try {
				Query q1 =
					    new Query(
					        "consult",
					        new Term[] {new Atom("main.pl")}
					    );
	            System.out.println(q1 + "" + (q1.hasMoreSolutions() ? "Success" : "Fail"));
	            
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
	          
	            String sub1 = "assert(second_first_term_grade(osf"+","+secondY1T_os.getText()+")).";
	            String sub2 = "assert(second_first_term_grade(cal2"+","+secondY1T_cal2.getText()+")).";
	            String sub3 = "assert(second_first_term_grade(sma"+","+secondY1T_sma.getText()+")).";
	            String sub4 = "assert(second_first_term_grade(b_fis"+","+secondY1T_bis.getText()+")).";
	            String sub5 = "assert(second_first_term_grade(bec"+","+secondY1T_bec.getText()+")).";
	            String sub6 = "assert(second_first_term_grade(elp3"+","+secondY1T_elp3.getText()+")).";
	            
	            Query execution1 = new Query(sub1);
	            Query execution2 = new Query(sub2);
	            Query execution3 = new Query(sub3);
	            Query execution4 = new Query(sub4);
	            Query execution5 = new Query(sub5);
	            Query execution6 = new Query(sub6);
	            
	            String secondSub1 = "assert(second_second_term_grade(dsa"+","+secondY2T_dsa.getText()+")).";
	            String secondSub2 = "assert(second_second_term_grade(ds2"+","+secondY2T_ds2.getText()+")).";
	            String secondSub3 = "assert(second_second_term_grade(hci_is"+","+secondY2T_hciis.getText()+")).";
	            String secondSub4 = "assert(second_second_term_grade(dbms"+","+secondY2T_dms.getText()+")).";
	            String secondSub5 = "assert(second_second_term_grade(nf"+","+secondY2T_nf.getText()+")).";
	            String secondSub6 = "assert(second_second_term_grade(elp4"+","+secondY2T_elp4.getText()+")).";
	    
	            Query secondExecution1 = new Query(secondSub1);
	            Query secondExecution2 = new Query(secondSub2);
	            Query secondExecution3 = new Query(secondSub3);
	            Query secondExecution4 = new Query(secondSub4);
	            Query secondExecution5 = new Query(secondSub5);
	            Query secondExecution6 = new Query(secondSub6);
	          
	            if (execution1.hasSolution() && execution2.hasSolution() && execution3.hasSolution() && execution4.hasSolution() && execution5.hasSolution() && execution6.hasSolution()
	            	&& secondExecution1.hasSolution() && secondExecution2.hasSolution() && secondExecution3.hasSolution() && secondExecution4.hasSolution() && secondExecution5.hasSolution() && secondExecution6.hasSolution()	
	            		) {
				root = FXMLLoader.load(Student_dialog_Controller.class.getResource("Student_dialog.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				
				stage.setScene(scene);
				
				stage.setTitle("Major Advisor");
				stage.setMaximized(true);
				stage.setResizable(false);
				stage.setX(450);
				stage.setY(370);
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
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Please fill correct information");
				alert.showAndWait();
				e1.printStackTrace();
			}	
		});
	}

}
