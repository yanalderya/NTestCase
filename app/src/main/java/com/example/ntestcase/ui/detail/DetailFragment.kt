package com.example.ntestcase.ui.detail

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.core.base.fragment.BaseDataFetchFragment
import com.example.ntestcase.R
import com.example.ntestcase.common.RxBus
import com.example.ntestcase.common.enum.CardTypeEnum
import com.example.ntestcase.ui.detail.viewmodel.DetailFragmentViewModel
import com.example.ntestcase.viewholder.MainCardDTO
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseDataFetchFragment<DetailFragmentViewModel>() {

    private var mainCardDTO: MainCardDTO? = null

    override val viewModelClass = DetailFragmentViewModel::class.java

    override val layoutViewRes = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val arg = DetailFragmentArgs.fromBundle(it)
            mainCardDTO = arg.mainCardDTO
        }
        setupView()
        changeBackgroundColor()
    }

    private fun setupView() {
        tv_title.text = mainCardDTO?.mainCardType

        if (mainCardDTO?.mainCardType == CardTypeEnum.TYPE_3.value) {
            mainCardDTO?.let {
                RxBus.instance?.mainCountSubject?.onNext(Pair(true, it))
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    mainCardDTO?.let {
                        viewModel.updateCount(it)
                    }
                    findNavController().popBackStack()
                }
            })
    }

    private fun changeBackgroundColor() {
        when (tv_title.text) {
            CardTypeEnum.TYPE_1.value -> {
                tv_title.setBackgroundResource(R.color.colorAccent)
            }
            CardTypeEnum.TYPE_2.value -> {
                tv_title.setBackgroundResource(R.color.red)
            }
            CardTypeEnum.TYPE_3.value -> {
                tv_title.setBackgroundResource(R.color.colorPrimary)
            }
        }
    }

    private fun count(): Int {
        val mainCardNumberOfViews = mainCardDTO?.mainCardNumberOfViews ?: 0
        return mainCardNumberOfViews + 1
    }
}
