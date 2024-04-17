package com.arunwichsapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.appcomponents.facebookauth.FacebookHelper
import com.arunwichsapplication.app.appcomponents.googleauth.GoogleHelper
import com.arunwichsapplication.app.databinding.ActivityLogInBinding
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.login.data.viewmodel.LogInVM
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.arunwichsapplication.app.modules.signup.ui.SignUpActivity
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
  private lateinit var databaseHelper: DatabaseHelper

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    callbackManager.onActivityResult(requestCode, resultCode, data)
    super.onActivityResult(requestCode, resultCode, data)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding.logInVM = viewModel
    googleLogin = GoogleHelper(this, { accountInfo -> }, { error -> })

    // Initialize DatabaseHelper and check database connection
    databaseHelper = DatabaseHelper(this)
    if (databaseHelper.isDatabaseConnected()) {
      Toast.makeText(this, "Database connected", Toast.LENGTH_SHORT).show()
    } else {
      Toast.makeText(this, "Database not connected", Toast.LENGTH_SHORT).show()
    }

    // Your remaining code...
  }


  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.logInVM = viewModel
    googleLogin = GoogleHelper(this,
      { accountInfo ->
      }, { error ->
      })
  }

  override fun setUpClicks() {
    binding.linearGoogle.setOnClickListener {
      googleLogin.login()
    }

    binding.linearGoogle1.setOnClickListener {
      LoginManager.getInstance().logInWithReadPermissions(this, listOf("public_profile"))
      facebookLogin.login(callbackManager, object : FacebookCallback<LoginResult> {
        override fun onSuccess(result: LoginResult?) {}
        override fun onError(error: FacebookException?) {}
        override fun onCancel() {}
      })
    }

    binding.btnLogInOne.setOnClickListener {
      val email = binding.txtFrameThree.text.toString().trim()
      val password = binding.txtPassword.text.toString().trim()

      if (email.isNotEmpty() && password.isNotEmpty()) {
        val isDatabaseConnected = databaseHelper.isDatabaseConnected()
        if (isDatabaseConnected) {
          val isUserExists = databaseHelper.checkUser(email, password)
          if (isUserExists) {
            // User exists, navigate to ProporActivity or perform other actions
            val intent = Intent(this, PropActivity::class.java)
            startActivity(intent)
          } else {
            // User doesn't exist or credentials are incorrect
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
          }
        } else {
          // Database connection failed
          Toast.makeText(this, "Database connection failed", Toast.LENGTH_SHORT).show()
        }
      } else {
        Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
      }
    }

    binding.txtSignup.setOnClickListener {
      // Navigate to SignUpActivity
      val intent = Intent(this, SignUpActivity::class.java)
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

  // Move this function to your DatabaseHelper class
  // Move this function to your DatabaseHelper class
  fun DatabaseHelper.checkUser(email: String, password: String): Boolean {
    val db = readableDatabase
    val query = "SELECT * FROM ${DatabaseHelper.getTableName()} WHERE ${DatabaseHelper.getColumnEmail()} = ? AND ${DatabaseHelper.getColumnPassword()} = ?"
    val cursor = db.rawQuery(query, arrayOf(email, password))
    val count = cursor.count
    cursor.close()
    return count > 0
  }

}
