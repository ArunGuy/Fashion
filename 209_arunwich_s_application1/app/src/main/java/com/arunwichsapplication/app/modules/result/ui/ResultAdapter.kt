package com.arunwichsapplication.app.modules.result.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arunwichsapplication.app.databinding.RowResultBinding
import com.arunwichsapplication.app.modules.result.data.model.ResultRowModel

class ResultAdapter(
  var list: List<ResultRowModel>,
  private val onItemClick: (position: Int, item: ResultRowModel) -> Unit
) : RecyclerView.Adapter<ResultAdapter.RowResultVH>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    RowResultVH(RowResultBinding.inflate(LayoutInflater.from(parent.context), parent, false))

  override fun onBindViewHolder(holder: RowResultVH, position: Int) {
    holder.bind(list[position], position, onItemClick)
  }

  override fun getItemCount() = list.size

  fun updateData(newData: List<ResultRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  inner class RowResultVH(
    private val binding: RowResultBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
      item: ResultRowModel,
      position: Int,
      onItemClick: (position: Int, item: ResultRowModel) -> Unit
    ) {
      binding.resultRowModel = item
      binding.imageViewFrame244.setImageResource(item.txtNumbersoldResourceId)
      binding.root.setOnClickListener { this@ResultAdapter.onItemClick(adapterPosition, item) }
      binding.executePendingBindings()
    }
  }

}
