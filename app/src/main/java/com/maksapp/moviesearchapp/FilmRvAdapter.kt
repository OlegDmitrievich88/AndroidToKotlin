package com.maksapp.moviesearchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maksapp.moviesearchapp.databinding.ItemForRsFilmBinding

class FilmRvAdapter(private val listFilm: ArrayList<Film>) : RecyclerView.Adapter<FilmRvAdapter.FilmViewHolder>(){

   // val filmList = ArrayList<Film>()

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemForRsFilmBinding.bind(itemView) // получили доступ к вьюхам

        fun bind(film: Film) = with(binding){
            imageFilm.setImageResource(film.imageFilm)
            textFilm.text = film.titleFilm

        }
    } //создали класс вьюхолдер, тут создаем разметку

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.item_for_rs_film,parent,false)
        return FilmViewHolder(itemView)
    }//тут нудуваем вьюху, создаем новый элемент

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
       holder.bind(listFilm[position])
    }// тут заполняем вьюху

    override fun getItemCount(): Int {
       return listFilm.size
    }//тут узнаем размер списка
} // создали адаптер для ресайкл вью