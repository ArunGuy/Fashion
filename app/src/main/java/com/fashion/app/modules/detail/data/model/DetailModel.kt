package com.fashion.app.modules.detail.`data`.model

import com.fashion.app.R
import com.fashion.app.appcomponents.di.MyApp
import kotlin.String

data class DetailModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtOne: String? = MyApp.getInstance().resources.getString(R.string.lbl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThree: String? = MyApp.getInstance().resources.getString(R.string.lbl3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOneTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFour: String? = MyApp.getInstance().resources.getString(R.string.lbl4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNumber: String? = MyApp.getInstance().resources.getString(R.string.lbl_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtColor: String? = MyApp.getInstance().resources.getString(R.string.lbl_color)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2427: String? = MyApp.getInstance().resources.getString(R.string.lbl_color2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2428: String? = MyApp.getInstance().resources.getString(R.string.lbl_color2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2430: String? = MyApp.getInstance().resources.getString(R.string.lbl_color2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2429: String? = MyApp.getInstance().resources.getString(R.string.lbl_color2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSize: String? = MyApp.getInstance().resources.getString(R.string.lbl_size)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2430One: String? = MyApp.getInstance().resources.getString(R.string.lbl_l)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2429One: String? = MyApp.getInstance().resources.getString(R.string.lbl_xl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_spend_5_days_an)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etAddtocartValue: String? = null
)
