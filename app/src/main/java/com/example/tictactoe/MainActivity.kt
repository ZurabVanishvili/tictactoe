package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var one : Button
    private lateinit var two : Button
    private lateinit var three : Button
    private lateinit var four : Button
    private lateinit var five : Button
    private lateinit var six : Button
    private lateinit var seven : Button
    private lateinit var eight : Button
    private lateinit var nine : Button
    private lateinit var restart : Button
    private var  activePlayer = 1
    private var  firstPlayer = ArrayList<Int>()
    private var  secondPlayer = ArrayList<Int>()
    private  lateinit var firstPlayerscore :TextView
    private  lateinit var secondPlayerscore :TextView
    private lateinit var score1 :TextView
    private lateinit var score2 :TextView
    private var pirveli = 0
    private var meore = 0
    private lateinit var resetscore : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        restart.setOnClickListener{
            reset()

        }
        resetscore.setOnClickListener(){
            resetscore()
        }



    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.one -> buttonNumber = 1
                R.id.two -> buttonNumber = 2
                R.id.three -> buttonNumber =3
                R.id.four -> buttonNumber = 4
                R.id.five -> buttonNumber = 5
                R.id.six -> buttonNumber = 6
                R.id.seven -> buttonNumber = 7
                R.id.eight -> buttonNumber = 8
                R.id.nine -> buttonNumber = 9
                R.id.restart -> restart
            }
            if (buttonNumber != 0 ){
                    playGame(clickedView , buttonNumber)
            }


        }



    }


    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)

        }
        else{
            clickedView.text = "O"
            clickedView.setTextColor(Color.WHITE)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false

        check()

    }

    private fun check() {
        var winnerPlayer = 0


        if (firstPlayer.contains(1)&& firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1)&& secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1)&& firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1)&& secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1)&& firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1)&& secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(2)&& firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(2)&& secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(3)&& firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3)&& secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(4)&& firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4)&& secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(3)&& firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3)&& secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2

        }
        if (firstPlayer.contains(7)&& firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7)&& secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2

        }
        if(winnerPlayer == 0 && firstPlayer.size + secondPlayer.size == 9){
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
            
        }

        if (winnerPlayer == 1 ) {
            pirveli += 1
            score1.text = pirveli.toString()
            Toast.makeText(this, "First player is Winner", Toast.LENGTH_SHORT).show()



        }
        else if (winnerPlayer == 2 ) {
            Toast.makeText(this, " Second player  is Winner", Toast.LENGTH_SHORT).show()
            meore += 1
            score2.text = meore.toString()


        }
        if (winnerPlayer!=0 ){
            one.isEnabled =false
            two.isEnabled =false
            three.isEnabled =false
            four .isEnabled =false
            five.isEnabled =false
            six.isEnabled =false
            seven.isEnabled =false
            eight.isEnabled =false
            nine.isEnabled =false

        }


    }


    private fun init(){
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        restart  = findViewById(R.id.restart)
        firstPlayerscore = findViewById(R.id.firstPlayerscore)
        secondPlayerscore = findViewById(R.id.secondPlayerscore)
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)
        resetscore = findViewById(R.id.resetscore)

        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        restart.setOnClickListener(this)
        resetscore.setOnClickListener(this)


    }
    fun reset(){
        one.text = ""
        two.text = ""
        three.text = ""
        four.text = ""
        five.text = ""
        six.text = ""
        seven.text = ""
        eight.text = ""
        nine.text = ""

        activePlayer = 1
        firstPlayer.clear()
        secondPlayer.clear()
        one.isEnabled = true
        two.isEnabled = true
        three.isEnabled = true
        four.isEnabled = true
        five.isEnabled = true
        six.isEnabled = true
        seven.isEnabled = true
        eight.isEnabled = true
        nine.isEnabled = true

    }

    fun resetscore(){
        pirveli = 0
        meore = 0
        score1.text = pirveli.toString()
        score2.text = meore.toString()

    }


    }



