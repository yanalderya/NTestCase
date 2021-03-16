package com.example.core.common.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.common.util.DataFetchResult
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

fun <T> PublishSubject<T>.toLiveData(compositeDisposable: CompositeDisposable): LiveData<T> {
    val data = MutableLiveData<T>()
    compositeDisposable.add(this.subscribe { t: T -> data.value = t })
    return data
}

fun <T> PublishSubject<DataFetchResult<T>>.failed(e: Throwable) {
    with(this) {
        loading(false)
        onNext(DataFetchResult.failure(e))
    }
}

fun <T> PublishSubject<DataFetchResult<T>>.success(t: T) {
    with(this) {
        loading(false)
        onNext(DataFetchResult.success(t))
    }
}

fun <T> PublishSubject<DataFetchResult<T>>.loading(isLoading: Boolean) {
    this.onNext(DataFetchResult.loading(isLoading))
}