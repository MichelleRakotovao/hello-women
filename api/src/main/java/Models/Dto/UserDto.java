package Models.Dto;

import Models.Role;

import java.util.Date;
import java.util.List;

public class UserDto {
    private String username;
    private String password;

    private Integer idRole;
    public String getPassword() {
        return password;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
