package com.maksapp.moviesearchapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.maksapp.moviesearchapp.databinding.RsForBdBinding
import com.maksapp.moviesearchapp.model.LocalRepositoryIml

class FragmentBD(): Fragment() {

    private val adapter = BdRvAdapter(LocalRepositoryIml(App.getHistoryDao()).getAllHistory()).also {
        it.notifyDataSetChanged()
    }
    private lateinit var binding: RsForBdBinding
//    private val viewModel: ViewModelFilm by lazy {
//        ViewModelProvider(this).get(ViewModelFilm::class.java)
//    }

    companion object {
        fun newInstance() = FragmentBD()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RsForBdBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            rsBd.layoutManager = GridLayoutManager(activity, 1)
            rsBd.adapter = adapter

        }
    }


}