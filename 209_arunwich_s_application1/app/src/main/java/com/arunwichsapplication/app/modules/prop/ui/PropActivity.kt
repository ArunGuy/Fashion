package com.arunwichsapplication.app.modules.prop.ui

import android.content.Intent
import android.os.Bundle
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
import com.arunwichsapplication.app.modules.login.ui.LogInActivity

class PropActivity : BaseActivity<ActivityPropBinding>(R.layout.activity_prop) {
  private val viewModel: PropVM by viewModels()
  private lateinit var databaseHelper: DatabaseHelper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding.propVM = viewModel
    databaseHelper = DatabaseHelper(this)

    // Set up button click listener
    binding.button5.setOnClickListener {
      processData()
    }
  }

  private fun processData() {
    // Get data from EditText fields
    val waistline = binding.waist.text.toString().toDoubleOrNull()
    val chest = binding.chest.text.toString().toDoubleOrNull()
    val hip = binding.hip.text.toString().toDoubleOrNull()
    val height = binding.height.text.toString().toDoubleOrNull()
    val weight = binding.weight.text.toString().toDoubleOrNull()

    // Check if data is not null
    if (waistline != null && chest != null && hip != null && height != null && weight != null) {
      sendDataToAnotherDestination(waistline, chest, hip, height, weight)
    } else {
      Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_SHORT).show()
    }
  }

  private fun sendDataToAnotherDestination(
    waistline: Double,
    chest: Double,
    hipInput: Double,
    height: Double,
    weight: Double
  ) {
    // Process data and navigate to another activity
    val person = Person(
      height = height,
      weight = weight,
      waist = waistline,
      bust = chest,
      hip = hipInput,
      gender = "", // Set gender as needed
      bodyType = "" // Body type will be calculated by BodyTypeCalculator
    )


    val bodyTypeCalculator = BodyTypeCalculator()
    val bodyType = bodyTypeCalculator.calculateBodyType(person)
    //Toast.makeText(this, "ประเภทร่างกาย Body Type : $bodyType", Toast.LENGTH_SHORT).show()
    if (databaseHelper.addUserProfileData(waistline, chest, hipInput, height, weight)) {

      Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
      val intent = Intent(this, AccountActivity::class.java)
      startActivity(intent)
    } else {
      // หากเกิดปัญหาในการเพิ่มข้อมูล UserProfile ในฐานข้อมูล
      Toast.makeText(this, "Failed to add user profile data.", Toast.LENGTH_SHORT).show()
    }

  }

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val detailAdapter = DetailAdapter(viewModel.detailList.value ?: mutableListOf())

    detailAdapter.setOnItemClickListener(object : DetailAdapter.OnItemClickListener {
      override fun onItemClick(view: View, position: Int, item: DetailRowModel) {
        onClickRecyclerDetail(view, position, item)
      }
    })
    viewModel.detailList.observe(this) {
      detailAdapter.updateData(it)
    }
    binding.propVM = viewModel
  }

  override fun setUpClicks() {

  }

  private fun onClickRecyclerDetail(
    view: View,
    position: Int,
    item: DetailRowModel
  ) {
    // Handle click on RecyclerView item
  }
}