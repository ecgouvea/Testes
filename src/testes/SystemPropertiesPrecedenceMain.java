package testes;

public class SystemPropertiesPrecedenceMain {

	public static void main(String[] args) {
		System.out.println("getenv=" + System.getenv());
		System.out.println("getProperties=" + System.getProperties());
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println("prop1=" + System.getProperty("prop1"));
	}
}
