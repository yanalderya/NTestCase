package com.example.ntestcase.data.dao

import androidx.room.*
import com.example.ntestcase.viewholder.MainCardDTO
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MainCardDao {

    @Query("SELECT * FROM table_card")
    fun getAllCard(): Single<List<MainCardDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMainCard(mainCardDTO: MainCardDTO) : Completable

    @Update()
    fun updateMainCard(mainCardDTO: MainCardDTO) : Completable
}