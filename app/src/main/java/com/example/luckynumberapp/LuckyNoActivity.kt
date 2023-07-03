package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import com.example.luckynumberapp.databinding.ActivityLuckyNoBinding
import java.util.Random

class LuckyNoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLuckyNoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_lucky_no)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_lucky_no)
        binding.button2.setTextColor(resources.getColorStateList(R.color.white,null))
        val bundle = intent.extras
        val userName = bundle?.getString("USERNAME")
        binding.textView3.text = "$userName, you are lucky today"
        val luckyNumber =getTheLuckyNumber()
         binding.textView4.text = "And your lucky number is ${luckyNumber}"
        binding.button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            //intent.putExtra(Intent.EXTRA_SUBJECT ,"$userName, is lucky today" )
            intent.putExtra(Intent.EXTRA_TEXT,"$userName, is lucky today\n with lucky number: $luckyNumber")
            intent.setType("text/plain")
            startActivity(intent)
        }

    }


    private fun getTheLuckyNumber():Int{
        val luckyNumber = Random().nextInt(100)
        return luckyNumber
    }
}