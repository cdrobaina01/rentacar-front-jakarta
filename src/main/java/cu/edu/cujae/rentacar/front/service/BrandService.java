package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.BrandDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface BrandService {
    public List<BrandDTO> getAll();
    public BrandDTO getById(Integer id);
    public ApiResponse save(BrandDTO dto);
    public ApiResponse update(BrandDTO dto);
    public ApiResponse delete(Integer id);
}
