package com.rest.springbootemployee.controller.dto;

public class EmployeeResponse {

    private String oid;
    private String name;
    private Integer age;

    public EmployeeResponse() {

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public EmployeeResponse(String oid, String name, Integer age, String gender) {
        this.oid = oid;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


}
