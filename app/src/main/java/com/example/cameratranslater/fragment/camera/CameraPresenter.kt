package com.example.cameratranslater.fragment.camera

import android.graphics.Bitmap
import com.example.cameratranslater.base.BasePresenter
import java.io.ByteArrayOutputStream

class CameraPresenter : BasePresenter<CameraView.View>(), CameraView.Presenter {

    override fun attach(view: CameraView.View) {
        super.attach(view)
        println()
    }

    override fun bitmapToBytes(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }
}