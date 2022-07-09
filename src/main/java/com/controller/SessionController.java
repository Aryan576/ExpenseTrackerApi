package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.dto.Userdto;
import com.entity.UserEntity;
import com.repositry.UserRespositry;

@RestController
@CrossOrigin
public class SessionController {
	@Autowired
	UserRespositry usersRepo;

	@PostMapping("saveusers")
	public ResponseBean<UserEntity> signup(@RequestBody UserEntity users) {
		ResponseBean<UserEntity> response = new ResponseBean<>();

		if (users != null) {
			usersRepo.save(users);
			response.setData(users);
			response.setMessage("User Added Sucefully ");
			response.setStatus(200);
		} else {
			response.setMessage("Some Data is Missing");
			response.setStatus(201);
		}

		return response;

	}

	@PostMapping("Login")
	public ResponseBean<UserEntity> login(@RequestBody Userdto userdto){
		UserEntity users=null;
		ResponseBean<UserEntity> response= new ResponseBean<>();
		users=usersRepo.findByEmailAndPassword(userdto.getEmail(), userdto.getPassword());
		if(users !=null) {
			response.setData(users);
			response.setMessage("You have Login Sucefully");
			response.setStatus(200);
		}else {
			response.setMessage("User Not Found");
			response.setStatus(400);
			
		}
		
		return response;
	}

}
