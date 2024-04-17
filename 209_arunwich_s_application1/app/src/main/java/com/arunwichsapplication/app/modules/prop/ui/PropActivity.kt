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
import com.arunwichsapplication.app.modules.DatabaseHelper
class PropActivity : BaseActivity<ActivityPropBinding>(R.layout.activity_prop) {
  private val viewModel: PropVM by viewModels()

  private lateinit var databaseHelper: DatabaseHelper
  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val detailAdapter = DetailAdapter(viewModel.detailList.value?:mutableListOf())
    databaseHelper = DatabaseHelper(this)
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
      val waistline = binding.linearWaistline.text.toString().toDoubleOrNull()
      val chest = binding.linearChest.text.toString().toDoubleOrNull()
      val hip = binding.linearHip.text.toString().toDoubleOrNull()
      val height = binding.linearHeight.text.toString().toDoubleOrNull()
      val weight = binding.linearWeight.text.toString().toDoubleOrNull()
      // ตรวจสอบว่าข้อมูลไม่ว่างเปล่าก่อนส่ง
      if (waistline != null && chest != null && hip != null && height != null && weight != null) {
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

  private fun sendDataToAnotherDestination(
    waistline: Double,
    chest: Double,
    hipInput: Double, // แก้ชื่อตัวแปรเป็น hipInput เพื่อป้องกันการซ่อนชื่อ
    height: Double,
    weight: Double
  ) {
    // แปลงข้อมูลที่รับมาจาก EditText เป็นชนิดที่ถูกต้อง (สำหรับอินพุตที่เป็นข้อความ)
    val waist = waistline
    val bust = chest
    val hip = hipInput
    val heightValue = height
    val weightValue = weight

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
    val isSuccess = databaseHelper.addUserProfileData(waistline, chest, hip, height, weight)
    if (isSuccess) {
      Toast.makeText(this, "เพิ่มข้อมูลลงในฐานข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show()
      val bodyType = bodyTypeCalculator.calculateBodyType(person)
      Toast.makeText(this, "ประเภทร่างกาย Body Type : $bodyType", Toast.LENGTH_SHORT).show()
      val intent = Intent(this, AccountActivity::class.java)
      startActivity(intent)
    } else {
      Toast.makeText(this, "มีข้อผิดพลาดเกิดขึ้นในการเพิ่มข้อมูลในฐานข้อมูล", Toast.LENGTH_SHORT).show()
    }

  }


}