package com.example.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "User_Detail")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_seq_generator")
    @SequenceGenerator(sequenceName = "my_seq_generator",name = "my_generator",allocationSize = 1,initialValue = 653214)
    @Column(name = "uid",nullable = false,updatable = false)
    private Integer uid;
    @Column(name = "User_FirstName",nullable = false)
    private String first_name;

    @Column(name = "User_LastName",nullable = false)
    private String last_name;

    @Column(name = "User_FullName",nullable = false)
    private String full_name;
    @Column(name = "User_Gender",nullable = false)
    private String gender;
    @Column(name = "User_Email",nullable = false,unique = true)
    private String email;

    @Column(name = "User_Phone",nullable = false,unique = true,length = 10)
    private String phone;

    @Column(name="User_Department",nullable = true)
    private String department;

    @Column(name = "User_Password",nullable = false)
    private String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
