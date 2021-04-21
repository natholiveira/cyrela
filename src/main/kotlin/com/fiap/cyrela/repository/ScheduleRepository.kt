package com.fiap.cyrela.repository

import com.fiap.cyrela.model.Occurrence
import com.fiap.cyrela.model.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
interface ScheduleRepository : JpaRepository<Schedule, Long> {
@Query("SELECT s FROM Schedule s\n" +
            " WHERE s.id IS NOT NULL\n" +
            " AND (:typeActivity IS NULL OR (s.typeActivity =:typeActivity))\n" +
            " AND (:unityId IS NULL OR (s.unity.id = :unityId))\n")
    fun findAllWithFilter(
        @Param("typeActivity") typeActivity: String? = null,
        @Param("unityId") unityId: Long? = null): List<Schedule>
}