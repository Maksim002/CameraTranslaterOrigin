package com.example.cameratranslater.fragment.saveImage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.example.cameratranslater.base.BasePresenter
import com.example.cameratranslater.fragment.saveImage.translater.Language
import com.example.cameratranslater.fragment.saveImage.translater.TranslateApi
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.text.TextRecognizer
import java.util.*


class SavePresenter : BasePresenter<SaveView.View>(), SaveView.Presenter {

    override fun attach(view: SaveView.View) {
        super.attach(view)
        println()
    }

    //Принемает картинку из камера фрагмент
    override fun byteToBitmap(key: String, fragment: SaveFragment): Bitmap = with(fragment) {
        val value = requireArguments().getByteArray(key)
        return BitmapFactory.decodeByteArray(value, 0, value?.size ?: 0)
    }

    //С картинки получает текст
    override fun imageTranslate(bitmap: Bitmap, context: Context) {
        val textRecognizer: TextRecognizer = TextRecognizer.Builder(context).build()
        val imageFrame: Frame = Frame.Builder()
            .setBitmap(bitmap) // your image bitmap
            .build()
        var imageText = ""
        val textBlocks = textRecognizer.detect(imageFrame)
        for (i in 0 until textBlocks.size()) {
            val textBlock = textBlocks[textBlocks.keyAt(i)]
            imageText += " " + textBlock.value // return string
        }
        textTranslate(imageText)
        view?.getImageBitmap(bitmap)

    }

    //Переводит получаемый текст
    private fun <T>textTranslate(text: T){
        val translateApi = TranslateApi(Language.AUTO_DETECT, Locale.getDefault().language.lowercase(), text.toString())
        translateApi.setTranslateListener(object : TranslateApi.TranslateListener {
            override fun onSuccess(translatedText: String?) {
                view?.getTranslatedText(translatedText?: "Не распознан текст")
            }

            override fun onFailure(ErrorText: String?) {
                Log.d("MyLog", "Error of translate!")
            }
        })
    }
}
