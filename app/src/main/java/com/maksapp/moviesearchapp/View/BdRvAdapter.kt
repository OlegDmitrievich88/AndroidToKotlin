package com.maksapp.moviesearchapp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maksapp.moviesearchapp.R
import com.maksapp.moviesearchapp.databinding.ItemForRvBdBinding
import com.maksapp.moviesearchapp.model.HistoryFilm

class BdRvAdapter(private var items: List<HistoryFilm>) : RecyclerView.Adapter<BdRvAdapter.BdViewHolder>() {

    //private var items: List<HistoryFilm> = listOf()

    class BdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemForRvBdBinding.bind(itemView)
        fun onBind(items: HistoryFilm) = with(binding){
            one.text = items.nameFilm
            two.text = items.lang
            free.text = items.content
            fore.text = items.rating.toString()

    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BdViewHolder {
        return BdViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_rv_bd,parent,false))
    }

    override fun onBindViewHolder(holder: BdViewHolder, position: Int) {
   holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size

}


