package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.entity.ExpenseEntity;
import com.repositry.ExpenseRepositry;

@RestController
@CrossOrigin
public class ExpenseController {

	@Autowired
	ExpenseRepositry expenseRepositry;
	
	
	@PostMapping("addExpense")
	public ResponseBean<ExpenseEntity> addexpesne(@RequestBody ExpenseEntity expenseEntity )
	{
		ResponseBean<ExpenseEntity> responseBean =  new ResponseBean<>();
		
		if(expenseEntity !=null) {
			
	  
				expenseRepositry.save(expenseEntity);
				responseBean.setData(expenseEntity);
				responseBean.setMessage("Expense added");
				responseBean.setStatus(200);
		}else {
			responseBean.setMessage("Something is not correct");
			responseBean.setStatus(400);
		}
		
		
		
		return responseBean;
	}
	@GetMapping("listexpense/{userid}")
	public ResponseBean<List<ExpenseEntity>> listexpense(@PathVariable("userid")Long userid)
	{
		ResponseBean<List<ExpenseEntity>> response = new ResponseBean<>();
		List<ExpenseEntity> exepEntities=expenseRepositry.getAllExpneseByUserid(userid);
		if(exepEntities !=null) {
			response.setData(exepEntities);
			response.setMessage("List of Expesne for user");
			response.setStatus(200);
		}else {
			response.setMessage("User does not exits");
			response.setStatus(400);
		}
		
		return response;
	}
}
