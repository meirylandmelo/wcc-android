package com.wcc.lance_dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lanceDadosBotao = findViewById<Button>(R.id.lanceDadosBotao)
        val dado1 = findViewById<ImageView>(R.id.dado1)
        val dado2 = findViewById<ImageView>(R.id.dado2)

       lanceDadosBotao.setOnClickListener {
           dado1.setImageResource(lanceDados())
           dado2.setImageResource(lanceDados())
        }

        val playerName = getIntent().getStringExtra("playerName")
        val playerNameTextView = findViewById<TextView>(R.id.playerNameText)
        playerNameTextView.text = "Olá, $playerName!"
    }

    fun lanceDados(): Int {
        return recuperaFaceDados(gerarNumero())
    }

    fun recuperaFaceDados(valor:Int): Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun gerarNumero() : Int {
            return (1..6).random()
   }
}