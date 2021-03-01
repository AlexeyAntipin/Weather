package com.company.weather.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beust.klaxon.Klaxon
import com.company.weather.models.Main
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result;

class MainActivityViewModel: ViewModel() {

    private var showText = MutableLiveData<Double>()

    fun getData(city: String) {
        val httpAsync = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=8e521744d51953e6b9ef676236503a52"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.d("MyLog", ex.toString())
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.d("MyLog", Klaxon().parse<Main>(data)?.main?.temp.toString())
                        showText.postValue(Klaxon().parse<Main>(data)?.main?.temp)
                    }
                }
            }

        httpAsync.join()
    }

    fun getProgressState(): MutableLiveData<Double> {
        return showText
    }
}