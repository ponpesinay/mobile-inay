package com.example.mobileinay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserNilai(private var nilaiList: List<Pair<String, Int>>) :
    RecyclerView.Adapter<UserNilai.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaMapel: TextView = itemView.findViewById(R.id.tv_mapelHadir)
        val tvNilai: TextView = itemView.findViewById(R.id.tv_totalhadir)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_sub_nilai, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val (mapel, nilai) = nilaiList[position]

        holder.namaMapel.text = mapel
        holder.tvNilai.text = nilai.toString()
//        holder.uas.text = "UAS : ${nilai.uas}"
//        holder.tugas.text = "TUGAS : ${nilai.tugas}"

    }

    override fun getItemCount(): Int = nilaiList.size

    fun updateData(newList: List<Pair<String, Int>>){
        nilaiList = newList
        notifyDataSetChanged()
    }

}