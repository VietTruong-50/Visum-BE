package com.mongoDb.main;

import com.mongoDb.entities.Album;
import com.mongoDb.entities.Music;
import com.mongoDb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
//        return args -> {
//            Album address = new Album(
//                    "Viet Nam",
//                    "Da Nang",
//                    "10000"
//            );

            String email = "truongquocviet2001@gmail.com";


//            repository.findStudentByEmail(email)
//                    .ifPresentOrElse(s -> {
//                        System.out.println(student.getFirstName() + " is already exist");
//                    }, () -> {
//                        System.out.println("Add student successfully");
//                        repository.insert(student);
//                    });

//            usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
//        };
//    }

    private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Music student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<Music> students = mongoTemplate.find(query, Music.class);

        if (students.size() > 1) {
            throw new IllegalStateException("found many students with this email" + email);
        }

        if (students.isEmpty()) {
            System.out.println("Add student successfully");
            repository.insert(student);
        }else{
//            System.out.println(student.getFirstName() + " is already exist");
        }
    }
}
