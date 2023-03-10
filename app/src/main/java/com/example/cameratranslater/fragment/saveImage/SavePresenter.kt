package com.example.cameratranslater.fragment.saveImage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.cameratranslater.base.BasePresenter


class SavePresenter : BasePresenter<SaveView.View>(), SaveView.Presenter {

    override fun attach(view: SaveView.View) {
        super.attach(view)
        println()
    }

    override fun byteToBitmap(key: String, fragment: SaveFragment) : Bitmap = with(fragment) {
        val value = requireArguments().getByteArray(key)
        return BitmapFactory.decodeByteArray(value, 0, value?.size?: 0)
    }
}
