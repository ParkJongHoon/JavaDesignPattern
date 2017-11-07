package tools.runtime;

public class RunTimeCheck {
	public RunTimeCheck() {
		Runtime.getRuntime().gc();
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("사용 메모리= " + used);
	}
}
