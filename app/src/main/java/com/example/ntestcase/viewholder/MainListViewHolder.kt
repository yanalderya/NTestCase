package com.example.ntestcase.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.recyclerview.DisplayItem
import com.example.core.recyclerview.ViewHolder
import com.example.core.recyclerview.ViewHolderBinder
import com.example.core.recyclerview.ViewHolderFactory
import com.example.ntestcase.R
import javax.inject.Inject

class MainListViewHolder(var view: View) : ViewHolder<MainCardDTO>(view) {

    private var title : TextView = view.findViewById(R.id.tv_title)

    override fun bind(item: MainCardDTO) {

        title.text = """${item.mainCardType} (${item.mainCardNumberOfViews})"""

        view.setOnClickListener {
            itemClickListener?.invoke(item, adapterPosition)
        }
    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            MainListViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_main_card,
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as MainListViewHolder).bind(item as MainCardDTO)
        }
    }
}