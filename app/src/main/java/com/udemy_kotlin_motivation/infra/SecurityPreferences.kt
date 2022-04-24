package com.udemy_kotlin_motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    //salvar o valor
    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    //recuperar o valor
    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
        //Se este for nulo security.getString(key, "") -> retorna esse ?: ""
        //Se não for nulo, é usada essa (key, "")
    }

}