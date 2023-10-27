package com.example.startspring

import com.example.startspring.global.async.AsyncService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class AsyncTest @Autowired constructor(
    private val asyncService: AsyncService
) {

    @Test
    fun void함수_비동기_실행() {
        asyncService.asyncMethodWithVoidReturnType()
    }
}