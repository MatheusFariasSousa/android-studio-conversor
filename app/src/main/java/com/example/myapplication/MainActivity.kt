package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.truncate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botao=findViewById<Button>(R.id.botao)
        val resposta=findViewById<TextView>(R.id.resposta)
        val dia=findViewById<TextView>(R.id.dia)
        val alunos=findViewById<Button>(R.id.alunos)

        fun isNumericToX(toCheck: String): Boolean {
            return toCheck.toDoubleOrNull() != null
        }



        fun conversor(valor: Double): Array<String> {
            val horas1=((valor/60)/60)
            val minutos0=valor%(24*3600)
            val minutos1=minutos0%3600
            val minutos3=minutos1/60
            val segundos1=valor%60
            val horas:String=("%.0f".format(truncate(horas1.toDouble())))
            val minutos:String=("%.0f".format(truncate(minutos3.toDouble())))
            val segundos:String=("%.0f".format(truncate(segundos1.toDouble())))
            return arrayOf(horas,minutos,segundos)


        }

        fun pg2 (){
            val tela2= Intent(this,MainActivity2::class.java)
            startActivity(tela2)
        }



        botao.setOnClickListener {
            val numb=findViewById<EditText>(R.id.valor).text.toString()
            val teste= isNumericToX(numb)
            if (teste==true){
                val valor=numb.toDouble()
                val resultado=conversor(valor)
                val final = "${resultado[0]}:${resultado[1]}:${resultado[2]}"
                val local="hora:minuto:segundo"

                resposta.text=local
                dia.text=final
            }
            else{
                resposta.text="Insira um valor válido!"

            }


        }

        alunos.setOnClickListener {
            pg2()
        }



    }
}