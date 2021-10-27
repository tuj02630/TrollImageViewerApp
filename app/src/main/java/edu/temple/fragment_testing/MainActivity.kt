package edu.temple.fragment_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), TrollSelectionFragment.TrollFragmentInterface  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iolist = ArrayList<ImageObject>();
        val myArray = this.resources.getStringArray(R.array.troll_list);
        var t = 0;
        iolist.add(ImageObject(myArray[t++], R.drawable.aradia))
        iolist.add(ImageObject(myArray[t++], R.drawable.tavros))
        iolist.add(ImageObject(myArray[t++], R.drawable.sollux))
        iolist.add(ImageObject(myArray[t++], R.drawable.karkat))
        iolist.add(ImageObject(myArray[t++], R.drawable.nepeta))
        iolist.add(ImageObject(myArray[t++], R.drawable.kanaya))
        iolist.add(ImageObject(myArray[t++], R.drawable.terezi))
        iolist.add(ImageObject(myArray[t++], R.drawable.vriska))
        iolist.add(ImageObject(myArray[t++], R.drawable.equius))
        iolist.add(ImageObject(myArray[t++], R.drawable.sollux))
        iolist.add(ImageObject(myArray[t++], R.drawable.eridan))
        iolist.add(ImageObject(myArray[t++], R.drawable.feferi))

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.selection_container_view, TrollSelectionFragment.newInstance(iolist))
                .commit()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.display_container_view, TrollDisplayFragment.newInstance(iolist[0]))
                .commit()
        }
    }

    override fun itemClicked(io:ImageObject)
    {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.display_container_view, TrollDisplayFragment.newInstance(io))
            .addToBackStack(null)
            .commit();
    }
}