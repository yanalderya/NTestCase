package com.example.ntestcase.ui.main.repository

import com.example.core.common.util.DataFetchResult
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

interface MainContract {

    interface Repository {
        val getLocalAllCardDataResult: PublishSubject<DataFetchResult<List<MainCardDTO>>>
        fun getLocalAllNews()

        val updateItemResult: PublishSubject<DataFetchResult<Boolean>>
        fun getUpdateCard(mainCardDTO: MainCardDTO)

        fun <T> handleError(result: PublishSubject<DataFetchResult<T>>, error: Throwable)
    }

    interface LocalDataSource {
        fun getLocalAllNews(): Single<List<MainCardDTO>>
        fun getUpdateCard(mainCardDTO: MainCardDTO): Completable
    }
}