package pl.gosia.TicTacToeMaven;

import javafx.scene.control.Button;

public interface SolutionChecker {
	boolean isWinning(Button button);

	boolean start();
}