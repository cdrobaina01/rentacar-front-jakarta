package cu.edu.cujae.rentacar.front.security.service;

import cu.edu.cujae.rentacar.front.security.dto.AuthenticatedUserDTO;
import cu.edu.cujae.rentacar.front.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Objects;

@Named
@RequestScoped
public class AuthenticationServiceImpl implements AuthenticationService{
    @Inject
    private RoleService roleService;
    @Override
    public AuthenticatedUserDTO login(LoginRequestDTO user) {
        AuthenticatedUserDTO authenticatedUser= null;
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            authenticatedUser = AuthenticatedUserDTO.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .role(roleService.getById(1))
                    .token("token")
                    .build();
        }
        return authenticatedUser;
    }

    @Override
    public ApiResponse logout() {
        return null;
    }
}
