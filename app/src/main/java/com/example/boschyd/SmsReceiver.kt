package com.example.boschyd

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "abdul u have an sms")

        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        for (message in smsMessages) {
            val sender = message.displayOriginatingAddress
            val messageBody = message.messageBody

            Log.d("SmsReceiver", "Sender: $sender")
            Log.d("SmsReceiver", "Message body: $messageBody")

//            if (sender == "+43....." || messageBody.contains("Einsatzgebiet")) {
//                Log.d("SmsReceiver", "Message received from: $sender")
//                Log.d("SmsReceiver", "Message body: $messageBody")
//
//                val launchIntent = Intent(context, CalendarActivity::class.java)
//                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                launchIntent.putExtra("sms_body", messageBody)
//                context.startActivity(launchIntent)
//            }
        }
    }

    companion object{
        var TAG = SmsReceiver::class.java.simpleName
    }

}