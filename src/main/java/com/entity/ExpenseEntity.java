package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "expense")
public class ExpenseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long expesneid;
	String expensename;
	Long amount;
	LocalDate expensedate;
	String category;
	String paymenttype;
	
	String comments;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "userid")
	UserEntity users;

}
