package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpl7.Query;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import animatefx.animation.Swing;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import animatefx.animation.*;

public class Analyzing_Loader_Controller implements Initializable {

	
	@FXML private Label w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14, w15, w16, w17, w18, w19, wSpace;
	@FXML private Circle sc1, sc2, sc3, sc4, sc5, sc6;
	
	@FXML
    private Button continue_Btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		continue_Btn.setVisible(false);
		Button_Actions();
		Analying_UI();
		
	}
	private void Analying_UI() {
		
		new FadeIn(w1).setCycleCount(3).setDelay(Duration.valueOf("500ms")).play();
		new FadeIn(w2).setCycleCount(3).setDelay(Duration.valueOf("600ms")).play();
		new FadeIn(w3).setCycleCount(3).setDelay(Duration.valueOf("700ms")).play();
		new FadeIn(w4).setCycleCount(3).setDelay(Duration.valueOf("800ms")).play();
		new FadeIn(w5).setCycleCount(3).setDelay(Duration.valueOf("900ms")).play();
		new FadeIn(w6).setCycleCount(3).setDelay(Duration.valueOf("1000ms")).play();
		new FadeIn(w7).setCycleCount(3).setDelay(Duration.valueOf("1100ms")).play();
		new FadeIn(w8).setCycleCount(3).setDelay(Duration.valueOf("1200ms")).play();
		new FadeIn(w9).setCycleCount(3).setDelay(Duration.valueOf("1300ms")).play();
		new FadeIn(w10).setCycleCount(3).setDelay(Duration.valueOf("1400ms")).play();
		new FadeIn(w11).setCycleCount(3).setDelay(Duration.valueOf("1500ms")).play();
		new FadeIn(w12).setCycleCount(3).setDelay(Duration.valueOf("1600ms")).play();
		new FadeIn(w13).setCycleCount(3).setDelay(Duration.valueOf("1700ms")).play();
		new FadeIn(w14).setCycleCount(3).setDelay(Duration.valueOf("1800ms")).play();
		
		new Swing(w15).setCycleCount(3).setDelay(Duration.valueOf("1900ms")).play();
		new Swing(w16).setCycleCount(3).setDelay(Duration.valueOf("2000ms")).play();
		new Swing(w17).setCycleCount(3).setDelay(Duration.valueOf("2100ms")).play();
		
		
		
		new Bounce(sc1).setCycleCount(3).setDelay(Duration.valueOf("500ms")).play(); 
		new Bounce(sc2).setCycleCount(3).setDelay(Duration.valueOf("600ms")).play(); 
		new Bounce(sc3).setCycleCount(3).setDelay(Duration.valueOf("700ms")).play();
		new Bounce(sc4).setCycleCount(3).setDelay(Duration.valueOf("800ms")).play();
		new Bounce(sc5).setCycleCount(3).setDelay(Duration.valueOf("900ms")).play();
		new Bounce(sc6).setCycleCount(3).setDelay(Duration.valueOf("1000ms")).play();
		
		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	continue_Btn.setVisible(true);
		            	
		            	Platform.runLater(()->{
		            	    w1.setText("F");
			            	w2.setText("i");
			            	w3.setText("n");
			            	w4.setText("i");
			            	w5.setText("s");
			            	w6.setText("h");
			            	w7.setText("e");
			            	w8.setText("d");
			            	w9.setText(""); 
			            	
			            	wSpace.setText("A"); 
			            	wSpace.setTextFill(Color.web("#ffc12e"));

			            	w10.setText("n");
			            	w10.setTextFill(Color.web("#ffc12e"));
			            	
			            	w11.setText("a"); 
			            	w11.setTextFill(Color.web("#ffc12e"));
			            	
			            	w12.setText("l");
			            	w12.setTextFill(Color.web("#ffc12e"));
			            	
			            	w13.setText("y"); 
			            	w13.setTextFill(Color.web("#ffc12e"));
			            	
			            	w14.setText("z"); 
			            	w14.setTextFill(Color.web("#ffc12e"));
			            	
			            	w15.setText("i");
			            	w15.setTextFill(Color.web("#ffc12e"));
			            	
			            	w16.setText("n");
			            	w16.setTextFill(Color.web("#ffc12e"));
			            	
			            	w17.setText("g");
			            	w17.setTextFill(Color.web("#ffc12e"));
			            	
			          

		            	});
		            		
		            }
		        }, 
		        4300 
		);
		
		
	}
	private void Button_Actions() {
		continue_Btn.setOnAction( e -> {
			Parent root;
			try {
	            
				root = FXMLLoader.load(Output_Controller.class.getResource("Output.fxml"));
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
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		});
	}
}
