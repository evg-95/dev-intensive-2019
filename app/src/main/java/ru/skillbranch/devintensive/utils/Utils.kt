package ru.skillbranch.devintensive.utils

import android.service.voice.AlwaysOnHotwordDetector
import androidx.core.text.trimmedLength
import java.io.File
import java.nio.charset.Charset
import java.util.*

object Utils {
    val dictionary = TreeMap<String, String>()
    init {
        val file = File("C:\\Users\\Evgeny\\Documents\\dev-intensive-2019\\app\\src\\main\\java\\ru\\skillbranch\\devintensive\\utils\\dict.txt")
        val payload = file.readBytes().toString(Charset.forName("UTF-8")).split(",")
        for (elem in payload)
        {
            dictionary[elem[0].toString()] = elem.split(":")[1]
        }
    }
    fun parseFullName(fullName: String?): Pair <String?, String?>{
        val parts: List<String>? = fullName?.split(" ")
        val firstName = when(parts?.getOrNull(0)){
            ""-> null
            else-> parts?.getOrNull(0)
        }
        val lastName = when(parts?.getOrNull(1)){
            ""-> null
            else-> parts?.getOrNull(1)
        }
        return firstName to lastName
    }
    fun toInitials(firstName :String?, lastName :String?):String?{
        var res: String = when (firstName?.trim()){
            ""-> ""
            else-> firstName?.trim()?.first()?.toString()?.toUpperCase() ?: ""
        }
        res += when (lastName?.trim()){
                ""-> ""
                else-> lastName?.trim()?.first()?.toString()?.toUpperCase() ?: ""
            }
        return if (res == "") null else res
    }

    fun transliteration(payload: String =" ", devider: String =" "):String{
        var result :String = payload.replace(" ",devider)
        for (elem in dictionary)
            result = result.replace(elem.key,elem.value)
        return result
    }
}