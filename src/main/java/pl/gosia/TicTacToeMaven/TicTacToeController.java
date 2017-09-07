package pl.gosia.TicTacToeMaven;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;

//import org.apache.log4j.BasicConfigurator;

//import com.sun.media.jfxmedia.logging.Logger;

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
import pl.gosia.TicTacToeMaven.Mark;

public class TicTacToeController implements Initializable {

	private static final int _sizeFont = 50;

	private static final int size = 200;

	@FXML
	private GridPane TicTacToeGrid;

	@FXML
	private Label namePlayer;

	private SolutionChecker logic = new Logic();
	private boolean flaga = false;

	public void initialize(URL location, ResourceBundle resources) {
		Main majority = new Main();
		namePlayer.setText(majority.createPopup(null));

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				Button bt = new Button("");
				bt.setMinSize(size, size);
				bt.setMaxSize(size, size);
				bt.setFont(new Font(_sizeFont));
				final int i1 = i;
				final int j1 = j;
				bt.setUserData(new Position(i1, j1));

				bt.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {

						Button clickedButton = (Button) event.getTarget();
						if (!"".equals(clickedButton.getText())) {
							return;
						}
						clickedButton.setText(Mark.from(start()).toString());

						if (logic.isWinning(clickedButton)) {
							showStage("Win" + clickedButton.getText());
						}
					}
				});

				TicTacToeGrid.add(bt, j, i);

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

	private boolean start() {
		return logic.start();
	}

}
