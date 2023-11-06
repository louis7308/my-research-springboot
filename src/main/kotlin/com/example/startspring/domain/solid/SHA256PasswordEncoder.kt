package com.example.startspring.domain.solid

class SHA256PasswordEncoder : PasswordEncorder, PasswordChecker {
    override fun encryptPassword(pw: String): String {
        return "string"
    }

    override fun isCorrectPassword(rawPw: String, pw: String): String {
        return this.encryptPassword("test")
    }
}