package com.phelat.splash.presentation.mapper

import com.google.gson.Gson
import com.phelat.splash.data.entity.PhotoEntity
import com.phelat.splash.data.mapper.Mapper
import com.phelat.splash.data.mapper.PhotoResponseToPhotoEntity
import com.phelat.splash.data.model.PhotoUrlsData
import com.phelat.splash.data.model.ProfileImageData
import com.phelat.splash.data.response.PhotosResponse
import com.phelat.splash.presentation.entity.ParcelPhotoEntity
import com.phelat.splash.presentation.model.ParcelPhotoUrlsData
import com.phelat.splash.presentation.model.ParcelProfileImageData
import com.phelat.splash.presentation.util.TestUtils
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PhotoEntityToParcelPhotoEntityMapperTest {

    private lateinit var photoUrlsDataMapper: Mapper<PhotoUrlsData?, ParcelPhotoUrlsData?>

    private lateinit var profileImageDataMapper: Mapper<ProfileImageData?, ParcelProfileImageData?>

    private lateinit var photoResponseToPhotoEntity: Mapper<PhotosResponse, PhotoEntity>

    private lateinit var mapper: Mapper<PhotoEntity, ParcelPhotoEntity>

    @Before
    fun setUp() {
        photoUrlsDataMapper = PhotoUrlsDataToParcelPhotoUrlsData()
        profileImageDataMapper = ProfileImageDataToParcelProfileImageData()
        photoResponseToPhotoEntity = PhotoResponseToPhotoEntity()
        mapper = PhotoEntityToParcelPhotoEntity(photoUrlsDataMapper, profileImageDataMapper)
    }

    @Test
    fun testIfPhotoEntityMapsToParcelPhotoEntity() {

        val photosResponse = Gson().fromJson(TestUtils.readResource("json/photos/photos_response.json",
                this.javaClass.classLoader),
                PhotosResponse::class.java)

        val photoEntity = photoResponseToPhotoEntity.mapFromTo(photosResponse)

        val parcelPhotoEntity = mapper.mapFromTo(photoEntity)

        MatcherAssert.assertThat(parcelPhotoEntity.id, IsEqual(photosResponse.id))
        MatcherAssert.assertThat(parcelPhotoEntity.createdAt, IsEqual(photosResponse.createdAt))
        MatcherAssert.assertThat(parcelPhotoEntity.updatedAt, IsEqual(photosResponse.updatedAt))
        MatcherAssert.assertThat(parcelPhotoEntity.width, IsEqual(photosResponse.width))
        MatcherAssert.assertThat(parcelPhotoEntity.height, IsEqual(photosResponse.height))
        MatcherAssert.assertThat(parcelPhotoEntity.color, IsEqual(photosResponse.color))
        MatcherAssert.assertThat(parcelPhotoEntity.likes, IsEqual(photosResponse.likes))
        MatcherAssert.assertThat(parcelPhotoEntity.description, IsEqual(photosResponse.description))
        MatcherAssert.assertThat(parcelPhotoEntity.userId, IsEqual(photosResponse.user?.id))
        MatcherAssert.assertThat(parcelPhotoEntity.usersName, IsEqual(photosResponse.user?.name))

    }

    @Test
    fun testIfParcelPhotoEntityMapsToPhotoEntity() {

        val photosResponse = Gson().fromJson(TestUtils.readResource("json/photos/photos_response.json",
                this.javaClass.classLoader),
                PhotosResponse::class.java)

        val photoEntity = photoResponseToPhotoEntity.mapFromTo(photosResponse)

        val parcelPhotoEntity = mapper.mapFromTo(photoEntity)

        val photoEntityAfterMap = mapper.mapToFrom(parcelPhotoEntity)

        MatcherAssert.assertThat(photoEntity.id, IsEqual(photoEntityAfterMap.id))
        MatcherAssert.assertThat(photoEntity.createdAt, IsEqual(photoEntityAfterMap.createdAt))
        MatcherAssert.assertThat(photoEntity.updatedAt, IsEqual(photoEntityAfterMap.updatedAt))
        MatcherAssert.assertThat(photoEntity.width, IsEqual(photoEntityAfterMap.width))
        MatcherAssert.assertThat(photoEntity.height, IsEqual(photoEntityAfterMap.height))
        MatcherAssert.assertThat(photoEntity.color, IsEqual(photoEntityAfterMap.color))
        MatcherAssert.assertThat(photoEntity.likes, IsEqual(photoEntityAfterMap.likes))
        MatcherAssert.assertThat(photoEntity.description, IsEqual(photoEntityAfterMap.description))
        MatcherAssert.assertThat(photoEntity.userId, IsEqual(photoEntityAfterMap.userId))
        MatcherAssert.assertThat(photoEntity.usersName, IsEqual(photoEntityAfterMap.usersName))

    }

}