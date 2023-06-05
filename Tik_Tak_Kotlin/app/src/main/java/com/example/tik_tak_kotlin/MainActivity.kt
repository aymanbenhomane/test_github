package com.example.tik_tak_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSelect(view: View){
        val btnChoise = view as Button
        var cellID = 0
        when(btnChoise.id){
            R.id.btn1-> cellID = 1
            R.id.btn2-> cellID = 2
            R.id.btn3-> cellID = 3
            R.id.btn4-> cellID = 4
            R.id.btn5-> cellID = 5
            R.id.btn6-> cellID = 6
            R.id.btn7-> cellID = 7
            R.id.btn8-> cellID = 8
            R.id.btn9-> cellID = 9
        }
        Log.d("cellID",cellID.toString())
        PlayGame(cellID,btnChoise)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun  PlayGame(cellID:Int,btnChoise:Button){
        if (activePlayer == 1){
            btnChoise.text="X"
            btnChoise.setBackgroundResource(R.drawable.xtictac)
            player1.add(cellID)
            activePlayer =2
            AutoPlay()
            CheckWinner()
            ens
        }else{
            btnChoise.text="O"
            btnChoise.setBackgroundResource(R.drawable.otictactoe)
            player2.add(cellID)
            activePlayer =1
            CheckWinner()
        }
        btnChoise.isEnabled=false
    }

    fun CheckWinner(){
        var winner = -1
        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) ){
            winner=1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3) ){
            winner=2
        }
        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6) ){
            winner=1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6) ){
            winner=2
        }
        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            winner=1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9) ){
            winner=2
        }
        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7) ){
            winner=1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7) ){
            winner=2
        }
        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8) ){
            winner=1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8) ){
            winner=2
        }
        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9) ){
            winner=1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9) ){
            winner=2
        }
        if (winner != -1){
            if (winner == 1){
                Toast.makeText(this,"Player 1 win the game",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Player 2 win the game",Toast.LENGTH_SHORT).show()
            }
        }
     }

    fun AutoPlay(){

        //scan empty cells
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9){
            if (!(player1.contains(cellID) || player2.contains(cellID)) ){
                emptyCells.add(cellID)
            }
        }
        //select rand index
        val r=Random
        val ranIndix = r.nextInt(emptyCells.size-0)+0
        val CellID = emptyCells[ranIndix]

        //interpeter index to button
        var buSelect :Button?
        when (CellID){
            1 -> buSelect = btn1
            2 -> buSelect = btn2
            3 -> buSelect = btn3
            4 -> buSelect = btn4
            5 -> buSelect = btn5
            6 -> buSelect = btn6
            7 -> buSelect = btn7
            8 -> buSelect = btn8
            9 -> buSelect = btn9
            else ->{
                buSelect=btn1
            }
        }

        //press
        PlayGame(CellID,buSelect)

    }

}
