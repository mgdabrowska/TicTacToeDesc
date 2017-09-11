package pl.gosia.TicTacToeMaven;

import javafx.geometry.Pos;
import javafx.util.Builder;

public class Position {

	int row;
	int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
//private Position(Builder builder) {
	//this.row = builder.row;
	//this.column = builder.column;
//}
	@Override
	public String toString() {
		String s1 = String.format("%d", row);
		String s2 = String.format("%d", column);
		return "[" + s1 + ", " + s2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + row;
		result = prime * result + column;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Position other = (Position) obj;
		return (!(obj instanceof Position)) || Double.compare(row, other.row) == 0 && Double.compare(column, other.column) == 0;
	}

	public int getX() {
		return row;
	}

	public int getY() {
		return column;
	}


	//public static class Builder {
	//	private int row;
	//	 private int column;
	//	 private Position position = new Position();

	/*public Builder row( int row){
		position.row = row;
		return this;
	}
	public Builder column( int column){
		position.column = column;
		return this;
	}
	 public Position build() {
		 return position;
	 }*/

	//}


}
