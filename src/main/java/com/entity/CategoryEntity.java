package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	Long categoryid;
	String categoryname;
}
