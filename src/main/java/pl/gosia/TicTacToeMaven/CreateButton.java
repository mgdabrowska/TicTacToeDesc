package pl.gosia.TicTacToeMaven;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class CreateButton {

	private static final int SIZE_FONT = 50;

	private static final int SIZE = 200;

	private static SolutionChecker logic = new Logic();

	public static Button createButton(int row, int column) {
		Button bt = new Button("");
		bt.setMinSize(SIZE, SIZE);
		bt.setMaxSize(SIZE, SIZE);
		bt.setFont(new Font(SIZE_FONT));
		bt.setUserData(Position.create().row(row).column(column).build());
		bt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Button clickedButton = (Button) event.getTarget();
				if (!"".equals(clickedButton.getText())) {
					return;
				}
				clickedButton.setText(Mark.from(start()).toString());

				if (logic.isWinning(clickedButton)) {
					TicTacToeController.showStage("Win" + clickedButton.getText());
				}
			}
		});
		return bt;
	}

	private static boolean start() {
		return logic.start();
	}

}
