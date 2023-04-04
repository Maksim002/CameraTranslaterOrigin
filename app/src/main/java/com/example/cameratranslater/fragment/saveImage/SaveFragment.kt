package com.example.cameratranslater.fragment.saveImage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cameratranslater.R
import com.example.cameratranslater.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_save.*


class SaveFragment : BaseMvpFragment<SaveView.View, SaveView.Presenter>(), SaveView.View {

    override var presenter: SaveView.Presenter = SavePresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var t = presenter.byteToBitmap("image", this)
        imageTranslate.setImageBitmap(t)
    }

    override fun showErrorMessage(e: Throwable?, dismissCallback: (() -> Unit)?) {}

    override fun showErrorMessage(messageRes: Int) {}
}