package com.maksapp.moviesearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager

import com.maksapp.moviesearchapp.databinding.RsFilmBinding

class FragmentForActivity: Fragment() {


    private val imageIdList = listOf(
        R.drawable.sun,R.drawable.ebrg,R.drawable.msc,R.drawable.nsk,
        R.drawable.sam,R.drawable.spb
    )

    private val listFilm = ArrayList<Film>()

    companion object {
        fun newInstance() = FragmentForActivity()
    }

    lateinit var binding: RsFilmBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RsFilmBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildList()
        val adapter = FilmRvAdapter(listFilm)
        binding.apply {
            rsFilm.layoutManager = GridLayoutManager(activity,3)
            rsFilm.adapter = adapter


        }
    }

    private fun buildList() {
        for (i in 1..6){
            val nameFilm = "NAME FILM$i"
            val imageFilm = imageIdList[i]
            listFilm.add(Film(imageFilm,nameFilm))
        }
    }
}