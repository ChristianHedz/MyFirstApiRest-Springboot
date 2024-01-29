package org.chris.myfirstapirest.api.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "{user.name.notBlank}")
    private String name;

    @NotBlank(message = "{user.lastname.notBlank}")
    private String lastname;

    @NotBlank(message = "{user.email.notBlank}")
    @Email(message = "{user.email.format}")
    private String email;

}
