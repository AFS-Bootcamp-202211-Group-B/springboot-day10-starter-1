package com.rest.springbootemployee.controller.mapper;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.entity.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {
    public Company toEntity(CompanyRequest companyRequest){
        Company company = new Company();
        BeanUtils.copyProperties(companyRequest, company);
        return company;
    }
    public CompanyResponse toResponse(Company company){
        CompanyResponse companyResponse = new CompanyResponse();
        int size = 0;
        if(company.getEmployees() != null){
            size = company.getEmployees().size();
        }
        BeanUtils.copyProperties(company, companyResponse);
        companyResponse.setEmployeesCount(size);
        return companyResponse;
    }
    public List<CompanyResponse> toResponseList(List<Company> companies){
        return companies.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }
}
