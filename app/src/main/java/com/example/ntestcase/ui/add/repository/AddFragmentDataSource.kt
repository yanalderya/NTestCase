package com.example.ntestcase.ui.add.repository

import com.example.ntestcase.data.dao.MainCardDao
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable

class AddFragmentDataSource(private val mainCardDao: MainCardDao) :
    AddFragmentContract.LocalDataSource {
    override fun insertCard(mainCardDTO: MainCardDTO): Completable =
        mainCardDao.insertMainCard(mainCardDTO)
}