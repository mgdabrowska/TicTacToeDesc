package pl.gosia;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TicTacToeController implements Initializable {

	@FXML
	private GridPane TicTacToeGrid;

	private boolean start = true;
	List<List<List<Integer>>> winList = Arrays.asList(
			Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(0, 2)),
			Arrays.asList(Arrays.asList(1, 0), Arrays.asList(1, 1), Arrays.asList(1, 2)),
			Arrays.asList(Arrays.asList(2, 0), Arrays.asList(2, 1), Arrays.asList(2, 2)),
			Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 0)),
			Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1)),
			Arrays.asList(Arrays.asList(0, 2), Arrays.asList(1, 2), Arrays.asList(2, 2)),
			Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 1), Arrays.asList(2, 2)),
			Arrays.asList(Arrays.asList(0, 2), Arrays.asList(1, 1), Arrays.asList(2, 0)));

	Set<List<Integer>> positionX = new HashSet<List<Integer>>();
	Set<List<Integer>> positionO = new HashSet<List<Integer>>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				Button bt = new Button("");
				bt.setMinSize(200, 200);
				bt.setMaxSize(200, 200);
				bt.setFont(new Font(50));
				final int i1 = i;
				final int j1 = j;
				bt.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Button clickedButton = (Button) event.getTarget();

						String buttonLabel = clickedButton.getText();
						if ("".equals(buttonLabel) && start) {

							clickedButton.setText("X");
							positionX.add(Arrays.asList(j1, i1));
							System.out.println("pozycja X " + positionX);
							if (positionX.size() >= 3) {
								for (List<List<Integer>> list : winList) {
									if (positionX.containsAll(list)) {
										System.out.println("WIN X");

										// bt.setStyle("-fx-background-color:
										// #ff0000; ");
										break;
									}
								}
							}

							start = false;
						} else if ("".equals(buttonLabel) && !start) {
							clickedButton.setText("O");
							positionO.add(Arrays.asList(j1, i1));
							System.out.println("pozycja 0 " + positionO);
							if (positionO.size() >= 3) {
								for (List<List<Integer>> list : winList) {
									if (positionO.containsAll(list)) {
										System.out.println("WIN O");
										// bt.setStyle("-fx-background-color:
										// #ff0000; ");
										break;
									}
								}
							}
							start = true;
						}

					}
				});

				TicTacToeGrid.add(bt, j, i);

			}

		}

	}

}
