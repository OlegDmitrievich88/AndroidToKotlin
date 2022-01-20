package com.maksapp.moviesearchapp.View

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maksapp.moviesearchapp.R
import com.maksapp.moviesearchapp.ViewModel.AppState
import com.maksapp.moviesearchapp.ViewModel.ViewModelFilm

import com.maksapp.moviesearchapp.databinding.RsFilmBinding
import com.maksapp.moviesearchapp.model.*

class FragmentForActivity: Fragment(), InterfaceForClick {

    private lateinit var binding: RsFilmBinding
   // private val adapter = FilmRvAdapter(this)
    private val viewModel: ViewModelFilm by lazy {
        ViewModelProvider(this).get(ViewModelFilm::class.java)
    }
    private val adapter = FilmRvAdapter(this)
    companion object {
        fun newInstance() = FragmentForActivity()
    }

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

//        binding.apply {
//            rsFilm.layoutManager = GridLayoutManager(activity,3)
//            rsFilm.adapter = adapter
//        }

       // requireActivity().startService(Intent(requireContext(),LoadService::class.java))

        viewModel.getData().observe(viewLifecycleOwner, Observer {
                state -> render(state)
        })// подписались на изменение данных
        viewModel.loadFromServer()

        //viewModel.getDescriptionFilm()//запросили данные
        binding.apply {
            rsFilm.layoutManager = GridLayoutManager(activity,3)
            rsFilm.adapter = adapter
        }
       // buildList()
        viewModel.getDescriptionFilm()
    }
    private fun render(state: AppState){
        when(state) {
            is AppState.Success ->{
               val listCinema: FactDescriptionDTO = state.cinema
                adapter.setCinema(listCinema)
            }
        }
    }



    override fun onItemClicked(cinema: FactDescriptionDTO) {
        val bundle = Bundle().apply { putParcelable("Description",cinema) }

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,FragmentDescriptionFilm.newInstance(bundle))
            .addToBackStack("")
            .commit()
    } // действие по клику
}