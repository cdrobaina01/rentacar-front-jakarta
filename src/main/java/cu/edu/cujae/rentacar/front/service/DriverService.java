package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface DriverService {
    public List<DriverDTO> getAll();
    public DriverDTO getById(Integer id);
    public ApiResponse save(DriverDTO dto);
    public ApiResponse update(DriverDTO dto);
    public ApiResponse delete(Integer id);
}
