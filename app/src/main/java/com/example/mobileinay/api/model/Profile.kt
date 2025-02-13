package com.example.mobileinay.api.model

data class ProfileResponse(
    val message: String,
    val data: DataProfile,
)

data class DataProfile(
    val id_santri: Long,
    val id_ayah: Long,
    val id_ibu: Long,
    val id_kelas: Long,
    val id_kamar: Long,
    val id_status: Long,
    val nama: String,
    val nik: String,
    val no_hp: String,
    val email: String,
    val alamat: String,
    val tgl_lahir: String,
    val tgl_masuk: String,
    val photo: Any?,
    val jns_kelamin: String,
    val created_at: String,
    val updated_at: String,
    val password: String,
    val kelas: Kelas,
    val kamar: Kamar,
    val ayah: OrangTua,
    val ibu: OrangTua,
    val status_santri: StatusSantri,
)

