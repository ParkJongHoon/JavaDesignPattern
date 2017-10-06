package org.park.javadesignpattern.kday.decorator;

public class SideBorder extends Border {
	private char borderChar;
	public SideBorder(Display display, char ch) {
		super(display);
		this.borderChar = ch;
	}

	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}

	@Override
	public int getRows() {
		return display.getRows();
	}

	@Override
	public String getRowText(int row) {
		// Display의 show()에서 해당 메소드를 실행함
		// StringDisplay 클래스에서 해당 getRows의 값이 1로 고정되어있음
		// 그러므로 display.getRowText안에 들어가는 인자값은 0일 때 string값을 반환함
		return borderChar + display.getRowText(row)+ borderChar;
	}

}
