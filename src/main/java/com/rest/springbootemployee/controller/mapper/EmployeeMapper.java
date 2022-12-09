package com.rest.springbootemployee.controller.mapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
//        employee.setName(employeeRequest.getName());
//        employee.setAge(employeeRequest.getAge());
//        employee.setGender(employeeRequest.getGender());
//        employee.setSalary(employeeRequest.getSalary());

        BeanUtils.copyProperties(employeeRequest, employee);
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {

     //   String id = employee.getId();
     //   String name = employee.getName();
     //   int age = employee.getAge();
     //   String gender = employee.getGender();
     //   EmployeeResponse employeeResponse = new EmployeeResponse(id, name, age, gender);
        EmployeeResponse employeeResponse = new EmployeeResponse();


        BeanUtils.copyProperties(employee, employeeResponse);
        return employeeResponse;
    }
}
