package io.security.learning.Controllers;

import io.security.learning.Models.User;
import io.security.learning.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo repo;

    @GetMapping("/user")
    public List<User> getUsers(){
        return repo.findAll();
    }

}
