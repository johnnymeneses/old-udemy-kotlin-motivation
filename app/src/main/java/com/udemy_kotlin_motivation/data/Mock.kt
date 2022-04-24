package com.udemy_kotlin_motivation.data

import com.udemy_kotlin_motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryID: Int) //classe de dados

class Mock {

    val all = MotivationConstants.FILTER.ALL
    val sun = MotivationConstants.FILTER.Sun
    val emoji = MotivationConstants.FILTER.Emoji


    private val mListPhrase = listOf<Phrase>(
        Phrase("Frase sun 1", sun),
        Phrase("Frase sun 2", sun),
        Phrase("Frase sun 3", sun),
        Phrase("Frase sun 4", sun),
        Phrase("Frase sun 5", sun),
        Phrase("Frase emoji 1", emoji),
        Phrase("Frase emoji 2", emoji),
        Phrase("Frase emoji 3", emoji),
        Phrase("Frase emoji 4", emoji),
        Phrase("Frase emoji 5", emoji)
    )

    fun getPhrase(value: Int): String {


        val filtered = mListPhrase.filter { it.categoryID == value || value==all }
        val index = Random.nextInt(filtered.size)
        filtered[index]

        return filtered[index].description


    }


}