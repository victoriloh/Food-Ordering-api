package com.restapi.foodapi.rest;

import com.restapi.foodapi.entity.Order;
import com.restapi.foodapi.entity.Users;
import com.restapi.foodapi.service.UsersService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UsersService usersService;

    public UserRestController(UsersService usersService) {
        this.usersService = usersService;
    }

//    @PostMapping("/user/create")
//    public ResponseEntity<Object> createUser(@RequestBody Users user) {
//        return usersService.save(user);
//    }
//    @GetMapping("/user/details/{id}")
//    public Users getUser(@PathVariable Long id) {
//        if(usersRepository.findById(id).isPresent())
//        return userRepository.findById(id).get();
//    else return  null;
//
//    }
//    @GetMapping("/user/all")
//    public List<Users> getUsers() {
//        return usersRepository.findAll();
//    }
//    @PutMapping("/user/update/{id}")
//    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody Users user) {
//        return usersService.updateUser(user, id);
//    }
//
//    @DeleteMapping("user/delete/{id}")
//    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
//        return usersService.deleteUser(id);
//    }

    @GetMapping("/order")
    public List<Users> getOrder() {
        return usersService.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<Users> getUsersById(@PathVariable Long userId) {
        Optional<Users> order = usersService.findById(userId);
        if (order == null){
            throw new RuntimeException("Order id not found -" +userId);
        }
        return order;
    }

    @PostMapping("/users")
    public Users saveId(@RequestBody Users users){
        users.setId((long) 0);
        usersService.save(users);
        return users;
    }
    @PutMapping("/users")
    public Users updateEmployee(@RequestBody Users users){
        usersService.save(users);
        return users;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteId(@PathVariable Long userId){
        Optional<Users> users = usersService.findById(userId);
        if (users == null){
            throw new RuntimeException("User id not found -" +userId);
        }
        usersService.deleteById(userId);
        return "Deleted User id - " + userId;
    }
}
