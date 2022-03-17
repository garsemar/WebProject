package com.garsemar.webproject.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


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

    @DeleteMapping(path = ["{id}"])
    fun deleteStudent(@PathVariable("id") id: Float?) {
        studentService.deleteStudent(id!!)
    }
}