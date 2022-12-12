package com.rest.springbootemployee.controller.dto;

public class CompanyResponse {

    private String oid;

    private String name;
    private Integer employeeCount;

    public CompanyResponse(String oid, String name, Integer employeeCount) {
        this.oid = oid;
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public CompanyResponse() {

    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
