package com.example.bekalmu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentDetailStok : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_stok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Tangkap 'Kardus' data yang dikirim dari Halaman Daftar (RecyclerView)
        // suppress digunakan karena cara lama getSerializable agak usang, tapi paling aman untuk pemula
        @Suppress("DEPRECATION")
        val menu = arguments?.getSerializable("data_menu") as? MenuBekal

        // 2. Kenalkan semua view dari XML
        val tvNama = view.findViewById<TextView>(R.id.tvDetailNama)
        val tvKategori = view.findViewById<TextView>(R.id.tvDetailKategori)
        val tvHarga = view.findViewById<TextView>(R.id.tvDetailHarga)
        val tvStok = view.findViewById<TextView>(R.id.tvDetailStok)
        val btnKembali = view.findViewById<Button>(R.id.btnKembali)
        val btnBackTop = view.findViewById<TextView>(R.id.btnBackTop)
        btnBackTop.setOnClickListener { findNavController().popBackStack() }
        // 3. Masukkan data ke layar jika datanya tidak kosong
        if (menu != null) {
            tvNama.text = menu.namaMenu
            tvKategori.text = menu.kategori
            tvHarga.text = "Rp ${menu.harga}"
            tvStok.text = "${menu.jumlahStok} Porsi"
        }

        // 4. Beri fungsi pada tombol kembali
        btnKembali.setOnClickListener {
            findNavController().navigate(R.id.fragmentDashboard)
        }
    }
}