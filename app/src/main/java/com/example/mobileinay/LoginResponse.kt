package com.example.mobileinay

data class Profile(
    val message: String,
    val data: UserData?
)
data class JadwalNew(
    val message: String,
    val data: DataKelas?
)
data class UserData(
    val id_santri: String,
    val nama: String,
    val email: String,
    val kelas: Kelas?,
    val password: String,
)
data class DataKelas(
    val id_kelas: Int,
    val kelas: Kelas?
)

data class Kelas(
    val id_kelas: Int,
    val kelas: String,
    val jadwal: List<DataJadwal>,
    val created_at: String,
    val updated_at: String
)
data class nilai(
    val mapel: String,
    val uts: Int,
    val uas: Int,
    val tugas: Int,
    val semester: Int
)

data class Jadwal(
    val hari: String,
    val pelajaran: List<DataJadwal>
)
data class DataJadwal(
    val kegiatan: String,
    val kitab: String,
    val jamMulai: String,
    val jamSelesai: String,
)


data class Pendidikan(
    val id_pendidikan: Int,
    val pendidikan: String,
    val is_aktif: Int,
    val created_at: String,
    val updated_at: String
)




