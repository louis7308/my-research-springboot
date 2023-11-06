package com.example.startspring.domain.solid

interface PasswordChecker {
    fun isCorrectPassword(rawPw: String, pw: String): String

}