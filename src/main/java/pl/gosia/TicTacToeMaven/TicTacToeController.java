package pl.gosia.TicTacToeMaven;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeController implements Initializable {
	private static final int SIZE_TABLE = 4;

	@FXML
	public GridPane TicTacToeGrid;
	@FXML
	public Label namePlayer;


	public void initialize(URL location, ResourceBundle resources) {
		Main majority = new Main();
		namePlayer.setText(majority.createPopup(null));

		for (int row = 0; row < SIZE_TABLE; row++) {

			for (int column = 0; column < SIZE_TABLE; column++) {

				Button bt = CreateButton.createButton(row, column);

				TicTacToeGrid.add(bt, column, row);

			}

		}

	}

	public static void showStage(String info) {
		Stage newStage = new Stage();
		VBox comp = new VBox();
		Label lb = new Label(info);
		lb.setFont(new Font("Arial", 90));
		lb.setMaxWidth(Double.MAX_VALUE);
		lb.setAlignment(Pos.CENTER);

		comp.getChildren().add(lb);

		Scene stageScene = new Scene(comp, 350, 150);
		newStage.setScene(stageScene);
		newStage.show();
		newStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	}

}
