package com.example.bekalmu

import java.io.Serializable

data class MenuBekal(
    val idMenu: String,
    val namaMenu: String,
    val kategori: String,
    val harga: String,
    val jumlahStok: String
) : Serializable