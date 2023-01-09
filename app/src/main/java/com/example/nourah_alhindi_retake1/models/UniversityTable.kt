package com.example.nourah_alhindi_retake1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UniversityTable(
    @PrimaryKey(autoGenerate = true)
    val pk:Int,
    val name:String,
    val country:String,
    var note:String
)
