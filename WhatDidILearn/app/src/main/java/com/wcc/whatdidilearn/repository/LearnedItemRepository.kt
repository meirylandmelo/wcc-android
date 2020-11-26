package com.wcc.whatdidilearn.repository

import com.wcc.whatdidilearn.data.LearnedItemDao
import com.wcc.whatdidilearn.entities.ItemLearned

class LearnedItemRepository(private val dao: LearnedItemDao) {
    val learnedItems = dao.getAll()

    suspend fun insertNewLearnedItem(item: ItemLearned) {
        dao.insert(item)
    }
}