package com.fiap.cyrela.request

data class DevelopmentRequest (
        val name: String? = null,
        val addressId: Long? = null,
        val block: BlockRequest
)

data class BlockRequest(
        val name: String? = null,
        val unity: UnityRequest
)

data class UnityRequest(
        val number: String? = null,
        val complement: String? = null,
        val userId: Long? = null
)