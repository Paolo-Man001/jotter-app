package com.paolomanlunas.jotter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.paolomanlunas.jotter.database.JotDb
import com.paolomanlunas.jotter.database.JotRepository
import com.paolomanlunas.jotter.model.JotItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class JotViewModel(application: Application) : AndroidViewModel(application) {
   private val repository: JotRepository
   val allItems: LiveData<List<JotItem>>

   init {
      val jotDao = JotDb.getDatabase(application).jotDao
      repository = JotRepository(jotDao)
      allItems = repository.allItems
   }

   /*
   *  Launch new coroutine to Insert New item
   * */
   fun insert(jotItem: JotItem) = viewModelScope.launch(Dispatchers.IO) {
      repository.insertNew(jotItem)
   }
}