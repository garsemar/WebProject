package com.garsemar.webproject.student

import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.*
import javax.persistence.*

@Entity
@Table
class Student(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    @param:JsonProperty("studentId") val id: Int,
    @field:NotNull @param:JsonProperty("firstName") val firstName: String,
    @field:NotNull @param:JsonProperty("lastName") val lastName: String,
    @field:NotNull @param:JsonProperty("email") val email: String,
    @field:NotNull @param:JsonProperty("gender") val gender: Gender
) {

    override fun toString(): String {
        return "Student{" +
                "studentId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}'
    }

    enum class Gender {
        MALE, FEMALE
    }
}