package com.example.mobileinay.api.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OrangTua(
    val id_ortu: Long,
    val id_pekerjaan: Long,
    val id_gaji: Long,
    val id_pendidikan: Long,
    val nama: String,
    val no_hp: String,
    val nik: String,
    val alamat: String,
    val is_hidup: Long,
    val is_wali: Long,
    val jns_kelamin: String,
    val created_at: String,
    val updated_at: String,
    val updatedAt: String,
    val gaji: Gaji,
    val pekerjaan: Pekerjaan,
    val pendidikan: Pendidikan
    )
