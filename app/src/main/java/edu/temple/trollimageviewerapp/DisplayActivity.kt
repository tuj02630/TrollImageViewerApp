package edu.temple.trollimageviewerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import edu.temple.customviewadapter.ImageObject
import edu.temple.trollimageviewerapp.IMAGE_URI_KEY
import edu.temple.trollimageviewerapp.TEXT_URI_KEY

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        title = "Displayer";
        var desc = intent.getStringExtra(TEXT_URI_KEY).toString()
        var image =  intent.getIntExtra(IMAGE_URI_KEY, -1);
        val io = ImageObject(desc, image)

        val iv = findViewById<ImageView>(R.id.trollimageplaceholder);
        val tv = findViewById<TextView>(R.id.description);
        iv.setImageResource(io.resourceId);
        tv.setText(io.description);
    }
}