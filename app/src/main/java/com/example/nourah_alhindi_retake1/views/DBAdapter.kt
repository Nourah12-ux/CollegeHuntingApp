package com.example.nourah_alhindi_retake1.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nourah_alhindi_retake1.databinding.ApiRowBinding
import com.example.nourah_alhindi_retake1.databinding.DbRowBinding
import com.example.nourah_alhindi_retake1.models.UniversityTable
import com.example.nourah_alhindi_retake1.models.data.UniversitiesItem

class DBAdapter (var UniversityList:List<UniversityTable>,val clicklistener:Clicklistener ):RecyclerView.Adapter<DBAdapter.ViewHolder>(){
    class ViewHolder(var binding: DbRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return DBAdapter.ViewHolder(
            DbRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val UniversityItem=UniversityList[position]

        holder.binding.apply {
            txname.text=UniversityItem.name
            txcountry.text=UniversityItem.country

            txname.setOnClickListener{
                clicklistener.showNotes(UniversityItem)
            }

            btnDelete.setOnClickListener {
                clicklistener.deleteUniversitiesName(UniversityItem)
            }
            btnUpdate.setOnClickListener {
                clicklistener.updateUniversitiesName(UniversityItem)
            }
        }

    }
    interface Clicklistener{
        fun showNotes(name: UniversityTable)
        fun deleteUniversitiesName(name:UniversityTable)
        fun updateUniversitiesName(name:UniversityTable)
    }

    override fun getItemCount(): Int {
        return UniversityList.size
    }

    fun updateUniversitieslist(newList:List<UniversityTable>)
    {
        UniversityList=newList
        notifyDataSetChanged()
    }



}