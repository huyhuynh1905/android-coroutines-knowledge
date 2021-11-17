package com.huyhuynh.android_coroutines_knowledge.coroutine_context

import android.util.Log
import com.huyhuynh.android_coroutines_knowledge.MainActivity
import kotlinx.coroutines.*

@ObsoleteCoroutinesApi
@DelicateCoroutinesApi
object TestDispatcher {
    fun runDispatcherContext(){
        GlobalScope.launch(){
            Log.d(MainActivity::class.java.simpleName,"run on dispatcher Non Send with name = ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Default){
            Log.d(MainActivity::class.java.simpleName,"run on dispatcher Dispatchers.Default with name = ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main){
            Log.d(MainActivity::class.java.simpleName,"run on dispatcher Dispatchers.Main with name = ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.IO){
            Log.d(MainActivity::class.java.simpleName,"run on dispatcher Dispatchers.IO with name = ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Unconfined){
            Log.d(MainActivity::class.java.simpleName,"run on dispatcher Dispatchers.Unconfined with name = ${Thread.currentThread().name}")
        }
        GlobalScope.launch(newSingleThreadContext("Huy Thread")){
            Log.d(MainActivity::class.java.simpleName,"run on ${Thread.currentThread().name}")
        }
    }

    /**
     * - Với withContext trong một coroutines khác thì nó sẽ làm cho một thread đang chạy thành một
     * thread khác => Ví dụ dưới đưa Thread Default về Main (Main có thể update UI ở trên android)
     */
    fun runDispatcherContextSecond(){
        GlobalScope.launch(Dispatchers.Default){
            Log.d(MainActivity::class.java.simpleName,"run on dispatcher Dispatchers.Default with name = ${Thread.currentThread().name}")
            delay(3000)
            withContext(Dispatchers.Main){
                Log.d(MainActivity::class.java.simpleName,"run on dispatcher Dispatchers.Main with name = ${Thread.currentThread().name}")
            }
        }
    }
}