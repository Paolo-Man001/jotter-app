package com.paolomanlunas.jotter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jot_item_table")
data class JotItem(
   @PrimaryKey(autoGenerate = true)
   val itemId: Long = 0L,

   @ColumnInfo(name = "title")
   val itemTitle: String,

   @ColumnInfo(name = "description")
   val itemDesc: String
)