package com.example.ntestcase.viewholder

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.recyclerview.DisplayItem
import com.example.ntestcase.common.constant.RecyclerviewAdapterConstant.TYPES
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "table_card")
@Parcelize
data class MainCardDTO(
    @PrimaryKey(autoGenerate = true)
    val mainCardId: Int = 0,
    val mainCardType: String,
    val mainCardNumberOfViews: Int
) : Parcelable, DisplayItem(TYPES.TYPE_MAIN_LIST)