package com.maksapp.moviesearchapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.maksapp.moviesearchapp.ViewModel.AppState
import com.maksapp.moviesearchapp.ViewModel.ViewModelFilm
import com.maksapp.moviesearchapp.databinding.ItemDescriptionFilmBinding
import com.maksapp.moviesearchapp.model.DescriptionFilm
import com.maksapp.moviesearchapp.model.getFilm
import kotlinx.android.synthetic.main.item_description_film.*

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

        val descriptionFilm = arguments?.getParcelable<DescriptionFilm>("Description")
        descriptionFilm?.let {
            image_film.setImageResource(descriptionFilm.film.imageFilm)
            name_film.text = descriptionFilm.film.titleFilm
            description_film.text = descriptionFilm.description
        }
//        viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
//        viewModel.getData().observe(viewLifecycleOwner, Observer {
//            state -> render(state)
//        })// подписались на изменение данных
//        viewModel.getDescriptionFilm()// запросили изменения

    }

//    private fun render(state: AppState) {
//        when(state) {
//            is AppState.Success ->{
//                //val listCinema: List<DescriptionFilm> = state.cinema
//                binding.loading.visibility = View.GONE
//                binding.textView.text = state.film.
//            }
//            is AppState.Error ->{
//                binding.loading.visibility = View.VISIBLE
//                Snackbar.make(binding.root,state.error.toString(),Snackbar.LENGTH_INDEFINITE)
//                    .setAction("попробй еще раз"){
//                        viewModel.getDescriptionFilm()
//                    }.show()
//            }
//            is AppState.Loading ->{
//                binding.loading.visibility = View.VISIBLE
//            }
//        }
//    }
}// фрагмент с описанием фильма