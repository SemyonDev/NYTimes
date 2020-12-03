package com.semyong.presentation.fragments.listfragment.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.semyong.entities.Result
import com.semyong.presentation.R
import com.semyong.presentation.fragments.listfragment.ListAction
import com.semyong.presentation.helpers.inflate
import kotlinx.android.synthetic.main.item_news.view.*
import java.util.*

class NewsListAdapter(var results: ArrayList<Result>, val actions: ListAction) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    fun updateResults(newResults: List<Result>) {
        results.clear()
        results.addAll(newResults)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(
        parent inflate R.layout.item_news
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(results[position])
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var title:TextView
        private var description:TextView

        init {
            title = itemView.item_news_title_txt
            description = itemView.item_news_title_desc
            itemView.setOnClickListener {
                actions.onItemClick(results[adapterPosition])
            }
        }

        fun bind(result: Result) {
            title.text = result.title
            description.text = result.abstract
        }
    }
}

