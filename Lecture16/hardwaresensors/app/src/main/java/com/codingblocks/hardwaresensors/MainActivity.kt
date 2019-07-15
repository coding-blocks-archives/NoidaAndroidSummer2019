package com.codingblocks.hardwaresensors

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor = sm.getSensorList(Sensor.TYPE_ALL)

        sensor.forEach {
            Log.i(
                "SENSORS", """
                ${it.name},
                ${it.vendor}
            """.trimIndent()
            )

            val acceSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            val sensorListener = object : SensorEventListener {
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }

                override fun onSensorChanged(p0: SensorEvent?) {
                    Log.i(
                        "SENSOR VALUES", """
                        values :
                        ax : ${p0?.values?.get(0)}
                        ay : ${p0?.values?.get(1)}
                        az : ${p0?.values?.get(2)}
                    """.trimIndent()
                    )

                    val ax = p0?.values?.get(0) ?: 0f
                    val ay = p0?.values?.get(1) ?: 0f
                    val az = p0?.values?.get(2) ?: 0f

                    back.setBackgroundColor(Color.rgb(
                        (((ax +12 )/ 24) * 255).toInt(),
                        (((ay +12 )/ 24) * 255).toInt(),
                        (((az +12 )/ 24) * 255).toInt()
                    ))


                }

            }
            sm.registerListener(sensorListener, acceSensor, 1000 * 60)
        }
    }
}
