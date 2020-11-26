package com.wcc.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.data.DataBaseItems
import com.wcc.whatdidilearn.databinding.ActivityMainBinding
import com.wcc.whatdidilearn.repository.LearnedItemRepository
import com.wcc.whatdidilearn.viewmodel.LearnedItemViewModel
import com.wcc.whatdidilearn.viewmodel.LearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.itemsRecycleView
        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        val dataBase = DataBaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = dataBase.learnedItemDao()
        val repository = LearnedItemRepository(dao)

        val viewModelFactory = LearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)
                .get(LearnedItemViewModel::class.java)

        val itemsList = viewModel.learnedItemsList
        itemsList.observe(this, Observer {
            adapter.data = it
        })

        binding.btnLearnedAdd.setOnClickListener {
            val intent = Intent(this, NewLearned::class.java)
            startActivity(intent)
        }

    }

}