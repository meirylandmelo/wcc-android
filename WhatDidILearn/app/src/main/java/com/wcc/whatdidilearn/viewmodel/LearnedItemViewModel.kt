package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcc.whatdidilearn.data.LearnedItemDao
import com.wcc.whatdidilearn.entities.ItemLearned
import com.wcc.whatdidilearn.repository.LearnedItemRepository
import kotlinx.coroutines.launch

class LearnedItemViewModel(private var repository: LearnedItemRepository): ViewModel() {
    val learnedItemsList: LiveData<List<ItemLearned>>
    init {
        learnedItemsList = repository.learnedItems
    }

    fun insertNewLearnedItem(item: ItemLearned) {
        viewModelScope.launch {
            repository.insertNewLearnedItem(item)
        }
    }
}