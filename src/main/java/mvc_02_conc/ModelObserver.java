package mvc_02_conc;

public interface ModelObserver {

	void attachToModel(ModelObserverSource source);

	void notifyModelUpdated();
}
