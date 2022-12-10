package com.medical.demo.models;

public abstract class User {


    int id;
    String email;
    String password;
    String firstName;
    String lastName;
    int age;
    Role role;
    Gender gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void validate() throws Exception{
        if (this.getFirstName() == null || this.getFirstName().isBlank()){
            throw new Exception("Please enter first name");
        }

        if (this.getLastName() == null || this.getLastName().isBlank()){
            throw new Exception("Please enter last name");
        }
        if (this.getEmail() == null || this.getEmail().isBlank()){
            throw new Exception("Please enter email");
        }
        if (this.getAge() < 1){
            throw new Exception("age cannot be less than 0");
        }
        if (this.getGender() == null){
            throw new Exception("Please enter gender");
        }

    }
    public boolean login(String email, String password){
        if (getEmail().equals(email) && getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public abstract User signup() throws Exception;


}

