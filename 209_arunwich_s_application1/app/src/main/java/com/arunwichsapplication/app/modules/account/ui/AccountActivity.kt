package com.arunwichsapplication.app.modules.account.ui

import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityAccountBinding
import com.arunwichsapplication.app.modules.account.`data`.viewmodel.AccountVM
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.arunwichsapplication.app.modules.result.ui.ResultActivity
import kotlin.String
import kotlin.Unit
import android.content.Intent
import com.arunwichsapplication.app.modules.setting.ui.SettingActivity


class AccountActivity : BaseActivity<ActivityAccountBinding>(R.layout.activity_account) {
  private val viewModel: AccountVM by viewModels<AccountVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.accountVM = viewModel
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
      startActivity(intent)
    }


  }


  companion object {
    const val TAG: String = "ACCOUNT_ACTIVITY"

  }
}
