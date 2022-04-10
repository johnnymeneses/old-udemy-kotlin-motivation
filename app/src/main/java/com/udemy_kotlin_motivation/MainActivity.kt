package com.udemy_kotlin_motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.udemy_kotlin_motivation.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    //variavel que vai receber o biding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Esconder barra de navegação
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNovaFrase.setOnClickListener(this)

    }

    //Contrato View.OnClickListener assinado, implementar membros
    override fun onClick(view: View) {
        if (view.id == R.id.btn_novaFrase) {
            println("Cliquei")
        }
    }
}