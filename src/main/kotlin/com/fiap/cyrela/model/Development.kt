package com.fiap.cyrela.model

import com.fiap.cyrela.request.DevelopmentRequest
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "development")
data class Development (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    val createdAt : OffsetDateTime,

    @LastModifiedDate
    @Column(name = "updated_at", updatable = false, nullable = false,)
    val updateAt: OffsetDateTime,

    @Column(name = "name")
    val name: String? = null,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: Address? = null,
) {
    companion object {
        fun toModel(developmentRequest: DevelopmentRequest, address: Address?) = Development(
                name = developmentRequest.name,
                address = address,
                createdAt = OffsetDateTime.now(ZoneOffset.UTC),
                updateAt =  OffsetDateTime.now(ZoneOffset.UTC)
        )
    }
}