package com.maksapp.moviesearchapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maksapp.moviesearchapp.model.InterfaceForClick
import com.maksapp.moviesearchapp.R
import com.maksapp.moviesearchapp.ViewModel.AppState
import com.maksapp.moviesearchapp.ViewModel.ViewModelFilm

import com.maksapp.moviesearchapp.databinding.RsFilmBinding
import com.maksapp.moviesearchapp.model.DescriptionFilm
import com.maksapp.moviesearchapp.model.Film

class FragmentForActivity: Fragment(), InterfaceForClick {

    private lateinit var binding: RsFilmBinding
    private val adapter = FilmRvAdapter(this)
    private lateinit var viewModel: ViewModelFilm
    private val imageIdList = listOf(
        R.drawable.sun, R.drawable.ebrg, R.drawable.msc, R.drawable.nsk,
        R.drawable.sam, R.drawable.spb
    )

    private val listFilm = ArrayList<Film>()

    companion object {
        fun newInstance() = FragmentForActivity()
    }

    //private lateinit var binding: RsFilmBinding
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
        binding.apply {
            rsFilm.layoutManager = GridLayoutManager(activity,3)
            rsFilm.adapter = adapter

        }
        viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer {
                state -> render(state)
        })// подписались на изменение данных
        viewModel.getDescriptionFilm()//запросили данные
       // buildList()

    }
    private fun render(state: AppState){
        when(state) {
            is AppState.Success ->{
               val listCinema: List<DescriptionFilm> = state.cinema
                adapter.setCinema(listCinema)
            }


        }
    }

//    private fun buildList() {
//        for (i in 0..5){
//            val nameFilm = "NAME FILM$i"
//            val imageFilm = imageIdList[i]
//            listFilm.add(Film(imageFilm,nameFilm))
//        }
//    } // заполняем массив

    override fun onItemClicked(cinema: DescriptionFilm) {
        val bundle = Bundle()
        bundle.putParcelable("Description",cinema)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,FragmentDescriptionFilm.newInstance(bundle))
            .addToBackStack("")
            .commit()
//        val descriptionFilm: FragmentManager = requireActivity().supportFragmentManager
//        val fragmentTransaction: FragmentTransaction = descriptionFilm.beginTransaction()
//        fragmentTransaction.replace(R.id.fragment_container, FragmentDescriptionFilm())
//        descriptionFilm.popBackStack()
       // fragmentTransaction.addToBackStack(null)
       // fragmentTransaction.commitNow()
    } // действие по клику
}