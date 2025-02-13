package com.example.mobileinay.api.model

data class Kelas(
    val id_kelas: Long,
    val kelas: String,
    val created_at: String,
    val updated_at: String,
    val jadwal: List<Jadwal>,
)