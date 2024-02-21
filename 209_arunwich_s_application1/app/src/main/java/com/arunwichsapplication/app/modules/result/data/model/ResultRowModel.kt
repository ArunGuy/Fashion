package com.arunwichsapplication.app.modules.result.`data`.model

import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ResultRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFive: String? = MyApp.getInstance().resources.getString(R.string.lbl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSix: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNumbersold: String? = MyApp.getInstance().resources.getString(R.string.lbl_number_sold)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl5)

)
