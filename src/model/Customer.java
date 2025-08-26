package model;

public class Customer {

    private String email;
    private boolean student;

    public Customer(String email, boolean student) {
        this.email = email;
        this.student = student;
    }

    public boolean isStudent() {
        return student;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "\nEmail: " + email +
                "\nO cliente é estudante: " + student +
                '\n';
    }
}
