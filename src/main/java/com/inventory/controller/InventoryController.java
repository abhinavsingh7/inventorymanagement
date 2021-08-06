package com.inventory.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.service.AppService;
import com.inventory.service.OrderService;

@RestController
@RequestMapping(value="/inventory/api")
public class InventoryController {

	@Autowired
	OrderService inventoryService;
	

}
