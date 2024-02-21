package com.arunwichsapplication.app.modules.result.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.databinding.RowResultBinding
import com.arunwichsapplication.app.modules.result.`data`.model.ResultRowModel
import kotlin.Int
import kotlin.collections.List

class ResultAdapter(
  var list: List<ResultRowModel>
) : RecyclerView.Adapter<ResultAdapter.RowResultVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowResultVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_result,parent,false)
    return RowResultVH(view)
  }

  override fun onBindViewHolder(holder: RowResultVH, position: Int) {
    val resultRowModel = ResultRowModel()
    // TODO uncomment following line after integration with data source
    // val resultRowModel = list[position]
    holder.binding.resultRowModel = resultRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ResultRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ResultRowModel
    ) {
    }
  }

  inner class RowResultVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowResultBinding = RowResultBinding.bind(itemView)
  }
}
