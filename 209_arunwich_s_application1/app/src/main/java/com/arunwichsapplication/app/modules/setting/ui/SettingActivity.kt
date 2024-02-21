package com.arunwichsapplication.app.modules.setting.ui

import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivitySettingBinding
import com.arunwichsapplication.app.modules.setting.`data`.viewmodel.SettingVM
import kotlin.String
import kotlin.Unit

class SettingActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {
  private val viewModel: SettingVM by viewModels<SettingVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SETTING_ACTIVITY"

  }
}
