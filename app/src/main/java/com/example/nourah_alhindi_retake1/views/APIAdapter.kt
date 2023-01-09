package com.example.nourah_alhindi_retake1.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nourah_alhindi_retake1.databinding.ApiRowBinding
import com.example.nourah_alhindi_retake1.models.data.UniversitiesItem

class APIAdapter(var UniversityList:ArrayList<UniversitiesItem>, val clicklistener: Clicklistener):RecyclerView.Adapter<APIAdapter.ViewHolder>(){
    class ViewHolder(var binding:ApiRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ApiRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val UniversityItem=UniversityList[position]

        holder.binding.apply {
            txtUniversityname.text=UniversityItem.name
            txtUniversityname.setOnClickListener {
                clicklistener.saveUniversitiesName(UniversityItem)
            }
        }
    }
    interface Clicklistener{
        fun saveUniversitiesName(name:UniversitiesItem)
    }
    override fun getItemCount(): Int {
        return UniversityList.size
    }

    fun updateUniversitieslist(newList:ArrayList<UniversitiesItem>)
    {
        UniversityList=newList
        notifyDataSetChanged()
    }
}