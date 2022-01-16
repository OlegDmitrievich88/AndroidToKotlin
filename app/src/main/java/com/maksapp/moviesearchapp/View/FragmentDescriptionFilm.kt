package com.maksapp.moviesearchapp.View

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.maksapp.moviesearchapp.databinding.ItemDescriptionFilmBinding
import com.maksapp.moviesearchapp.model.DescriptionDTO
import com.maksapp.moviesearchapp.model.FactDescriptionDTO
import com.maksapp.moviesearchapp.model.LoadService


class FragmentDescriptionFilm() : Fragment() {

    private lateinit var binding: ItemDescriptionFilmBinding
   // private lateinit var viewModel: ViewModelFilm


    companion object {
        fun newInstance(bundle: Bundle): FragmentDescriptionFilm{
            val fragment = FragmentDescriptionFilm()
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemDescriptionFilmBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val descriptionFilm = arguments?.getParcelable<FactDescriptionDTO>("Description")
        val urlPoster = "https://image.tmdb.org/t/p/w500"+(descriptionFilm?.poster_path ?: 0)
        with(binding){
            descriptionFilm?.let {
                nameFilm.text = descriptionFilm.title
                descriptionsFilm.text = descriptionFilm.overview
                imageFilm.load(urlPoster)
            }
        }

    }


}// фрагмент с описанием фильма