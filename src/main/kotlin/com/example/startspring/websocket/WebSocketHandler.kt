package com.example.startspring.websocket

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap

class WebSocketHandler : TextWebSocketHandler() {
    private val sessions = ConcurrentHashMap<String, WebSocketSession>()

    // 웹소켓 연결
    override fun afterConnectionEstablished(session: WebSocketSession) {
        var sessionId = session.id
        sessions[sessionId] = session

        val message: Message = Message(sender = sessionId, receiver = "all")
        message.newConnect()

        sessions.values
            .filter { it.id != sessionId }
            .forEach { otherSession ->
                run {
                    try {
                        otherSession.sendMessage(TextMessage("Welcome new user $sessionId"))
                    } catch (e: Exception) {
                        throw RuntimeException("")
                    }
                }
            }
    }

    // 양방향 데이터 통신
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        super.handleTextMessage(session, message)
    }

    // 소켓 연결 종료
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
    }

    // 소켓 통신 에러
    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        super.handleTransportError(session, exception)
    }

}