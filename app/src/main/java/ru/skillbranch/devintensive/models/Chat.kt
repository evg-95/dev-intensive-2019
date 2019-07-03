package ru.skillbranch.devintensive.models

class Chat (
    val id:String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
){
    fun addMessage(baseMessage: BaseMessage) {
        messages.add(baseMessage)
    }

    fun addUser(user: User?) {

        if (user == null)
            return
        members.add(user)
    }

    companion object Factory{
        private var lastId = -1
        fun makeChat(members: MutableList<User>): Chat{
            lastId++
            return Chat("$lastId", members)
        }
    }
}