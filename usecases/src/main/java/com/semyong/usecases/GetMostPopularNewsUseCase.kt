package com.semyong.usecases

import com.semyong.entities.MyResponse
import com.semyong.entities.News

interface GetMostPopularNewsUseCase {
    suspend fun getNews(days: String): MyResponse<News>
}