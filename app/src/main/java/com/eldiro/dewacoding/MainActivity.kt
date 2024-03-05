package com.eldiro.dewacoding

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}

@HiltAndroidApp
class MainActivity: Application() {

}