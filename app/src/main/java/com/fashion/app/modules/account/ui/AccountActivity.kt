package com.fashion.app.modules.account.ui

import androidx.activity.viewModels
import com.fashion.app.R
import com.fashion.app.appcomponents.base.BaseActivity
import com.fashion.app.databinding.ActivityAccountBinding
import com.fashion.app.modules.account.`data`.viewmodel.AccountVM
import kotlin.String
import kotlin.Unit

class AccountActivity : BaseActivity<ActivityAccountBinding>(R.layout.activity_account) {
  private val viewModel: AccountVM by viewModels<AccountVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.accountVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ACCOUNT_ACTIVITY"

  }
}
