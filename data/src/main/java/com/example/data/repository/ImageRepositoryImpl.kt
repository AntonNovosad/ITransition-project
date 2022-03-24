package com.example.data.repository

import android.util.Log
import com.example.data.api.repository.ApiImageRepository
import com.example.domain.repository.ImageRepository
import com.example.entity.models.ImageEntity
import com.squareup.picasso.BuildConfig
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.await
import javax.inject.Inject
import kotlin.random.Random

class ImageRepositoryImpl(
    private var imageInterface: ApiImageRepository
) : ImageRepository {
//    private val random: Random = Random(1)

    override fun getImageData(): Flow<ImageEntity> = flow {
        delay(2000)

//        val list = imageInterface.getUsers().execute().body()
//        val url = list?.get(1)!!.download_url

//        Log.e("test", list.toString())
//        Log.e("url", url)

        val imageEntity = ImageEntity(
            image = "picture"
        )
        emit(imageEntity)
    }
}