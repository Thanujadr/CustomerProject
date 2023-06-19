package com.student.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Customer;
import com.student.app.response.ResponseStructure;
import com.student.app.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path="/post")
	public ResponseEntity<?>  postCustomer(@RequestBody Customer customer)
	{
		ResponseStructure<?> responseStructure = customerService.insertCustomer(customer);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
	}
	
	@GetMapping(path="/getall")
	public ResponseEntity<?> getAllCustomer()
	{
		ResponseStructure<?> responseStructure = customerService.findAllCustomer();
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
	}
	
	@GetMapping(path="/getbyid")
	public ResponseEntity<?> getCustomerById(@RequestParam int id){
		ResponseStructure<?> responseStructure=customerService.findCustById(id);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
		
	}
	
	@DeleteMapping(path="/delete/{custid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int custid){
		ResponseStructure<?> responseStructure = customerService.deleteCustById(custid);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
		
	}
	
	//updating 
	//postmapping - > used when we want to update whole resource
	//patchmapping -> used when partial updation pf the resorce
	
	@PutMapping(path="/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer)
	{
		ResponseStructure<?> responseStructure = customerService.updateCustomer(customer);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpstatus());
	}
	
	@PatchMapping(path="/updatepartial")
	public ResponseEntity<?> updatePhone(@RequestParam int id,@RequestParam long phone)
	{
		ResponseStructure<?> responseStructure = customerService.updatePhone(id,phone);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
	}
	
	
}
