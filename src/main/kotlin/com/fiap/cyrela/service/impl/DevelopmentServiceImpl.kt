package com.fiap.cyrela.service.impl

import com.fiap.cyrela.model.Block
import com.fiap.cyrela.model.Development
import com.fiap.cyrela.model.Unity
import com.fiap.cyrela.repository.*
import com.fiap.cyrela.request.DevelopmentRequest
import com.fiap.cyrela.service.DevelopmentService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DevelopmentServiceImpl(
        private val userRepository: UserRepository,
        private val unityRepository: UnityRepository,
        private val developmentRepository: DevelopmentRepository,
        private val blockRepository: BlockRepository,
        private val addressRepository: AddressRepository
) : DevelopmentService{
    override fun createDevelopment(developmentRequest: DevelopmentRequest): Development? =
        userRepository.findByIdOrNull(developmentRequest.block.unity.userId)?.let {  user ->
            addressRepository.findByIdOrNull(developmentRequest.addressId)?.let { address ->
                val development = developmentRepository.save(Development.toModel(developmentRequest, address))
                val block = blockRepository.save(Block.toModel(developmentRequest.block, development))
                val unity = unityRepository.save(Unity.toModel(developmentRequest.block.unity, block, user))

                return development
            }
        }
}