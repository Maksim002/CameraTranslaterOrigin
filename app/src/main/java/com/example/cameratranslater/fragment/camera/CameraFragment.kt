package com.example.cameratranslater.fragment.camera


import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.camerakit.CameraKitView
import com.camerakit.CameraKitView.CameraListener
import com.example.cameratranslater.R
import com.example.cameratranslater.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_camera.*
import kotlinx.android.synthetic.main.fragment_camera.view.*


class CameraFragment : BaseMvpFragment<CameraView.View, CameraView.Presenter>(), CameraView.View {

    override var presenter: CameraView.Presenter = CameraPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        layoutCon.isVisible = true
    }

    private fun initClick() {
        btnPhoto.setOnClickListener {
            camera.captureImage {ths, bytes ->
                val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                ivCrop.setImageToCrop(bitmap)
                layoutCon.isVisible = false
                ivCrop.isVisible = true
                btnOk.isVisible = true
            }
        }

        btnOk.setOnClickListener {
            val args = Bundle()
            args.putByteArray("image", presenter.bitmapToBytes(ivCrop.crop()))
            findNavController().navigate(R.id.saveFragment, args,)
        }
    }

    override fun onResume() {
        super.onResume()
        camera.onStart()
    }

    override fun onPause() {
        super.onPause()
        camera.onStop()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        camera.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun showErrorMessage(e: Throwable?, dismissCallback: (() -> Unit)?) {}

    override fun showErrorMessage(messageRes: Int) {}
}
