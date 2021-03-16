package com.example.ntestcase.ui.add.repository

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
class AddFragmentRepository(
    private val local: AddFragmentContract.LocalDataSource,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable
) : AddFragmentContract.Repository {

    override val addItemResult = PublishSubject.create<DataFetchResult<Boolean>>()

    override fun insertCard(mainCardDTO: MainCardDTO) {
        addItemResult.loading(true)
        local.insertCard(mainCardDTO)
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                {
                    addItemResult.success(true)
                },
                { error ->
                    handleError(addItemResult, error)
                }
            ).addTo(compositeDisposable)
    }

    override fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable) {
        result.failed(error)
    }
}