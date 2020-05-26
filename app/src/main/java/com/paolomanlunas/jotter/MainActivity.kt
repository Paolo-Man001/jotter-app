package com.paolomanlunas.jotter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      // App Center:
      AppCenter.start(application, "b69b0182-2837-42f2-b150-3e8c635f9002",
              Analytics::class.java, Crashes::class.java)
   }
}
