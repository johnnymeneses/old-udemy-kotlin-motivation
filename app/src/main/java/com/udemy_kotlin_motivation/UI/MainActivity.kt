package com.udemy_kotlin_motivation.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.udemy_kotlin_motivation.infra.MotivationConstants
import com.udemy_kotlin_motivation.R
import com.udemy_kotlin_motivation.data.Mock
import com.udemy_kotlin_motivation.data.Phrase
import com.udemy_kotlin_motivation.infra.SecurityPreferences
import com.udemy_kotlin_motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    //variavel que vai receber o biding
    private lateinit var binding: ActivityMainBinding

    private var categoryID = MotivationConstants.FILTER.ALL

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //Esconder barra de navegação
            supportActionBar?.hide()

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            handleUserName()
            handleFilter(R.id.imageAll)


            //Eventos
            binding.btnNovaFrase.setOnClickListener(this)
            binding.imageAll.setOnClickListener(this)
            binding.imageEmoji.setOnClickListener(this)
            binding.imageSun.setOnClickListener(this)


        }


    //Contrato View.OnClickListener assinado, implementar membros
    override fun onClick(view: View) {

        if (view.id == R.id.btn_novaFrase) {
            Toast.makeText(this, "Cliquei", Toast.LENGTH_SHORT).show()
            handleNewPhrase()

        } else if (view.id in listOf(R.id.imageAll, R.id.imageEmoji, R.id.imageSun)) {
            handleFilter(view.id)
        }


    }


    private fun handleUserName() {
        val nameTela = SecurityPreferences(this).getString(MotivationConstants.key.USER_NAME)
        binding.textSaudacao.text = "Olá, $nameTela !"
    }


    private fun handleNewPhrase(){
        binding.textMensagem.text = Mock().getPhrase(categoryID)
    }


    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.gray))

        when (id) {
            R.id.imageAll -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryID = MotivationConstants.FILTER.ALL

            }
            R.id.imageEmoji -> {
                binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryID = MotivationConstants.FILTER.Emoji
            }
            R.id.imageSun -> {
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryID = MotivationConstants.FILTER.Sun
            }


        }


    }


}