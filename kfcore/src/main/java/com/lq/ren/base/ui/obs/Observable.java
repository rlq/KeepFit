package com.lq.ren.base.ui.obs;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    List<Observer<T>> observers = new ArrayList<>();

    boolean changed = false;

    public void addObserver(Observer<T> observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!observers.contains(observer))
                observers.add(observer);
        }
    }

    protected void clearChanged() {
        changed = false;
    }

    public synchronized void deleteObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public synchronized void deleteObservers() {
        observers.clear();
    }

    public boolean hasChanged() {
        return changed;
    }

    protected void setChanged() {
        changed = true;
    }

    public void notifyObservers() {
        notifyObserver(null);
    }

    @SuppressWarnings("unchecked")
    public void notifyObserver(T data) {
        int size = 0;
        Observer<T>[] arrays = null;
        synchronized (this) {
            if (hasChanged()) {
                clearChanged();
                size = observers.size();
                arrays = new Observer[size];
                observers.toArray(arrays);
            }
        }
        if (arrays != null) {
            for (Observer<T> observer : arrays) {
                observer.update(this, data);
            }
        }
    }

}
