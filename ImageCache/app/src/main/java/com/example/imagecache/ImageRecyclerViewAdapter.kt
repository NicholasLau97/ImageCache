package com.example.imagecache

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagecache.models.Image

class ImageRecyclerViewAdapter(private val clickListener:(Image)->Unit):RecyclerView.Adapter<ImageViewHolder>() {
   private val imageList = ArrayList<Image>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val rvImageItem = layoutInflater.inflate(R.layout.rv_image_item,parent,false)
        return ImageViewHolder(rvImageItem)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
    fun setList(images:List<Image>){
        imageList.clear()
        imageList.addAll(images)
    }
}

class ImageViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun bind(image: Image,clickListener: (Image) -> Unit){
        val imgPhoto = view.findViewById<ImageView>(R.id.imgPhoto)
        val imgText = view.findViewById<TextView>(R.id.tvImgText)

        imgText.text = image.title
        Glide.with(view)
            .load(image.thumbnail)
            .centerCrop()
            .into(imgPhoto)

        /*
        view.setOnClickListener {
            clickListener(image)
        }
        */

        imgPhoto.setOnClickListener{
            clickListener(image)
        }
    }

}
