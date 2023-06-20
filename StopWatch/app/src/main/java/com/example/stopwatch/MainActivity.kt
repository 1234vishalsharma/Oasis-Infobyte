package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var isRunning:Boolean = false
    private var elapsedtime:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.play.setOnClickListener {
            binding.play.visibility= View.GONE
            binding.pause.visibility=View.VISIBLE
            startChronometer()

        }

        binding.pause.setOnClickListener {
            binding.play.visibility= View.VISIBLE
            binding.pause.visibility=View.GONE
            stopChronometer()
        }

        binding.repeat.setOnClickListener {
            binding.pause.visibility=View.GONE
            binding.play.visibility=View.VISIBLE
            binding.timer.base=SystemClock.elapsedRealtime()
            elapsedtime=0
            stopChronometer()
        }
    }

    private fun stopChronometer() {
        if(isRunning){
            binding.timer.stop()
            elapsedtime=SystemClock.elapsedRealtime()-binding.timer.base
            isRunning=false
        }
    }

    private fun startChronometer() {
        if(!isRunning){
            binding.timer.base=SystemClock.elapsedRealtime()-elapsedtime
            binding.timer.start()
            isRunning=true
        }
    }
}