package com.example.mobileinay.api.model

data class NilaiResponse(
  val message: String,
  val data: List<NilaiData>
)

data class NilaiData(
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
)