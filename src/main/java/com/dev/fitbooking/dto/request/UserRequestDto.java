package com.dev.fitbooking.dto.request;

import com.dev.fitbooking.annotation.EmailConstraint;
import com.dev.fitbooking.annotation.PasswordMatch;
import javax.validation.constraints.Size;

@PasswordMatch.List({
        @PasswordMatch(
                password = "password",
                passwordMatch = "repeatPassword",
                message = "Password do not match!"
        )
})
public class UserRequestDto {
    @EmailConstraint
    private String email;
    @Size(min = 4, max = 30)
    private String password;
    @Size(min = 4, max = 30)
    private String repeatPassword;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
