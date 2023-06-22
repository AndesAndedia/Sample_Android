package com.example.tugas1andes

import android.icu.text.LocaleDisplayNames.UiListItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tugas1andes.databinding.RecycleViewBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolderCustom>() {
    private var listData = mutableListOf<RecyclerViewItemModel>()

    inner class ViewHolderCustom(private val binding: RecycleViewBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bindData(item: RecyclerViewItemModel){
            with (binding){
                Glide.with(itemView.context).load(item.gambar).into(gambarItem)
                judulItem.text = item.judul
                deskripsiItem.text = item.deskripsi
                tahunItem.text = item.tahun
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolderCustom {
        return ViewHolderCustom(
            RecycleViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolderCustom, position: Int) {
        holder.bindData(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun isiList(listItem: MutableList<RecyclerViewItemModel>){
        listData.clear()
        listData.addAll(listItem)
    }

}