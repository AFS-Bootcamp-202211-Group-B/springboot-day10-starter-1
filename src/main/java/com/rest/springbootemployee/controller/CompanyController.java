package com.rest.springbootemployee.controller;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.controller.maper.CompanyMapper;
import com.rest.springbootemployee.controller.maper.EmployeeMapper;
import com.rest.springbootemployee.entity.Company;
import com.rest.springbootemployee.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;
    private CompanyMapper companyMapper;
    private EmployeeMapper employeeMapper;


    public CompanyController(CompanyService companyService, CompanyMapper companyMapper, EmployeeMapper employeeMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyService.findAll().stream().map(company -> companyMapper.toResponse(company)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable String id) {
        return companyMapper.toResponse(companyService.findById(id));
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeResponse> getEmployees(@PathVariable String id) {
        return companyService.getEmployees(id).stream().map(employee -> employeeMapper.toResponse(employee)).collect(Collectors.toList());
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<CompanyResponse> getByPage(Integer page, Integer pageSize) {
        return companyService.findByPage(page, pageSize).stream().map(company -> companyMapper.toResponse(company)).collect(Collectors.toList());
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompanyResponse create(@RequestBody Company company) {
        return companyMapper.toResponse(companyService.create(company));
    }

    @PutMapping("/{id}")
    public CompanyResponse update(@PathVariable String id, @RequestBody CompanyRequest companyRequest) {
        Company company = companyMapper.toEntity(companyRequest);
        return companyMapper.toResponse(companyService.update(id, company));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable String id) {
        companyService.delete(id);
    }
}
