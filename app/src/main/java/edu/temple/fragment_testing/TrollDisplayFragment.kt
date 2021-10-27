package edu.temple.fragment_testing

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class TrollDisplayFragment : Fragment() {
    var io : ImageObject? = ImageObject("", 0);
    companion object{
        fun newInstance(io : ImageObject) : TrollDisplayFragment
        {
            var tdf =  TrollDisplayFragment();
            var args = Bundle();
            args.putParcelable("CURRENT", io);
            tdf.setArguments(args);
            return tdf;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(getArguments() != null) {
            io = requireArguments().getParcelable<ImageObject>("CURRENT")
        }

    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.troll_display, container, false)
    }

    override fun onStart() {
        super.onStart()
        if(io != null) {
            var temp1: Int = (io as ImageObject).resourceId;
            var temp2: String = (io as ImageObject).description as String;
            view?.findViewById<ImageView>(R.id.troll_image)?.setImageResource(temp1);
            view?.findViewById<TextView>(R.id.troll_name)?.setText(temp2);
        }
    }
}