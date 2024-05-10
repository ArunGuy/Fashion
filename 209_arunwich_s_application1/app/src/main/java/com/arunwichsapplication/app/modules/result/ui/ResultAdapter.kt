import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arunwichsapplication.app.databinding.RowResultBinding
import com.arunwichsapplication.app.modules.result.data.model.ResultRowModel

class ResultAdapter(
  private var originalList: List<ResultRowModel>,
  private val onItemClick: (position: Int, item: ResultRowModel) -> Unit
) : RecyclerView.Adapter<ResultAdapter.RowResultVH>() {

  private var filteredList: List<ResultRowModel> = originalList

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowResultVH {
    val binding = RowResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RowResultVH(binding)
  }

  override fun onBindViewHolder(holder: RowResultVH, position: Int) {
    holder.bind(filteredList[position], onItemClick)
  }

  override fun getItemCount(): Int {
    return filteredList.size
  }

  fun filter(query: String?) {
    filteredList = if (query.isNullOrBlank()) {
      originalList
    } else {
      originalList.filter {
        it.txtFiveResourceId?.contains(query, ignoreCase = true) == true
      }
    }
    notifyDataSetChanged()
  }

  fun updateData(newData: List<ResultRowModel>) {


    originalList = newData
    filter("") // Reset filter
  }

  inner class RowResultVH(private val binding: RowResultBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResultRowModel, onItemClick: (position: Int, item: ResultRowModel) -> Unit) {
      binding.resultRowModel = item
      binding.imageViewFrame244.setImageResource(item.txtNumbersoldResourceId)
      binding.root.setOnClickListener { onItemClick(adapterPosition, item) }
      binding.executePendingBindings()
    }
  }
}
