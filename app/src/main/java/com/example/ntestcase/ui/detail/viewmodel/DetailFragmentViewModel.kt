package com.example.ntestcase.ui.detail.viewmodel

import com.example.core.base.viewmodel.BaseFragmentViewModel
import com.example.core.di.scopes.FragmentScope
import com.example.ntestcase.common.enum.CardTypeEnum
import com.example.ntestcase.ui.detail.repository.DetailFragmentRepository
import com.example.ntestcase.viewholder.MainCardDTO
import javax.inject.Inject

@FragmentScope
class DetailFragmentViewModel @Inject constructor(
    var repository: DetailFragmentRepository
) : BaseFragmentViewModel() {

    fun updateCount(mainCardDTO: MainCardDTO) {
        if (mainCardDTO.mainCardType == CardTypeEnum.TYPE_2.value) {
            val mainCardNumberOfViews = mainCardDTO.mainCardNumberOfViews
            val newCount = mainCardNumberOfViews + 1
            val updatedItem = MainCardDTO(
                mainCardId = mainCardDTO.mainCardId,
                mainCardType = mainCardDTO.mainCardType,
                mainCardNumberOfViews = newCount
            )
            repository.getUpdateCard(updatedItem)
        }
    }
}