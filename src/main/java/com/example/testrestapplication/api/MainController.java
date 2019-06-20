package com.example.testrestapplication.api;

import com.example.testrestapplication.dao.UserRepository;
import com.example.testrestapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MainController {

    UserRepository repository;

    @Autowired
    MainController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("state")
    public Flux<String> alive() {
        return Flux.just("I'm alive");
    }
   @GetMapping("/user")
   public List<User> findAll() {
        return (List<User>) repository.findAll();
   }

    @GetMapping("/user/{id}")
    public User findOne(@PathVariable("id") String id) {
        return repository.findById(Long.decode(id));
    }
    @PostMapping("/user/")
    public void createUser(@RequestBody User user) {
        repository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

}
