package com.example.ntestcase.ui.add

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.core.base.fragment.BaseDataFetchFragment
import com.example.core.common.util.DataFetchResult
import com.example.ntestcase.R
import com.example.ntestcase.ui.add.viewmodel.AddFragmentViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : BaseDataFetchFragment<AddFragmentViewModel>() {

    override val viewModelClass: Class<AddFragmentViewModel> = AddFragmentViewModel::class.java

    override val layoutViewRes = R.layout.fragment_add

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewClicks()
        bindView()
    }

    private fun bindView() {
        viewModel.insertDataResult.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataFetchResult.Failure -> {
                }
                is DataFetchResult.Progress -> {

                }
                is DataFetchResult.Success -> {
                    requireActivity().onBackPressed()
                }
            }
        })
    }

    private fun onViewClicks() {
        btn_add.setOnClickListener {
            val spinner = spinner.selectedItem.toString()
            viewModel.insertCard(spinner)
        }
    }
}
