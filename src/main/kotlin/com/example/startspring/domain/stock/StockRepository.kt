package com.example.startspring.domain.stock

import org.springframework.data.jpa.repository.JpaRepository

interface StockRepository : JpaRepository<Stock, Long>