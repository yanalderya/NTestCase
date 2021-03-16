package com.example.ntestcase.ui.main.viewmodel

import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.common.extensions.toLiveData
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.ui.main.repository.MainRepository
import com.example.ntestcase.viewholder.MainCardDTO
import javax.inject.Inject

@FragmentScope
class MainFragmentViewModel @Inject constructor(
    private var mainRepository: MainRepository
) : BaseFragmentViewModel() {

    val mainListDataResult = mainRepository.getLocalAllCardDataResult.toLiveData(disposables)

    fun getLocalAllCard() {
        mainRepository.getLocalAllNews()
    }

    fun getUpdateCard(mainCardDTO: MainCardDTO) {
        mainRepository.getUpdateCard(mainCardDTO)
    }
}