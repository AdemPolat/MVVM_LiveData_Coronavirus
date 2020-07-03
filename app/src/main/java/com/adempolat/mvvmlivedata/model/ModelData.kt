package com.adempolat.mvvmlivedata.model


import android.widget.ImageView
import com.google.gson.annotations.SerializedName

data class ModelData(

    @SerializedName("cases")
    var cases: String,
    @SerializedName("deaths")
    var deaths: String,
    @SerializedName("country")
    var country: String,
    @SerializedName("todayCases")
    var todayCases: String,
    @SerializedName("todayDeaths")
    var todayDeaths: String,
    @SerializedName("population")
    var population: String
    )
