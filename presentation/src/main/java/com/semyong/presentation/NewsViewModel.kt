package com.semyong.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.semyong.common.EventManager
import com.semyong.entities.MyResponse
import com.semyong.entities.News
import com.semyong.usecases.GetMostPopularNewsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "NewsViewModel"

class NewsViewModel(
    private val getMostPopularNewsUseCase: GetMostPopularNewsUseCase,
    private val eventManager: EventManager
) : ViewModel() {

    val error: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            value = true
        }
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

    fun getNews(result: (MutableLiveData<News>) -> Unit) {
        val mError: MutableLiveData<String> = MutableLiveData()
        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            // handle thrown exceptions from coroutine scope
            mError.postValue(throwable.stackTrace.toString())
            Log.e(TAG, "coroutineExceptionHandler = " + throwable.printStackTrace())
            throwable.printStackTrace()
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            when (val mostPopularNewsResponse =
                getMostPopularNewsUseCase.getNews("1.json")) {
                is MyResponse.Success -> withContext(Dispatchers.Main) {
                    result.invoke(MutableLiveData<News>(mostPopularNewsResponse.data))
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

