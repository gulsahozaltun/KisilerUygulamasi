package com.example.kisileruygulamasi.retrofit

import com.example.kisileruygulamasi.retrofit.KisilerDaoInterface

class ApiUtils {

    companion object{
        //bu url ile kisilerDao daki url birlesip calisacak
        val BASE_URL="http://kasimadalan.pe.hu/"

        fun getKisilerDaoInterface(): KisilerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }

}