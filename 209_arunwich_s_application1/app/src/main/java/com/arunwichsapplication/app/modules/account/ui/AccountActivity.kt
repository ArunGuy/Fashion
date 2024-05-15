package com.arunwichsapplication.app.modules.account.ui


import android.content.Intent
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityAccountBinding
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.account.data.viewmodel.AccountVM
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.arunwichsapplication.app.modules.result.ui.ResultActivity
import com.arunwichsapplication.app.modules.setting.ui.SettingActivity


class AccountActivity : BaseActivity<ActivityAccountBinding>(R.layout.activity_account) {
  private val viewModel: AccountVM by viewModels<AccountVM>()
  private lateinit var databaseHelper: DatabaseHelper

  private var waistline: Double = 0.0
  private var chest: Double = 0.0
  private var hipInput: Double = 0.0
  private var height: Double = 0.0
  private var weight: Double = 0.0

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.accountVM = viewModel
    initData()
  }

  private fun initData() {
    waistline = intent.getDoubleExtra("waistline", 0.0)
    chest = intent.getDoubleExtra("chest", 0.0)
    hipInput = intent.getDoubleExtra("hipInput", 0.0)
    height = intent.getDoubleExtra("height", 0.0)
    weight = intent.getDoubleExtra("weight", 0.0)
    databaseHelper = DatabaseHelper(this)
    val userEmail = databaseHelper.getUserEmail()
    viewModel.setUserEmail(userEmail)
  }

  override fun setUpClicks() {
    binding.linearCart.setOnClickListener {
      // Navigate to CartActivity
      val intent = Intent(this, ResultActivity::class.java)
      startActivity(intent)
    }

    binding.linearAc.setOnClickListener {
      // Navigate to OtherActivity
      val intent = Intent(this, SettingActivity::class.java)
      startActivity(intent)
    }

    binding.linearPropor.setOnClickListener {
      // Navigate to ProporActivity
      val intent = Intent(this, PropActivity::class.java)
      intent.putExtra("waistline", waistline)
      intent.putExtra("chest", chest)
      intent.putExtra("hipInput", hipInput)
      intent.putExtra("height", height)
      intent.putExtra("weight", weight)
      startActivity(intent)
    }
  }

  companion object {
    const val TAG: String = "ACCOUNT_ACTIVITY"
  }
}

