package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class TicTacToeController {

	@FXML
 private boolean start = true;



	@FXML
	public  void Steps(ActionEvent event) {
		Button clickedButton = (Button) event.getTarget();

        String buttonLabel = clickedButton.getText();
		if("".equals(buttonLabel) && start){
			clickedButton.setText("X");
			start = false;
		}else if("".equals(buttonLabel) && !start){
			clickedButton.setText("O");
			start = true;
		}
	}


}
