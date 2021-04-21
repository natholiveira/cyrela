package com.fiap.cyrela.service.impl

import com.fiap.cyrela.model.Address
import com.fiap.cyrela.repository.AddressRepository
import com.fiap.cyrela.request.AdrressRequest
import com.fiap.cyrela.service.AddressService
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(
        private val addressRepository: AddressRepository
) : AddressService {
    override fun createAddress(addressRequest: AdrressRequest): Address =
        addressRepository.save(Address.toModel(addressRequest))
}