package pl.gosia;

import javafx.scene.control.Button;

public interface SolutionChecker {
	boolean isWinning(Button button);
	boolean start();
}