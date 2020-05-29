package com.paolomanlunas.jotter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.paolomanlunas.jotter.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {
   lateinit var binding: ActivityItemBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = DataBindingUtil.setContentView(this, R.layout.activity_item)

      binding.fabSubmitItem.setOnClickListener {
         Toast.makeText(this,"Adding New Item", Toast.LENGTH_SHORT).show()
         addNewItem(it)
      }
   }

   private fun addNewItem(view: View) {
      val intent = Intent(this, MainActivity::class.java)
      startActivity(intent)
   }
}