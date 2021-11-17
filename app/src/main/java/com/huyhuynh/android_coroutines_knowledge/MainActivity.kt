package com.huyhuynh.android_coroutines_knowledge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huyhuynh.android_coroutines_knowledge.coroutine_context.TestDispatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TestDispatcher.runDispatcherContextSecond()
    }
}