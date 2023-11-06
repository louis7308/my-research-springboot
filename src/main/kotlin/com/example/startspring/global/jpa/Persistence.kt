package com.example.startspring.global.jpa

import com.example.startspring.domain.user.Gender
import com.example.startspring.domain.user.User
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Component

@Component
class Persistence(
    @PersistenceContext
    private var em: EntityManager
) {


    fun execute() {
        val tx = em.transaction

        tx.begin()
        val user = User(5, "전승원", "", Gender.MAN, "", "") // 비영속화

        println("Before")
        em.persist(user) // 영속화 ( 영속성 컨텍스트 1차 캐시에 저장 )
        println("After")

        val findUser: User = em.find(User::class.java, 5)
        println("findUser.getId()  = ${findUser.id}")
        println("findUser.getUsername()  = ${findUser.name}")

        tx.commit()
    }
}