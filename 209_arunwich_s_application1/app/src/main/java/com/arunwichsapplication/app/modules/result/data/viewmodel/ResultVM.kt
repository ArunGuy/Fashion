package com.arunwichsapplication.app.modules.result.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arunwichsapplication.app.modules.result.`data`.model.ResultModel
import com.arunwichsapplication.app.modules.result.`data`.model.ResultRowModel
import com.arunwichsapplication.app.modules.result.`data`.model.SpinnerFrame2441Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ResultVM : ViewModel(), KoinComponent {
    val resultModel: MutableLiveData<ResultModel> = MutableLiveData(ResultModel())

    var navArguments: Bundle? = null

    val spinnerFrame2441List: MutableLiveData<MutableList<SpinnerFrame2441Model>> = MutableLiveData()

    val resultList: MutableLiveData<MutableList<ResultRowModel>> = MutableLiveData(mutableListOf())
    fun filterResultList(query: String) {
        // กรองรายการผลลัพธ์ที่ต้องการตาม query ที่รับเข้ามา
        val filteredList = resultList.value?.filter { it.txtFiveResourceId?.contains(query, ignoreCase = true) ?: false }
        // ตั้งค่ารายการผลลัพธ์ใหม่ให้กับ LiveData
        resultList.value = filteredList?.toMutableList()
    }

}