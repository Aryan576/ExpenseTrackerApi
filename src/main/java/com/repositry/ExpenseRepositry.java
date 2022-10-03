package com.repositry;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.ExpenseEntity;

public interface ExpenseRepositry extends JpaRepository<ExpenseEntity, Long> {
	
	@Query(value="select * from expense where userid=:userid",nativeQuery = true)
	List<ExpenseEntity> getAllExpneseByUserid(Long userid);

}
