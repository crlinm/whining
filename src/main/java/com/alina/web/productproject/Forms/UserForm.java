package com.alina.web.productproject.Forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {
    private String displayName;
    @NotEmpty
    private String nickName;
    @NotEmpty
    private String email;
    private String password;
    private String description;
}
