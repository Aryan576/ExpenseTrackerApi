package com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CategoryEntity;

public interface CategoryRepositry extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findBycategoryname(String categoryname);

}
