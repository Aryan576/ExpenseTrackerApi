package com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public interface UserRespositry extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByEmailAndPassword(String email, String passowrd);

}
