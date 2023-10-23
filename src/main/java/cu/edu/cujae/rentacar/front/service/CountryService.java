package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface CountryService {
    public List<CountryDTO> getAll();
    public CountryDTO getById(Integer id);
    public ApiResponse save(CountryDTO dto);
    public ApiResponse update(CountryDTO dto);
    public ApiResponse delete(Integer id);
    public ApiResponse delete(List<Integer> ids);
}
