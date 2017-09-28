package pl.gosia.TicTacToeMaven;


import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class PropertiesOfButton {

	private static final int SIZE_FONT = 10;
	 private static int size=3;
	private static final int SIZE = 600/size;

	public static Button createButton() {
		Button bt = new Button("");
		bt.setMinSize(SIZE, SIZE);
		bt.setMaxSize(SIZE, SIZE);
		bt.setFont(new Font(SIZE_FONT));

		return bt;
	}



}
