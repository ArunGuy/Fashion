package com.arunwichsapplication.app.modules.prop.ui

import android.view.View
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityPropBinding
import com.arunwichsapplication.app.modules.prop.`data`.model.DetailRowModel
import com.arunwichsapplication.app.modules.prop.`data`.viewmodel.PropVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class PropActivity : BaseActivity<ActivityPropBinding>(R.layout.activity_prop) {
  private val viewModel: PropVM by viewModels<PropVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val detailAdapter = DetailAdapter(viewModel.detailList.value?:mutableListOf())
    binding.recyclerDetail.adapter = detailAdapter
    detailAdapter.setOnItemClickListener(
    object : DetailAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : DetailRowModel) {
        onClickRecyclerDetail(view, position, item)
      }
    }
    )
    viewModel.detailList.observe(this) {
      detailAdapter.updateData(it)
    }
    binding.propVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerDetail(
    view: View,
    position: Int,
    item: DetailRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PROP_ACTIVITY"

  }
}
