package com.rest.springbootemployee.controller.dto;

import com.rest.springbootemployee.entity.Employee;

import java.util.List;

public class CompanyRequest {

    private String name;


    public CompanyRequest() {
    }

    public CompanyRequest( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
