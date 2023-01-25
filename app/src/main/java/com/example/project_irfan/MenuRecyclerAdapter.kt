package com.example.project_irfan

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_list_menu.view.*
import java.util.ArrayList

class MenuRecyclerAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ListObjMenu> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_menu, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener {
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }

    fun submitList(LisMenu: List<ListObjMenu>) {
        items = LisMenu
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MenuViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val gambar: ImageView = itemView.gambar
        val nama: TextView = itemView.nama
        val harga: TextView = itemView.harga
        var klik: RelativeLayout = itemView.findViewById(R.id.rl_klik)

        fun bind(listObjDosen: ListObjMenu) {
            nama.setText(listObjDosen.nama)
            harga.setText(listObjDosen.harga)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(listObjDosen.gambar)
                .into(gambar)

        }

        fun kalau_diklik(get: ListObjMenu) {
            val position: Int = adapterPosition
            Toast.makeText(
                itemView.context, "Kamu memilih : ${get.nama}",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(itemView.context, DetilMenu::class.java)
            intent.putExtra("namanya", get.nama)
            intent.putExtra("harganya", get.harga)
            intent.putExtra("gambarnya", get.gambar)
            intent.putExtra("temanya", get.tema)
            intent.putExtra("deskripsinya", get.deskripsi)
            itemView.context.startActivity(intent)
        }
    }
}