package com.arunwichsapplication.app.modules.result.ui

import ResultAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityResultBinding
import com.arunwichsapplication.app.modules.BodyAnalyzer
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.result.data.model.ResultRowModel
import com.arunwichsapplication.app.modules.result.data.model.SpinnerFrame2441Model
import com.arunwichsapplication.app.modules.result.data.viewmodel.ResultVM


class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
  private val viewModel: ResultVM by viewModels()

  private lateinit var testData: MutableList<ResultRowModel>

  private fun initData() {

  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)





    val dbHelper = DatabaseHelper(this)
    val email = dbHelper.getUserEmail()
    val userData = dbHelper.getUserData(email)



// แสดงผลค่าที่ได้จากข้อมูลแต่ละคอลัมน์
    val waistline = userData[DatabaseHelper.getColumnWaist()] ?: 0.0
    val chest = userData[DatabaseHelper.getColumnChest()] ?: 0.0
    val hipInput = userData[DatabaseHelper.getColumnHip()] ?: 0.0
    val height = userData[DatabaseHelper.getColumnHeight()] ?: 0.0
    val weight = userData[DatabaseHelper.getColumnWeight()] ?: 0.0





    val bodyAnalyzer = BodyAnalyzer()

    val personData = mapOf(
      "front_length" to height,
      "bust_size" to chest,
      "shoulder_width" to 0.0,
      "waist_size" to waistline,
      "arm_length" to 0.0,
      "hip_size" to hipInput
    )

    val clothingDataList = mutableListOf(
      mapOf<String, Double>(
        "bust" to 98.0,
        "shoulder" to 24.0,
        "arm" to 40.64,
        "frontLength" to 54.0,
        "waist" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 77.0,
        "shoulder" to 24.0,
        "arm" to 38.0,
        "frontLength" to 41.0,
        "waist" to 71.0
      ),
      mapOf<String, Double>(
        "bust" to 38.0,
        "shoulder" to 31.0,
        "arm" to 16.0,
        "frontLength" to 39.0,
        "waist" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 112.0,
        "shoulder" to 0.0,
        "arm" to 44.0,
        "frontLength" to 62.0,
        "waist" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 74.0,
        "shoulder" to 0.0,
        "arm" to 15.0,
        "frontLength" to 48.0,
        "waist" to 0.0
      )
    )



    testData = mutableListOf(
      ResultRowModel(
        txtFiveResourceId = "Orange Vest",
        txtSixResourceId = "280 THB",
        txtNumbersoldResourceId = R.drawable.orange_vest,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[0], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อกั๊ก ผ้าขนสัตว์ ลายสก็อต สไตล์อเมริกัน",
        txtSixResourceId = "149 THB",
        txtNumbersoldResourceId = R.drawable.a2,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[1], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อครอปแขนสั้น คอวี ผ้าไหมพรม",
        txtSixResourceId = "79 THB",
        txtNumbersoldResourceId = R.drawable.a3,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[2], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อกันหนาว คอวี ผ้าถัก ทรงหลวม สไตล์เกาหลี",
        txtSixResourceId = "199 THB",
        txtNumbersoldResourceId = R.drawable.a4,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[3], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "Nuziro Baby Tee",
        txtSixResourceId = "138 THB",
        txtNumbersoldResourceId = R.drawable.a5,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[2], null)
      ),

    )
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerFrame2441List.value = mutableListOf(
      SpinnerFrame2441Model("Item1"),
      SpinnerFrame2441Model("Item2"),
      SpinnerFrame2441Model("Item3"),
      SpinnerFrame2441Model("Item4"),
      SpinnerFrame2441Model("Item5")
    )


    val resultAdapter = ResultAdapter(viewModel.resultList.value ?: mutableListOf()) { position, item ->
      onClickRecyclerResult(position, item)
    }
    binding.recyclerResult.adapter = resultAdapter
    viewModel.resultList.observe(this) {
      resultAdapter.updateData(it)
    }









    val testAdapter = ResultAdapter(testData) { position, item ->
      onClickRecyclerResult(position, item)
    }
    binding.recyclerResult.adapter = testAdapter



    setUpSearchViewFrame2432Listener()

    binding.resultVM = viewModel

  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  private fun onClickRecyclerResult(position: Int, item: ResultRowModel) {
    // Handle item click
  }


  fun filterList(filteredFitsWellList: List<ResultRowModel>, query: String) {
    val filteredList = filteredFitsWellList.filter {
      it.txtFiveResourceId?.contains(query, ignoreCase = true) ?: false
    }
    val resultAdapter = ResultAdapter(filteredList) { position, item ->
      onClickRecyclerResult(position, item)
    }
    binding.recyclerResult.adapter = resultAdapter
  }

  private fun setUpSearchViewFrame2432Listener() {
    // Set up the SearchView to listen for query changes
    binding.searchViewFrame2432.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // กรองลิสต์ข้อมูลใน RecyclerView โดยใช้ query แล้วอัพเดต UI

        filterList(testData, query)
        return false
      }

      override fun onQueryTextChange(newText: String): Boolean {
        // กรองลิสต์ข้อมูลใน RecyclerView เมื่อมีการเปลี่ยนแปลงข้อความ แล้วอัพเดต UI
        filterList(testData, newText)
        return false
      }
    })
  }










  companion object {
    const val TAG: String = "RESULT_ACTIVITY"
  }
}