package com.udemy_kotlin_motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.udemy_kotlin_motivation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySplashBinding //Aqui vai o nome da activity Declarada


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        binding = ActivitySplashBinding.inflate(layoutInflater) //instanciada
        setContentView(binding.root) //sendo usada

        binding.buttonSalvarNome.setOnClickListener(this)

        supportActionBar?.hide()


    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_SalvarNome) {
            handleSave()
        }

    }




    fun handleSave() {



        val name = binding.textNome.text.toString()

        if (name != "") {

            //Salvei o nome do usuario
            SecurityPreferences(this).storeString("USER_NAME",name)

            //Intenção
            startActivity(Intent(this, MainActivity::class.java))
            finish() //destruir tela atual

        } else {
            Toast.makeText(this, "Preencha o nome", Toast.LENGTH_SHORT).show()
        }


    }

}