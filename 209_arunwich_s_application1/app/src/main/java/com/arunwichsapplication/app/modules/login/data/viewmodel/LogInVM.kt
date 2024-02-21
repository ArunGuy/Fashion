package com.arunwichsapplication.app.modules.login.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arunwichsapplication.app.modules.login.`data`.model.LogInModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import org.json.JSONObject
import org.koin.core.KoinComponent

class LogInVM : ViewModel(), KoinComponent {
  val logInModel: MutableLiveData<LogInModel> = MutableLiveData(LogInModel())


  var navArguments: Bundle? = null


  lateinit var googleAuthResponse: GoogleSignInAccount

  var facebookAuthResponse: JSONObject = JSONObject()
}
