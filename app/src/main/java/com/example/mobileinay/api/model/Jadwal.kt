package com.example.mobileinay.api.model

data class JadwalResponse(
    val message: String,
    val data: DataJadwal,
)

data class JadwalRequest(
    val id_user: String,
    val day: String?
)

data class JadwalView(
    val mapel: String,
    val kitab: String,
    val jamMulai: String,
    val jamSelesai: String
)

data class DataJadwal(
    val id_kelas: Long,
    val kelas: Kelas,
)

data class Jadwal(
    val idJadwal: Long,
    val id_kelas: Long,
    val id_mapel: Long,
    val id_pengajar: Long,
    val hari: String,
    val mulai: String,
    val selesai: String,
    val created_at: String,
    val updated_at: String,
    val mapel: MapelData,
    val pengajar: Pengajar,
)