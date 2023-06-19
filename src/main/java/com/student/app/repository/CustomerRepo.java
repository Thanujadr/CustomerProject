package com.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.app.dto.Customer;
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
