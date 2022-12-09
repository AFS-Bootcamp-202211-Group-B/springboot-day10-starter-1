package com.rest.springbootemployee.controller.dto;

public class CompanyRequest {
    private String name;

    public CompanyRequest(String name) {
        this.name = name;
    }

    public CompanyRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
