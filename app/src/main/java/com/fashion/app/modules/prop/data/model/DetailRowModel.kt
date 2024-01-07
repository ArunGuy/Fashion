package com.fashion.app.modules.prop.`data`.model

import com.fashion.app.R
import com.fashion.app.appcomponents.di.MyApp
import kotlin.String

data class DetailRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWaistline: String? = MyApp.getInstance().resources.getString(R.string.lbl_waistline)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFortyEight: String? = MyApp.getInstance().resources.getString(R.string.lbl_n_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInch: String? = MyApp.getInstance().resources.getString(R.string.lbl_inch)

)
