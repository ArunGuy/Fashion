package com.arunwichsapplication.app.modules.notification.ui

import android.content.Intent
import androidx.activity.viewModels
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityNotificationBinding
import com.arunwichsapplication.app.modules.DatabaseHelper
import com.arunwichsapplication.app.modules.NotificationAdapter
import com.arunwichsapplication.app.modules.account.ui.AccountActivity
import com.arunwichsapplication.app.modules.notification.data.model.NotificationModel
import com.arunwichsapplication.app.modules.notification.data.viewmodel.NotificationVM
import com.arunwichsapplication.app.modules.prop.ui.PropActivity
import com.arunwichsapplication.app.modules.result.ui.ResultActivity
import com.arunwichsapplication.app.modules.setting.ui.SettingActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NotificationActivity : BaseActivity<ActivityNotificationBinding>(R.layout.activity_notification) {
    private val viewModel: NotificationVM by viewModels<NotificationVM>()

    private lateinit var databaseHelper: DatabaseHelper
    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.notificationVM = viewModel

        // กำหนดข้อมูลแบบแบรนด์เนอร์



        val notificationsFromDB = fetchNotificationsFromDB()
// แปลงข้อมูลจากแบบแบรนด์เนอร์เป็นรูปแบบของ NotificationModel
        val notifications = mutableListOf<NotificationModel>()
        notificationsFromDB.forEach { notificationData ->
            val title = notificationData["title"] ?: ""
            val timestamp = notificationData["timestamp"] ?: ""
            val message = notificationData["message"] ?: ""

            // แปลง timestamp เป็นรูปแบบของวันที่และเวลา
            val formattedTimestamp = formatDate(timestamp.toLong())

            notifications.add(NotificationModel(txtTitle = title, txtMessage = message, txtTime = formattedTimestamp))
        }

// สร้าง Adapter และตั้งค่า RecyclerView
        val notificationAdapter = NotificationAdapter(this, mutableListOf())
        binding.recyclerView.adapter = notificationAdapter

// เพิ่มข้อมูลใน RecyclerView Adapter
        notificationAdapter.updateData(notifications)




    }



    private fun fetchNotificationsFromDB(): List<Map<String, String>> {
        val databaseHelper = DatabaseHelper(this)
        val email = databaseHelper.getUserEmail()
        return databaseHelper.getAllNotifications(email)
    }

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        return sdf.format(calendar.time)
    }

    override fun setUpClicks(): Unit {

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
        binding.linearCart.setOnClickListener {
            // Navigate to CartActivity
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

        binding.linearNoti.setOnClickListener {
            // Navigate to ProporActivity

        }
    }

    companion object {
        const val TAG: String = "NOTIFICATION_ACTIVITY"
    }
}
