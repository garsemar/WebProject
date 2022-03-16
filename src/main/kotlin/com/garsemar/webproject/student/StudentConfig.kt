package com.garsemar.webproject.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StudentConfig {

    @Bean
    fun commandLinerRunner(repository: StudentRepository): CommandLineRunner {
        return CommandLineRunner {
            val maria = Student(
                1,
                "Maria",
                "Garcia",
                "maria.garcia@gmail.com",
                Student.Gender.MALE
            )
            val alex = Student(
                2,
                "Alex",
                "Serra",
                "alex.serra@gmail.com",
                Student.Gender.MALE
            )
            repository.saveAll(
                listOf(maria, alex)
            )
        }
    }
}