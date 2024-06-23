package com.arunwichsapplication.app.modules.result.ui

import ResultAdapter
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityResultBinding
import com.arunwichsapplication.app.modules.BodyAnalyzer
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.account.ui.AccountActivity
import com.arunwichsapplication.app.modules.notification.ui.NotificationActivity
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.arunwichsapplication.app.modules.result.data.model.ResultRowModel
import com.arunwichsapplication.app.modules.result.data.model.SpinnerFrame2441Model
import com.arunwichsapplication.app.modules.result.data.viewmodel.ResultVM
import com.arunwichsapplication.app.modules.setting.ui.SettingActivity


class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
  private val viewModel: ResultVM by viewModels()

  private lateinit var testData: MutableList<ResultRowModel>

  private fun initData() {

  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.linearHome.setOnClickListener {
      // Navigate to CartActivity
      val intent = Intent(this, AccountActivity::class.java)
      startActivity(intent)
    }
    binding.linearPropor.setOnClickListener {
      // Navigate to CartActivity
      val intent = Intent(this, PropActivity::class.java)
      startActivity(intent)
    }

    binding.linearAc.setOnClickListener {
      // Navigate to OtherActivity
      val intent = Intent(this, SettingActivity::class.java)
      startActivity(intent)
    }

    binding.linearNoti.setOnClickListener {
      // Navigate to ProporActivity

      val intent = Intent(this, NotificationActivity::class.java)
      startActivity(intent)
    }



    val dbHelper = DatabaseHelper(this)
    val email = dbHelper.getUserEmail()
    val userData = dbHelper.getUserData(email)



// แสดงผลค่าที่ได้จากข้อมูลแต่ละคอลัมน์
    val waistline = userData[DatabaseHelper.getColumnWaist()] ?: 0.0
    val chest = userData[DatabaseHelper.getColumnChest()] ?: 0.0
    val hipInput = userData[DatabaseHelper.getColumnHip()] ?: 0.0
    val height = userData[DatabaseHelper.getColumnHeight()] ?: 0.0
    val weight = userData[DatabaseHelper.getColumnWeight()] ?: 0.0
    val frontLength = ((height!! - 30) / 2)
    val armLength = (height / 4)
    val shoulderWidth = ((height / 3) - 5)




    val bodyAnalyzer = BodyAnalyzer()

    val personData = mapOf(
      "front_length" to frontLength,
      "bust_size" to chest,
      "shoulder_width" to shoulderWidth,
      "waist_size" to waistline,
      "arm_length" to armLength,
      "hip_size" to hipInput
    )

    val clothingDataList = mutableListOf(
      mapOf<String, Double>(
        "bust" to 98.0,
        "shoulder" to 45.0,
        "arm" to 39.50,
        "frontLength" to 60.0,
        "waist" to 75.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 88.0,
        "shoulder" to 47.0,
        "arm" to 38.0,
        "frontLength" to 63.0,
        "waist" to 88.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 38.0,
        "shoulder" to 31.0,
        "arm" to 16.0,
        "frontLength" to 39.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 112.0,
        "shoulder" to 0.0,
        "arm" to 44.0,
        "frontLength" to 62.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 74.0,
        "shoulder" to 0.0,
        "arm" to 15.0,
        "frontLength" to 48.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 99.0,
        "shoulder" to 0.0,
        "arm" to 0.0,
        "frontLength" to 38.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 116.0,
        "shoulder" to 57.0,
        "arm" to 52.0,
        "frontLength" to 68.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 106.0,
        "shoulder" to 48.0,
        "arm" to 55.0,
        "frontLength" to 44.5,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 91.0,
        "shoulder" to 63.0,
        "arm" to 57.0,
        "frontLength" to 40.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 121.0,
        "shoulder" to 50.0,
        "arm" to 52.0,
        "frontLength" to 45.72,
        "waist" to 0.0,
        "hip" to 0.0
      )
      ,
      mapOf<String, Double>(
        "bust" to 92.0,
        "shoulder" to 41.0,
        "arm" to 18.0,
        "frontLength" to 60.00,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 88.0,
        "shoulder" to 0.0,
        "arm" to 60.0,
        "frontLength" to 45.0,
        "waist" to 68.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 88.0,
        "shoulder" to 0.0,
        "arm" to 10.0,
        "frontLength" to 46.00,
        "waist" to 72.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 88.0,
        "shoulder" to 0.0,
        "arm" to 12.0,
        "frontLength" to 40.00,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 96.52,
        "shoulder" to 0.0,
        "arm" to 12.0,
        "frontLength" to 38.1,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 60.0,
        "shoulder" to 20.0,
        "arm" to 45.0,
        "frontLength" to 98.0,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 81.0,
        "shoulder" to 0.0,
        "arm" to 20.0,
        "frontLength" to 55.88,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 106.0,
        "shoulder" to 0.0,
        "arm" to 35.56,
        "frontLength" to 68.58,
        "waist" to 0.0,
        "hip" to 0.0
      ),
      mapOf<String, Double>(
        "bust" to 101.0,
        "shoulder" to 45.72,
        "arm" to 20.32,
        "frontLength" to 67.00,
        "waist" to 0.0,
        "hip" to 0.0
      )
    )



    testData = mutableListOf(
      ResultRowModel(
        txtFiveResourceId = "Orange Vest",
        txtoneResourceId = "C&M shop .TH",
        txttwoResourceId = "freesize",
        txtSixResourceId = "280 THB",
        txtNumbersoldResourceId = R.drawable.orange_vest,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[0], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อกั๊ก ผ้าขนสัตว์ ลายสก็อต สไตล์อเมริกัน",
        txtoneResourceId = "C&M shop .TH",
        txttwoResourceId = "freesize",
        txtSixResourceId = "149 THB",
        txtNumbersoldResourceId = R.drawable.a2,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[1], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อครอปแขนสั้น คอวี ผ้าไหมพรม",
        txtoneResourceId = "cici.official",
        txttwoResourceId = "freesize",
        txtSixResourceId = "79 THB",
        txtNumbersoldResourceId = R.drawable.a3,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[2], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อกันหนาว คอวี ผ้าถัก ทรงหลวม สไตล์เกาหลี",
        txtoneResourceId = "NZN.th--ifashion",
        txttwoResourceId = "freesize",
        txtSixResourceId = "199 THB",
        txtNumbersoldResourceId = R.drawable.a4,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[3], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "Nuziro Baby Tee",
        txtoneResourceId = "nuziro . th",
        txttwoResourceId = "freesize",
        txtSixResourceId = "138 THB",
        txtNumbersoldResourceId = R.drawable.a5,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[4], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "Martin Denim Jacket",
        txtoneResourceId = "riley.apparels",
        txttwoResourceId = "freesize",
        txtSixResourceId = "750 THB",
        txtNumbersoldResourceId = R.drawable.a6,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[5], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อแจ็กเก็ตหนัง แขนยาว สไตล์วินเทจ",
        txtoneResourceId = "JUNNOVGAL Official Store",
        txttwoResourceId = "M",
        txtSixResourceId = "789 THB",
        txtNumbersoldResourceId = R.drawable.a7,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[6], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อแจ็คเก็ต สไตล์ลำลอง",
        txtoneResourceId = "LOVITO OFFICIAL STORE",
        txttwoResourceId = "S",
        txtSixResourceId = "433 THB",
        txtNumbersoldResourceId = R.drawable.a8,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[7], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "meer crop jacket",
        txtoneResourceId = "MeeerShop",
        txttwoResourceId = "freesize",
        txtSixResourceId = "590 THB",
        txtNumbersoldResourceId = R.drawable.a9,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[8], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "2 way zip jacket",
        txtoneResourceId = "kome.girls",
        txttwoResourceId = "freesize",
        txtSixResourceId = "550 THB",
        txtNumbersoldResourceId = R.drawable.a10,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[9], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "T-shirt เสื้อยืดคอกลมผ้าฝ้ายธรรมดา ลายน่ารัก",
        txtoneResourceId = "amaq1uorzt",
        txttwoResourceId = "S",
        txtSixResourceId = "225 THB",
        txtNumbersoldResourceId = R.drawable.a11,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[10], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อยืดลําลองสําหรับสตรีแขนยาวคอกลมพิมพ์ลายหูเต่า",
        txtoneResourceId = "sweeticme . th",
        txttwoResourceId = "S",
        txtSixResourceId = "129 THB",
        txtNumbersoldResourceId = R.drawable.a12,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[11], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อยืดคอกลม แขนสั้น พิมพ์ลายตัวอักษร สีพื้น",
        txtoneResourceId = "MsMona . TH",
        txttwoResourceId = "S",
        txtSixResourceId = "189 THB",
        txtNumbersoldResourceId = R.drawable.a13,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[12], null)
      ),
      ResultRowModel(
        txtFiveResourceId = "เสื้อยืด คอกลม แขนสั้น พิมพ์ลายดอกไม้ สีพื้น",
        txtoneResourceId = "MsMona . TH",
        txttwoResourceId = "S",
        txtSixResourceId = "155 THB",
        txtNumbersoldResourceId = R.drawable.a14,
        txtSevenResourceId = bodyAnalyzer.calculateBodyTypeAndClothingFit(personData, clothingDataList[13], null)
      )

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

    binding.imageSearchOne.setOnClickListener {
      showFilterDialog()
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

  fun filterList1(filteredFitsWellList: List<ResultRowModel>, query: String) {
    val filteredList = filteredFitsWellList.filter {
      it.txtSevenResourceId?.contains(query, ignoreCase = true) ?: false
    }
    val resultAdapter = ResultAdapter(filteredList) { position, item ->
      onClickRecyclerResult(position, item)
    }
    binding.recyclerResult.adapter = resultAdapter
  }


  private fun showFilterDialog() {
    val options = arrayOf("ฟิต", "คับ", "หลวม", "oversize", "ทั้งหมด")
    var selectedOption = -1 // ตัวแปรเก็บค่าตัวเลือกที่ถูกเลือก

    val builder = AlertDialog.Builder(this)
    builder.setTitle("Choose a filter")
    builder.setSingleChoiceItems(options, selectedOption) { dialog, which ->
      selectedOption = which
    }

    builder.setPositiveButton("OK") { dialog, which ->
      if (selectedOption != -1) {
        val filterCondition = options[selectedOption]
        if (filterCondition == "ทั้งหมด") {
          // คืนค่ารายการทั้งหมด
          val resultAdapter = ResultAdapter(testData) { position, item ->
            onClickRecyclerResult(position, item)
          }
          binding.recyclerResult.adapter = resultAdapter
        } else {
          // กรองรายการตามเงื่อนไขที่เลือก
          filterList1(testData, filterCondition)
        }
      }
    }

    builder.setNegativeButton("Cancel") { dialog, which ->
      dialog.dismiss()
    }

    val dialog = builder.create()
    dialog.show()
  }








  companion object {
    const val TAG: String = "RESULT_ACTIVITY"
  }
}