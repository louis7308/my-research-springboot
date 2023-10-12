package com.example.startspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StartSpringApplication

fun main(args: Array<String>) {
    var id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    var report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    println( solution(id_list, report, 2).toString())
    runApplication<StartSpringApplication>(*args)
}

fun solution(idList: Array<String>, report: Array<String>, k: Int): IntArray {
    var answer: IntArray = IntArray(1000, {0})
    // 신고 당한 횟수 Hash Map
    var userReportHashCount = HashMap<String, Int>()
    for(usr in idList) userReportHashCount.put(usr, 0)
    // 중복 제거
    var reportHashSet = HashSet<String>()
    for(rep in report) reportHashSet.add(rep)


    var userHash = HashMap<String, MutableList<String>>()
    for(rep in reportHashSet) {
        val t = rep.split(" ")
        userHash.put(t[0], userHash.getOrDefault(t[0], mutableListOf(t[1])))?.add(t[1])
        userReportHashCount.put(t[1], userReportHashCount.get(t[1])!! + 1)
    }

    var count = 0
    for(key in userReportHashCount.keys) {
        var value = userReportHashCount.get(key)
        if(k <= value!!) {
            for(userKey in userHash.keys) {
                if(userHash.get(userKey)?.contains(key) == true) {
                    answer[count] = answer[count] + 1
                }
            }
        }
    }


    println(userHash)
    return answer
}


