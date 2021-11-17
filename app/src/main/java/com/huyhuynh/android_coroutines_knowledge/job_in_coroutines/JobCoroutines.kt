package com.huyhuynh.android_coroutines_knowledge.job_in_coroutines

import kotlinx.coroutines.*

@DelicateCoroutinesApi
suspend fun main() {
    val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() // wait until child coroutine completes
    println("Done")
}