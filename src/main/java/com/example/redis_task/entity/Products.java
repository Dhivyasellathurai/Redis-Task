package com.example.redis_task.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private int qty;
	private long price;
}
