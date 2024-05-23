package dev.prateek.productservice;

import dev.prateek.productservice.inheritanceDemo.tablePerClass.MentorRepository;
import dev.prateek.productservice.inheritanceDemo.tablePerClass.UserRepository;
import dev.prateek.productservice.inheritanceDemo.tablePerClass.Mentor;
import dev.prateek.productservice.inheritanceDemo.tablePerClass.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication{
    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);
    }

}