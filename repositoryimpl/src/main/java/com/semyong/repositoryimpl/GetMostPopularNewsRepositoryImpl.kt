package com.semyong.repositoryimpl

import com.semyong.data.api.ApiServices
import com.semyong.entities.MyResponse
import com.semyong.entities.News
import com.semyong.repository.GetMostPopularNewsRepository
import com.semyong.repositoryimpl.helpers.makeApiCall

class GetMostPopularNewsRepositoryImpl(private val apiServices: ApiServices) :
    GetMostPopularNewsRepository {
    override suspend fun getNews(days: String): MyResponse<News> = makeApiCall(
        call = { apiServices.getNews(days) }
    )

}