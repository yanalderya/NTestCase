package com.example.ntestcase.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.core.base.fragment.BaseDataFetchFragment
import com.example.core.common.extensions.setup
import com.example.core.common.util.DataFetchResult
import com.example.core.recyclerview.DefaultDisplayItemComperator
import com.example.core.recyclerview.DisplayItem
import com.example.core.recyclerview.RecyclerViewAdapter
import com.example.ntestcase.R
import com.example.ntestcase.common.RxBus
import com.example.ntestcase.common.constant.RecyclerviewAdapterConstant
import com.example.ntestcase.common.enum.CardTypeEnum
import com.example.ntestcase.ui.main.viewmodel.MainFragmentViewModel
import com.example.ntestcase.viewholder.MainCardDTO
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseDataFetchFragment<MainFragmentViewModel>() {

    private var mainLocalCardList: MutableList<MainCardDTO> = mutableListOf()

    private val adapterRecyclerView = RecyclerViewAdapter(
        itemComperator = DefaultDisplayItemComperator(),
        viewBinderFactoryMap = RecyclerviewAdapterConstant().binderFactoryMap,
        viewHolderFactoryMap = RecyclerviewAdapterConstant().holderFactoryMap
    )

    override val viewModelClass = MainFragmentViewModel::class.java

    override val layoutViewRes = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_main_list.setup(adapterRecyclerView)
        bindView()
        setupView()
    }

    private fun setupView() {
        floatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_main_to_addFragment)
        }

        adapterRecyclerView.itemClickListener = { displayItem: DisplayItem, _: Int ->
            when (displayItem) {
                is MainCardDTO -> {
                    navigateToDetail(displayItem)
                }
            }
        }

        RxBus.instance?.mainCountSubject?.subscribe {
            if (it.first) {
                viewModel.getUpdateCard(
                    MainCardDTO(
                        it.second.mainCardId,
                        it.second.mainCardType,
                        count(it.second)
                    )
                )
            }
        }?.isDisposed
    }

    private fun navigateToDetail(displayItem: MainCardDTO) {
        when (displayItem.mainCardType) {
            CardTypeEnum.TYPE_1.value -> {
                viewModel.getUpdateCard(
                    MainCardDTO(
                        displayItem.mainCardId,
                        displayItem.mainCardType,
                        count(displayItem)
                    )
                )
            }
        }
        val action = MainFragmentDirections.actionNavigationMainToDetailFragment(displayItem)
        findNavController().navigate(action)
    }

    private fun bindView() {
        mainLocalCardList.clear()

        viewModel.mainListDataResult.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataFetchResult.Progress -> {
                }
                is DataFetchResult.Failure -> {

                }
                is DataFetchResult.Success -> {
                    mainLocalCardList.addAll(it.data)
                    adapterRecyclerView.updateAllItems(mainLocalCardList)
                }
            }
        })
        viewModel.getLocalAllCard()
    }

    private fun count(mainCardDTO: MainCardDTO): Int {
        val mainCardNumberOfViews = mainCardDTO.mainCardNumberOfViews
        return mainCardNumberOfViews + 1
    }
}