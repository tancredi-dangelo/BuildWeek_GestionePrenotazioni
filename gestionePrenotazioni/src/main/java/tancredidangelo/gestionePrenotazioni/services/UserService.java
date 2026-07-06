package tancredidangelo.gestionePrenotazioni.services;

import org.springframework.stereotype.Service;
import tancredidangelo.gestionePrenotazioni.entities.User;
import tancredidangelo.gestionePrenotazioni.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // dependency injection
    private final UserRepository userRepository;

    // constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // --------- METHODS ------------------------------------------------------------

    public Optional<User> findUserById(Long userId) {
        return this.userRepository.findById(userId);
    }


    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }


    public void saveUser(User user) {
        this.userRepository.save(user);
        System.out.println("\nUser successfully saved in database.");
    }


    public void deleteUserById(Long id) {
        Optional<User> userFound = findUserById(id);
        if (userFound.isPresent()) {
            this.userRepository.delete(userFound.get());
            System.out.println("\nUser successfully deleted from database.");
        } else System.out.println("\nNo user with the provided ID was found in database.");
    }


    public void deleteAllUsers() {
        this.userRepository.deleteAll();
    }

    List<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    List<User> findByName(String name) {
        return userRepository.findUserByName(name);
    }

    List<User> findBySurname(String surname) {
        return userRepository.findUserBySurname(surname);
    }


}



