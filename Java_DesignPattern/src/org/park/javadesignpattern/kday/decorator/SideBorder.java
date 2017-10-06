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
		// Display�� show()���� �ش� �޼ҵ带 ������
		// StringDisplay Ŭ�������� �ش� getRows�� ���� 1�� �����Ǿ�����
		// �׷��Ƿ� display.getRowText�ȿ� ���� ���ڰ��� 0�� �� string���� ��ȯ��
		return borderChar + display.getRowText(row)+ borderChar;
	}

}
