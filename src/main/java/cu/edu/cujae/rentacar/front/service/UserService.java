package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.UserDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAll();
    public UserDTO getById(Integer id);
    public ApiResponse save(UserDTO dto);
    public ApiResponse update(UserDTO dto);
    public ApiResponse delete(Integer id);
}
