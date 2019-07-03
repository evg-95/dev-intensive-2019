package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
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
        var user = User.makeUser("Evgeny Izmaylov")
        var user1 = User.makeUser("John Whick")
        var list :MutableList<User> = mutableListOf()
        list.add(user)
        list.add(user1)

        var chat = Chat.makeChat(list)
        println(BaseMessage.makeMessage(user, chat, Date().add(-12, TimeUnits.MINUTE),payload = "Hi!").formatMessage())
    }
}
