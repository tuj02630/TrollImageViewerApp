package edu.temple.trollimageviewerapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TrollListFragment : Fragment() {

    private lateinit var ios: ArrayList<ImageObject>;

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context != null) {
            // Get dog names and descriptions.
            val resources = context.resources

        }
    }
    override fun onCreateView(inflater: LayoutInflater,
                              parent: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        if (recyclerView != null) {
            recyclerView.layoutManager = GridLayoutManager(activity, 2)
        }
        val view = inflater.inflate(R.layout.grid_layout, parent,
            false)
        val activity = activity as Context

        if (recyclerView != null) {
            recyclerView.adapter = ImageAdapter(activity, ios)
        }
        return view
    }
    companion object {

        fun newInstance(): TrollListFragment {
            return TrollListFragment()
        }
    }
}