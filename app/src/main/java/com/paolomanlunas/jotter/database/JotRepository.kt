package com.paolomanlunas.jotter.database

import androidx.lifecycle.LiveData
import com.paolomanlunas.jotter.model.JotItem

class JotRepository(private val jotDao: JotDao) {
   // GET all items
   val allItems: LiveData<List<JotItem>> = jotDao.getAll()

   // POST new item
   suspend fun insertNew(item: JotItem) {
      jotDao.insert(item)
   }

   // DELETE One
   fun deleteItem(item: JotItem) {
      jotDao.deleteOne(item)
   }

   // DELETE All
   suspend fun deleteAll() {
      jotDao.clear()
   }
}