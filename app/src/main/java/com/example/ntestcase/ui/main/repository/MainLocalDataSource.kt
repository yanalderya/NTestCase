package com.example.ntestcase.ui.main.repository

import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable
import io.reactivex.Single


class MainLocalDataSource(private val mainCardDao: MainCardDao) : MainContract.LocalDataSource {
    override fun getLocalAllNews(): Single<List<MainCardDTO>> {
        return mainCardDao.getAllCard()
    }

    override fun getUpdateCard(mainCardDTO: MainCardDTO): Completable =
        mainCardDao.updateMainCard(mainCardDTO)
}