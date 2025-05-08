package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.Entities.User;
import com.example.sample.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService service;
	
    @GetMapping("/check")
    public String check() {
    	return "working";
}
    @GetMapping("/users/{user_id}")
    public User getDetail(@PathVariable("user_id") int id) {
    	
    	return service.findUserById(id);
	
 }
    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User obj) {
        service.saveUser(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }
    @DeleteMapping("/users/{user_id}")
    public String deleteUser(@PathVariable("user_id") int id){
    	if(service.deleteUser(id)) {
    		return  "user deleted successfully";
    	}
    	return "User not registered";
    	
    }
    @GetMapping("users")
    public List<User> findall(){
    	return service.showAllUsers();
    }
    @PutMapping("/users/{user_id}")
    public String edit(@RequestBody User user, @PathVariable("user_id") int id) {
    	service.update(user,id);
    	return "updated successfully";

}
    @GetMapping("/findbyusername/{username}")
    public User findByname(@PathVariable("username") String username){
    	return service.searchByName(username);
    }
    @GetMapping("/findbystatus/{status}")
    public User findBystatus(@PathVariable("status") String status) {
    	return service.searchByStatus(status);
    }
}
