package com.fiap.cyrela.model

import com.fiap.cyrela.request.ScheduleRequest
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    val createdAt : OffsetDateTime,

    @LastModifiedDate
    @Column(name = "updated_at", updatable = false, nullable = false,)
    val updateAt: OffsetDateTime,

    @Column(name = "type_activity")
    val typeActivity: String? = null,

    @Column(name = "subject")
    val subject: String? = null,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "unity_id", referencedColumnName = "id")
    val unity: Unity? = null,

    @Column(name = "actual_start", nullable = false,)
    val actualStart : Date? = null,

    @Column(name = "actual_end", nullable = false,)
    val actualEnd: Date? = null,
) {
    companion object {
        fun toModel(scheduleRequest: ScheduleRequest, unity: Unity) =
               Schedule (
                       typeActivity = scheduleRequest.typeActivity,
                       unity = unity,
                       actualStart = scheduleRequest.actualStart,
                       actualEnd = scheduleRequest.actualEnd,
                       subject = scheduleRequest.subject,
                       createdAt = OffsetDateTime.now(ZoneOffset.UTC),
                       updateAt =  OffsetDateTime.now(ZoneOffset.UTC)
               )
    }
}