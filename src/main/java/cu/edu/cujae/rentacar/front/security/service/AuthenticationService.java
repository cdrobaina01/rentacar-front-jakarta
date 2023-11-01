package cu.edu.cujae.rentacar.front.security.service;

import cu.edu.cujae.rentacar.front.security.dto.AuthenticatedUserDTO;
import cu.edu.cujae.rentacar.front.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

public interface AuthenticationService {
    AuthenticatedUserDTO login(LoginRequestDTO user);
    ApiResponse logout();
}
