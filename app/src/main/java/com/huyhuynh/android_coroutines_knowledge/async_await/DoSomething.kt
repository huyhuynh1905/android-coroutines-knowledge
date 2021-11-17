package com.huyhuynh.android_coroutines_knowledge.async_await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time1 = measureTimeMillis {
            val a = getNumberA()
            val b = getNumberB()
            println("Show the total 1= ${a+b}")
        }
        println("Show Time 1 = $time1")

        val time2 = measureTimeMillis {
            val a:Deferred<Int> = async { getNumberA() }
            val b:Deferred<Int> = async { getNumberB() }
            println("Show the total 2 = ${a.await()+b.await()}")
        }
        println("Show Time 2 = $time2")
    }
}

suspend fun getNumberA() : Int{
    delay(500)
    return 5
}

suspend fun getNumberB() : Int{
    delay(500)
    return 3
}