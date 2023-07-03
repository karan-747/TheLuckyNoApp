package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.luckynumberapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.button.setOnClickListener {
            var userName =  binding.editTextText.text.toString()
            if(userName.isNotEmpty()){
                val intent = Intent (this,LuckyNoActivity::class.java)
                intent.putExtra("USERNAME",userName)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Enter Username...",Toast.LENGTH_SHORT).show()
            }
        }

    }
}