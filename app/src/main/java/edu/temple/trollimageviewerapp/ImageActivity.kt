package edu.temple.customviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.trollimageviewerapp.R

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById<RecyclerView>(R.id.recyclerview)
        title = "Homestuck Trolls";
        val iolist = ArrayList<ImageObject>();
        iolist.add(ImageObject("Aradia", R.drawable.aradia))
        iolist.add(ImageObject("Tavros", R.drawable.tavros))
        iolist.add(ImageObject("Sollux", R.drawable.sollux))
        iolist.add(ImageObject("Karkat", R.drawable.karkat))
        iolist.add(ImageObject("Nepeta", R.drawable.nepeta))
        iolist.add(ImageObject("Kanaya", R.drawable.kanaya))
        iolist.add(ImageObject("Terezi", R.drawable.terezi))
        iolist.add(ImageObject("Vriska", R.drawable.vriska))
        iolist.add(ImageObject("Equius", R.drawable.equius))
        iolist.add(ImageObject("Gamzee", R.drawable.gamzee))
        iolist.add(ImageObject("Eridan", R.drawable.eridan))
        iolist.add(ImageObject("Feferi", R.drawable.feferi))


        // Creating an instance of our custom adapter and passing in context, along with a
        // collection of data elemeconts
        val adapter = ImageAdapter(this, iolist.toTypedArray())
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 3);
        adapter.onItemClick = { imageOb ->

            // do something with your item
        // Log.d("TAG", imageOb.description);
        }
        // Our OnItemSelectionListener works exactly the same as when we
        // work with a predefined adapter, except now we are retrieving ImageObjects
        // instead of Strings

    }

    // Test data for demonstration purposes
    // Using resource IDs for drawables along with text descriptions
}