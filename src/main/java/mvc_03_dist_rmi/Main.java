package mvc_03_dist_rmi;

import mvc_01_basic.*;
import mvc_01_with_extensions.*;

public class Main {
  static public void main(String[] args) throws Exception {
	  
	MyModel model = new MyModel();
	
    MyGUIView view = new MyGUIView();
    view.attachToModel(model);
    
    MyGUIInput inputUI = new MyGUIInput();
	MyController controller = new MyController(model);
	inputUI.addObserver(controller);
	view.display();
	inputUI.display();

	/* adding a remote view */
	
	MyRemoteViewProxy remoteViewProxy = new MyRemoteViewProxy();
	remoteViewProxy.attachToModel(model);
	
  }	
  
}
