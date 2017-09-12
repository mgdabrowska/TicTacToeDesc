package pl.gosia.TicTacToeMaven;

import java.util.HashSet;

public class WinList extends HashSet<WinLine> {

	public WinList(int size) {

		for (int row = 0; row < size; row++) {
			WinLine.Builder builder = WinLine.create();
			for (int column = 0; column < size; column++) {
				builder.position(Position.create().row(row).column(column).build());
				builder.position(Position.create().column(column).row(row).build());
				builder.position(Position.create().row(row).row(row).build());
				builder.position(Position.create().row(row).column(size-row).build());
			}

			this.add(builder.build());
		}

	}

}