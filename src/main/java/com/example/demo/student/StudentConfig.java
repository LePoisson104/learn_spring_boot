//package com.example.demo.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository){
//        return args -> {
//            Student Mariam = new Student(
//                    "Mariam",
//                    "mariam.jamal@gmail.com",
//                    LocalDate.of(2000, Month.JANUARY, 5)
//            );
//            Student David = new Student(
//                    "David",
//                    "david.jamal@gmail.com",
//                    LocalDate.of(2000, Month.APRIL, 10)
//            );
//            repository.saveAll(List.of(Mariam, David));
//        };
//    }
//}
