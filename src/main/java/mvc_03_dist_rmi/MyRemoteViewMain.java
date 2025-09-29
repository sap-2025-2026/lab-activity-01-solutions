package mvc_03_dist_rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * Remote view main.
 * 
 * Warning: RMIRegistry must be installed on the classpath.
 * 
 * 
 */
public class MyRemoteViewMain {

	public static void main(String[] argv) throws Exception {
		try {
			MyRemoteView view = new MyRemoteView();
			view.display();
			Remote viewStub = UnicastRemoteObject.exportObject(view, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("remote-view", viewStub);
			System.out.println("Remote view registered.");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
