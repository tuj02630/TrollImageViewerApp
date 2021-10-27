package edu.temple.fragment_testing

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

var key : String = "TROLL_LIST"

class TrollSelectionFragment() : Fragment() {
    private lateinit var recyclerView: RecyclerView;
    var iol: ArrayList<ImageObject>? = ArrayList<ImageObject>();
    companion object{

        fun newInstance(al : ArrayList<ImageObject>) : TrollSelectionFragment
        {
            var tsf =  TrollSelectionFragment();
            var args = Bundle();
            args.putParcelableArrayList(key, al);
            tsf.setArguments(args);
            return tsf;
        }
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.troll_selection, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(getArguments() != null) {
            iol = requireArguments().getParcelableArrayList<ImageObject>(key)
        }

    }

    override fun onStart() {
        super.onStart()
        val activity = activity as Context;
        recyclerView = requireView().findViewById(R.id.recycler_view);
        recyclerView.layoutManager = GridLayoutManager(activity, 3);
        var adptr = ImageAdapter(activity, iol as java.util.ArrayList<ImageObject>)
        recyclerView.adapter = adptr;
        adptr.onItemClick = { imageObject ->
            (activity as TrollFragmentInterface).itemClicked(imageObject)
        }
    }

    override fun onAttach(context: Context) {
            super.onAttach(context)

    }
    interface TrollFragmentInterface{
        public fun itemClicked(io:ImageObject)
    }
}