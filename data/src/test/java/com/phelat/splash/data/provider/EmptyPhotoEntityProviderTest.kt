package com.phelat.splash.data.provider

import com.phelat.splash.data.entity.PhotoEntity
import com.phelat.splash.data.provider.base.Provider
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EmptyPhotoEntityProviderTest {

    private lateinit var provider: Provider<PhotoEntity>

    @Before
    fun setUp() {
        provider = EmptyPhotoEntityProvider()
    }

    @Test
    fun `test if provider returns PhotoEntity`() {

        val providedData = provider.provide()

        assertThat(providedData, notNullValue())
    }

    @Test
    fun `test if provider returns empty PhotoEntity`() {

        val providedData = provider.provide()

        assertThat(providedData.photoUrls, nullValue())
        assertThat(providedData.id, nullValue())
        assertThat(providedData.usersName, nullValue())
        assertThat(providedData.userId, nullValue())
        assertThat(providedData.description, nullValue())
        assertThat(providedData.likes, nullValue())
        assertThat(providedData.width, nullValue())
        assertThat(providedData.updatedAt, nullValue())
        assertThat(providedData.color, nullValue())
        assertThat(providedData.createdAt, nullValue())
        assertThat(providedData.height, nullValue())
        assertThat(providedData.userProfileImage, nullValue())
    }

}