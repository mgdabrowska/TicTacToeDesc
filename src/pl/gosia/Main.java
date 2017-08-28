package pl.gosia;

import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TextInputDialog dialog = new TextInputDialog("Gosia");
			dialog.setTitle("Text Input Dialog");
			dialog.setHeaderText("Choose player");
			dialog.setContentText("Please enter your name:");

			// Traditional way to get the response value.
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				result.ifPresent(name -> System.out.println("Your name: " + name));
			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/pl/gosia/TicTacToe.fxml"));
			Scene scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
