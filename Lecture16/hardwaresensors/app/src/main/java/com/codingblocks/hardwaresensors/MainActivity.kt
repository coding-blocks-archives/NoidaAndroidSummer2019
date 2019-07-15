package com.codingblocks.hardwaresensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

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
                        ay : ${p0?.values?.get(0)}
                        az : ${p0?.values?.get(0)}
                    """.trimIndent()
                    )
                }

            }
            sm.registerListener(sensorListener, acceSensor, 100000 * 60)
        }
    }
}
