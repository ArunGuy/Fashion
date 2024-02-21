package com.arunwichsapplication.app.modules.prop.`data`.model

import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class PropModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPROPORTIONS: String? = MyApp.getInstance().resources.getString(R.string.lbl_proportions)

)
