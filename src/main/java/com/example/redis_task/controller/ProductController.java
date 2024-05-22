package com.example.redis_task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis_task.entity.Products;
import com.example.redis_task.repository.ProductRepo;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductRepo repo;

	@PostMapping("/create")
	public Products save(@RequestBody Products product) {
		return repo.save(product);
	}

	@GetMapping
	public List<Products> getAllProducts() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Products findProduct(@PathVariable int id) {
		return repo.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return repo.deleteProduct(id);
	}

}
