package com.rest.springbootemployee.controller.dto;

public class CompanyResponse {
    private String id;
    private String name;
    private Integer employeeCount;
    public CompanyResponse() {
    }

    public CompanyResponse(String id, String name, Integer employeeCount) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public void setEmployeesCount(int size) {
        this.employeeCount = size;
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

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
}
