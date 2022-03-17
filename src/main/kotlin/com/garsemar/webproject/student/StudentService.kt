package com.garsemar.webproject.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService {

    @Autowired
    private val studentRepository: StudentRepository? = null

    fun getStudents(): List<Student> {
        return studentRepository!!.findAll()
    }

    fun addNewStudent(student: Student) {
        val studentOptional: Optional<Student>? = studentRepository?.findUserByEmail(student.email)
        if (studentOptional != null) {
            if (studentOptional.isPresent) {
                throw IllegalStateException("Email ${student.email} taken")
            }
        }
        studentRepository?.save(student)
    }

    fun deleteStudent(id: Float) {
        if (!studentRepository!!.existsById(id.toInt())) {
            throw IllegalStateException(
                "Student with id $id does not exists"
            )
        }
        studentRepository.deleteById(id.toInt())
    }
}








/*
class StudentService {

    private val studentRepository: StudentRepository? = null

    fun getAllStudents(): List<Student> {
        return studentRepository!!.findAll()
    }

    fun addStudent(student: Student) {
        val existsEmail: Boolean = studentRepository
            .selectExistsEmail(student.email)
        if (existsEmail) {
            throw BadRequestException(
                "Email " + student.email + " taken"
            )
        }
        studentRepository!!.save(student)
    }

    fun deleteStudent(studentId: Long) {
        if (!studentRepository!!.existsById(studentId.toInt())) {
            throw StudentNotFoundException(
                "Student with id $studentId does not exists"
            )
        }
        studentRepository.deleteById(studentId.toInt())
    }
}*/
