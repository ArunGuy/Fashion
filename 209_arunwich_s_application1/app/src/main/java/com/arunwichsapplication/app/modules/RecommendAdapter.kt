package com.arunwichsapplication.app.modules

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

class RecommendAdapter(val item: MutableList<ItemModel>):
    RecyclerView.Adapter<RecommendAdapter.Viewholder>() {
    private var context: Context?=null

    class Viewholder(val binding: ViewholderRecommendBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendAdapter.Viewholder {
        context = parent.context
        val binding =
            ViewholderRecommendBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: RecommendAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text = item[position].title
        holder.binding.priceTxt.text = "฿"+item[position].price.toString()
        holder.binding.ratingTxt.text = item[position].rating.toString()

        val requestOption = RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(item[position].picUrl[0])
            .apply(requestOption)
            .into(holder.binding.picRecommend)
    }

    override fun getItemCount(): Int = item.size

}