package com.fashion.app.modules.setting.ui

import androidx.activity.viewModels
import com.fashion.app.R
import com.fashion.app.appcomponents.base.BaseActivity
import com.fashion.app.databinding.ActivitySettingBinding
import com.fashion.app.modules.setting.`data`.viewmodel.SettingVM
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
