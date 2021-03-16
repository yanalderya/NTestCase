package com.example.core.common.extensions

import com.example.core.common.util.Scheduler
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Completable.performOnBackOutOnMain(scheduler: Scheduler): Completable {
    return this.subscribeOn(scheduler.io())
        .observeOn(scheduler.mainThread())
}

fun <T> Single<T>.performOnBackOutOnMain(scheduler: Scheduler): Single<T> {
    return this.subscribeOn(scheduler.io())
        .observeOn(scheduler.mainThread())
}

fun <T> Observable<T>.performOnBackOutOnMain(scheduler: Scheduler): Observable<T> {
    return this.subscribeOn(scheduler.io())
        .observeOn(scheduler.mainThread())
}

fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}