package com.arunwichsapplication.app.modules.prop.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityPropBinding
import com.arunwichsapplication.app.modules.BodyTypeCalculator
import com.arunwichsapplication.app.modules.Person
import com.arunwichsapplication.app.modules.prop.data.model.DetailRowModel
import com.arunwichsapplication.app.modules.prop.data.viewmodel.PropVM
import com.arunwichsapplication.app.modules.account.ui.AccountActivity
class PropActivity : BaseActivity<ActivityPropBinding>(R.layout.activity_prop) {
  private val viewModel: PropVM by viewModels()

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val detailAdapter = DetailAdapter(viewModel.detailList.value?:mutableListOf())

    detailAdapter.setOnItemClickListener(object : DetailAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : DetailRowModel) {
        onClickRecyclerDetail(view, position, item)
      }
    })
    viewModel.detailList.observe(this) {
      detailAdapter.updateData(it)
    }
    binding.propVM = viewModel
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.buttonProcessData.setOnClickListener {
      // ดึงข้อมูลที่กรอกใน EditText
      val waistline = binding.linearWaistline.text.toString()
      val chest = binding.linearChest.text.toString()
      val hip = binding.linearHip.text.toString()
      val height = binding.linearHeight.text.toString()
      val weight = binding.linearWeight.text.toString()

      // ตรวจสอบว่าข้อมูลไม่ว่างเปล่าก่อนส่ง
      if (waistline.isNotEmpty() && chest.isNotEmpty() && hip.isNotEmpty() &&
        height.isNotEmpty() && weight.isNotEmpty()) {
        // ส่งข้อมูลไปยังที่ท่านต้องการ เช่น แสดงข้อความผ่านทาง Toast
        sendDataToAnotherDestination(waistline, chest, hip, height, weight)
      } else {
        Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun onClickRecyclerDetail(
    view: View,
    position: Int,
    item: DetailRowModel
  ) {
    // ตรงนี้คุณสามารถจัดการกับการคลิกบนรายการ RecyclerView ได้
  }

  // ในฟังก์ชัน sendDataToAnotherDestination() ใน PropActivity
  // ในฟังก์ชัน sendDataToAnotherDestination() ใน PropActivity
  private fun sendDataToAnotherDestination(
    waistline: String,
    chest: String,
    hipInput: String, // แก้ชื่อตัวแปรเป็น hipInput เพื่อป้องกันการซ่อนชื่อ
    height: String,
    weight: String
  ) {
    // แปลงข้อมูลที่รับมาจาก EditText เป็นชนิดที่ถูกต้อง (สำหรับอินพุตที่เป็นข้อความ)
    val waist = waistline.toDoubleOrNull() ?: 0.0
    val bust = chest.toDoubleOrNull() ?: 0.0
    val hip = hipInput.toDoubleOrNull() ?: 0.0 // ใช้ชื่อตัวแปร hipInput ที่แก้ไขแล้ว
    val heightValue = height.toDoubleOrNull() ?: 0.0
    val weightValue = weight.toDoubleOrNull() ?: 0.0

    // สร้างอินสแตนซ์ของคลาส Person โดยใช้ข้อมูลจาก EditText
    val person = Person(
      height = heightValue,
      weight = weightValue,
      waist = waist,
      bust = bust,
      hip = hip,
      gender = "", // ใส่เพศได้ตามที่ต้องการ
      bodyType = "" // ค่านี้จะถูกคำนวณโดย BodyTypeCalculator
    )

    // สร้างอินสแตนซ์ของ BodyTypeCalculator
    val bodyTypeCalculator = BodyTypeCalculator()

    // คำนวณประเภทร่างกาย
    val bodyType = bodyTypeCalculator.calculateBodyType(person)
    Toast.makeText(this, "ประเภทร่างกาย Body Type : $bodyType", Toast.LENGTH_SHORT).show()
    val intent = Intent(this, AccountActivity::class.java)
    startActivity(intent)
  // ทำสิ่งที่ต้องการกับประเภทร่างกาย เช่น ส่งไปยังที่อื่นตามที่ต้องการ
  }


}
