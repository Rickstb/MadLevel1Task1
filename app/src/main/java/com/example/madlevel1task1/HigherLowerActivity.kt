package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.buttonL.setOnClickListener { onLowerClick() }
        binding.buttonE.setOnClickListener { onEqualClick() }
        binding.buttonH.setOnClickListener { onHigherClick() }
        updateUI()
    }
    private fun updateUI(){
        binding.PLastThrow.text = getString(R.string.Last_throw, lastThrow)


        when(currentThrow){
            1-> binding.Image.setImageResource(R.drawable.dice1)
            2 -> binding.Image.setImageResource(R.drawable.dice2)
            3 -> binding.Image.setImageResource(R.drawable.dice3)
            4 -> binding.Image.setImageResource(R.drawable.dice4)
            5 -> binding.Image.setImageResource(R.drawable.dice5)
            6 -> binding.Image.setImageResource(R.drawable.dice6)

        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) AnswerCorrect()
        else AnswerIncorrect()
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) AnswerCorrect()
        else AnswerIncorrect()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) AnswerCorrect()
        else AnswerIncorrect()
    }
    private fun AnswerIncorrect() {
        Toast.makeText(this, getString(R.string.Correct), Toast.LENGTH_LONG).show()
    }

    private fun AnswerCorrect() {
        Toast.makeText(this, getString(R.string.Incorrect), Toast.LENGTH_LONG).show()
    }


}