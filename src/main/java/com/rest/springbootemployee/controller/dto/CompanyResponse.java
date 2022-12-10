package com.rest.springbootemployee.controller.dto;

public class CompanyResponse {
    private String id;
    private String name;
    private Integer employeesCount;

    public CompanyResponse(String id, String name, Integer employeesCount) {
        this.id = id;
        this.name = name;
        this.employeesCount = employeesCount;
    }

    public CompanyResponse() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }
}
