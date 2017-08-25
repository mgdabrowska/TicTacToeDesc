package pl.gosia;

public enum Mark {
	X("X"), O("O");

	private String sign;

	Mark(String sign) {
		this.sign = sign;
	}

	public static Mark from(boolean isCross) {
		return isCross ? X : O;
	}

	public String toString() {
		return sign;
	}
}
