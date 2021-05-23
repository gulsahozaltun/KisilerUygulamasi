package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.KisilerAdapter

import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.viewmodel.AnasayfaFragmentViewModel


class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaFragmentViewModel
    private lateinit var adapter:KisilerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment=this
        tasarim.anaSayfaToolbarBaslik= "Kisiler"

        //arama ozelligi bu olmadan calismaz
        //toolbar uzerine menu eklemek icin yazilmasi gereken kod
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.kisilerListesi.observe(viewLifecycleOwner,{ kisilerListesi ->
            adapter= KisilerAdapter(requireContext(),kisilerListesi,viewModel)
            tasarim.adapter=adapter

        })






        return tasarim.root
    }

    fun fabTikla(view: View){
        Navigation.findNavController(view).navigate(R.id.kayitGecis)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //options menuyu calistirmak icin gerekli olan yapi
        setHasOptionsMenu(true)
        val temp:AnasayfaFragmentViewModel by viewModels()
        viewModel=temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //bu sayfaya toolbar menuyu baglamis olduk
        inflater.inflate(R.menu.toolbar_arama,menu)
        //menu uzerindeki item a tiklayinca aramayi tetiklemek icin kod yaziyoruz
        val item=menu.findItem(R.id.action_ara)

        val searchView=item.actionView as SearchView

        //searchView i sayfaya bagliyoruz
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisilerYukle()
    }
}