package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.mock.CountryMock;
import cu.edu.cujae.rentacar.front.mock.RoleMock;
import cu.edu.cujae.rentacar.front.mock.UserMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class CountryServiceImpl implements CountryService {

    private RoleMock mocker;
    @Override
    public List<CountryDTO> getAll() {
        return CountryMock.getInstance().getAll();
    }

    @Override
    public CountryDTO getById(Integer id) {
        return CountryMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(CountryDTO dto) {
        return new ApiResponse(CountryMock.getInstance().save(dto), "Save");
    }

    @Override
    public ApiResponse update(CountryDTO dto) {
        return new ApiResponse(CountryMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(CountryMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> ids) {
        return null;
    }

}