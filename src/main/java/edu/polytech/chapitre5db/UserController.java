package edu.polytech.chapitre5db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping
    public  User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("L'utilisateur n'existe pas avec l'id : " + id));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {

        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("User non trouvé avec l'id : " + id));
        updateUser.setName(userDetails.getName());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setTel(userDetails.getTel());
        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Utilisateur non trouvé avec l'id : " + id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

