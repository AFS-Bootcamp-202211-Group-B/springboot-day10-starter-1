package com.rest.springbootemployee.controller.mapper;

import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
//        employee.setName(employee.getName());
//        employee.setAge(employee.getAge());
//        employee.setGender(employee.getGender());
//        employee.setSalary(employee.getSalary());

        BeanUtils.copyProperties(employeeRequest, employee);
        return employee;
    }
}
