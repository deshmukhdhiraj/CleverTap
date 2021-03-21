package com.example.clevertapapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clevertap.R

class ImageAdapter(private var images: ArrayList<String>) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    public var onItemClickListener: (String) -> Unit = { }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tvImageName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.tile_image, parent, false)
        return ViewHolder(itemView).apply {
            itemView.setOnClickListener {
                onItemClickListener(images[adapterPosition])
            }

        }
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        holder.title.text = images[position]


    }

    override fun getItemCount(): Int {
        return images.size
    }

}