package com.example.sample.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.Entities.User;
import java.util.List;
import com.example.sample.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;

	public User findUserById(int id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("user with given credential not present"));
	}

	public void saveUser(User obj) {
		repo.save(obj);
		
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id)) {
		repo.deleteById(id);
		return true;}
		return false;
	}

	public List<User> showAllUsers() {
	return repo.findAll();
		
	
	}

	public void update(User user, int id) {
		Optional<User> updateuser=repo.findById(id);
		User update;
		if(updateuser.isEmpty()) {
			throw new RuntimeException("user not found");
		}
		
		else {
			 update=updateuser.get();
			update.setEmail(user.getEmail());
			update.setName(user.getName());
			update.setStatus(user.getStatus());
			
		}
		repo.save(update);
		
	}

	public User searchByName(String username) {
		
		return repo.findByName(username).orElseThrow(()->new RuntimeException("user with given credential not found"));
		
			 
		 
	}

	public User searchByStatus(String status) {
		return repo.findByStatus(status).orElseThrow(()->new RuntimeException("user not found"));
	}


}
