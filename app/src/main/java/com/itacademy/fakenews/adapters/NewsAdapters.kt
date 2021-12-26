package com.itacademy.fakenews.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.fakenews.fragments.NewsFragments
import com.itacademy.fakenews.R
import com.bumptech.glide.Glide
import com.itacademy.fakenews.models.News

class NewsAdapters(private val array: List<News>, val listener: NewsFragments):
    RecyclerView.Adapter<NewsAdapters.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val newst = view.findViewById<TextView>(R.id.news_title)
        val newsi = view.findViewById<ImageView>(R.id.news_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]

        Glide
            .with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.newsi)

        holder.newst.text = item.name

        holder.itemView.setOnClickListener {
            listener.newsClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}
interface NewsClickListener{
    fun newsClicked(clickedNews : News)
}

