package pl.gosia.TicTacToeMaven;

import java.util.HashSet;

public class WinList extends HashSet<WinLine> {

	public WinList(int size) {

		WinLine.Builder descreasingDiagonal = WinLine.create();
		WinLine.Builder incrisingDiagonal = WinLine.create();
		for (int row = 0; row < size; row++) {
			WinLine.Builder rowCombination = WinLine.create();
			WinLine.Builder columnCombination = WinLine.create();

			for (int column = 0; column < size; column++) {
				rowCombination.position(Position.create().row(row).column(column).build());
				columnCombination.position(Position.create().row(column).column(row).build());

			}
			this.add(rowCombination.build());
			this.add(columnCombination.build());

			descreasingDiagonal.position(Position.create().row(row).column(row).build());
			incrisingDiagonal.position(Position.create().row(row).column((size - 1) - row).build());
		}
		this.add(descreasingDiagonal.build());
		this.add(incrisingDiagonal.build());
	}
}
