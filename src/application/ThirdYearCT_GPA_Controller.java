package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpl7.Query;

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

public class ThirdYearCT_GPA_Controller implements Initializable {
	
	
	@FXML private Button gpa_Btn;
	@FXML private Button continue_Btn;
	
	@FXML
	private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;
	
	
    @FXML
    private JFXTextField thirdY1T_ct_ai;

    @FXML
    private JFXTextField thirdY1T_ct_em;

    @FXML
    private JFXTextField thirdY1T_ct_an;

    @FXML
    private JFXTextField thirdY1T_ct_ca;

    @FXML
    private JFXTextField thirdY1T_ct_sre;

    @FXML
    private JFXTextField thirdY1T_ct_ecs;

    @FXML
    private JFXTextField thirdY1T_ct_plp;

    @FXML
    private JFXTextField thirdY1T_ct_co;

    @FXML
    private JFXTextField thirdY1T_ct_lans;

    @FXML
    private JFXTextField thirdY1T_ct_mpee;

    @FXML
    private JFXTextField thirdY1T_ct_nde;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Button_Actions();
		
	}
	
	
	private void Button_Actions() {
		
		gpa_Btn.setOnAction( e -> {
			
			BoxBlur blur = new BoxBlur(1,1,1);
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
				String connection = "consult('main.pl')";
	            Query con = new Query(connection);
	            System.out.println(connection + "" + (con.hasMoreSolutions() ? "Success" : "Fail"));
	          
	            String connection1 = "consult('calculate_threshold.pl')";
	            Query con1 = new Query(connection1);
	            System.out.println(connection1 + "" + (con1.hasMoreSolutions() ? "Success" : "Fail"));
	            
	            String sub1 = "assert(third_cs_first_term_grade(ai"+","+thirdY1T_ct_ai.getText()+")).";
	            String sub2 = "assert(third_cs_first_term_grade(em"+","+thirdY1T_ct_em.getText()+")).";
	            String sub3 = "assert(third_cs_first_term_grade(an"+","+thirdY1T_ct_an.getText()+")).";
	            String sub4 = "assert(third_cs_first_term_grade(ca"+","+thirdY1T_ct_ca.getText()+")).";
	            String sub5 = "assert(third_cs_first_term_grade(sre"+","+thirdY1T_ct_sre.getText()+")).";
	            String sub6 = "assert(third_cs_first_term_grade(awt"+","+thirdY1T_ct_ecs.getText()+")).";
	            
	            Query execution1 = new Query(sub1);
	            Query execution2 = new Query(sub2);
	            Query execution3 = new Query(sub3);
	            Query execution4 = new Query(sub4);
	            Query execution5 = new Query(sub5);
	            Query execution6 = new Query(sub6);
	            
	            
	            if (execution1.hasSolution() && execution2.hasSolution() && execution3.hasSolution() && execution4.hasSolution() && execution5.hasSolution() && execution6.hasSolution()) {
				root = FXMLLoader.load(InterestLevel_CT_Controller.class.getResource("InterestLevel_CT.fxml"));
				Stage stage = new Stage();
				
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("gpa.css").toExternalForm());
				stage.setScene(scene);
				
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
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		});
	}

}
