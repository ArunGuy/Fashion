package com.arunwichsapplication.app.modules.detail.ui

import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityDetailBinding
import com.arunwichsapplication.app.modules.detail.`data`.viewmodel.DetailVM
import kotlin.String
import kotlin.Unit

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {
  private val viewModel: DetailVM by viewModels<DetailVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.detailVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "DETAIL_ACTIVITY"

  }
}
