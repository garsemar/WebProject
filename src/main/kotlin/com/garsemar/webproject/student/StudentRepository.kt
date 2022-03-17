package com.garsemar.webproject.student

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository: JpaRepository<Student, Int>{
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    fun findUserByEmail(email: String): Optional<Student>
}