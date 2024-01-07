package com.fashion.app.modules.prop.`data`.model

import com.fashion.app.R
import com.fashion.app.appcomponents.di.MyApp
import kotlin.String

data class PropModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPROPORTIONS: String? = MyApp.getInstance().resources.getString(R.string.lbl_proportions)

)
