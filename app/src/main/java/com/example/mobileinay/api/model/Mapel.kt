package com.example.mobileinay.api.model

data class MapelResponse(
    val message: String,
    val data: List<MapelWithPengajar>
)
data class MapelWithPengajar(
    val mapel: String,
    val pengajar: String,
)
data class MapelDaUm (
    val id_nilai: Long,
    val id_santri: Long,
    val id_mapel: Long,
    val id_pengajar: Long,
    val nilai: Long,
    val tugas: String,
    val created_at: String,
    val updated_at: String,
    val ket: String,
    val mapel: MapelData,
    val pengajar: Pengajar
)

data class MapelData(
    val id_mapel: Long,
    val mapel: String,
    val created_at: String,
    val updated_at: String,
)