package com.semyong.repository

import com.semyong.entities.MyResponse
import com.semyong.entities.News

interface GetMostPopularNewsRepository {
    suspend fun getNews(days: String): MyResponse<News>
}