package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;
	
	public int getState() {
		return state;
	}
	
	public void setState(int update) {
		state = update;
		notifyObservers();
	}
	
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObservers()
	{
		for (Observer observer : observers) {
			observer.update(null, observer);
		}
	}
}
