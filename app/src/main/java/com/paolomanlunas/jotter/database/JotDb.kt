package com.paolomanlunas.jotter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.paolomanlunas.jotter.model.JotItem
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [JotItem::class], version = 1, exportSchema = false)
abstract class JotDb : RoomDatabase() {
   //   abstract fun jotDao(): JotDao
   abstract val jotDao: JotDao

   companion object {
      // Make SINGLETON Database so only 1 DB us open at anytime:
      @Volatile
      private var INSTANCE: JotDb? = null

      @InternalCoroutinesApi
      fun getDatabase(context: Context): JotDb {
         synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
               instance = Room.databaseBuilder(
                  context.applicationContext,
                  JotDb::class.java,
                  "jot_database"
               )
                  .fallbackToDestructiveMigration()
                  .build()
               INSTANCE = instance
            }
            return instance
         }
      }
   }
}