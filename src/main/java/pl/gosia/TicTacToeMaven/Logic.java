package pl.gosia.TicTacToeMaven;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.control.Button;

public class Logic implements SolutionChecker {
	private static final int SIZE = 4;
	private final static Logger logger = LoggerFactory.getLogger(Logic.class.getName());
	private WinList winList = new WinList(SIZE);

	private Set<Position> positionX = new HashSet<Position>();
	private Set<Position> positionO = new HashSet<Position>();

	public Set<Position> position(boolean start) {
		return start ? positionX : positionO;
	}

	public boolean start() {
		return (positionX.size() <= positionO.size());
	}

	public boolean isWinning(Button clickedButton) {

		Set<Position> position = position(start());
		position.add((Position) clickedButton.getUserData());

		logger.info("pozycja " + clickedButton.getText() + " " + position);
		if (position.size() < SIZE) {
			return false;
		}

		for (WinLine list : winList) {
			logger.info(" pozycja" + position);
			if (position.containsAll(list)) {
				logger.info("WIN " + clickedButton.getText());
				return true;
			}

		}
		return false;

	}

}
