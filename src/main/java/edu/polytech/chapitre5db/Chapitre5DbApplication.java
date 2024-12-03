package edu.polytech.chapitre5db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringBootApplication
public class Chapitre5DbApplication {

    private final UserRepository userRepository;

    public Chapitre5DbApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapitre5DbApplication.class, args);
    }


    public void run(String... args) throws Exception {

        User user = new User();
        user.setName("samar");
        user.setEmail("samar@gmail.com");
        user.setTel(26043567);
        userRepository.save(user);

        List<User> users = userRepository.findAllByEmail("Samar");
        System.out.println("Utilisateurs trouvés : " + users.size());
        users.forEach(user1 -> System.out.println(user.getName()));
    }

}
