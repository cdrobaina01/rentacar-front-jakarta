package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.BrandDTO;
import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.mock.BrandMock;
import cu.edu.cujae.rentacar.front.mock.CategoryMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class BrandServiceImpl implements BrandService{

    @Override
    public List<BrandDTO> getAll() {
        return BrandMock.getInstance().getAll();
    }

    @Override
    public BrandDTO getById(Integer id) {
        return BrandMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(BrandDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse update(BrandDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(true, "Not Implemented");
    }
}