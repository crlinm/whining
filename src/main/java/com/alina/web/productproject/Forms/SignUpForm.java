package com.alina.web.productproject.Forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SignUpForm {
    private String displayName;
    private String nickName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String description;
}
