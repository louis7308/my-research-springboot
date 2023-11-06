package com.example.startspring.domain.solid

interface PasswordEncorder {
    fun encryptPassword(pw: String): String
}