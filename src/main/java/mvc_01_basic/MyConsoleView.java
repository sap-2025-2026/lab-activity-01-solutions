package mvc_01_basic;

/**
 * 
 * A Console View component.
 * 
 * It is an observer of the model.
 * 
 */
public class MyConsoleView implements ModelObserver {

	private ModelObserverSource model;
	
	public MyConsoleView() {}
	
	public void attachToModel(ModelObserverSource model) {
		this.model = model;		
	    model.addObserver(this);	    
	}

	public void notifyModelUpdated() {
		log("New state: " + model.getState());
	}
		
	private void log(String msg) {
		System.out.println("[Console View] " + msg);
	}
	
}
