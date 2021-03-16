package com.example.ntestcase.ui.add.viewmodel

import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.common.extensions.toLiveData
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.ui.add.repository.AddFragmentRepository
import com.example.ntestcase.viewholder.MainCardDTO
import javax.inject.Inject

@FragmentScope
class AddFragmentViewModel @Inject constructor(
    var repository: AddFragmentRepository
) : BaseFragmentViewModel() {

    val insertDataResult = repository.addItemResult.toLiveData(disposables)

    private fun getInsertCard(mainCardDTO: MainCardDTO) {
        repository.insertCard(mainCardDTO)
    }

    fun insertCard(type: String) {
        getInsertCard(MainCardDTO(mainCardType = type, mainCardNumberOfViews = 0))
    }
}