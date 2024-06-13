package com.example.metabook.helper

import com.example.metabook.data.ItemsItem


interface OnItemClickCallback {
    fun onItemClicked(data: ItemsItem)
}