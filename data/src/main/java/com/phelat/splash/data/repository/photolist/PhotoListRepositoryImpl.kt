package com.phelat.splash.data.repository.photolist

import com.phelat.splash.data.datasource.DataSource
import com.phelat.splash.data.entity.PhotoEntity
import com.phelat.splash.data.mapper.Mapper
import com.phelat.splash.data.request.GetPhotoRequest
import com.phelat.splash.data.response.PhotosResponse
import io.reactivex.Single
import javax.inject.Inject

class PhotoListRepositoryImpl @Inject constructor(

        private val remoteDataSource: DataSource.SingleReadable<GetPhotoRequest, List<PhotosResponse>>,
        private val photoResponseToPhotoEntity: Mapper<PhotosResponse, PhotoEntity>

) : PhotoListRepository {

    override fun getListOfPhotos(request: GetPhotoRequest?): Single<MutableList<PhotoEntity>> {
        return remoteDataSource.read(request)
                .toObservable()
                .flatMapIterable { it }
                .map { photosResponse ->
                    photoResponseToPhotoEntity.mapFromTo(photosResponse)
                }
                .toList()
    }

}