package com.example.mobileinay.api.model
import com.fasterxml.jackson.annotation.JsonProperty

data class JadwalResponse(
    val message: String,
    val data: Data,
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

data class Data(
    val id_kelas: Long,
    val kelas: Kelas,
)

data class Kelas(
    val id_kelas: Long,
    val kelas: String,
    val created_at: String,
    val updated_at: String,
    val jadwal: List<Jadwal>,
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
    val mapel: Mapel,
    val pengajar: Pengajar,
)


data class Mapel(
    val id_mapel: Long,
    val mapel: String,
    val created_at: String,
    val updated_at: String,
)

data class Pengajar(
    val id_pengajar: Long,
    val nama: String,
    val no_hp: String,
    val alamat: String,
    val jns_kelamin: String,
    val created_at: String,
    val updated_at: String,
)
