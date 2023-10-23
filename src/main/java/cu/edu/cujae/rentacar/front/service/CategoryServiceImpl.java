package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.mock.CategoryMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class CategoryServiceImpl implements CategoryService{
    @Override
    public List<CategoryDTO> getAll() {
        return CategoryMock.getInstance().getAll();
    }

    @Override
    public CategoryDTO getById(Integer id) {
        return CategoryMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(CategoryDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse update(CategoryDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(true, "Not Implemented");
    }
}
