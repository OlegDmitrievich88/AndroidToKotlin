package com.maksapp.moviesearchapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.maksapp.moviesearchapp.R

class StartFragment: Fragment()  {



    companion object{
        fun newInstanceTwo() = StartFragment()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button? = view.findViewById(R.id.button_start)
        button?.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,FragmentForActivity.newInstance())
                .addToBackStack("")
                .commit()
        }

    }
}