package com.example.ntestcase.ui.detail.repository

import com.example.core.common.util.DataFetchResult
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable
import io.reactivex.subjects.PublishSubject

interface DetailFragmentContract {

    interface Repository {
        val updateItemResult: PublishSubject<DataFetchResult<Boolean>>
        fun getUpdateCard(mainCardDTO: MainCardDTO)

        fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable)
    }

    interface LocalDataSource {
        fun getUpdateCard(mainCardDTO: MainCardDTO): Completable
    }
}