package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils.toInitials
import ru.skillbranch.devintensive.utils.Utils.transliteration
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_message(){
        val user = User.makeUser("Evgeny Izmaylov")
        val user1 = User.makeUser("John Whick")
        val list :MutableList<User> = mutableListOf()
        list.add(user)
        list.add(user1)

        val chat = Chat.makeChat(list)
        println(BaseMessage.makeMessage(user, chat, Date().add(-22, TimeUnits.MINUTE),payload = "Hi!").formatMessage())
        println(toInitials(" ",""))
        println(transliteration("Евгений Измайлов".toString(),"_"))
    }

    @Test
    fun data_mapping(){
        val user = User.makeUser("Измайлов Евгений")
        println(user)
        val userView = user.toUserView()
        userView.printMe()
    }
}
