package com.maksapp.moviesearchapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.maksapp.moviesearchapp.R
import com.maksapp.moviesearchapp.ViewModel.AppState
import com.maksapp.moviesearchapp.ViewModel.ViewModelFilm
import com.maksapp.moviesearchapp.databinding.ItemDescriptionFilmBinding
import com.maksapp.moviesearchapp.model.DescriptionFilm

class FragmentDescriptionFilm() : Fragment() {

    private lateinit var binding: ItemDescriptionFilmBinding
    private lateinit var viewModel: ViewModelFilm

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemDescriptionFilmBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            state -> render(state)
        })// подписались на изменение данных
        viewModel.getDescriptionFilm()// запросили изменения

    }

    private fun render(state: AppState) {
        when(state) {
            is AppState.Success ->{
                binding.loading.visibility = View.GONE
                val desc = state.descriptionFilm
                binding.textView.text = desc.description
            }
            is AppState.Error ->{
                binding.loading.visibility = View.VISIBLE
                Snackbar.make(binding.root,state.error.toString(),Snackbar.LENGTH_INDEFINITE)
                    .setAction("попробй еще раз"){
                        viewModel.getDescriptionFilm()
                    }.show()
            }
            is AppState.Loading ->{
                binding.loading.visibility = View.VISIBLE
            }
        }
    }
}// фрагмент с описанием фильма