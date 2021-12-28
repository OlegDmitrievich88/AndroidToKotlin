package com.maksapp.moviesearchapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

}