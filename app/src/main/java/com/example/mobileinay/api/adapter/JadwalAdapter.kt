package com.example.mobileinay.api.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.api.model.Jadwal

class JadwalAdapter(
    private var jadwalList: List<Jadwal>?
) : RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>() {

    // ViewHolder untuk mengikat data ke tampilan
    class JadwalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val jdlKegiatan: TextView? = itemView.findViewById(R.id.JdlKegiatan)
        private val kitab: TextView? = itemView.findViewById(R.id.Kitab)
        private val jamMulai: TextView? = itemView.findViewById(R.id.jamMulai)
        private val jamSelesai: TextView? = itemView.findViewById(R.id.jamSelesai)

        fun bind(jadwal: Jadwal?) {
            jdlKegiatan?.text = jadwal?.mapel?.mapel ?: "Tidak tersedia"
            kitab?.text = jadwal?.pengajar?.nama ?: "Tidak ada pengajar"
            jamMulai?.text = jadwal?.mulai ?: "-"
            jamSelesai?.text = jadwal?.selesai ?: "-"
        }
    }

    // Inflate layout item untuk setiap baris RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_jadwal, parent, false)
        return JadwalViewHolder(itemView)
    }

    // Menghubungkan data ke ViewHolder
    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        jadwalList?.get(position)?.let { holder.bind(it) }
    }

    // Mengembalikan jumlah item
    override fun getItemCount(): Int = jadwalList?.size ?: 0

    // Fungsi untuk memperbarui data dalam adapter
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<Jadwal>?) {
        jadwalList = newList ?: emptyList() // Jika null, set list kosong
        notifyDataSetChanged()
    }
}
