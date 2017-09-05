package pl.gosia.TicTacToeMaven;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Logic implements SolutionChecker {
	private final static Logger logger = LoggerFactory.getLogger(Logic.class.getName());
	private List<List<List<Integer>>> winList = Arrays.asList(
			Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(0, 2)),
			Arrays.asList(Arrays.asList(1, 0), Arrays.asList(1, 1), Arrays.asList(1, 2)),
			Arrays.asList(Arrays.asList(2, 0), Arrays.asList(2, 1), Arrays.asList(2, 2)),
			Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 0)),
			Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1)),
			Arrays.asList(Arrays.asList(0, 2), Arrays.asList(1, 2), Arrays.asList(2, 2)),
			Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 1), Arrays.asList(2, 2)),
			Arrays.asList(Arrays.asList(0, 2), Arrays.asList(1, 1), Arrays.asList(2, 0)));

	private Set<List<Integer>> positionX = new HashSet<List<Integer>>();
	private Set<List<Integer>> positionO = new HashSet<List<Integer>>();

	public Set<List<Integer>> position(boolean start) {
		return start ? positionX : positionO;
	}

	public boolean start() {
		return (positionX.size() <= positionO.size());
	}

	public boolean isWinning(Button clickedButton) {

		Set<List<Integer>> position = position(start());
		position.add(Arrays.asList((Integer[]) clickedButton.getUserData()));

		logger.info("pozycja " + clickedButton.getText() + " " + position);
		if (position.size() < 3) {
			return false;
		}

		for (List<List<Integer>> list : winList) {
			if (position.containsAll(list)) {

				logger.info("WIN " + clickedButton.getText());
				showStage("WIN " + clickedButton.getText());

				// System.exit(0);

				return true;
			}

		}
		return false;

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
