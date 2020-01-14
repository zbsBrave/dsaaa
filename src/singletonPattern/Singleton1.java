package singletonPattern;

public class Singleton1 {
	private static Singleton1 sg = new Singleton1();
	private Singleton1() {
		
	}
	public Singleton1 getSingleton1() {
		return sg;
	}
}
