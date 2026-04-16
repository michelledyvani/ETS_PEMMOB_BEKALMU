package com.example.bekalmu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StokAdapter(
    private val listMenu: List<MenuBekal>,
    private val onItemClick: (MenuBekal) -> Unit // Fungsi untuk handle klik
) : RecyclerView.Adapter<StokAdapter.StokViewHolder>() {

    // 1. Menentukan desain XML mana yang dipakai
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StokViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stok, parent, false)
        return StokViewHolder(view)
    }

    // 2. Memasukkan data ke dalam XML (Binding)
    override fun onBindViewHolder(holder: StokViewHolder, position: Int) {
        val menu = listMenu[position]
        holder.tvNama.text = menu.namaMenu
        holder.tvKategori.text = menu.kategori
        holder.tvStok.text = "${menu.jumlahStok} Porsi"

        // Handle klik untuk pindah ke Detail
        holder.itemView.setOnClickListener { onItemClick(menu) }
    }

    override fun getItemCount(): Int = listMenu.size

    // Kelas untuk memegang ID dari XML agar tidak dicari berulang-ulang
    class StokViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvItemNama)
        val tvKategori: TextView = view.findViewById(R.id.tvItemKategori)
        val tvStok: TextView = view.findViewById(R.id.tvItemStok)
    }
}