package com.maksapp.moviesearchapp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maksapp.moviesearchapp.model.InterfaceForClick
import com.maksapp.moviesearchapp.R
import com.maksapp.moviesearchapp.databinding.ItemForRsFilmBinding
import com.maksapp.moviesearchapp.model.DescriptionDTO

class FilmRvAdapter(
    private val itemClick: InterfaceForClick

) : RecyclerView.Adapter<FilmRvAdapter.FilmViewHolder>(){

   // private var cinemaList: List<DescriptionFilm> = listOf() // список фильмов с описанием
    private var cinemaListFromServer: List<DescriptionDTO> = listOf()
//    fun setCinema(data: List<DescriptionFilm>) {
//       cinemaList = data
//       notifyDataSetChanged()
//   }
    fun setCinema(data: List<DescriptionDTO>) {
        cinemaListFromServer = data
        notifyDataSetChanged()
    }

    class FilmViewHolder(itemView: View, private val itemClick: InterfaceForClick) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemForRsFilmBinding.bind(itemView) // получили доступ к вьюхам

        fun bind(film: DescriptionDTO) = with(binding){
           // imageFilm.setImageResource(film.film.imageFilm) //сетим постер фильма
            textFilm.text = film.descDTO.title // название фильма
            itemView.setOnClickListener {
                itemClick.onItemClicked(film)
            }//обработали клик
        }
    } //создали класс вьюхолдер, тут создаем разметку

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.item_for_rs_film,parent,false)
        return FilmViewHolder(itemView,itemClick)
    }//тут нудуваем вьюху, создаем новый элемент

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        //holder.bind(cinemaList[position])//передали позицию
        holder.bind(cinemaListFromServer[position])
           }// тут заполняем вьюху

    override fun getItemCount(): Int {
        return cinemaListFromServer.size
       //return cinemaList.size
    }//тут узнаем размер списка
} // создали адаптер для ресайкл вью