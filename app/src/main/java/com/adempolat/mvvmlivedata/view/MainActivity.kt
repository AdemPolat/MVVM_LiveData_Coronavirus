package com.adempolat.mvvmlivedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.adempolat.mvvmlivedata.R
import com.adempolat.mvvmlivedata.adapter.RecyclerViewAdapter
import com.adempolat.mvvmlivedata.model.ModelData
import com.adempolat.mvvmlivedata.service.DataAPI
import com.adempolat.mvvmlivedata.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Locale.filter
import android.text.TextWatcher as TextWatcher1

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private val recyclerViewAdapter= RecyclerViewAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.refreshData()

        recyclerView.layoutManager= LinearLayoutManager( applicationContext)
        recyclerView.adapter = recyclerViewAdapter

    }




    override fun onStart() {
        super.onStart()

        swipeRefreshLayout.setOnRefreshListener {
            recyclerView.visibility=View.GONE
            dataError.visibility=View.GONE
            dataLoading.visibility=View.VISIBLE
            viewModel.refreshData()
            swipeRefreshLayout.isRefreshing=false
        }

        observeLiveData()
    }
    private fun observeLiveData(){
        viewModel.data.observe(this, Observer { data->
            data?.let {
                recyclerView.visibility= View.VISIBLE
                recyclerViewAdapter.updateDataList(data)
            }

        })
        viewModel.dataError.observe(this, Observer { error ->
            error?.let {
                if(it) {
                    dataError.visibility = View.VISIBLE
                } else {
                    dataError.visibility = View.GONE
                }
            }

        })
        viewModel.dataLoading.observe(this, Observer { loading->
            loading?.let {
                if (it) {
                    dataLoading.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    dataError.visibility = View.GONE
                } else {
                    dataLoading.visibility = View.GONE
                }
            }

        })
    }

}