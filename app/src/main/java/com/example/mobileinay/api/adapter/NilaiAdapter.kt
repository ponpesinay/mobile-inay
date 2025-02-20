package com.example.mobileinay.api.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.R
import com.example.mobileinay.api.model.NilaiData

class NilaiAdapter (
  private var nilaiList: List<NilaiData>?
) : RecyclerView.Adapter<NilaiAdapter.NilaiViewHolder>(){

  class NilaiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private  val tvMapel: TextView? = itemView.findViewById(R.id.tv_mapelHadir)
    private val tvNilai: TextView? = itemView.findViewById(R.id.tv_totalhadir)

    fun bind(nilai: NilaiData?) {
      tvMapel?.text = nilai?.mapel?.mapel
      tvNilai?.text = nilai?.nilai.toString()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NilaiViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.card_sub_nilai, parent, false)
    return NilaiViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: NilaiViewHolder, position: Int) {
    nilaiList?.get(position)?.let { holder.bind(it) }
  }

  override fun getItemCount(): Int = nilaiList?.size?: 0

  @SuppressLint("NotifyDataSetChanged")
  fun updateData(newList: List<NilaiData>?) {
    nilaiList = (newList ?: emptyList())
    notifyDataSetChanged()
  }
}