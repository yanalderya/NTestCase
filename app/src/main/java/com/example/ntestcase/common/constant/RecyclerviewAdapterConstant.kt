package com.example.ntestcase.common.constant

import com.example.ntestcase.viewholder.MainListViewHolder

class RecyclerviewAdapterConstant {

    object TYPES {
        const val TYPE_MAIN_LIST = 1
    }

    var binderFactoryMap = mutableMapOf(
        TYPES.TYPE_MAIN_LIST to MainListViewHolder.BinderFactory()
    )

    var holderFactoryMap = mutableMapOf(
        TYPES.TYPE_MAIN_LIST to MainListViewHolder.HolderFactory()
    )
}