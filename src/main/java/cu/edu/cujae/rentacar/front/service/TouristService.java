package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.dto.TouristDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface TouristService {
        public List<TouristDTO> getAll();
        public TouristDTO getById(Integer id);
        public ApiResponse save(TouristDTO dto);
        public ApiResponse update(TouristDTO dto);
        public ApiResponse delete(Integer id);
        public ApiResponse delete(List<Integer> ids);
}
