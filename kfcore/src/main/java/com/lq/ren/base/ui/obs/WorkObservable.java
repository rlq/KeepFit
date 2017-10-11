package com.lq.ren.base.ui.obs;

/**
 * An observable that return the last value when add an observer.
 */
public class WorkObservable<T> extends Observable<T> {

    private T lastValue;
    private boolean hasLastValue = false;

    @Override
    public void notifyObservers() {
        boolean hasLast;
        T last;
        synchronized (this) {
            hasLast = hasLastValue;
            last = lastValue;
        }
        if (hasLast) {
            setChanged();
            super.notifyObserver(last);
        }
    }

    @Override
    public void notifyObserver(T data) {
        synchronized (this) {
            hasLastValue = true;
            lastValue = data;
        }
        setChanged();
        super.notifyObserver(data);
    }

    @Override
    public void addObserver(Observer<T> observer) {
        super.addObserver(observer);

        // Just update given observer, not affect other observers.
        if (observer != null) {
            boolean hasLast;
            T last;
            synchronized (this) {
                hasLast = hasLastValue;
                last = lastValue;
            }
            if (hasLast) {
                observer.update(this, last);
            }
        }
    }
}
