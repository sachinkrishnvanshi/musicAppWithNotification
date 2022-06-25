package com.example.musicapp.callBack

import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import android.support.v4.media.session.MediaSessionCompat
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.musicapp.R
import com.example.musicapp.ui.MainActivity

class MusicService : Service() {


    private lateinit var mediaSession: MediaSessionCompat
    private lateinit var musicPlayer: MediaPlayer


    override fun onCreate() {
        super.onCreate()
        musicPlayer = MediaPlayer.create(this, R.raw.ringtone)
        musicPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Music Player Started", Toast.LENGTH_SHORT).show()
        musicPlayer.isLooping
        musicPlayer.start()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.stop()
        Toast.makeText(this, "Music Player Stopped", Toast.LENGTH_SHORT).show()
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}




