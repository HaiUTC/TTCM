package com.example.thuctap.Types;

import lombok.Data;

@Data
public class LoginDataInput {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
