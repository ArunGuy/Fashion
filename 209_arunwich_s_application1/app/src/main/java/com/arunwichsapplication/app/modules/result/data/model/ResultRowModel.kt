package com.arunwichsapplication.app.modules.result.`data`.model

import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.di.MyApp
import kotlin.String
import android.media.Image
data class ResultRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFiveResourceId: String? = MyApp.getInstance().resources.getString(R.string.lbl),
  var txtoneResourceId: String? = MyApp.getInstance().resources.getString(R.string.lbl),
  var txttwoResourceId: String? = MyApp.getInstance().resources.getString(R.string.lbl),

  /**
   * TODO Replace with dynamic value
   */
  var txtSixResourceId: String? = MyApp.getInstance().resources.getString(R.string.lbl),
  /**
   * TODO Replace with dynamic value
   */
  val txtNumbersoldResourceId: Int ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSevenResourceId: String? = MyApp.getInstance().resources.getString(R.string.lbl),

)


