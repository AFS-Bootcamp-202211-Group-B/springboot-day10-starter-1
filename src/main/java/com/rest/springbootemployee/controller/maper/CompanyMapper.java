package com.rest.springbootemployee.controller.maper;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.entity.Company;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public Company toEntity(CompanyRequest companyRequest){
        Company company = new Company();
        BeanUtils.copyProperties(companyRequest,company);
        return company;
    }

    public CompanyResponse toResponse(Company company){
        CompanyResponse CompanyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company,CompanyResponse);
        CompanyResponse.setEmployeeCount(company.getEmployees()==null?0:company.getEmployees().size());
        return CompanyResponse;
    }
}
