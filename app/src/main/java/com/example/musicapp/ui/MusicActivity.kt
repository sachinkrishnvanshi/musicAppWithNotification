package com.example.musicapp.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.musicapp.R
import com.example.musicapp.callBack.MusicService
import kotlinx.android.synthetic.main.activity_music.*


class MusicActivity : AppCompatActivity() {

    private val CHANNEL_ID="chanel_id_sachin"
    private val NOTIFICATION_ID=101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        supportActionBar?.hide()
        createNotificationChannel()
        iv_play.setOnClickListener {
            sendNotification()
            startService(Intent(this, MusicService::class.java))
            iv_stop.visibility = View.VISIBLE
            iv_play.visibility = View.INVISIBLE

        }
        iv_stop.setOnClickListener {
            stopService(Intent(this, MusicService::class.java))
            iv_stop.visibility = View.INVISIBLE
            iv_play.visibility = View.VISIBLE

        }
        iv_share.setOnClickListener {
//
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.setDataAndType(Uri.parse(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString()), "audio/*")
            startActivity(intent)
        }

    }


   private fun sendNotification() {
       val intent : Intent = Intent(this,MainActivity::class.java).apply {
           flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
       }
       val pendingIntent: PendingIntent= PendingIntent.getActivity(this,0,intent,0)
       val bitmap: Bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.bhagwa)
       val bitmapLargeIcon : Bitmap =BitmapFactory.decodeResource(applicationContext.resources, R.drawable.musicplayer)

       val builder: NotificationCompat.Builder = NotificationCompat.Builder(this,"channell")
            .setSmallIcon(R.drawable.ic_baseline_sports_soccer_24)
            .setContentTitle("Music")
            .setContentText("I am listening this song")
           .setLargeIcon(bitmapLargeIcon)
           .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
           .setContentIntent(pendingIntent)
           .setPriority(NotificationCompat.PRIORITY_DEFAULT)

       with(NotificationManagerCompat.from(this)){
           notify(NOTIFICATION_ID,builder.build())
       }
   }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance : Int = NotificationManager.IMPORTANCE_DEFAULT
            val channel :NotificationChannel = NotificationChannel(CHANNEL_ID,name,importance).apply {
                description = descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}