package uyishi2;

import java.time.LocalDateTime;

class User {
    private String email;
    private LocalDateTime dateTime;

    public User(){}

    public User(String email, LocalDateTime dateTime) {
        this.email = email;
        this.dateTime = dateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return email + ", " + dateTime.toString();
    }


}