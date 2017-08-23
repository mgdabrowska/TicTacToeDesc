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

public class TicTacToeController implements Initializable {

	@FXML
	private GridPane TicTacToeGrid;

	private boolean start = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TicTacToeGrid.getChildren().add(new Label(""));
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				Button bt = new Button("");
				bt.setMinSize(200, 200);
				bt.setMaxSize(200, 200);
				bt.setFont(new Font(50));
				bt.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Button clickedButton = (Button) event.getTarget();

						String buttonLabel = clickedButton.getText();
						if ("".equals(buttonLabel) && start) {
							
							clickedButton.setText("X");
							start = false;
						} else if ("".equals(buttonLabel) && !start) {
							clickedButton.setText("O");
							start = true;
						}

					}
				});
				TicTacToeGrid.add(bt, j, i);
				
			}

		}

	}

}
