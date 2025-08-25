package model;

public class Customer {

    private String email;
    private boolean student;

    public Customer(String email) {
        this.email = email;
    }

    public boolean isStudent() {
        return student;
    }

    public String getEmail() {
        return email;
    }
}
