package com.fiap.cyrela.model

import com.fiap.cyrela.request.BlockRequest
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
@Table(name = "block")
data class Block (
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    val createdAt : OffsetDateTime,

    @LastModifiedDate
    @Column(name = "updated_at", updatable = false, nullable = false,)
    val updateAt: OffsetDateTime,

    @ManyToOne
    @JoinColumn(name="development_id", nullable=false, referencedColumnName = "id")
    val development: Development? = null,
) {
    companion object {
        fun toModel(blockRequest: BlockRequest, development: Development) = Block(
                name = blockRequest.name,
                development = development,
                createdAt = OffsetDateTime.now(ZoneOffset.UTC),
                updateAt =  OffsetDateTime.now(ZoneOffset.UTC)
        )
    }
}