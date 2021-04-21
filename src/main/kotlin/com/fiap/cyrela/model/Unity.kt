package com.fiap.cyrela.model

import com.fiap.cyrela.request.UnityRequest
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "unity")
data class Unity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    val createdAt : OffsetDateTime,

    @LastModifiedDate
    @Column(name = "updated_at", updatable = false, nullable = false,)
    val updateAt: OffsetDateTime,

    @Column(name = "number")
    val number: String? = null,

    @Column(name = "complement")
    val complement: String? = null,


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, referencedColumnName = "id")
    val user: User? = null,

    @ManyToOne
    @JoinColumn(name="block_id", nullable=false, referencedColumnName = "id")
    val block: Block? = null
) {
    companion object {
        fun toModel(unityRequest: UnityRequest, block: Block, user: User) = Unity(
                number = unityRequest.number,
                complement = unityRequest.complement,
                block = block,
                user = user,
                createdAt = OffsetDateTime.now(ZoneOffset.UTC),
                updateAt =  OffsetDateTime.now(ZoneOffset.UTC)
        )
    }
}