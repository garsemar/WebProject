package com.garsemar.webproject.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService {

    @Autowired
    private val studentRepository: StudentRepository? = null

    fun getStudents(): List<Student> {
        return studentRepository!!.findAll()
    }

    fun addNewStudent(student: Student) {
        println(student)
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
