package com.wcc.whatdidilearn.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wcc.whatdidilearn.entities.ItemLearned

@Dao
interface LearnedItemDao {
    @Query("SELECT * FROM learned_item ORDER BY Item_title ASC")
    fun getAll(): LiveData<List<ItemLearned>>

    @Insert
    suspend fun insert (item: ItemLearned)
}