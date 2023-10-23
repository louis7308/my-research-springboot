package com.example.startspring.domain.stock

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "quantity")
    var remain: Long
) {
    fun decrease(quantity: Long) {
        if((remain - quantity) < 0 ) throw IllegalArgumentException("수량이 잘 못 입력되었다")
        remain -= quantity
    }

}