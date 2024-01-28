package org.chris.myfirstapirest.api.models.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String lastname;
    private String email;
}
