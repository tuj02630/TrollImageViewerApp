package edu.temple.trollimageviewerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TrollDetailsFragment : Fragment() {
    companion object {

        fun newInstance(): TrollDetailsFragment {
            return TrollDetailsFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dog_details, container, false)
    }

}
