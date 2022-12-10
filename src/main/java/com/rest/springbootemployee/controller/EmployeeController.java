package com.rest.springbootemployee.controller;

import com.mongodb.lang.NonNull;
import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.controller.mapper.EmployeeMapper;
import com.rest.springbootemployee.entity.Employee;
import com.rest.springbootemployee.exception.InvalidIdException;
import com.rest.springbootemployee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return employeeMapper.toResponseList(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@NonNull @PathVariable String id) {
        if(!ObjectId.isValid(id)){
            throw new InvalidIdException();
        }
        Employee findEmployee = employeeService.findById(id);
        return employeeMapper.toResponse(findEmployee);
    }

    @GetMapping(params = {"gender"})
    public List<EmployeeResponse> getByGender(@RequestParam String gender) {
        return employeeMapper.toResponseList(employeeService.findByGender(gender));
    }
    //Requesting Employee -> EmployeeRequest
    // Mapper convert EmployeeRequest -> Employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse add(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEntity(employeeRequest);
        Employee savedEmployee = employeeService.create(employee);
        return employeeMapper.toResponse(savedEmployee);
    }
    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable String id, @RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEntity(employeeRequest);
        Employee updatedEmployee = employeeService.update(id, employee);
        return employeeMapper.toResponse(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }


    @GetMapping(params = {"page", "pageSize"})
    public List<EmployeeResponse> getByPage(int page, int pageSize) {
        return employeeMapper.toResponseList(employeeService.findByPage(page, pageSize));
    }

}
