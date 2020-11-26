package com.wcc.whatdidilearn.viewmodel

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcc.whatdidilearn.data.LearnedItemDao
import com.wcc.whatdidilearn.entities.ItemLearned
import com.wcc.whatdidilearn.entities.Level
import com.wcc.whatdidilearn.repository.LearnedItemRepository
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private var repository: LearnedItemRepository): ViewModel() {
    fun insertNewLearnedItem(itemTitle: String, itemDescription: String) {
        viewModelScope.launch {
            val item = ItemLearned(itemTitle, itemDescription, Level.HIGH)
            repository.insertNewLearnedItem(item)
        }
    }

}