package com.example.cameratranslater.fragment.saveImage

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import com.example.cameratranslater.R
import com.example.cameratranslater.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_save.*

class SaveFragment : BaseMvpFragment<SaveView.View, SaveView.Presenter>(), SaveView.View {

    override var presenter: SaveView.Presenter = SavePresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.imageTranslate(presenter.byteToBitmap("image", this), requireContext())
    }

    override fun getTranslatedText(string: String) {
        textTranslate.setText(string)
    }

    override fun getImageBitmap(bitmap: Bitmap) {
        imageTranslate.setImageBitmap(bitmap)
    }


    override fun showErrorMessage(e: Throwable?, dismissCallback: (() -> Unit)?) {}

    override fun showErrorMessage(messageRes: Int) {}
}