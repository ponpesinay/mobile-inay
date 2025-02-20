package com.example.mobileinay.api.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.api.adapter.MapelAdapter.MapelViewHolder
import com.example.mobileinay.api.model.KehadiranData

class KehadiranAdapter (
  private var kehadiranList: List<KehadiranData>?
) : RecyclerView.Adapter<KehadiranAdapter.KehadiranViewHolder>(){
  class KehadiranViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private  val tvKehadiran: TextView? = itemView.findViewById(R.id.tv_mapelHadir)
    private val tvJumlah: TextView? = itemView.findViewById(R.id.tv_totalhadir)

    fun bind(kehadiran: KehadiranData?) {
      tvKehadiran?.text = kehadiran?.name
      tvJumlah?.text = kehadiran?.jumlah.toString()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KehadiranViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.card_sub_nilai, parent, false)
    return KehadiranViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: KehadiranViewHolder, position: Int) {
    kehadiranList?.get(position)?.let { holder.bind(it) }
  }

  override fun getItemCount(): Int = kehadiranList?.size?: 0

  @SuppressLint("NotifyDataSetChanged")
  fun updateData(newList: List<KehadiranData>?) {
    kehadiranList = (newList ?: emptyList())
    notifyDataSetChanged()
  }
}