package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.dto.FeeDTO;
import cu.edu.cujae.rentacar.front.mock.AuxiliaryMock;
import cu.edu.cujae.rentacar.front.mock.DriverMock;
import cu.edu.cujae.rentacar.front.mock.FeeMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class FeeServiceImpl implements FeeService {
    @Override
    public List<FeeDTO> getAll() {
        return FeeMock.getInstance().getAll();
    }

    @Override
    public FeeDTO getById(Integer id) {
        return FeeMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(FeeDTO dto) {
        return new ApiResponse(FeeMock.getInstance().save(dto), "Saved");
    }

    @Override
    public ApiResponse update(FeeDTO dto) {
        return new ApiResponse(FeeMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(FeeMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> ids) {
        FeeMock.getInstance().delete(ids);
        return new ApiResponse(true, "Delete");
    }
}
