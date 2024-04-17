package com.example.quiz_app.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz_app.R
import com.example.quiz_app.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    var score: Int = 0
    lateinit var binding: ActivityScoreBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        score = intent.getIntExtra("Score",0)

        binding.apply{
            scoretext.text = score.toString()
            backbutton.setOnClickListener{
                startActivity(Intent(this@ScoreActivity,MainActivity::class.java))
                finish()
                return@setOnClickListener
            }


        }
    }
}