package com.example.bekalmu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentDashboard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Tombol Utama Dashboard
        val btnTambah = view.findViewById<Button>(R.id.btnTambahStok)
        val btnDaftar = view.findViewById<Button>(R.id.btnLihatDaftar)
        val tvTotalMenu = view.findViewById<TextView>(R.id.tvTotalMenu)

        tvTotalMenu.text = DataStokGlobal.listStokBekal.size.toString()

        btnTambah.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_tambah)
        }

        btnDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_daftar)
        }

        // 2. Kenalkan View Histori
        val cvHistori1 = view.findViewById<View>(R.id.cvHistori1)
        val cvHistori2 = view.findViewById<View>(R.id.cvHistori2)
        val tvHistoriNama1 = view.findViewById<TextView>(R.id.tvHistoriNama1)
        val tvHistoriNama2 = view.findViewById<TextView>(R.id.tvHistoriNama2)

        // 3. Ambil data terbaru
        val listTerbaru = DataStokGlobal.listStokBekal.reversed()

        // 4. Masukkan data ke Histori (Jika ada)
        if (listTerbaru.isNotEmpty()) {
            cvHistori1.visibility = View.VISIBLE
            // Tambahkan tipe data MenuBekal agar tidak merah lagi
            val menu1: MenuBekal = listTerbaru[0]
            tvHistoriNama1.text = menu1.namaMenu
            cvHistori1.setOnClickListener { navigateToDetail(menu1) }

            if (listTerbaru.size > 1) {
                cvHistori2.visibility = View.VISIBLE
                val menu2: MenuBekal = listTerbaru[1]
                tvHistoriNama2.text = menu2.namaMenu
                cvHistori2.setOnClickListener { navigateToDetail(menu2) }
            }
        }
    } // <-- Batas akhir onViewCreated

    // FUNGSI NAVIGASI INI HARUS BERADA DI LUAR onViewCreated
    private fun navigateToDetail(menu: MenuBekal) {
        val bundle = Bundle()
        bundle.putSerializable("data_menu", menu)
        findNavController().navigate(R.id.action_dashboard_to_detail, bundle)
    }
}