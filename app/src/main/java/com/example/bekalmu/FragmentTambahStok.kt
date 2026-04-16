package com.example.bekalmu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import android.widget.RadioButton
import android.widget.RadioGroup
class FragmentTambahStok : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tambah_stok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Kenalkan semua EditText dan Button dari XML
        val etIdMenu = view.findViewById<EditText>(R.id.etIdMenu)
        val etNamaMenu = view.findViewById<EditText>(R.id.etNamaMenu)
        val rgKategori = view.findViewById<RadioGroup>(R.id.rgKategori)
        val etHarga = view.findViewById<EditText>(R.id.etHarga)
        val etJumlahStok = view.findViewById<EditText>(R.id.etJumlahStok)
        val btnSimpan = view.findViewById<Button>(R.id.btnSimpanStok)
        val btnBack = view.findViewById<TextView>(R.id.btnBack)
        btnBack.setOnClickListener { findNavController().popBackStack() }
        // 2. Beri perintah saat tombol simpan diklik
        btnSimpan.setOnClickListener {
            // Ambil teks dari inputan dan buang spasi berlebih pakai trim()
            val id = etIdMenu.text.toString().trim()
            val nama = etNamaMenu.text.toString().trim()
            // Mencari ID RadioButton yang sedang dipilih
            val selectedId = rgKategori.checkedRadioButtonId
            val rbTerpilih = view.findViewById<RadioButton>(selectedId)
            // Ambil teks dari RadioButton yang terpilih (Makanan/Minuman)
            val kategori = rbTerpilih.text.toString()
            val harga = etHarga.text.toString().trim()
            val jumlah = etJumlahStok.text.toString().trim()



            // --- VALIDASI ANTI-ERROR ---
            // Pastikan tidak ada kolom yang dibiarkan kosong
            if (id.isEmpty() || nama.isEmpty() || kategori.isEmpty() || harga.isEmpty() || jumlah.isEmpty()) {
                Toast.makeText(requireContext(), "Semua data wajib diisi, Bos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Hentikan proses, jangan simpan
            }

            // 3. Bungkus data ke dalam kardus (Data Class)
            val menuBaru = MenuBekal(id, nama, kategori, harga, jumlah)

            // 4. Masukkan kardus ke dalam keranjang Global (Database Palsu)
            DataStokGlobal.listStokBekal.add(menuBaru)

            // 5. Tampilkan notifikasi sukses
            Toast.makeText(requireContext(), "$nama berhasil ditambahkan!", Toast.LENGTH_LONG).show()

            // 6. Kembali ke Dashboard
            findNavController().popBackStack()
        }
    }
}