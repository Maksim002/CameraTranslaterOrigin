package com.example.cameratranslater.fragment.camera

import android.graphics.Bitmap
import com.example.cameratranslater.base.MvpView
import com.example.deleteafter.db.base.MvpPresenter

interface CameraView {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {
        fun bitmapToBytes(bitmap: Bitmap): ByteArray
    }
}