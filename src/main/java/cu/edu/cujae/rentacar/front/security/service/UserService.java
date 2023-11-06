package cu.edu.cujae.rentacar.front.security.service;

import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.service.CrudService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface UserService extends CrudService<UserDTO> {
    ApiResponse changePassword(Integer id, String password);
}
