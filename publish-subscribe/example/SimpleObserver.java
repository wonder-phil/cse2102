package example;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer {
	
	private String name;
	private Subject subject;
	
	public SimpleObserver(Subject subject, String name) {
		this.subject = subject;
		this.subject.attach(this);
		
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("SimpleObserver " + name + " sees: " + Integer.toString(subject.getState()));	
	}
}
