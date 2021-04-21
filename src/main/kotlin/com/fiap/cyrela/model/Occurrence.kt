package com.fiap.cyrela.model

import com.fiap.cyrela.request.OccurrenceRequest
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "Occurrence")
public final class Occurrence (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "ticket_number")
    val ticketNumber: String,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    val createdAt : OffsetDateTime,

    @LastModifiedDate
    @Column(name = "updated_at", updatable = false, nullable = false,)
    val updateAt: OffsetDateTime,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "unity_id", referencedColumnName = "id")
    val unity: Unity? = null
) {

    companion object {
        fun toModel(occurrenceRequest: OccurrenceRequest, unity: Unity) =
                Occurrence(
                        ticketNumber = occurrenceRequest.ticketNumber!!,
                        description = occurrenceRequest.description,
                        unity = unity,
                        createdAt = OffsetDateTime.now(ZoneOffset.UTC),
                        updateAt =  OffsetDateTime.now(ZoneOffset.UTC)
                )
    }
}