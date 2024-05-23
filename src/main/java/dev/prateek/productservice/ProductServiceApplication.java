package dev.prateek.productservice;

import dev.prateek.productservice.inheritanceDemo.tablePerClass.MentorRepository;
import dev.prateek.productservice.inheritanceDemo.tablePerClass.UserRepository;
import dev.prateek.productservice.inheritanceDemo.tablePerClass.Mentor;
import dev.prateek.productservice.inheritanceDemo.tablePerClass.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements  CommandLineRunner{
    private MentorRepository mentorRepository;
    private UserRepository userRepository;

    public ProductServiceApplication(MentorRepository mentorRepository,
                                     UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Naman");
        mentor.setEmail("Naman@scaler.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("Sarath");
        user.setEmail("sarathcool@yopmail.com");
        userRepository.save(user);
    }
}