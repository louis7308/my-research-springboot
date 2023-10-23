package com.example.startspring.domain.book

import com.example.startspring.domain.stock.Stock
import jakarta.persistence.*

@Entity
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val price: Int,

    @OneToOne(fetch = FetchType.LAZY)
    val stock: Stock
) {
    fun purchase(quantify: Long) {
        stock.decrease(quantify)
    }
}