package com.example.startspring.domain.book

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    val bookRepository: BookRepository,
) {
    @Transactional
    fun purchase(bookId: Long, quantify: Long) {
            val book = bookRepository.findByIdOrNull(bookId)
                ?: throw IllegalArgumentException("BookId 값이 올바르지 않습니다.")
            book.purchase(quantify)
    }
}