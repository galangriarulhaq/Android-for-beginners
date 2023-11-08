package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvLanguage: RecyclerView
    private val list = ArrayList<ProgrammingLanguage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLanguage = findViewById(R.id.l_language)
        rvLanguage.setHasFixedSize(true)

        list.addAll(getListLanguages())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListLanguages(): ArrayList<ProgrammingLanguage> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listProgrammingLanguage = ArrayList<ProgrammingLanguage>()

        for (i in dataName.indices) {
            val language = ProgrammingLanguage(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listProgrammingLanguage.add(language)
        }
        return listProgrammingLanguage
    }

    private fun showRecyclerList() {
        rvLanguage.layoutManager = LinearLayoutManager(this)
        val listLanguage = ListProgrammingLanguage(list)
        rvLanguage.adapter = listLanguage
    }
}