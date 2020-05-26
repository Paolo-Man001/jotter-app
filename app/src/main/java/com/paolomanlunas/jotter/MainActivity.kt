package com.paolomanlunas.jotter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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
      binding = ActivityMainBinding.inflate(layoutInflater)
      val view = binding.root
      setContentView(view)

      // App Center:
      AppCenter.start(
              application, "b662e675-0625-41d9-8c89-90c16029d398",
              Analytics::class.java, Crashes::class.java
      )
      Timber.d("onCreate CALLED!")  // Logging

      // FAB
      binding.fabCreate.setOnClickListener { view ->
         Snackbar.make(view, "You clicked the round-button!", Snackbar.LENGTH_SHORT)
                 .setAction("Action", null)
                 .show()
      }
   }
}
