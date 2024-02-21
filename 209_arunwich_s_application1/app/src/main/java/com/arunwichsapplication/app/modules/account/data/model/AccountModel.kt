package com.arunwichsapplication.app.modules.account.`data`.model

import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AccountModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNAME: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAccountsetting: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_account_setting)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyOrder: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_order)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtViewPurchaseH: String? =
      MyApp.getInstance().resources.getString(R.string.msg_view_purchase_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtToPay: String? = MyApp.getInstance().resources.getString(R.string.lbl_to_pay)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtToShip: String? = MyApp.getInstance().resources.getString(R.string.lbl_to_ship)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtToReceive: String? = MyApp.getInstance().resources.getString(R.string.lbl_to_receive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtToReview: String? = MyApp.getInstance().resources.getString(R.string.lbl_to_review)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyLikes: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_likes)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRecentlyViewed: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_recently_viewed)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyReview: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_review)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAccountSettingOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_account_setting)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNotificationSe: String? =
      MyApp.getInstance().resources.getString(R.string.msg_notification_se)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrivacySetting: String? =
      MyApp.getInstance().resources.getString(R.string.msg_privacy_setting)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_language)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHomeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCart: String? = MyApp.getInstance().resources.getString(R.string.lbl_cart)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProportion: String? = MyApp.getInstance().resources.getString(R.string.lbl_proportion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNotification: String? = MyApp.getInstance().resources.getString(R.string.lbl_notification)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAccount: String? = MyApp.getInstance().resources.getString(R.string.lbl_account)

)
