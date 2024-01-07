package com.fashion.app.modules.setting.`data`.model

import com.fashion.app.R
import com.fashion.app.appcomponents.di.MyApp
import kotlin.String

data class SettingModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAccountSetting: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_account_setting2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAccountSecur: String? = MyApp.getInstance().resources.getString(R.string.msg_account_secur)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyAddresses: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_addresses)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBankAccounts: String? = MyApp.getInstance().resources.getString(R.string.msg_bank_accounts)

)
