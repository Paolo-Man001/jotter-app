package com.paolomanlunas.jotter.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.paolomanlunas.jotter.model.JotItem

@Dao
interface JotDao {

   // Get all items:
   @Query("SELECT * FROM jot_item_table ORDER BY itemId ASC")
   fun getAll(): LiveData<List<JotItem>>

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(jotItem: JotItem)

   // Delete One
   @Delete
   fun deleteOne(jotItem: JotItem)

   // Delete All
   @Query("DELETE FROM jot_item_table")
   suspend fun clear()

}