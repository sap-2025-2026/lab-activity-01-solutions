package mvc_02_conc;

import mvc_01_basic.ModelInterface;

public interface ModelObserverSource extends ModelInterface {

	void addObserver(ModelObserver obs);

}
