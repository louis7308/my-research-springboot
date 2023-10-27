package com.example.startspring

import com.example.startspring.domain.book.Book
import com.example.startspring.domain.book.BookFacade
import com.example.startspring.domain.book.BookRepository
import com.example.startspring.domain.stock.Stock
import com.example.startspring.domain.stock.StockRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import kotlin.test.assertEquals

@SpringBootTest
class BookTest @Autowired constructor(
    private val bookRepository: BookRepository,
    private val stockRepository: StockRepository,
    private val bookFacadeService: BookFacade
) {

    @Test
    fun 동시에_100명이_책을_구매한다() {
        val stock = stockRepository.save(Stock(remain = 100))
        val bookId = bookRepository.save(Book(name = "육각형개발자", price = 36000, stock = stock)).id
        val executorService = Executors.newFixedThreadPool(100)
        val countDownLatch: CountDownLatch = CountDownLatch(100)

        for (i in 0 until 100) {
            executorService.submit {
                try {
                    bookFacadeService.purchase(bookId, 1)
                } finally {
                    countDownLatch.countDown()
                }
            }
        }

        countDownLatch.await()
        val actual = bookRepository.findByIdOrNull(bookId)
        assertEquals(0L, actual?.stock?.remain)
    }
}