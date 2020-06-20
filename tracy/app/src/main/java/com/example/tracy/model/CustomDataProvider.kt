package com.example.tracy.model

import com.google.android.gms.maps.model.LatLng

object CustomDataProvider {
    fun getData() = listOf(
        InfoWindowData(
            LatLng(59.932473, 30.349120),
            "+79108911350",
            "Перевезти 2 тонны щебня к полудню",
            "По договорённости",
            "2 тонны щебня"
        ),
        InfoWindowData(
            LatLng(59.982473, 30.349142),
            "+79108911350",
            "Переезжаю в другую квартиру, нужно помочь собрать вещи и доставить в другое место",
            "1000 рублей",
            "Перезд в квартиру"
        ),
        InfoWindowData(
            LatLng(59.932500, 30.400142),
            "+79108911350",
            "Все вопросы по телефону",
            "999999$",
            "Нелегальная деятельность"
        )
    )
}