package com.example.ntestcase.common

import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.subjects.PublishSubject

class RxBus {

    val mainCountSubject = PublishSubject.create<Pair<Boolean, MainCardDTO>>()

    companion object {
        private var rxInstance: RxBus? = null
        val instance: RxBus?
            get() {
                if (rxInstance == null)
                    rxInstance =
                        RxBus()
                return rxInstance
            }
    }
}