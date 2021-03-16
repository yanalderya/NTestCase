package com.example.core.recyclerview

import android.os.Parcelable
import androidx.room.Ignore
import kotlinx.android.parcel.Parcelize
import kotlin.random.Random

@Parcelize
open class DisplayItem(@Ignore val type: Int, @Ignore val stableId: Long = Random.nextLong()) :
    Parcelable