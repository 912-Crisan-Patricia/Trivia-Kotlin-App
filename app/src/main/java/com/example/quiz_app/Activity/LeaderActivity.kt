package com.example.quiz_app.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quiz_app.Domain.UserModel
import com.example.quiz_app.R
import com.example.quiz_app.databinding.ActivityLeaderBinding
import com.example.quiz_app.Adapter.LeaderAdapter

class LeaderActivity : AppCompatActivity() {

    lateinit var binding:ActivityLeaderBinding

    private val leaderAdapter by lazy { LeaderAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LeaderActivity, R.color.grey)


        binding.apply{
            coinmoney1.text=loadData().get(0).score.toString()
            coinmoney2.text=loadData().get(1).score.toString()
            coinmoney3.text=loadData().get(2).score.toString()
            title1top.text=loadData().get(0).name
            title2top.text=loadData().get(1).name
            title3top.text=loadData().get(2).name

            val drawableResourceId1:Int= binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            val drawableResourceId2:Int= binding.root.resources.getIdentifier(
                loadData().get(1).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            val drawableResourceId3:Int= binding.root.resources.getIdentifier(
                loadData().get(2).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)


            menu.setItemSelected(R.id.Board)
            //bottomMenu.setItemSelected(R.id.Board)
            menu.setOnItemSelectedListener {
                if(it==R.id.home){
                    startActivity((Intent(this@LeaderActivity,MainActivity::class.java)))
                }
            }

            var list:MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply{
                layoutManager=LinearLayoutManager(this@LeaderActivity)
                adapter=leaderAdapter

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadData():MutableList<UserModel>{
        val users:MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1, "Patricia","person1",48763))
        users.add(UserModel(2, "John", "person2", 4879))
        users.add(UserModel(3, "Marcus", "person3", 2345))
        users.add(UserModel(4, "Michael", "person4", 1234))
        users.add(UserModel(5, "Sophia", "person5", 2671))
        users.add(UserModel(6, "William", "person6", 9328))
        users.add(UserModel(7, "Emma", "person7", 15632))
        users.add(UserModel(8, "Alexander", "person8", 7849))
        users.add(UserModel(9, "Olivia", "person9", 28764))
        users.add(UserModel(10,"James", "person10", 456))

        return users.sortedByDescending { it.score }.toMutableList()
    }
}