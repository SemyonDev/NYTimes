package com.semyong.usecasesimpl

import com.semyong.entities.MyResponse
import com.semyong.entities.News
import com.semyong.repository.GetMostPopularNewsRepository
import com.semyong.usecases.GetMostPopularNewsUseCase

class GetMostPopularNewsUseCaseImpl(private val getMostPopularNewsRepository: GetMostPopularNewsRepository): GetMostPopularNewsUseCase {
    override suspend fun getNews(days: String): MyResponse<News>  = getMostPopularNewsRepository.getNews(days)
}

