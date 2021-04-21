package com.fiap.cyrela.request

import javax.persistence.Column

data class AdrressRequest (
        val state: String? = null,

        val number: String? = null,

        val city: String? = null,

        val complement: String? = null,

        val zipCode : String? = null,

        val street : String? = null,

        val neighborhood  : String? = null
)