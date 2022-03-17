package com.garsemar.webproject.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.Id

@Configuration
class StudentConfig {

    @Bean
    fun commandLinerRunner(repository: StudentRepository): CommandLineRunner {
        return CommandLineRunner {
            val maria = Student(
                1,
                "Marti",
                "Garcia",
                "martia.garcia@gmail.com",
                Student.Gender.MALE
            )
            val alex = Student(
                2,
                "Laura",
                "Serra",
                "laura.serra@gmail.com",
                Student.Gender.FEMALE
            )
            repository.saveAll(
                listOf(maria, alex)
            )
        }
    }
}