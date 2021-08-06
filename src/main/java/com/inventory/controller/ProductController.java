package com.inventory.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Product;
import com.inventory.model.Response;
import com.inventory.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/inventory/api")
public class ProductController {

	@Autowired
	ProductService productService;

	// @ApiOperation is swagger annotation to print text over URLS in swagger UI
	@ApiOperation(value = "Get All Products")
	@GetMapping("/product")
	public Response<Product> getAllProducts() throws Exception {
		return new Response(HttpStatus.OK, productService.getAll());
	}

	@ApiOperation(value = "Get Particular Product by ID")
	@GetMapping("/product/{id}")
	public Response<Product> getProductById(@PathVariable("id") int productId) throws Exception {
		return new Response(HttpStatus.OK, Arrays.asList(productService.getById(productId)));
	}

	@ApiOperation(value = "Create Product")
	@PostMapping("/product")
	public Response<Product> createProduct(@RequestBody Product product) throws Exception {
		int id = productService.create(product);
		return new Response(HttpStatus.OK, Arrays.asList(id));
	}

	@ApiOperation(value = "Update a Particular Product")
	@PutMapping("/product/{id}")
	public Response<Product> updateProduct(@RequestBody Product product, int productId) throws Exception {
		int id = productService.update(product, productId);
		return new Response(HttpStatus.OK, Arrays.asList(id));
	}
}
