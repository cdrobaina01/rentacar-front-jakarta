package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.dto.UserDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface RoleService {
    public List<RoleDTO> getAll();
    public RoleDTO getById(Integer id);
    public ApiResponse save(RoleDTO dto);
    public ApiResponse update(RoleDTO dto);
    public ApiResponse delete(Integer id);
}
