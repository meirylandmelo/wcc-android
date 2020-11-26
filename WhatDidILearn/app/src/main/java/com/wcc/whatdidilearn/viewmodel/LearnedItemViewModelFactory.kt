package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wcc.whatdidilearn.data.LearnedItemDao
import com.wcc.whatdidilearn.repository.LearnedItemRepository

class LearnedItemViewModelFactory (private val repository: LearnedItemRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java)) {
            return LearnedItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}