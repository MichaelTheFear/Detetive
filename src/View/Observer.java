package View;

import Util.Events;
import Util.ObserverCallback;

public class Observer {
	private static Notify notifications;
	private static Observer observer = null;
	
	private Observer() {
		notifications = new Notify();
	}
	
	public static Observer getObserver() {
		if(observer == null)
			observer = new Observer();
		return observer;
	}
	
	public void callEvent(Events event,Object o) {
		notifications.notify(event,o);
	}
	
	public void susbcribe(Events eve, ObserverCallback callback) {
		notifications.subscribe(eve, callback);
	}
	
	public void unsubscribe(Events event, ObserverCallback action) {
		notifications.unsubscribe(event,action);
	}
	
}

/*
 * functio
 */
