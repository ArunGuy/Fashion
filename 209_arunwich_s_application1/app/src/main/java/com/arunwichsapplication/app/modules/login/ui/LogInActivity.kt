package com.arunwichsapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.appcomponents.facebookauth.FacebookHelper
import com.arunwichsapplication.app.appcomponents.googleauth.GoogleHelper
import com.arunwichsapplication.app.databinding.ActivityLogInBinding
import com.arunwichsapplication.app.modules.login.`data`.viewmodel.LogInVM
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlin.Int
import kotlin.String
import kotlin.Unit

class LogInActivity : BaseActivity<ActivityLogInBinding>(R.layout.activity_log_in) {
  private val viewModel: LogInVM by viewModels<LogInVM>()

  private lateinit var googleLogin: GoogleHelper

  private var callbackManager: CallbackManager = CallbackManager.Factory.create()

  private val facebookLogin: FacebookHelper = FacebookHelper()

  override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    `data`: Intent?
  ) {
    callbackManager.onActivityResult(requestCode, resultCode, data)
    super.onActivityResult(requestCode,resultCode,data)
  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.logInVM = viewModel
    googleLogin = GoogleHelper(this,
    { accountInfo ->
      },{ error -> 

      })
    }

    override fun setUpClicks(): Unit {
      binding.linearGoogle.setOnClickListener {
        googleLogin.login()
      }
      binding.linearGoogle1.setOnClickListener {
        LoginManager.getInstance().logInWithReadPermissions(this, listOf("public_profile"))
        facebookLogin.login(callbackManager,object : FacebookCallback<LoginResult> {
          override fun onSuccess(result: LoginResult?) {
          }
          override fun onError(error: FacebookException?) {
          }
          override fun onCancel() {
          }
          })
        }

      binding.btnLogInOne.setOnClickListener {
        // Navigate to ProporActivity
        val intent = Intent(this, PropActivity::class.java)
        startActivity(intent)
      }
      }

      companion object {
        const val TAG: String = "LOG_IN_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
          val destIntent = Intent(context, LogInActivity::class.java)
          destIntent.putExtra("bundle", bundle)
          return destIntent
        }
      }
    }
