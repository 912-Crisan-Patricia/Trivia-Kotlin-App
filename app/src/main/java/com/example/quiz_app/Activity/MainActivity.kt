package com.example.quiz_app.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz_app.Domain.QuestionModel
import com.example.quiz_app.R
import com.example.quiz_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        //enableEdgeToEdge()
        setContentView(binding.root)
        val window:Window= this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.grey)


        binding.apply{
            menu.setItemSelected(R.id.home)
            menu.setOnItemSelectedListener {
                if(it==R.id.Board){
                    startActivity(Intent(this@MainActivity,LeaderActivity::class.java))
                }
            }
            singlebutton.setOnClickListener{
                val intent= Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }


    private  fun questionList():MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Which planet is the largest in our solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            ))

        question.add(
            QuestionModel(
                    2,
            "What is the closest star to Earth?",
            "Venus",
            "Mars",
            "The Sun",
            "Jupiter",
            "c",
            5,
            "q_2",
            null
        ))
        question.add(
        QuestionModel(
            3,
            "What is the study of drugs and their effects called?",
            "Zoology",
            "Botany",
            "Pharmacology",
            "Psychology",
            "c",
            5,
            "q_3",
            null
        ))
        question.add(
        QuestionModel(
            4,
            "Which country is known as the 'Land of the Rising Sun'?",
            "China",
            "Australia",
            "Japan",
            "Brazil",
            "c",
            5,
            "q_4",
            null
        ))
        question.add(
        QuestionModel(
            5,
            "Which organelle is known as the 'powerhouse of the cell'?",
            "Nucleus",
            "Ribosome",
            "Mitochondria",
            "Endoplasmic reticulum",
            "c",
            5,
            "q_5",
            null
        ))
        question.add(
        QuestionModel(
            6,
            "Who wrote the famous poem 'The Raven'?",
            "William Wordsworth",
            "Edgar Allan Poe",
            "Robert Frost",
            "Emily Dickinson",
            "b",
            5,
            "q_6",
            null
        ))
        question.add(
        QuestionModel(
            7,
            "What is the capital city of Australia?",
            "Sydney",
            "Melbourne",
            "Canberra",
            "Brisbane",
            "c",
            5,
            "q_7",
            null
        ))
        question.add(
        QuestionModel(
            8,
            "Who is the author of the Harry Potter series?",
            "J.R.R. Tolkien",
            "J.K. Rowling",
            "Stephen King",
            "George R.R. Martin",
            "b",
            5,
            "q_8",
            null
        ))
        question.add(
        QuestionModel(
            9,
            "Which is the longest river in the world?",
            "Nile",
            "Amazon",
            "Yangtze",
            "Mississippi",
            "a",
            5,
            "q_9",
            null
        ))
        question.add(
        QuestionModel(
            10,
            "Which planet is known as the 'Red Planet'?",
            "Earth",
            "Mars",
            "Neptune",
            "Jupiter",
            "b",
            5,
            "q_10",
            null
        ))
        return question
    }

}