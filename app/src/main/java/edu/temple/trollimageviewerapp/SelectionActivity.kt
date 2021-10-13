package edu.temple.trollimageviewerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.customviewadapter.ImageAdapter
import edu.temple.customviewadapter.ImageObject


const val IMAGE_URI_KEY = "IMAGE_URI"
const val TEXT_URI_KEY = "TEXT_URI"

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById<RecyclerView>(R.id.recyclerview)
        title = this.resources.getString(R.string.option_text);
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
        iolist.add(ImageObject(myArray[t++], R.drawable.gamzee))
        iolist.add(ImageObject(myArray[t++], R.drawable.eridan))
        iolist.add(ImageObject(myArray[t++], R.drawable.feferi))


        // Creating an instance of our custom adapter and passing in context, along with a
        // collection of data elements
        val adapter = ImageAdapter(this, iolist.toTypedArray())
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 3);
        adapter.onItemClick = { imageOb ->

            val dispIntent = Intent(this, DisplayActivity::class.java).apply {
                putExtra(IMAGE_URI_KEY,imageOb.resourceId);
                putExtra(TEXT_URI_KEY,imageOb.description);
            }
            startActivity(dispIntent)

            // do something with your item
            Log.d("TAG", imageOb.description);
        }
    }
}