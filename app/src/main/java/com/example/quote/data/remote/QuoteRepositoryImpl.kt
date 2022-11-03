package com.example.quote.data.remote

import com.example.quote.data.local.QuoteLocalDataSource
import com.example.quote.domain.QuoteRepository
import com.example.quote.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepositoryImpl @Inject constructor
    (private val localDataSource: QuoteLocalDataSource):
    QuoteRepository {

    override suspend fun getQuoteRandom(): Flow<QuoteModel> {
        return localDataSource.getQuoteRandom()
    }

    override suspend fun getQuote(quoteId: Int): Flow<QuoteModel> {
        return localDataSource.getQuote(quoteId)
    }
    override suspend fun getAllQuote(): Flow<List<QuoteModel>> {
        return localDataSource.getQuotes()
    }
    override suspend fun addQuote(quoteModel: QuoteModel) {
        return localDataSource.insert(quoteModel)
    }
}