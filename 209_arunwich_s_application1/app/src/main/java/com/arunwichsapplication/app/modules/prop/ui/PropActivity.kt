package com.arunwichsapplication.app.modules.prop.ui


import Notification
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityPropBinding
import com.arunwichsapplication.app.modules.BodyTypeCalculator
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.Person
import com.arunwichsapplication.app.modules.account.ui.AccountActivity
import com.arunwichsapplication.app.modules.prop.data.model.DetailRowModel
import com.arunwichsapplication.app.modules.prop.data.viewmodel.PropVM

class PropActivity : BaseActivity<ActivityPropBinding>(R.layout.activity_prop) {
  private val viewModel: PropVM by viewModels()
  private lateinit var databaseHelper: DatabaseHelper
  private var isEmailProcessed = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding.propVM = viewModel
    databaseHelper = DatabaseHelper(this)

    val notification = Notification(this)
    notification.createNotificationChannel()




    binding.button5.setOnClickListener {

      processData()
    }


  }





  // ตรวจสอบว่า processEmail() ได้ทำงานแล้วหรือไม่
  private fun checkEmailProcessed(): Boolean {
    val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("emailProcessed", false)
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

    val email = databaseHelper.getUserEmail()
    val bodyTypeCalculator = BodyTypeCalculator()
    val bodyType = bodyTypeCalculator.calculateBodyType(person)
    //Toast.makeText(this, "ประเภทร่างกาย Body Type : $bodyType", Toast.LENGTH_SHORT).show()
    if (databaseHelper.addUserProfileData(email ,waistline, chest, hipInput, height, weight)) {

      val intent = Intent(this, AccountActivity::class.java)
      intent.putExtra("waistline", waistline)
      intent.putExtra("chest", chest)
      intent.putExtra("hipInput", hipInput)
      intent.putExtra("height", height)
      intent.putExtra("weight", weight)
      showNotification()
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


  private fun showNotification() {
    val CHANNEL_ID = "MyNotificationChannel"
    val NOTIFICATION_ID = 123
    val builder = NotificationCompat.Builder(this, CHANNEL_ID)
      .setSmallIcon(R.drawable.notifi)
      .setContentTitle("Fashion Scan")
      .setContentText("บันทึกข้อมูลสำเร็จ")
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    // Show the notification
    with(NotificationManagerCompat.from(this@PropActivity)) {
      if (ContextCompat.checkSelfPermission(
          this@PropActivity,
          Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
      ) {
        // TODO: Handle the case where the permission is not granted
        return
      }
      notify(NOTIFICATION_ID, builder.build())
    }
  }


}