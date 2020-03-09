package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Student_dialog_Controller implements Initializable {

	

    @FXML
    private Button cs_Btn;
    
    public static String student_type;

    @FXML
    private Button ct_Btn;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Button_Actions();
		
	}
	
	private void Button_Actions() {
		cs_Btn.setOnAction( e -> {
			student_type = "cs";
			Parent root;
			try {
				
				root = FXMLLoader.load(ThirdYearCS_GPA_Controller.class.getResource("ThirdYearCS_GPA.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("gpa.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Major Advisor");
				stage.setMaximized(true);
				stage.setResizable(false);
				stage.setX(350);
				
				cs_Btn.getScene().getWindow().hide();
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
		
		
		ct_Btn.setOnAction( e -> {
			student_type = "ct";
			Parent root;
			try {
				root = FXMLLoader.load(ThirdYearCT_GPA_Controller.class.getResource("ThirdYearCT_GPA.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("gpa.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Major Advisor");
				stage.setMaximized(true);
				stage.setResizable(false);
				stage.setX(350);
				
				ct_Btn.getScene().getWindow().hide();
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

}
