package model;

import java.util.*;


public class ObserveState implements Observer {
    ObservableState observableState;
    ConShape config;

    public ObserveState(ObservableState observableState) {
          this.observableState = observableState;
          observableState.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.toString());
        config = new ConShape();
        if (arg == "ShapeChange") {
            config.UpdateShape();
        }else if (arg == "PriColorChange") {
            config.UpdatePriColor();
        }else if (arg == "SecColorChange") {
            config.UpdateSecColor();
        }else if (arg == "ShadeChange") {
            config.UpdateShading();
        }
    }
}
//private List<Observer> observers = new ArrayList<Observer>();
//private int state;
//
//public int getState() {
//   return state;
//}
//
//public void setState(int state) {
//   this.state = state;
//   notifyAllObservers();
//}
//
//public void attach(Observer observer){
//   observers.add(observer);		
//}
//
//public void notifyAllObservers(){
//   for (Observer observer : observers) {
//      observer.update();
