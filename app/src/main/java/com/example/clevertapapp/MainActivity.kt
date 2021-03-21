package com.example.clevertapapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clevertabsdk.LibCleverTap
import com.example.clevertap.R
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {

    private lateinit var rvImageView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var ivDisplay: ImageView
    private val drawables = ArrayList<Drawable>()
    private var images = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvImageView = findViewById(R.id.rvImages)
        ivDisplay = findViewById(R.id.ivDisplay)

        startCleverTapSDK()
    }

    private fun startCleverTapSDK() {
        val hostApplication: HostApplication = applicationContext as HostApplication
        val libCleverTap: LibCleverTap = hostApplication.libCleverTap
        try {
            val assetManager = assets
            images = assetManager.list("Drawables")?.toCollection(ArrayList())!!
            imageAdapter = ImageAdapter(images)
            rvImageView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            rvImageView.layoutManager = LinearLayoutManager(applicationContext)
            rvImageView.adapter = imageAdapter


            imageAdapter.onItemClickListener = {
                val inputStream: InputStream = assets.open("drawable/" + it)
                val drawable = Drawable.createFromStream(inputStream, null)
                ivDisplay.setImageBitmap(libCleverTap.drawableToBitmap(drawable))
                if (!ivDisplay.isVisible) {
                    ivDisplay.visibility = VISIBLE
                }
            }
        } catch (e: IOException) {

        }


    }
}