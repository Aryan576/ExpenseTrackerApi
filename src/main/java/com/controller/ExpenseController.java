package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
