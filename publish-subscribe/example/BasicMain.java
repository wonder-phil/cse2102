package example;

public class BasicMain {
	
	public static void main(String[] args) {
		
		Subject subject = new Subject();
		
		SimpleObserver simpleObserver1 = new SimpleObserver(subject, "one");
		SimpleObserver simpleObserver2 = new SimpleObserver(subject, "two");
		SimpleObserver simpleObserver3 = new SimpleObserver(subject, "three");
		
		subject.setState(3);
		subject.setState(5);
	}
}
