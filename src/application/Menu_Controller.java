package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import javafx.animation.RotateTransition;
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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Menu_Controller implements Initializable {
	
	@FXML Circle c1, c2, c3;
	@FXML private Button exit_Btn;
	@FXML private Button start_Btn;
    

	
	
	int rotate = 0;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Start_UI();	
	}
	
	private void Start_UI() {
		SetRotate(c1, true, 360, 10);
		SetRotate(c2, true, 180, 18);
		SetRotate(c3, true, 145, 24);
		Button_Actions();
	}
	private void SetRotate(Circle c, boolean reverse, int angle, int duration) {
		RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
		
		rotateTransition.setAutoReverse(reverse);
		rotateTransition.setByAngle(angle);
		rotateTransition.setDelay(Duration.seconds(0));
		rotateTransition.setRate(3);
		rotateTransition.setCycleCount(18);
		rotateTransition.play();
	}
	private void Button_Actions() {
		exit_Btn.setOnAction(e -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Close confirmation");
			alert.setContentText("Are you sure do you want to exit?");

			alert.showAndWait().ifPresent(type -> {
				if (type == ButtonType.CANCEL) {
					e.consume();
				}else if(type == ButtonType.OK) {
					Platform.exit();
				}
			});
			
		});
		
		start_Btn.setOnAction( e -> {
			Parent root;
			try {

				String connection = "consult('main.pl')";
	            Query con = new Query(connection);
	            System.out.println(connection + "" + (con.hasMoreSolutions() ? "Success" : "Fail"));
	           
				String clear = "clear.";
				Query exec = new Query(clear);
				System.out.println(clear+" " + (exec.hasSolution()?"success" : "fail"));
				
				
				root = FXMLLoader.load(SecondYear_GPA_Controller.class.getResource("SecondYear_GPA.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("gpa.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Major Advisor");
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.setX(350);
				stage.setY(-10);
				exit_Btn.getScene().getWindow().hide();
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
