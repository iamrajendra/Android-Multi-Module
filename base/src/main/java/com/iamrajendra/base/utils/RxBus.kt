package com.iamrajendra.base.utils

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RxBus<T> {
    private val bus: PublishSubject<T> = PublishSubject.create()
    fun send(o: T) {
        bus.onNext(o)
    }

    fun toObservable(): Observable<T> {
        return bus
    }
}