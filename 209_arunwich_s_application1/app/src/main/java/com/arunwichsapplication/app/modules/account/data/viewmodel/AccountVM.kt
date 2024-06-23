package com.arunwichsapplication.app.modules.account.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arunwichsapplication.app.modules.account.data.model.AccountModel
import org.koin.core.KoinComponent

class AccountVM : ViewModel(), KoinComponent {
  val accountModel: MutableLiveData<AccountModel> = MutableLiveData(AccountModel())
  private val _userEmail = MutableLiveData<String>()
  val userEmail: LiveData<String>
    get() = _userEmail

  fun setUserEmail(email: String) {
    _userEmail.value = email
  }
  var navArguments: Bundle? = null
}
