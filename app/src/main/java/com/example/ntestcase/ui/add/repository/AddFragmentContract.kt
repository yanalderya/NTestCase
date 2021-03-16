package com.example.ntestcase.ui.add.repository

import com.example.core.common.util.DataFetchResult
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable
import io.reactivex.subjects.PublishSubject

interface AddFragmentContract {

    interface Repository {
        val addItemResult: PublishSubject<DataFetchResult<Boolean>>
        fun insertCard(mainCardDTO: MainCardDTO)

        fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable)
    }

    interface LocalDataSource {
        fun insertCard(mainCardDTO: MainCardDTO): Completable
    }
}