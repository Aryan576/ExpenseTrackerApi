package com.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity()
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long userid;
	
	String name;
	String email;
	String password;
	String gender;
	
	@CreationTimestamp
	Date createdDate;
	
	@UpdateTimestamp
	Date updatedDate;
	
	
	

}
