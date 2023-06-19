package com.student.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.student.app.repository.CustomerDao;
import com.student.app.response.ResponseStructure;
import com.student.app.dto.Customer;

@Service
public class CustomerService {
    @Autowired
	private CustomerDao customerDao; 
    
    public ResponseStructure<?> insertCustomer(Customer customer)
    {
    	Customer cust = customerDao.insertCustomer(customer);
    	ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
    	responseStructure.setData(cust);
    	responseStructure.setHttpstatus(HttpStatus.CREATED);
    	
    	return responseStructure;
    }
    
    public ResponseStructure<?> findAllCustomer()
    {
    	List<Customer> customers = customerDao.findAllCustomer();
    	ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
    	responseStructure.setData(customers);
    	responseStructure.setHttpstatus(HttpStatus.OK);
    	
    	return responseStructure;
    	
    }
    
    public ResponseStructure<?> findCustById(int custid)
    {
    	Optional<Customer> cust = customerDao.findCustById(custid);
    	if(cust.isPresent())
    	{
    		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
        	responseStructure.setData(cust.get());
        	responseStructure.setHttpstatus(HttpStatus.FOUND);
        	
        	return responseStructure;
    	}
    	else
    	{
    		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
        	responseStructure.setData("Customer Not found");
        	responseStructure.setHttpstatus(HttpStatus.NOT_FOUND);
        	
        	return responseStructure;
    	}
    }
    
    
    public ResponseStructure<?> deleteCustById(int custid)
    {
    	Customer customer = customerDao.deleteCustomer(custid);
    	
    	ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
    	responseStructure.setData(customer);
    	responseStructure.setHttpstatus(HttpStatus.FOUND);
    	
    	return responseStructure;
    }

	public ResponseStructure<?> updateCustomer(Customer customer) {
	    Customer cust = customerDao.updateCustomer(customer);
	    ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
    	responseStructure.setData(cust);
    	responseStructure.setHttpstatus(HttpStatus.FOUND);
    	
    	return responseStructure;
	}

	public ResponseStructure<?> updatePhone(int id, long phone) {
		Customer cust = customerDao.updatePhone(id,phone);
		 ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
	    	responseStructure.setData(cust);
	    	responseStructure.setHttpstatus(HttpStatus.FOUND);
	    	
	    	return responseStructure;
	}
    
    
}
