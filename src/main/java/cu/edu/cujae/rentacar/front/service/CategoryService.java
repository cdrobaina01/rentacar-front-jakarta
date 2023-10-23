package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> getAll();
    public CategoryDTO getById(Integer id);
    public ApiResponse save(CategoryDTO dto);
    public ApiResponse update(CategoryDTO dto);
    public ApiResponse delete(Integer id);
}
