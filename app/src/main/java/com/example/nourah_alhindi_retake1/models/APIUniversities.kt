package com.example.nourah_alhindi_retake1.models

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIUniversities {
//http://universities.hipolabs.com/search?name=middle&country=turkey
    var gson = GsonBuilder()
        .setLenient()
        .create()

    var retrofit: Retrofit? = null
    fun getClint(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}