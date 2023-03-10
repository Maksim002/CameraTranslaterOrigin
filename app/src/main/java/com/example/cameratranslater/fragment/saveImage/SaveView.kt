package com.example.cameratranslater.fragment.saveImage

import android.graphics.Bitmap
import com.example.cameratranslater.base.MvpView
import com.example.deleteafter.db.base.MvpPresenter

interface SaveView {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {
        fun byteToBitmap(key: String, fragment: SaveFragment) : Bitmap
    }
}