package mvc_01_basic;

public class Main {
  static public void main(String[] args) throws Exception {
	  
	/* Instantiating the model */  
	MyModel model = new MyModel();
	
	/* Attaching the view(s) to the model */
    MyConsoleView consoleView = new MyConsoleView();
    consoleView.attachToModel(model);
    
    /* Instantiating the controller */
    MyController controller = new MyController(model);
    MyGUIInput inputUI = new MyGUIInput();
	inputUI.addObserver(controller);
	inputUI.display();
  }	
  
}
