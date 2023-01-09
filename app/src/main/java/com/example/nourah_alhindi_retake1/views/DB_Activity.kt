package com.example.nourah_alhindi_retake1.views

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nourah_alhindi_retake1.R
import com.example.nourah_alhindi_retake1.ViewModel.UniversitiesViewModel
import com.example.nourah_alhindi_retake1.databinding.ActivityDbBinding
import com.example.nourah_alhindi_retake1.models.UniversityTable
import com.example.nourah_alhindi_retake1.models.data.UniversitiesItem

class DB_Activity : AppCompatActivity(),DBAdapter.Clicklistener {
    lateinit var binding: ActivityDbBinding
    lateinit var RvAdapter:DBAdapter
    lateinit var viewModel: UniversitiesViewModel
    val UniversityList= listOf<UniversityTable>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDbBinding.inflate(layoutInflater)
        setContentView(binding.root)


        RvAdapter=DBAdapter(UniversityList,this)
        binding.rvdatabasa.adapter=RvAdapter
        binding.rvdatabasa.layoutManager= LinearLayoutManager(this)


        //view model
        viewModel = ViewModelProvider(this).get(UniversitiesViewModel::class.java)
        viewModel.getUniversities().observe(this) { it -> RvAdapter.updateUniversitieslist(it)}



    }

    override fun showNotes(name: UniversityTable) {
        if(name!=null)
        {
            Toast.makeText(this,name.note,Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"note is empty",Toast.LENGTH_LONG).show()

        }
    }

    override fun deleteUniversitiesName(name: UniversityTable) {
        viewModel.deleteUniversity(name)
        Toast.makeText(this,"University deleted",Toast.LENGTH_LONG).show()

    }

    override fun updateUniversitiesName(name: UniversityTable) {
        if (name!= null) {
            val input = EditText(this@DB_Activity)
            val dialogBuilder = AlertDialog.Builder(this@DB_Activity)
                .setPositiveButton("SAVE", DialogInterface.OnClickListener { dialog, _ ->
                    val massage = input.text.toString()
                    name.note = massage
                    viewModel.update(name)
                    Toast.makeText(this@DB_Activity, "the notes  Updated", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this,name.note,Toast.LENGTH_LONG).show()
                })
                // negative button text and action
                .setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Update Notes")
            alert.setView(input)
            alert.show()
        }

    }
}