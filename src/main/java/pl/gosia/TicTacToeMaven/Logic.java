package pl.gosia.TicTacToeMaven;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.logging.Logger;

import javafx.scene.control.Button;

public class Logic implements SolutionChecker {
	private final static Logger LOGGER = Logger.getLogger(Logic.class.getName());
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

		LOGGER.info("pozycja " + clickedButton.getText() + " " + position);
		if (position.size() < 3) {
			return false;
		}

		for (List<List<Integer>> list : winList) {
			if (position.containsAll(list)) {
				LOGGER.info("WIN " + clickedButton.getText());

				return true;
			}
		}
		return false;
	}

}
