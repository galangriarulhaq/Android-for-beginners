package com.example.projectakhir

import android.app.Person
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_LANGUAGE = "key_language"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_img)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<ProgrammingLanguage>(KEY_LANGUAGE, ProgrammingLanguage::class.java)
        }else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_LANGUAGE)
        }

        if (data != null) {
            tvDetailName.text = data.name
            tvDetailDescription.text = data.description
            ivDetailPhoto.setImageResource(data.photo)
        }

    }
}