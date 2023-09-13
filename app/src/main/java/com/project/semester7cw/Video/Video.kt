package com.project.semester7cw.Video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CalendarCache.URI
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.project.semester7cw.R


class Video : AppCompatActivity() {
    var videoView: VideoView? = null
    lateinit var mediaControls: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById<VideoView>(R.id.videoView)
        mediaControls = MediaController(this)
        if(mediaController == null) {
            mediaControls.setAnchorView(videoView)
        }

        videoView!!.setMediaController(mediaControls)
        videoView!!.setZOrderMediaOverlay(true)

        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + R.raw.play_vid2))

        videoView!!.requestFocus()
        videoView!!.setZOrderOnTop(false)

        videoView!!.start()

        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video Over", Toast.LENGTH_SHORT).show()
        }
    }
}