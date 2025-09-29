package mvc_01_with_extensions;

import mvc_01_basic.*;

public class Main {
  static public void main(String[] args) throws Exception {
	 
	/* Instantiating the model */
	  
	MyModel model = new MyModel();
	
	/* Attaching the views */

	MyConsoleView consoleView = new MyConsoleView();
    consoleView.attachToModel(model);
    
    MyGUIView view = new MyGUIView();
    view.attachToModel(model);

    /* Instantiating the controller with multiple views */
    
	MyController controller = new MyController(model);

    MyGUIInput inputUI = new MyGUIInput();
	inputUI.addObserver(controller);
	view.display();
	inputUI.display();

	MyConsoleInput input2 = new MyConsoleInput();
	input2.addObserver(controller);
	input2.startGettingInput();
  }	
  
}
