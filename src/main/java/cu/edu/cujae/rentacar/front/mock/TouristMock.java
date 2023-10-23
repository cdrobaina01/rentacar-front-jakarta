package cu.edu.cujae.rentacar.front.mock;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.dto.TouristDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.ArrayList;
import java.util.List;

public class TouristMock {
    private static TouristMock instance;
    private final List<TouristDTO> tourists;

    public static TouristMock getInstance() {
        if (instance == null) {
            instance = new TouristMock();
        }
        return instance;
    }

    private TouristMock() {
        tourists = new ArrayList<>();
        tourists.add(new TouristDTO(1, "T123", "juan", 4, "masculo", "asdasd", new CountryDTO(999, "SIRIA")));
        tourists.add(new TouristDTO(2, "T234", "juana", 5, "mascula", "dsadsa", new CountryDTO(998, "NONSIRIA")));

    }

    public List<TouristDTO> getAll() {
        return tourists;
    }

    public TouristDTO getById(Integer id) {
        TouristDTO tourist = null;
        for(TouristDTO dto : tourists) {
            if (dto.getId().equals(id)) {
                tourist = dto;
                break;
            }
        }
        return tourist;
    }

    public boolean save(TouristDTO dto) {
        boolean result = true;
        for (TouristDTO tourist : tourists) {
            if (tourist.getId().equals(dto.getId())) {
                result = false;
                break;
            }
        }
        if (result) {
            dto.setId(tourists.size());
            tourists.add(dto);
        }
        return result;
    }

    public boolean update(TouristDTO dto) {
        boolean result = false;
        for (TouristDTO tourist : tourists) {
            if (tourist.getId().equals(dto.getId())) {
                result = true;
                tourist = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        TouristDTO deleted = null;
        for (TouristDTO tourist : tourists) {
            if (tourist.getId().equals(id)) {
                result = true;
                deleted = tourist;
            }
        }
        tourists.remove(deleted);
        return result;
    }

    public ApiResponse delete(List<Integer> ids) {
        return null;
    }
}

