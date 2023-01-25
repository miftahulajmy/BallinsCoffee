package com.example.project_irfan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_produk.*

class Produk : AppCompatActivity() {

    private lateinit var menuAdapter: MenuRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_produk)
        initRecyclerView()
        tambahDataSet()
    }

    private fun tambahDataSet(){
        val data = Menu.buatSetData()
        menuAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recyler_view.apply {
            layoutManager = LinearLayoutManager(this@Produk)
            val spacingAtas = DekorasiSpasiGambar(20)
            addItemDecoration(spacingAtas)
            menuAdapter = MenuRecyclerAdapter()
            adapter = menuAdapter
        }
    }
}