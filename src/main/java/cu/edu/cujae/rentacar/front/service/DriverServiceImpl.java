package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.mock.DriverMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class DriverServiceImpl implements DriverService{
    @Override
    public List<DriverDTO> getAll() {
        return DriverMock.getInstance().getAll();
    }

    @Override
    public DriverDTO getById(Integer id) {
        return DriverMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(DriverDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse update(DriverDTO dto) {
        return new ApiResponse(true, "Not Implemented");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(true, "Not Implemented");
    }
}
