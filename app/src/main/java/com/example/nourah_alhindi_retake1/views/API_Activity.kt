package com.example.nourah_alhindi_retake1.views

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.nourah_alhindi_retake1.ViewModel.UniversitiesViewModel
import com.example.nourah_alhindi_retake1.databinding.ActivityApiBinding
import com.example.nourah_alhindi_retake1.models.APIInterface
import com.example.nourah_alhindi_retake1.models.APIUniversities
import com.example.nourah_alhindi_retake1.models.UniversityTable
import com.example.nourah_alhindi_retake1.models.data.Universities
import com.example.nourah_alhindi_retake1.models.data.UniversitiesItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class API_Activity : AppCompatActivity(),APIAdapter.Clicklistener {
    lateinit var bindig:ActivityApiBinding
    lateinit var viewModel: UniversitiesViewModel
    var name =""
    val UniversityList= arrayListOf<UniversitiesItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig=ActivityApiBinding.inflate(layoutInflater)
        setContentView(bindig.root)


        val adapter= APIAdapter(UniversityList,this)
        bindig.rvapi.adapter=adapter

        viewModel = ViewModelProvider(this).get(UniversitiesViewModel::class.java)


        bindig.apply {
            btSearch.setOnClickListener {
                name = bindig.edInput.text.toString()
                println("name:"+name)


                val apiClint = APIUniversities().getClint()
                if (apiClint != null) {
                    val apiInterface = apiClint.create(APIInterface::class.java)
                    apiInterface.getAllUniversities(name).enqueue(object : Callback<Universities> {
                        override fun onResponse(call: Call<Universities>, response: Response<Universities>) {
                            val body = response.body()
                            if (body != null) {
                                val universities = body
                                UniversityList.clear()
                                for (universitiesItem in universities) {
                                    UniversityList.add(universitiesItem)
                                    Log.d("retrofit", "onResponse ${universitiesItem.name}")
                                }
                                adapter.updateUniversitieslist(UniversityList)
                                edInput.text.clear()
                            }
                        }

                        override fun onFailure(call: Call<Universities>, t: Throwable) {
                            Log.d("retrofit", "onFailure:${t.message}")

                        }
                    })
                }

            }
        }

    }

    override fun saveUniversitiesName( University: UniversitiesItem) {
        if (University!= null) {
            val dialogBuilder = AlertDialog.Builder(this@API_Activity)

                .setPositiveButton("ADD", DialogInterface.OnClickListener { dialog, _ ->
                    viewModel.addUniversity(UniversityTable(0,University.name,University.country,""))
                    Toast.makeText(this@API_Activity, "the university added", Toast.LENGTH_SHORT).show()
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("You want to save the university to a local database?")
            alert.show()
        }
    }
}