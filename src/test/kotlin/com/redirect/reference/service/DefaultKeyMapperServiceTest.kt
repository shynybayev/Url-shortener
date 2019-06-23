package com.redirect.reference.service

import org.junit.Assert.*
import org.junit.Test

class DefaultKeyMapperServiceTest {

    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "redirect"
    private val LINK: String = "http://www.oracle.com"
    private val LINK_NEW: String = "http://www.jetbrains.com"

    @Test
    fun clientCanAddNewKeyWithLink(){
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey(){
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    //пытается получить ссылку по ключу который в системе не зарегистрирован
    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService(){
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }
}