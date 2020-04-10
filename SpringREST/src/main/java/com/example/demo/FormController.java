package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

	@Autowired
	CustomerRepo repo;

	@RequestMapping("/")
	public String getCustomerPage() {
		return "GetCustomerPage";
	}

	@RequestMapping("/details")
	public String customerDetailsSave(Customer customers) {
		repo.save(customers);
		return "GetCustomerPage";
	}
	
	@RequestMapping("/customers")
	@ResponseBody()
	public List<Customer> getAllCustomer()
	{
		return repo.findAll();		 
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody()
	public Optional<Customer> getAllCustomer2(@PathVariable ("cid") int cid)
	{
		return repo.findById(cid);		 
	}
	
	
	@PostMapping("/customers")
	@ResponseBody()
	public Customer getAllCustomer3(@RequestBody Customer customer)
	{
		repo.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{cid}")
	@ResponseBody()
	public  Customer getAllCustomer3(@PathVariable ("cid") int cid)
	{
		Customer cust=repo.getOne(cid);
		repo.delete(cust);
		return cust;
	}
	
	@PutMapping(path="/customers", consumes="application/json")
	@ResponseBody()
	public  Customer getAllCustomer4(@RequestBody Customer customer)
	{
		
		repo.save(customer);
		return customer;
	}

}
