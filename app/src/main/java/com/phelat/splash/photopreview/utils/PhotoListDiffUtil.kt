package com.phelat.splash.photopreview.utils

import android.support.v7.util.DiffUtil
import com.phelat.splash.data.entity.PhotoEntity

class PhotoListDiffUtil(

        private val newItems: MutableList<PhotoEntity>,
        private val oldItems: MutableList<PhotoEntity>

) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

}