package com.example.startspring.domain.book

import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class BookFacade(
    private val bookService: BookService,
    private val redissonClient: RedissonClient
) {
    fun purchase(bookId: Long, quantify: Long) {
        val rLock = redissonClient.getLock("purchase:bookId:${bookId}")
        try {
            val available = rLock.tryLock(10, 1, TimeUnit.SECONDS)
            if(!available) {
                println("아직 락을 획득하지 못했습니다.")
                return
            }
            bookService.purchase(bookId, quantify)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        } finally {
            rLock.unlock()
        }
    }
}