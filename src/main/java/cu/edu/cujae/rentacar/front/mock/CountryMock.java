package cu.edu.cujae.rentacar.front.mock;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.ArrayList;
import java.util.List;

public class CountryMock {
    private static CountryMock instance;
    private final List<CountryDTO> countrys;

    public static CountryMock getInstance() {
        if (instance == null) {
            instance = new CountryMock();
        }
        return instance;
    }

    private CountryMock() {
        countrys = new ArrayList<>();
        countrys.add(new CountryDTO(1, "CUBA"));
        countrys.add(new CountryDTO(2, "ANGOLA"));
    }

    public List<CountryDTO> getAll() {
        return countrys;
    }

    public CountryDTO getById(Integer id) {
        CountryDTO country = null;
        for(CountryDTO dto : countrys) {
            if (dto.getId().equals(id)) {
                country = dto;
                break;
            }
        }
        return country;
    }

    public boolean save(CountryDTO dto) {
        boolean result = true;
        for (CountryDTO country : countrys) {
            if (country.getId().equals(dto.getId())) {
                result = false;
                break;
            }
        }
        if (result) {
            dto.setId(countrys.size());
            countrys.add(dto);
        }
        return result;
    }

    public boolean update(CountryDTO dto) {
        boolean result = false;
        for (CountryDTO country : countrys) {
            if (country.getId().equals(dto.getId())) {
                result = true;
                country = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        CountryDTO deleted = null;
        for (CountryDTO country : countrys) {
            if (country.getId().equals(id)) {
                result = true;
                deleted = country;
            }
        }
        countrys.remove(deleted);
        return result;
    }

    public ApiResponse delete(List<Integer> ids) {
        return null;
    }
}
