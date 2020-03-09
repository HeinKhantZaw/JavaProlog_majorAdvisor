package application;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.ResourceBundle;

import org.jpl7.Query;
import org.jpl7.Term;

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
		
		String BIS = "BIS is a set of inter-related procedures using IT infrastructure in a business enterprise to generate and disseminate desired information";
		String SE = "SE is a process of analyzing user requirements and then designing, building, and testing software application which will satisfy those requirements.";
		String HPC = "HPC is the ability to process data and perform complex calculations at high speeds and the use of super computers and parallel processing techniques for solving complex computational problems";
		String KE = "KE is a field of AI, creating rules that apply to data in order to imitate the way a human thinks and approaches problems.";
		String CN = "CN is an engineering discipline that aims to study and analyze the communication process among various computing devices or computer systems that are linked, or networked, together to exchange information and share resources.";
		String ES = "ES is a combination of computer hardware and software, either fixed in capability or programmable, designed for a specific function or functions within a larger system.";
		
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
       
        String showMajor = "show_majors.";
        Query execSM = new Query(showMajor);
        execSM.hasSolution();
        String ke = "should_take(knowledge_engineering,X,Y)";
        String se = "should_take(software_engineering,X,Y)";
        String bis = "should_take(business_information_system,X,Y)";
        String hpc = "should_take(high_performance_computing,X,Y)";
        String cn = "should_take(computer_networking,X,Y)";
        String es = "should_take(embedded_systems,X,Y)";
        
        Query execKE = new Query(ke);
        Query execSE = new Query(se);
        Query execBIS = new Query(bis);
        Query execHPC = new Query(hpc);
        Query execCN = new Query(cn);
        Query execES = new Query(es);
        ArrayList<String> subjectTitle = new ArrayList<String>();
        ArrayList<String> subjectDescription = new ArrayList<String>();
        
        if(execKE.hasSolution()) {
        	subjectTitle.add(execKE.oneSolution().get("X").toString());
        	subjectDescription.add(execKE.oneSolution().get("Y").toString());
        }
        if(execSE.hasSolution()) {
        	subjectTitle.add(execSE.oneSolution().get("X").toString());
        	subjectDescription.add(execSE.oneSolution().get("Y").toString());
            }
        if(execBIS.hasSolution()) {
        	subjectTitle.add(execBIS.oneSolution().get("X").toString());
        	subjectDescription.add(execBIS.oneSolution().get("Y").toString());
            }
        if(execHPC.hasSolution()) {
        	subjectTitle.add(execHPC.oneSolution().get("X").toString());
        	subjectDescription.add(execHPC.oneSolution().get("Y").toString());
            }
        if(execCN.hasSolution()) {
        	subjectTitle.add(execCN.oneSolution().get("X").toString());
        	subjectDescription.add(execCN.oneSolution().get("Y").toString());
            }
        if(execES.hasSolution()) {
        	subjectTitle.add(execES.oneSolution().get("X").toString());
        	subjectDescription.add(execES.oneSolution().get("Y").toString());
            }
        for(String a : subjectTitle){
        	   majors_TArea.appendText(a + "\n");
        	}
        switch (subjectDescription.size()) {
		case 1:
			major1_label.setText(subjectTitle.get(0));
			major1_descrp_TArea.setText(subjectDescription.get(0));
			break;
		case 2:
			major1_label.setText(subjectTitle.get(0));
			major1_descrp_TArea.setText(subjectDescription.get(0));
			major2_label.setText(subjectTitle.get(1));
			major2_descrp_TArea.setText(subjectDescription.get(1));
			
			break;
		case 3:
			major1_label.setText(subjectTitle.get(0));
			major1_descrp_TArea.setText(subjectDescription.get(0));
			major2_label.setText(subjectTitle.get(1));
			major2_descrp_TArea.setText(subjectDescription.get(1));
			major3_label.setText(subjectTitle.get(2));
			major3_descrp_TArea.setText(subjectDescription.get(2));
			
			break;
		case 4:
			major1_label.setText(subjectTitle.get(0));
			major1_descrp_TArea.setText(subjectDescription.get(0));
			major2_label.setText(subjectTitle.get(1));
			major2_descrp_TArea.setText(subjectDescription.get(1));
			major3_label.setText(subjectTitle.get(2));
			major3_descrp_TArea.setText(subjectDescription.get(2));
			major4_label.setText(subjectTitle.get(3));
			major4_descrp_TArea.setText(subjectDescription.get(3));
			
			
			break;
		default:
			major1_label.setText("No subjects to show :(");
			break;
		}
        execKE.close();
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
