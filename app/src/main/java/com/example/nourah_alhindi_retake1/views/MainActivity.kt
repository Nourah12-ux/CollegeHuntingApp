package com.example.nourah_alhindi_retake1.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nourah_alhindi_retake1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
           btnAPI.setOnClickListener{
                val intent= Intent(this@MainActivity,API_Activity::class.java)
                startActivity(intent)
            }
            btnDB.setOnClickListener{
                val intent= Intent(this@MainActivity,DB_Activity::class.java)
                startActivity(intent)
            }
        }
    }
}