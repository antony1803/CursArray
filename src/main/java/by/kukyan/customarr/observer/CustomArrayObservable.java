package by.kukyan.customarr.observer;

public interface CustomArrayObservable {
    void attach(CustomCollectionObserver observer);

    void detach(CustomCollectionObserver observer);

    void notifyObserver();
}
