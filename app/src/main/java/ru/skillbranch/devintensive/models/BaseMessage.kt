package ru.skillbranch.devintensive.models

import java.util.Date

abstract class BaseMessage (
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
){
    init {
        chat.addMessage(this)
        if (from !in chat.members.toList())
            chat.addUser(from)
    }

    abstract fun formatMessage():String
    companion object AbstractFactory{
        private var lastId = -1
        fun makeMessage(from: User?, chat: Chat, date: Date = Date(), payload:Any?, type:String = "text", isIncoming: Boolean = false):BaseMessage{
            lastId++
            return when(type){
                "image"->ImageMessage("$lastId",from,chat,isIncoming,date=date,image=payload as String)
                else->TextMessage("$lastId",from,chat,isIncoming,date=date,text=payload as String)
            }
        }
    }
}