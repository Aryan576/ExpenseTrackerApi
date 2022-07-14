package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.entity.CategoryEntity;
import com.repositry.CategoryRepositry;

@RestController
@CrossOrigin
public class CategoryController {
	@Autowired
	CategoryRepositry caterepo;

	@PostMapping("addCategory")
	public ResponseBean<CategoryEntity> addcategory(@RequestBody CategoryEntity cate) {
		ResponseBean<CategoryEntity> response = new ResponseBean<>();
		CategoryEntity cateEnt = null;
		cateEnt = caterepo.findBycategoryname(cate.getCategoryname());

		if (cateEnt == null) {
			caterepo.save(cate);
			response.setData(cate);
			response.setMessage("Category Added");
			response.setStatus(200);

		} else {
			response.setMessage("Category Already there");
			response.setStatus(400);

		}

		return response;
	}

	@GetMapping("ListCategory")
	public ResponseBean<List<CategoryEntity>> listCategory() {
		
		ResponseBean<List<CategoryEntity>> responseBean = new ResponseBean<>();
		List<CategoryEntity> cate = caterepo.findAll();
		
		if (cate != null) {
			responseBean.setData(cate);
			responseBean.setMessage("List of Category");
			responseBean.setStatus(200);
		} else {
			responseBean.setMessage("Something went Wrong");
			responseBean.setStatus(400);
		}

		return responseBean;
	}
}
