package com.semyong.presentation.fragments.listfragment

import android.os.Bundle
import android.view.*
import android.view.View.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.semyong.entities.Result
import com.semyong.presentation.R
import com.semyong.presentation.fragments.listfragment.adapters.NewsListAdapter
import com.semyong.presentation.helpers.Day
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.loading.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(), ListAction {

    private val viewModel: ListViewModel by viewModel()
    private val newsListAdapter = NewsListAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewMOodel()
        viewModel.getNews(Day.ONE.days)
        fragment_list_news_rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsListAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_fragment_list_day_1 -> {
                loading.visibility = VISIBLE
                viewModel.getNews(Day.ONE.days)
            }
            R.id.menu_fragment_list_day_7 -> {
                loading.visibility = VISIBLE
                viewModel.getNews(Day.SEVEN.days)
            }
            R.id.menu_fragment_list_day_30 -> {
                loading.visibility = VISIBLE
                viewModel.getNews(Day.THIRTY.days)
            }
        }
        return true
    }

    private fun initViews() {
        loading.visibility = VISIBLE
        fragment_list_news_rv.visibility = INVISIBLE
    }

    fun observeViewMOodel() {
        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            loading.visibility = GONE
            fragment_list_news_rv.visibility = VISIBLE
            news.results?.let {
                newsListAdapter.updateResults(it)
            }
            if (news.results == null) {
                showEmptyResult()
            }
        })
    }

    private fun goToDetailFragment(
        result: Result
    ) {
        val action = ListFragmentDirections.actionGotToDetailsFragment(result)
        Navigation.findNavController(fragment_list_news_rv).navigate(action)
    }


    override fun onItemClick(resultItem: Result) {
        goToDetailFragment(resultItem)
    }

    fun showEmptyResult() {

    }
}



