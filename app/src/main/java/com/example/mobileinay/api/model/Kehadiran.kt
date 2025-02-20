package com.example.mobileinay.api.model

data class KehadiranResponse(
  val message: String,
  val data: List<KehadiranData>,
)

data class KehadiranData(
  val name: String,
  val jumlah: Long,
)