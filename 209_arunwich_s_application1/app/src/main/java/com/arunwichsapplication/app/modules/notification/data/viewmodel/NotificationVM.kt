package com.arunwichsapplication.app.modules.notification.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arunwichsapplication.app.modules.notification.data.model.NotificationModel
import org.koin.core.KoinComponent

class NotificationVM : ViewModel(), KoinComponent {
    private val _notificationList = MutableLiveData<List<NotificationModel>>()
    var navArguments: Bundle? = null
    val notificationList: LiveData<List<NotificationModel>> get() = _notificationList

    fun updateNotifications(notifications: List<NotificationModel>) {
        _notificationList.value = notifications
    }


}

var navArguments: Bundle? = null