package com.example.startspring.websocket


class Message(
    var type: String = "",
    var sender: String = "",
    val receiver: String = "",
    val data: Any? = null
) {
    fun newConnect() {
        type = "new"
    }

    fun closeConnect() {
        type = "close"
    }
}