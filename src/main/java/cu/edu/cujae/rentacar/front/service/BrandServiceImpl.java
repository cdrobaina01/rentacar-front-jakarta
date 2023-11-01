package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.mock.AuxiliaryMock;
import cu.edu.cujae.rentacar.front.mock.DriverMock;
import cu.edu.cujae.rentacar.front.mock.ModelMock;
import cu.edu.cujae.rentacar.front.service.ModelService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class BrandServiceImpl implements BrandService {
    @Override
    public List<AuxiliaryDTO> getAll() {
        return AuxiliaryMock.getInstance().getAll();
    }

    @Override
    public AuxiliaryDTO getById(Integer id) {
        return AuxiliaryMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(AuxiliaryDTO dto) {
        return new ApiResponse(AuxiliaryMock.getInstance().save(dto), "Saved");
    }

    @Override
    public ApiResponse update(AuxiliaryDTO dto) {
        return new ApiResponse(AuxiliaryMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(AuxiliaryMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> ids) {
        AuxiliaryMock.getInstance().delete(ids);
        return new ApiResponse(true, "Delete");
    }
}
