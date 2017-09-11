package pl.gosia.TicTacToeMaven;

import java.util.Optional;

import org.apache.log4j.BasicConfigurator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private static final String Title = "Please enter your name:";
	private static final String Header = "Choose player";
	private static final String Content = "Text Input Dialog";
	public String nazwa = "Gosia";

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getClassLoader().getResource("TicTacToe.fxml"));
			Scene scene = new Scene(root, 600, 700);

			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String createPopup(Stage primaryStage) {

		try {
			TextInputDialog dialog = new TextInputDialog("Gosia");

			dialog.setTitle(Title);
			dialog.setHeaderText(Header);
			dialog.setContentText(Content);
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent())
				nazwa = result.get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nazwa;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
