package mvc_02_conc;

public class Main {
  static public void main(String[] args) throws Exception {
	  
	MyModel model = new MyModel();
    
	MyGUIView view = new MyGUIView(model);
    view.attachToModel(model);
	view.display();
    
    /* first controller */
    
    MyController controller = new MyController(model);
	MyGUIInput inputGUI = new MyGUIInput();
	inputGUI.addObserver(controller);
	inputGUI.display();
	
	/* a second, autonomous controller */
	
	MyAutonomousController autController = new MyAutonomousController(model);
	autController.start();
	
  }
  
}
