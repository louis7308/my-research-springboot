package com.example.startspring.domain.user


class User(
    private val id: Long,

    private val name: String,

    private val phone: String,

    private val gender: Gender,

    private val email: String,

    private val password: String,
) {
}