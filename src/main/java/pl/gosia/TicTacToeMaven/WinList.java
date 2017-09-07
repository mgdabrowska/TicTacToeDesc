package pl.gosia.TicTacToeMaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WinList extends HashSet<WinLine> {

	public WinList() {

		addAll(Arrays.asList(new WinLine(Arrays.asList(new Position(0, 0), new Position(0, 1), new Position(0, 2))),
				new WinLine(Arrays.asList(new Position(1, 0), new Position(1, 1), new Position(1, 2))),
				new WinLine(Arrays.asList(new Position(2, 0), new Position(2, 1), new Position(2, 2))),
				new WinLine(Arrays.asList(new Position(0, 0), new Position(1, 0), new Position(2, 0))),
				new WinLine(Arrays.asList(new Position(0, 1), new Position(1, 1), new Position(2, 1))),
				new WinLine(Arrays.asList(new Position(0, 2), new Position(1, 2), new Position(2, 2))),
				new WinLine(Arrays.asList(new Position(0, 0), new Position(1, 1), new Position(2, 2))),
				new WinLine(Arrays.asList(new Position(0, 2), new Position(1, 1), new Position(2, 0)))));

	}

}
