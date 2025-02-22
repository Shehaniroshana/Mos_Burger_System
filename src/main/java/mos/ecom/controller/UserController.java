package mos.ecom.controller;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.User;
import mos.ecom.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    final UserService service;

    @PostMapping("/save_user")
    public void saveUser(@RequestBody User user) {
     service.addUser(user);
    }

    @GetMapping("/authenticate_user/{name}/{password}")
    public boolean authenticateUser(@PathVariable String name,@PathVariable String password) {
       return service.isHere(name, password);
    }

}
