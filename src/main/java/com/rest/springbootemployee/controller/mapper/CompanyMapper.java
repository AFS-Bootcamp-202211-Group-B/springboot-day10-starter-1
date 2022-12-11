package com.rest.springbootemployee.controller.mapper;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.entity.Company;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {
    public Company toEntity(CompanyRequest companyRequestRequest) {
        Company company = new Company();
        BeanUtils.copyProperties(companyRequestRequest, company);

        return company;
    }

    public CompanyResponse toResponse(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();

        int size = 0;
        if(company.getEmployees() != null){
            size = company.getEmployees().size();
        }

        BeanUtils.copyProperties(company, companyResponse);
        companyResponse.setEmployeeCount(size);

        return companyResponse;
    }

    public List<CompanyResponse> toResponseList(List<Company> companies){
        return companies.stream()
                .map(company -> toResponse(company))
                .collect(Collectors.toList());
    }

}
