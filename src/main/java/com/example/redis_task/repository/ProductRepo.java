package com.example.redis_task.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redis_task.entity.Products;

@Repository
public class ProductRepo {
	public static final String HASH_KEY = "Product";
	@Autowired
	private RedisTemplate template;

	public Products save(Products product) {
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Products> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	public Products findProductById(int id) {
		return (Products) template.opsForHash().get(HASH_KEY, id);
	}

	public String deleteProduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "product removed !!";
	}
}
