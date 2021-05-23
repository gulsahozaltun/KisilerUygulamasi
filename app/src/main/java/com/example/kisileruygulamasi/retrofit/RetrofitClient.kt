package com.example.kisileruygulamasi.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient  {
    //listeye donusturmeyi saglayan alt yapi static olarak burada olusturuldu
    companion object {
        fun getClient(baseUrl: String): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}