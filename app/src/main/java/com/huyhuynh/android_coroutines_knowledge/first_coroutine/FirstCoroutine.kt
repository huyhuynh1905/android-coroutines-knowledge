package com.huyhuynh.android_coroutines_knowledge.first_coroutine

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main() {
    /*
    - Đối với GlobalScope thì các phương thức bên ngoài có thể dược gọi tuần tự trước
    - Các logic bên trong GlobalScope sẽ thực hiện một cách "như là" song song với các logic bên ngoài
    * */
    GlobalScope.launch {
        println("Hello Coroutine 1a")
        delay(1000)
        println("Hello Coroutine 1b")
        delay(1000)
        println("Hello Coroutine 1c")
        delay(1000)
        println("Hello Coroutine 1d")
    }

    println("Hello Coroutine 2")
    //Thread.sleep(4000)

    /*
    - Khi sử dụng runBlocking thì các logic sẽ được xử lí tuần tự, nghĩa là nó sẽ chạy xong các logic
    bên trong runBloking rồi mới chạy các phương thức bên ngoài.
    - Hạn chế hoặc không sử dụng runBlocking trong App vì nó có thể khiến app bị block thread.
    * */
    runBlocking {
        println("Hello Coroutine 3")
        delay(1000)
        println("Hello Coroutine 4")
        delay(1000)
        println("Hello Coroutine 5")
        delay(1000)
        println("Hello Coroutine 6")
        launch {
            for (i in 0..20){
                delay(100)
                println("Số $i")
            }
        }
        launch {
            for (i in 0..20){
                delay(100)
                println("Num $i")
            }
        }
    }
    println("End Code")

}