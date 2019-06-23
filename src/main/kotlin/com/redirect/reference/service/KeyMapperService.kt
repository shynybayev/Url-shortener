package com.redirect.reference.service

interface KeyMapperService{
    //интерфейсы хранят в себе все возможные дата классы, у которыъ должны реализовать методы
    interface Add {
        data class Success(val key: String, val link: String): Add
        data class AlreadyExist(val key: String): Add
    }

    //ответ для метода гет
    interface Get {
        data class Link(val link: String): Get
        data class NotFound(val key: String): Get
    }

    fun add(key: String, link: String): Add //возвращает интерфейс Add
    fun getLink(key: String): Get
}