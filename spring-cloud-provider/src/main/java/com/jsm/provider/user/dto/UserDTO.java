package com.jsm.provider.user.dto;

import com.jsm.common.util.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO extends BaseDTO {

    private String username;

    private String password;

    public UserDTO(){}

    public UserDTO(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
