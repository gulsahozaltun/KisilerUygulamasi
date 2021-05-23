package com.example.kisileruygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context,var kisilerListesi:List<Kisiler>,var viewModel:AnasayfaFragmentViewModel)
    :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding):
            RecyclerView.ViewHolder(cardTasarimBinding.root){

        var cardTasarim:CardTasarimBinding

        init{
            this.cardTasarim=cardTasarimBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim=CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val kisi=kisilerListesi.get(position)

        holder.cardTasarim.imageViewSil.setOnClickListener {


            Snackbar.make(it,"${kisi.kisi_ad} silmek istiyor musunuz?",Snackbar.LENGTH_LONG).setAction("Evet"){
                viewModel.sil(kisi.kisi_id)
                Snackbar.make(it,"${kisi.kisi_ad} silindi",Snackbar.LENGTH_LONG).show()
                true
            }.show()

        }
        //holder.cardTasarim.textViewKisiBilgi.text="${kisi.kisi_id} - ${kisi.kisi_tel}"
        holder.cardTasarim.kisiNesnesi=kisi

        holder.cardTasarim.satirCard.setOnClickListener {

           val gecis=AnasayfaFragmentDirections.detayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)

        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }


}