package com.divya.controller;

import com.divya.dao.UserDao;
import com.divya.model.DAOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.divya.model.UserDTO;

import java.util.List;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@GetMapping( "/home")
	public String welcome() {
		return "Welcome";


	}
	@GetMapping("/all")
	public List<DAOUser> getAllUser(){
		return (List<DAOUser>) userDao.findAll();
	}
@GetMapping("{username}")
public ResponseEntity<DAOUser> getUserByID(@PathVariable(value="username") String username){
		return ResponseEntity.ok(userDao.findByUsername(username));
}

	@PutMapping("/update")
	public ResponseEntity<DAOUser> updateUser(@RequestBody DAOUser user){
		return ResponseEntity.ok(userDao.save(user));
	}

@DeleteMapping("{id}")
	public void deleteById(@PathVariable(value= "id") int id){

		userDao.deleteById(id);
}

}