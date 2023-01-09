package com.example.nourah_alhindi_retake1.models

import com.example.nourah_alhindi_retake1.models.data.Universities
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    //http://universities.hipolabs.com/search?name=middle

    @GET("search")
    fun getAllUniversities(@Query("name") name:String): Call<Universities>
}