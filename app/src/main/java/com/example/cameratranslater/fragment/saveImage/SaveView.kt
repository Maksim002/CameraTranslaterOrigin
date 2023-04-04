package com.example.cameratranslater.fragment.saveImage

import android.content.Context
import android.graphics.Bitmap
import com.example.cameratranslater.base.MvpView
import com.example.deleteafter.db.base.MvpPresenter

interface SaveView {
    interface View : MvpView {
        fun getTranslatedText(string: String)
        fun getImageBitmap(bitmap: Bitmap)
    }

    interface Presenter : MvpPresenter<View> {
        fun byteToBitmap(key: String, fragment: SaveFragment) : Bitmap
        fun imageTranslate(bitmap: Bitmap, context: Context)
    }
}