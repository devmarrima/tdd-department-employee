package com.devmarrima.tdd_department_employee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmarrima.tdd_department_employee.dto.EmployeeDTO;
import com.devmarrima.tdd_department_employee.entities.Department;
import com.devmarrima.tdd_department_employee.entities.Employee;
import com.devmarrima.tdd_department_employee.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pageable){
		Page<Employee> page = repository.findAll(pageable);
		return page.map(x->new EmployeeDTO(x));
	}
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setDepartment(new Department(dto.getDepartmentId(),null));
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
		
	}
}
