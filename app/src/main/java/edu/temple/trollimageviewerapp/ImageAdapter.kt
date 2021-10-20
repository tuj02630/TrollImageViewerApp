package edu.temple.trollimageviewerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList


class ImageAdapter(_context: Context, _imageObjects: ArrayList<ImageObject>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    var onItemClick: ((ImageObject) -> Unit)? = null
    private val imageObjects = _imageObjects;
    val inflater = LayoutInflater.from(_context)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(imageObjects[adapterPosition])
            }
        }
        val iv = itemView.findViewById<ImageView>(R.id.imageView);
        lateinit var io : ImageObject;
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val inflated = inflater.inflate(R.layout.grid_layout, parent, false)
        // Return a new holder instance
        var x = ViewHolder(inflated);
        return x;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.io = imageObjects[position]
        holder.iv.setImageResource(imageObjects[position].resourceId)
    }

    override fun getItemCount(): Int {
        return imageObjects.size;
    }
}