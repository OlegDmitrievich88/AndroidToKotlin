package com.maksapp.moviesearchapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.maksapp.moviesearchapp.View.FragmentForActivity.Companion.newInstance
import com.maksapp.moviesearchapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.history->{
               supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,FragmentBD.newInstance())
                    .addToBackStack("")
                    .commit()}
            R.id.contact->{}
        }
        return true
    }

}