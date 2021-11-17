package com.huyhuynh.android_coroutines_knowledge.flow_function

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    var list = listOf(1,2,1,5,2,6,7,8,3,9)
    var strList = listOf("Huỳnh", "Bảo")

    runBlocking {
        /*val time = measureTimeMillis {
            foo(5).collect {
                println("X = $it")
            }
        }
        println("Time = $time")*/

        //transform
        /*list.asFlow().transform {
            emit(it*2)
            emit(it*3)
        }.collect {
            println("It = $it")
        }*/

        //map
        /*list.asFlow().map {
            it+4
        }.collect{
            println("Map = $it")
        }*/

        //take
        /*list.asFlow().take(3).collect {
            println("Take = $it")
        }*/

        //filter
        println(list.filter { it -> it>=3 })
        list.asFlow().filter {
            it%2!=0
        }.collect {
            println("filter = $it")
        }

        //reduce
        println(list.reduce { acc, i -> acc+i })
        val sum = list.reduce { acc, i ->
            println("acc = $acc -- i = $i")
            acc+i
        }

        //zip : cộng đối các phần tử
        println(list.zip(strList))
    }

}

fun foo(x:Int) : Flow<Int> = flow {
    for (i in 0..x){
        delay(100)
        emit(i)
    }
}

