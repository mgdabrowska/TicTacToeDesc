package pl.gosia.TicTacToeMaven;

import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private static final String TIC_TAC_TOE_FXML = "/TicTacToe.fxml";
	private static final String TITLE = "Please enter your name:";
	private static final String HEADER = "Choose player";
	private static final String CONTENT = "Text Input Dialog";
	public String DEFAULT_USER = "Gosia";

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(TIC_TAC_TOE_FXML));
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

			dialog.setTitle(TITLE);
			dialog.setHeaderText(HEADER);
			dialog.setContentText(CONTENT);
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent())
				DEFAULT_USER = result.get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return DEFAULT_USER;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
