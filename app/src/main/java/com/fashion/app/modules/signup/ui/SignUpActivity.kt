package com.fashion.app.modules.signup.ui

import androidx.activity.viewModels
import com.fashion.app.R
import com.fashion.app.appcomponents.base.BaseActivity
import com.fashion.app.databinding.ActivitySignUpBinding
import com.fashion.app.modules.signup.`data`.viewmodel.SignUpVM
import kotlin.String
import kotlin.Unit

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
  private val viewModel: SignUpVM by viewModels<SignUpVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUpVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SIGN_UP_ACTIVITY"

  }
}
