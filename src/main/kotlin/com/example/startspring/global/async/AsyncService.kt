package com.example.startspring.global.async

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AsyncService {

    @Async

    fun asyncMethodWithVoidReturnType() {
        println("비동기 함수 실행 ${Thread.currentThread().name}")
    }
}