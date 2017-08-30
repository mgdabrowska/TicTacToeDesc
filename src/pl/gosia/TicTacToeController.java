package pl.gosia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import pl.gosia.Mark;

public class TicTacToeController implements Initializable {

	private static final int _sizeFont = 50;

	private static final int size = 200;

	@FXML
	private GridPane TicTacToeGrid;

	@FXML
	private Label namePlayer;

	private SolutionChecker logic = new Logic();

	@Override
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
				bt.setUserData(new Integer[] { i1, j1 });

				bt.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

						Button clickedButton = (Button) event.getTarget();
						if (!"".equals(clickedButton.getText())) {
							return;
						}
						clickedButton.setText(Mark.from(start()).toString());

						logic.isWinning(clickedButton);
					}
				});

				TicTacToeGrid.add(bt, j, i);

			}

		}

	}

	private boolean start() {
		return logic.start();
	}

}
