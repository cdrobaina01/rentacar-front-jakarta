package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.mock.DriverMock;
import cu.edu.cujae.rentacar.front.mock.ModelMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ModelServiceImpl implements ModelService{
    @Override
    public List<ModelDTO> getAll() {
        return ModelMock.getInstance().getAll();
    }

    @Override
    public ModelDTO getById(Integer id) {
        return ModelMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(ModelDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse update(ModelDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(true, "Not Implemented");
    }
}
