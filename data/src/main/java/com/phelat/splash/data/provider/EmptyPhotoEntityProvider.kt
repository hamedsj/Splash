package com.phelat.splash.data.provider

import com.phelat.splash.data.entity.PhotoEntity
import com.phelat.splash.data.provider.base.Provider

/**
 * Created by MAHDi on 6/27/18.
 * Contact me m4hdi.pdroid at gmail.com
 */

class EmptyPhotoEntityProvider : Provider<PhotoEntity> {

    override fun provide(): PhotoEntity {
        return PhotoEntity(null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null)
    }

}