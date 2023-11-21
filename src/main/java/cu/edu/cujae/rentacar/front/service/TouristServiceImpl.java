package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.TouristDTO;
import cu.edu.cujae.rentacar.front.mock.TouristMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class TouristServiceImpl implements TouristService {
    @Override
    public List<TouristDTO> getAll() {
        return TouristMock.getInstance().getAll();
    }

    @Override
    public TouristDTO getById(Integer id) {
        return TouristMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(TouristDTO dto) {
        return new ApiResponse(TouristMock.getInstance().save(dto), "Save");
    }

    @Override
    public ApiResponse update(TouristDTO dto) {
        return new ApiResponse(TouristMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(TouristMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> id) {
        return null;
    }
}
