package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.DTO.UserDTO;
import com.example.sample.Entities.User;
import com.example.sample.Service.UserService;

import jakarta.validation.Valid;


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
    public String addUser(@Valid  @RequestBody UserDTO obj) {
        if(service.saveUser(obj)) {
        return "User created successfully.";
        }
        else {
        	return "user already present";
        }
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
   
    
    @Validated
    @PostMapping("test/dto")
    public String saveEntity(@Valid @RequestBody UserDTO user) {
    	
    	return "validation page";
    	
    }
    
    
    
    
    
}
