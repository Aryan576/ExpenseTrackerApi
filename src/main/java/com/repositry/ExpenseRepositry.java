package com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ExpenseEntity;

public interface ExpenseRepositry extends JpaRepository<ExpenseEntity, Long> {

}
