package ru.skillbranch.devintensive.utils

import androidx.core.text.trimmedLength

object Utils {
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
}