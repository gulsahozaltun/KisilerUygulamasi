package com.example.kisileruygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.repo.KisilerDaoRepository

class AnasayfaFragmentViewModel:ViewModel() {
    var kisilerListesi=MutableLiveData<List<Kisiler>>()
    val kdaor=KisilerDaoRepository()

    init{
        kisilerYukle()
        kisilerListesi=kdaor.kisilerGetir()
    }
    fun kisilerYukle(){
        kdaor.tumKisileriAl()

    }

    fun sil(kisi_id:Int){
    kdaor.kisiSil(kisi_id)
    }

    fun ara(aramaKelimesi:String){
        kdaor.kisiAra(aramaKelimesi)
    }
}