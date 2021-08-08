package com.inventory.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Order;
import com.inventory.model.Product;
import com.inventory.model.Purchase;
import com.inventory.model.Response;
import com.inventory.service.AppService;
import com.inventory.service.OrderService;
import com.inventory.service.PurchaseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/inventory/api")
public class InventoryController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PurchaseService purchaseService;

	@ApiOperation(value = "Get All Purchases")
	@GetMapping("/purchase")
	public Response<Purchase> getAllPurchases() throws Exception {
		return new Response(HttpStatus.OK, purchaseService.getAll());
	}

	@ApiOperation(value = "Get Particular Purchase by ID")
	@GetMapping("/purchase/{id}")
	public Response<Purchase> getPurchaseById(@PathVariable("id") int purchaseId) throws Exception {
		return new Response(HttpStatus.OK, Arrays.asList(purchaseService.getById(purchaseId)));
	}

	@ApiOperation(value = "Create Purchase")
	@PostMapping("/purchase")
	public Response<Purchase> createPurchase(@RequestBody Purchase purchase) throws Exception {
		int id = purchaseService.create(purchase);
		String msg = "Purchase created with Id: " + id;
		return new Response(HttpStatus.OK, Arrays.asList(msg));
	}

	@ApiOperation(value = "Get All Orders")
	@GetMapping("/order")
	public Response<Order> getAllOrders() throws Exception {
		return new Response(HttpStatus.OK, orderService.getAll());
	}

	@ApiOperation(value = "Get Particular Order by ID")
	@GetMapping("/order/{id}")
	public Response<Order> getOrdertById(@PathVariable("id") int orderId) throws Exception {
		return new Response(HttpStatus.OK, Arrays.asList(orderService.getById(orderId)));
	}

	@ApiOperation(value = "Create Order")
	@PostMapping("/order")
	public Response<Order> createOrder(@RequestBody Order order) throws Exception {
		int id = orderService.create(order);
		String msg = "Order created with Id: " + id;
		return new Response(HttpStatus.OK, Arrays.asList(msg));
	}
}
