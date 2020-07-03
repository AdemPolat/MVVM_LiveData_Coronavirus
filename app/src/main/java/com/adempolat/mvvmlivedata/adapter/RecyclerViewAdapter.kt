package com.adempolat.mvvmlivedata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.adempolat.mvvmlivedata.R
import com.adempolat.mvvmlivedata.model.ModelData

import kotlinx.android.synthetic.main.item_recyclerview.view.*

class RecyclerViewAdapter(val dataList: ArrayList<ModelData>): RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder> (){
    class DataViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recyclerview,parent,false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.view.ulke.text = dataList[position].country
        holder.view.cases.text=dataList[position].cases
        holder.view.deaths.text=dataList[position].deaths
        holder.view.todayCases.text=dataList[position].todayCases
        holder.view.todayDeaths.text=dataList[position].todayDeaths
        holder.view.population.text=dataList[position].population




    }
    fun updateDataList(newDataList: List<ModelData>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }

}


