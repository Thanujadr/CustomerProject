package com.student.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.student.app.dto.Customer;
import com.student.app.exception.CustomerIdNotFoundException;

import java.util.List;
import java.util.Optional;
@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepo customerRepo;
	public Customer insertCustomer(Customer customer)
	{
		return 	customerRepo.save(customer);
	}
	
	public List<Customer> findAllCustomer()
	{
		return customerRepo.findAll();
	}
	
	public Optional<Customer> findCustById(int custid)
	{
		Optional<Customer> findById = customerRepo.findById(custid);
		return findById;
	}
	
	public Customer deleteCustomer(int custid)
	{
		Optional<Customer> findById = customerRepo.findById(custid);
		
		if(findById.isPresent())
		{
			customerRepo.deleteById(custid);
			return findById.get();
		}
		
		throw new CustomerIdNotFoundException("Customer Id is Not Available !!!");
	}

	public Customer updateCustomer(Customer customer) {
		Optional<Customer> findById = customerRepo.findById(customer.getId());
		if(findById.isPresent())
		{
			return customerRepo.save(customer);
		}
		throw new CustomerIdNotFoundException("Customer Id Not Available !!!");
		
	}

	public Customer updatePhone(int id, long phone) {
		Optional<Customer> optional = customerRepo.findById(id);
		if(optional.isPresent())
		{
			Customer cust = optional.get();
			cust.setPhno(phone);
			return customerRepo.save(cust);
		}
		throw new CustomerIdNotFoundException("Customer Id Not Available !!!");
	}
}
