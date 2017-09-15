package com.lq.ren.base.ui.obs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author lqren on 17/9/14.
 * 被观察者当在改变发生时通知一个对象的观察者。
 * 调用notifyObservers()更新已注册的观察者。
 */

public class Observable<T> {

    List<Observer<T>> observers = new ArrayList<>();

    boolean changed = false;

    public Observable() {
    }

    public synchronized void addObserver(Observer<T> observer) {
        if (observer == null) {
            throw new NullPointerException("Add Observer == null");
        }
        if (observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public synchronized void deleteObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public synchronized void deleteObservers() {
        observers.clear();
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(T data) {
        int size = 0;
        Observer<T>[] arrays = null;
        if (hasChanged()) {
            clearChanged();
            size = observers.size();
            arrays = new Observer[size];
            observers.toArray(arrays);
        }
        if (arrays != null) {
            for (Observer<T> observer : arrays) {
                observer.update(this, data);
            }
        }
    }



    protected synchronized void setChanged() {

    }

    protected synchronized void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return observers.size();
    }

}
