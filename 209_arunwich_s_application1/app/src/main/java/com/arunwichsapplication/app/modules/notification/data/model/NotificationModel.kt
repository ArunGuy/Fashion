package com.arunwichsapplication.app.modules.notification.data.model

import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.di.MyApp

data class NotificationModel(
    /**
     * TODO Replace with dynamic value
     */
    var txtTitle: String? = MyApp.getInstance().resources.getString(R.string.lbl_notification_title),
    /**
     * TODO Replace with dynamic value
     */
    var txtMessage: String? = MyApp.getInstance().resources.getString(R.string.lbl_notification_message),
    /**
     * TODO Replace with dynamic value
     */
    var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_notification_time)
) {

}
