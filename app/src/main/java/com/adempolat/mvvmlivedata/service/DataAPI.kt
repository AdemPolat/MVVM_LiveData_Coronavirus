package com.adempolat.mvvmlivedata.service

import com.adempolat.mvvmlivedata.model.ModelData
import io.reactivex.Single
import retrofit2.http.GET

interface DataAPI {
    //https://api.github.com/users/hadley/
    @GET("v3/covid-19/countries")
    fun getBaseData(): Single<List<ModelData>>
}