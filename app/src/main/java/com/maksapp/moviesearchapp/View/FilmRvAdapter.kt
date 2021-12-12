package com.maksapp.moviesearchapp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maksapp.moviesearchapp.model.InterfaceForClick
import com.maksapp.moviesearchapp.R
import com.maksapp.moviesearchapp.databinding.ItemForRsFilmBinding
import com.maksapp.moviesearchapp.model.Film

class FilmRvAdapter(

    private val listFilm: ArrayList<Film>,
    private val itemClick: InterfaceForClick
) : RecyclerView.Adapter<FilmRvAdapter.FilmViewHolder>(){

   // val filmList = ArrayList<Film>()

    class FilmViewHolder(itemView: View, private val itemClick: InterfaceForClick) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemForRsFilmBinding.bind(itemView) // получили доступ к вьюхам

        fun bind(film: Film, position: Int) = with(binding){
            imageFilm.setImageResource(film.imageFilm)
            textFilm.text = film.titleFilm
            itemView.setOnClickListener {
                itemClick?.onItemClicked(adapterPosition)
            }

        }
    } //создали класс вьюхолдер, тут создаем разметку

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.item_for_rs_film,parent,false)
        return FilmViewHolder(itemView,itemClick)
    }//тут нудуваем вьюху, создаем новый элемент

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
       holder.bind(listFilm[position],position)
    }// тут заполняем вьюху

    override fun getItemCount(): Int {
       return listFilm.size
    }//тут узнаем размер списка
} // создали адаптер для ресайкл вью