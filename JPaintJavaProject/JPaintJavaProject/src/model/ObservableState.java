package model;

public class ObservableState extends java.util.Observable {

    public ObservableState() { }

    public void uiStateChange (Object object2) {
        System.out.println("uiStateChange ....\n");
        setChanged();
        notifyObservers(object2);
    }

}