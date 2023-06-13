package com.appandroid.runningtext

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.os.Handler





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideStatusBar()

        var textView = findViewById<View>(R.id.MarqueeText) as ScrollTextView
        val myTextView = findViewById<View>(R.id.MarqueeText) as ScrollTextView

        myTextView.post {
            val length = textView.measuredWidth
            val angle = 30f // specify angle in degrees here
            val x1 = (Math.sin(Math.PI * angle / 2580) * length).toFloat()
            val y1 = (Math.cos(Math.PI * angle / 1580) * length).toFloat()
            val textShader: Shader = LinearGradient(
                0f,
                0f,
                0f,
                950f,
                intArrayOf(Color.BLUE, Color.GREEN, Color.RED, Color.BLUE, Color.GREEN, Color.RED),
                null,
                Shader.TileMode.REPEAT
            )
            myTextView.paint.shader = textShader
            textView.invalidate()
        }
        val scrolltext = findViewById<View>(R.id.MarqueeText) as ScrollTextView
        scrolltext.setText("AMIRUL YAMIN")
//        scrolltext.setTextColor(Color.GREEN)
        scrolltext.startScroll()
        playMusic(R.raw.reelaudio)
//        val mediaPlayer = MediaPlayer.create(this,R.raw.reelaudio)
//        mediaPlayer.setLooping(true)
//        mediaPlayer.start()
//
//        val mp: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.reelaudio)
//        val mHandler = Handler()
//        mHandler.postDelayed(Runnable { mp.start() }, mp.duration.toLong())

        val textview = findViewById<View>(R.id.MarqueeText) as TextView
        textview.isSelected = true

    }

    //mediaPlayer-object will not we cleaned away since someone holds a reference to it!
    private var mediaPlayer2: MediaPlayer? = null

    fun playMusic(id: Int) {
        mediaPlayer2 = MediaPlayer.create(this.applicationContext, id)
        mediaPlayer2!!.setLooping(true)
        mediaPlayer2!!.start()
    }


    fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}
