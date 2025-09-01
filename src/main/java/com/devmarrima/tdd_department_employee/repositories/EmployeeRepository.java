package com.devmarrima.tdd_department_employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmarrima.tdd_department_employee.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
