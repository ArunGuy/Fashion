package com.arunwichsapplication.app.modules.signup.ui

import android.content.Intent
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.appcomponents.facebookauth.FacebookHelper
import com.arunwichsapplication.app.appcomponents.googleauth.GoogleHelper
import com.arunwichsapplication.app.databinding.ActivitySignUpBinding
import com.arunwichsapplication.app.modules.signup.`data`.viewmodel.SignUpVM
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlin.Int
import kotlin.String
import kotlin.Unit
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.login.ui.LogInActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
  private val viewModel: SignUpVM by viewModels<SignUpVM>()

  private lateinit var googleLogin: GoogleHelper

  private var callbackManager: CallbackManager = CallbackManager.Factory.create()

  private val facebookLogin: FacebookHelper = FacebookHelper()

  private lateinit var databaseHelper: DatabaseHelper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding.signUpVM = viewModel // ไม่แน่ใจว่าต้องใส่ viewModel หรือไม่
    databaseHelper = DatabaseHelper(this)

    binding.btnSignUpOne.setOnClickListener {
      val email = binding.txtFrameThree.text.toString().trim()
      val password = binding.txtPassword.text.toString().trim()
      val phone = binding.txtPhone.text.toString().trim()

      if (email.isNotEmpty() && password.isNotEmpty() && phone.isNotEmpty()) {
        val isInserted = databaseHelper.addUser(email, password, phone)
        if (isInserted) {
          Toast.makeText(this, "User added successfully!", Toast.LENGTH_SHORT).show()
          // ทำต่อไปเช่นเปลี่ยนหน้าหรือทำอย่างอื่นตามที่ต้องการ
          val intent = Intent(this, LogInActivity::class.java)
          startActivity(intent)
        } else {
          Toast.makeText(this, "User already exists!", Toast.LENGTH_SHORT).show()
        }
      } else {
        Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
      }
    }

    binding.txtLogin.setOnClickListener {
      // Navigate to SignUpActivity
      val intent = Intent(this, LogInActivity::class.java)
      startActivity(intent)
    }

  }
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
    binding.signUpVM = viewModel
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
      }

      companion object {
        const val TAG: String = "SIGN_UP_ACTIVITY"

      }
    }
