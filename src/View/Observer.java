package View;

import Util.Events;

public class Observer {
	private static Notify notifications = new Notify();
	private static Observer observer = null;
	
	private Observer() {}
	
	public static Observer getObserver() {
		if(observer == null)
			observer = new Observer();
		return observer;
	}
	
	public static void callEvent(Events event,Object o) {
		notifications.notify(event,o);
	}
	
}
