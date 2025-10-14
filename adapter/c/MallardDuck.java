package c;

/*
 * From:
 * Eric and Elizabeth Freeman: Head first design patterns, O'Reilly 2004
 * 
 */

public class MallardDuck implements Duck {
	public void quack() {
		System.out.println("Mallard Duck: quack!");
	}
	public void fly() {
		System.out.println("I am a flying Mallard Duck!");
	}
}
