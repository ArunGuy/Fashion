package com.arunwichsapplication.app.modules.setting.ui

import android.content.Intent
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivitySettingBinding
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.account.ui.AccountActivity
import com.arunwichsapplication.app.modules.login.ui.LogInActivity
import com.arunwichsapplication.app.modules.setting.`data`.viewmodel.SettingVM
import kotlin.String
import kotlin.Unit


class SettingActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {
  private val viewModel: SettingVM by viewModels<SettingVM>()
  private lateinit var databaseHelper: DatabaseHelper

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.right1.setOnClickListener {
      finish() // ปิด Activity ปัจจุบันเมื่อคลิกที่ปุ่ม Back
    }

    binding.logOut.setOnClickListener {
      databaseHelper = DatabaseHelper(this)
      val email = databaseHelper.getUserLoggedInEmail()
      databaseHelper.updateUserStatus(email, 0)
      val intent = Intent(this@SettingActivity, LogInActivity::class.java)
      startActivity(intent)

      finishAffinity() // ปิดทุก Activity ที่เป็นส่วนของแอป
    }
  }


  companion object {
    const val TAG: String = "SETTING_ACTIVITY"

  }
}
