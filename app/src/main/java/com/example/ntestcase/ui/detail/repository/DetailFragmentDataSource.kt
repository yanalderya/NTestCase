package com.example.ntestcase.ui.detail.repository

import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable

class DetailFragmentDataSource(private val mainCardDao: MainCardDao) : DetailFragmentContract.LocalDataSource {
    override fun getUpdateCard(mainCardDTO: MainCardDTO): Completable =
        mainCardDao.updateMainCard(mainCardDTO)
}