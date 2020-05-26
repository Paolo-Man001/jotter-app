package com.paolomanlunas.jotter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import timber.log.Timber

class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      // App Center:
      AppCenter.start(application, "b662e675-0625-41d9-8c89-90c16029d398",
              Analytics::class.java, Crashes::class.java)

      Timber.d("onCreate CALLED!")
   }
}
