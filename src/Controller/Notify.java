package Controller;

import Util.ObserverCallback;
import java.util.ArrayList;
import java.util.HashMap;

import Util.Events;

class Notify {
	private HashMap<Events,ArrayList<ObserverCallback>> observer;
	
	public Notify () {
		observer = new HashMap<>();
		for(Events event : Events.values()) {
			observer.put(event, new ArrayList<>());
		}
	}
	
	public void subscribe(Events event, ObserverCallback action) {
		observer.get(event).add(action);
	}
	
	public void unsubscribe(Events event, ObserverCallback action) {
		observer.get(event).remove(action);
	}
	
	public void notify(Events event,Object o) {
		for(ObserverCallback e: observer.get(event)) {
			e.onCall(o);
		}
	}
	
}
