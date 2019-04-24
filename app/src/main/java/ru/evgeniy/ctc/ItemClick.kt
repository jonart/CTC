package ru.evgeniy.ctc

import ru.evgeniy.ctc.models.Item

interface ItemClick {
    fun onItemClick(item: Item)
}