package com.example.bekalmu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentDaftarStok : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_daftar_stok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvStok = view.findViewById<RecyclerView>(R.id.rvStokBekal) // Pastikan ID ini ada di XML
        val btnBack = view.findViewById<TextView>(R.id.btnBack)
        btnBack.setOnClickListener { findNavController().popBackStack() }
        // Atur layout jadi memanjang ke bawah
        rvStok.layoutManager = LinearLayoutManager(requireContext())

        // Pasang Adapter
        val adapter = StokAdapter(DataStokGlobal.listStokBekal) { menu ->
            // Saat item diklik, lempar datanya ke Detail menggunakan Bundle
            val bundle = Bundle()
            bundle.putSerializable("data_menu", menu)
            findNavController().navigate(R.id.action_daftar_to_detail, bundle)
        }

        rvStok.adapter = adapter
    }
}