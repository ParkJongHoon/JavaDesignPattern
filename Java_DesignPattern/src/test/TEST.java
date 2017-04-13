package test;

public class TEST {

	public static void main(String[] args) {
		String test = "year=1999";
		String result;
		String result2;
		int position;
		position = test.indexOf("=");
		result = test.substring(0, position);
		result2 = test.substring(position +1);
		
		System.out.println("result = " + result);
		System.out.println("result2 = " + result2);

	}

}
