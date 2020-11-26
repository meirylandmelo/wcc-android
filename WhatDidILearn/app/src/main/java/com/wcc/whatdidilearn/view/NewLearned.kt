package com.wcc.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.data.DataBaseItems
import com.wcc.whatdidilearn.databinding.ActivityNewLearnedBinding
import com.wcc.whatdidilearn.repository.LearnedItemRepository
import com.wcc.whatdidilearn.viewmodel.NewLearnedItemViewModel
import com.wcc.whatdidilearn.viewmodel.NewLearnedViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class NewLearned : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewLearnedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title="New Learned Item"

        val dao = DataBaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO)).learnedItemDao()
        val repository = LearnedItemRepository(dao)
        val viewModelFactory = NewLearnedViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NewLearnedItemViewModel::class.java)

        binding.buttonSave.setOnClickListener {
            val title = binding.inputTitle.text.toString()
            val description = binding.inputDescription.text.toString()

            viewModel.insertNewLearnedItem(title, description)

            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}