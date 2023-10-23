package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface ModelService {
    public List<ModelDTO> getAll();
    public ModelDTO getById(Integer id);
    public ApiResponse save(ModelDTO dto);
    public ApiResponse update(ModelDTO dto);
    public ApiResponse delete(Integer id);
}
