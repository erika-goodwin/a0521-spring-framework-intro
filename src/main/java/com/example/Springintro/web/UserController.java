package com.example.Springintro.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springintro.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User found: " + userId;
	}
	
	@RequestMapping("/{userId}/invoices")
	public String displayUserInvoices(
			@PathVariable int userId, 
			@RequestParam(value = "date", required=false) Date date
		) {
		return "Invoice found for user: " +userId+ " on the date: " +date;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson(){
		return Arrays.asList("Pencil","Ruler","Eraser");
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsJson(){
		return Arrays.asList(
				new Product(1, "Shoes", 34.99),
				new Product(2, "Bag", 199.89),
				new Product(3, "Books", 15.00));
	}
	
}
