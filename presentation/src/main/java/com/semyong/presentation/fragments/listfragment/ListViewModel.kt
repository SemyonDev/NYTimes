package com.semyong.presentation.fragments.listfragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semyong.common.EventManager
import com.semyong.entities.MyResponse
import com.semyong.entities.News
import com.semyong.usecases.GetMostPopularNewsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(
    private val getMostPopularNewsUseCase: GetMostPopularNewsUseCase,
    private val eventManager: EventManager
) : ViewModel() {

    val news: MutableLiveData<News> by lazy { MutableLiveData<News>() }
    val error: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            value = true
        }
    }

    companion object {
        private const val TAG = "ListViewModel"
    }


    init {
        viewModelScope.launch(Dispatchers.IO) {
            eventManager.throwableFlow.collect {
                it?.let {
                    Log.d(TAG, "eventManager = " + it)
                }
            }
        }
    }

    fun getNews(daysCount:String) {
        val mError: MutableLiveData<String> = MutableLiveData()
        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            // handle thrown exceptions from coroutine scope
            mError.postValue(throwable.stackTrace.toString())
            Log.e(TAG, "coroutineExceptionHandler = " + throwable.printStackTrace())
            throwable.printStackTrace()
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            when (val mostPopularNewsResponse =
//                getMostPopularNewsUseCase.getNews("1.json")) {
                getMostPopularNewsUseCase.getNews(daysCount)) {
                is MyResponse.Success -> withContext(Dispatchers.Main) {
                    news.postValue(mostPopularNewsResponse.data)
                    isLoading.value = false
                }
                is MyResponse.Error -> withContext(Dispatchers.Main) {
                    Log.e(TAG, "Error getting news", mostPopularNewsResponse.exception)
                    error.value = "Error getting news"
                    isLoading.value = false
                }
            }
        }
    }
}

