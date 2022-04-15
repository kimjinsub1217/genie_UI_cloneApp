package com.example.genie_clone.home.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.genie_clone.R
import com.example.genie_clone.home.BannerItem


class BannerListAdapter: ListAdapter<BannerItem, BannerListAdapter.ItemViewHolder>(differ) {

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(bannerItem: BannerItem) {
            val bannerImageView = view.findViewById<ImageView>(R.id.bannerImageView)


            Glide
                .with(bannerImageView.context)
                .load(bannerItem.image)
                .into(bannerImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.activity_item_banner_viewpage2, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {

        val differ = object : DiffUtil.ItemCallback<BannerItem>() {
            override fun areItemsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
                return oldItem.image == newItem.image
            }

            override fun areContentsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}