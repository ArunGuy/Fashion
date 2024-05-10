package com.arunwichsapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.appcomponents.facebookauth.FacebookHelper
import com.arunwichsapplication.app.appcomponents.googleauth.GoogleHelper
import com.arunwichsapplication.app.databinding.ActivityLogInBinding
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.account.ui.AccountActivity
import com.arunwichsapplication.app.modules.login.data.viewmodel.LogInVM
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.arunwichsapplication.app.modules.signup.ui.SignUpActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlin.Int
import kotlin.String

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
    databaseHelper = DatabaseHelper(this)

    val status10 = databaseHelper.getStatusForLoggedInUser()
    val intent = Intent(this, AccountActivity::class.java)
    if (status10 == 1) {
      startActivity(intent)
      finish()
    }


  }



  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")




  }

  override fun setUpClicks() {


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
            // Update user status to 1 before checking user email
            val loggedIn = databaseHelper.updateUserStatus(email, 1)
            if (loggedIn) {
              // User status updated, proceed to process email
              processEmail()
            } else {
              // Failed to update user status
              Toast.makeText(this, "Failed to update user status", Toast.LENGTH_SHORT).show()
            }
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
      finish()
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

  private fun processEmail(){
    val email = databaseHelper.getUserEmail()
    if (email != null) {
      // ค่า email ไม่เท่ากับ null แสดงว่ามีผู้ใช้อยู่จริง
      // ดังนั้นให้กำหนดค่า email ให้กับ loggedInUserEmail
      databaseHelper.setLoggedInUserEmail(email)
      // แสดง Toast ต้อนรับผู้ใช้ที่ล็อกอินเข้าสู่ระบบ
      Toast.makeText(this, "Welcome2 : $email", Toast.LENGTH_SHORT).show()
      // เรียกใช้ Activity ที่ต้องการเปิดหลังจากล็อกอินเสร็จสมบูรณ์
      val intent = Intent(this, AccountActivity::class.java)
      startActivity(intent)
      finish()
    } else {
      // ถ้า email เป็น null แสดงว่าไม่มีผู้ใช้อยู่
      // ในกรณีนี้เราไม่ควรกำหนดค่า email ให้กับ loggedInUserEmail
      // สามารถใช้ฟังก์ชันนี้เพื่อลบค่า email ที่เก็บไว้เมื่อไม่มีผู้ใช้อยู่
      // databaseHelper.setLoggedInUserEmail(null)
      // แสดง Toast ต้อนรับผู้ใช้ใหม่ที่ยังไม่ได้ล็อกอิน
      Toast.makeText(this, "ไม่ผู้ Email ในฐายข้อมูล ", Toast.LENGTH_SHORT).show()
      // เรียกใช้ Activity ที่ต้องการเปิดสำหรับผู้ใช้ใหม่

    }
  }

  private fun delayedStartAccountActivity() {
    Handler(Looper.getMainLooper()).postDelayed({
      val email1 = databaseHelper.getUserEmail()
      val status = databaseHelper.getUserStatus(email1)
      if (status == 1) {
        val intent = Intent(this, AccountActivity::class.java)
        startActivity(intent)
        finish()

      }
    }, 5000) // รอ 5 วินาที ก่อนที่โค้ดในบล็อกนี้จะถูกเรียก
  }








}
