package com.garsemar.webproject.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/student"])
class StudentController {

    @Autowired
    private val studentService = StudentService()

    @GetMapping
    fun getStudents(): List<Student> {
        return studentService.getStudents()
    }

    @PostMapping
    fun registerNewStudent(@RequestBody student: Student){
        studentService.addNewStudent(student)
    }
}