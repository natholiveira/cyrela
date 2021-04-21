package com.fiap.cyrela.service

import com.fiap.cyrela.model.Address
import com.fiap.cyrela.request.AdrressRequest

interface AddressService {
    fun createAddress(addressRequest: AdrressRequest): Address
}