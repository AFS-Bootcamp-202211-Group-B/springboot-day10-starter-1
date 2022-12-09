package com.rest.springbootemployee.controller.maper;

import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest,employee);
        return employee;
    }
}
