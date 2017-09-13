package pl.gosia.TicTacToeMaven;

import java.util.ArrayList;
import java.util.List;

public class WinLine extends ArrayList<Position> {

	public WinLine(List<Position> list) {
		super(list);
	}

	private WinLine() {
	}

	public static Builder create() {
		return new Builder();
	}

	public static class Builder {
		private WinLine list = new WinLine();

		public Builder setList(List<Position> list) {

			this.list = (WinLine) list;
			return this;
		}

		public WinLine build() {
			return new WinLine(list);
		}

		public void position(Position build) {
			list.add(build);

		}

	}

}