package com.example.project_irfan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.detail_menu_view.*

class DetilMenu : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_menu_view)
        if(intent.hasExtra("namanya")){
            val tema: String = this.intent.getStringExtra("temanya").toString()
            val nama: String = this.intent.getStringExtra("namanya").toString()
            val deskripsi: String = this.intent.getStringExtra("deskripsinya").toString()
            val harga: String = this.intent.getStringExtra("harganya").toString()
            val gambar: String = this.intent.getStringExtra("gambarnya").toString()
            setDetail(gambar,nama, tema, deskripsi, harga)
        }
    }
    fun setDetail(gambar: String, nama:String, tema:String, deskripsi:String, harga:String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        tema_detail_menu_view.text = tema
        nama_detail_menu_view.text = nama
        deskripsi_detail_menu_view.text = deskripsi
        harga_detail_menu_view.text = harga
        Glide.with(this)
            .load(gambar)
            .apply(requestOp)
            .centerCrop()
            .into(gambar_detail_menu_view)
    }
}