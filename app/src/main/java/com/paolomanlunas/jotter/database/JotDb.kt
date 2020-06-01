package com.paolomanlunas.jotter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.paolomanlunas.jotter.model.JotItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch

@Database(entities = [JotItem::class], version = 1, exportSchema = false)
abstract class JotDb : RoomDatabase() {
   //   abstract fun jotDao(): JotDao
   abstract fun jotDao(): JotDao

   private class JotDbCallback(
      private val scope: CoroutineScope
   ) : RoomDatabase.Callback() {
      override fun onOpen(db: SupportSQLiteDatabase) {
         super.onOpen(db)
         INSTANCE?.let { database ->
            scope.launch {
               val jotDao = database.jotDao()

               // Delete all contents
               jotDao.clear()

               // Add sample-data:
               var item = JotItem(itemTitle = "First Title", itemDesc = "First Description")
               jotDao.insert(item)

               item = JotItem(itemTitle = "Second Title", itemDesc = "Second Description")
               jotDao.insert(item)

               item = JotItem(itemTitle = "3rd Title", itemDesc = "3rd Description")
               jotDao.insert(item)
            }
         }
      }
   }

   companion object {
      // Make SINGLETON Database so only 1 DB us open at anytime:
      @Volatile
      private var INSTANCE: JotDb? = null

      @InternalCoroutinesApi
      fun getDatabase(
         context: Context,
         scope: CoroutineScope
      ): JotDb {
         // If instance is Null -> create the db,Else, return
         return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
               context.applicationContext,
               JotDb::class.java,
               "jot_database"
            )
               .addCallback(JotDbCallback(scope))
               .build()
            INSTANCE = instance

            // return instance
            instance
         }
      }
   }
}

/* OLD:
* synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
               instance = Room.databaseBuilder(
                  context.applicationContext,
                  JotDb::class.java,
                  "jot_database"
               )
                  .addCallback(JotDbCallback(scope))
                  .build()
               INSTANCE = instance
            }
            return instance
         }
* */