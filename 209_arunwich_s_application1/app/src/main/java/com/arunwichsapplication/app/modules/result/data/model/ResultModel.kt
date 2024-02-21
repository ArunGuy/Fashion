package com.arunwichsapplication.app.modules.result.`data`.model

import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ResultModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2433: String? = MyApp.getInstance().resources.getString(R.string.lbl_relevance)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2434: String? = MyApp.getInstance().resources.getString(R.string.lbl_latest)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2435: String? = MyApp.getInstance().resources.getString(R.string.lbl_top_sales)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMall: String? = MyApp.getInstance().resources.getString(R.string.lbl_mall)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_free_shipping)

)
