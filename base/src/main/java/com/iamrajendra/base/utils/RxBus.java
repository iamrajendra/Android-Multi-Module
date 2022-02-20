package com.iamrajendra.base.utils;

import com.iamrajendra.base.data.Rout;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus<T> {

    public RxBus() {
    }

    private PublishSubject<T> bus = PublishSubject.create();

    public void send(T o) {
        bus.onNext(o);
    }

    public Observable<T> toObservable() {
        return bus;
    }

}
