package com.arunwichsapplication.app.modules.prop.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arunwichsapplication.app.modules.prop.`data`.model.DetailRowModel
import com.arunwichsapplication.app.modules.prop.`data`.model.PropModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class PropVM : ViewModel(), KoinComponent {
  val propModel: MutableLiveData<PropModel> = MutableLiveData(PropModel())

  var navArguments: Bundle? = null

  val detailList: MutableLiveData<MutableList<DetailRowModel>> = MutableLiveData(mutableListOf())
}
