package com.example.kisileruygulamasi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.repo.KisilerDaoRepository

class KisiDetayFragmentViewModel:ViewModel() {
    val kdaor= KisilerDaoRepository()
    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        kdaor.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)

    }
}