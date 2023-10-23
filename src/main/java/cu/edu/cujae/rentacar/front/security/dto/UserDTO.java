package cu.edu.cujae.rentacar.front.security.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private RoleDTO role;

    public UserDTO() {

    }

    public UserDTO(Integer id, String username, String password, RoleDTO role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
