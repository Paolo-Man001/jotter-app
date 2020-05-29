package com.paolomanlunas.jotter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.paolomanlunas.jotter.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      // setContentView(R.layout.activity_main)
      binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

      // App Center:
      AppCenter.start(
         application, "b662e675-0625-41d9-8c89-90c16029d398",
         Analytics::class.java, Crashes::class.java
      )
//      Timber.d("onCreate CALLED!")  // Logging

      // FAB
      binding.fabCreate.setOnClickListener {
         Toast.makeText(this, "floating button Clicked!", Toast.LENGTH_SHORT).show()
         val intent = Intent(this, ItemActivity::class.java)
         startActivity(intent)
      }
   }
}
