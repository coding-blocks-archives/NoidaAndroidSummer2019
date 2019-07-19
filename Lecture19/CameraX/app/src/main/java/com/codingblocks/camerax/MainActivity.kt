package com.codingblocks.camerax

import android.content.pm.PackageManager
import android.graphics.Matrix
import android.os.Bundle
import android.util.Rational
import android.util.Size
import android.view.Surface
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                123
            )
        } else {
            textureView.post {
                startCamera()
            }
        }
    }

    private fun startCamera() {

        //to capture the image of a button click
        val imageCaptureConfig = ImageCaptureConfig.Builder().apply {
            setTargetAspectRatio(Rational(1,1))
            setCaptureMode(ImageCapture.CaptureMode.MIN_LATENCY)
        }.build()

        val imageCapture = ImageCapture(imageCaptureConfig)
        imageButton.setOnClickListener {
            val file = File(externalMediaDirs.first(),"${System.currentTimeMillis()}.jpg")

            imageCapture.takePicture(file,object : ImageCapture.OnImageSavedListener{
                override fun onImageSaved(file: File) {
                    Toast.makeText(this@MainActivity,"Photo Captured ${file.absolutePath}",Toast.LENGTH_LONG).show()
                }

                override fun onError(useCaseError: ImageCapture.UseCaseError, message: String, cause: Throwable?) {
                    Toast.makeText(this@MainActivity,"Error Capturing $message",Toast.LENGTH_LONG).show()
                }

            })
        }

        //To get the preview of camera
        val previewConfig = PreviewConfig.Builder().apply {
            setTargetResolution(Size(1080, 1080))
            setTargetAspectRatio(Rational(1, 1))
            setLensFacing(CameraX.LensFacing.BACK) //to open Rear camera
        }.build()

        val preview = Preview(previewConfig)

        preview.setOnPreviewOutputUpdateListener {
            val parent = textureView.parent as ViewGroup
            parent.removeView(textureView)
            parent.addView(textureView,0)
            updatePreview()
            textureView.surfaceTexture = it.surfaceTexture
        }
        CameraX.bindToLifecycle(this, preview,imageCapture)

    }
    private fun updatePreview(){
        val matrix = Matrix()

        val centerX = textureView.width/2f
        val centerY = textureView.height/2f

        val rotation = when(textureView.display.rotation){
            Surface.ROTATION_0 -> 0
            Surface.ROTATION_90 -> 90
            Surface.ROTATION_180 -> 180
            Surface.ROTATION_270 -> 270
            else -> return
        }

        matrix.postRotate(-rotation.toFloat(),centerX,centerY)

        textureView.setTransform(matrix)
    }
}
