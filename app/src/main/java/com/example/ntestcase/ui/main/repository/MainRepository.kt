package com.example.ntestcase.ui.main.repository

import com.example.core.common.extensions.failed
import com.example.core.common.extensions.loading
import com.example.core.common.extensions.performOnBackOutOnMain
import com.example.core.common.extensions.success
import com.example.core.common.util.DataFetchResult
import com.example.core.common.util.Scheduler
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

@FragmentScope
class MainRepository(
    private val local: MainContract.LocalDataSource,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : MainContract.Repository {

    override val getLocalAllCardDataResult: PublishSubject<DataFetchResult<List<MainCardDTO>>> =
        PublishSubject.create()

    override fun getLocalAllNews() {
        getLocalAllCardDataResult.loading(true)
        local.getLocalAllNews()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
            .subscribe(
                {
                    getLocalAllCardDataResult.success(it)
                },
                { error ->
                    handleError(getLocalAllCardDataResult, error)
                })
            .addTo(compositeDisposable)
    }

    override val updateItemResult = PublishSubject.create<DataFetchResult<Boolean>>()

    override fun getUpdateCard(mainCardDTO: MainCardDTO) {
        updateItemResult.loading(true)
        local.getUpdateCard(mainCardDTO)
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                {
                    updateItemResult.success(true)
                },
                { error ->
                    handleError(updateItemResult, error)
                }
            ).addTo(compositeDisposable)
    }

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
    }
}