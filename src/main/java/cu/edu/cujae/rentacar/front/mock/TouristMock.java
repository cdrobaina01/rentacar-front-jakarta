package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.TouristDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.service.CountryService;
import cu.edu.cujae.rentacar.front.service.GenderService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class TouristMock {
    private static TouristMock instance;
    private final List<TouristDTO> tourists;

    @Inject
    private CountryService countryService;
    @Inject
    private GenderService genderService;

    public static TouristMock getInstance() {
        if (instance == null) {
            instance = new TouristMock();
        }
        return instance;
    }

    private TouristMock() {
        tourists = new ArrayList<>();
        TouristDTO dto = TouristDTO.builder()
                .name(Faker.instance().name().firstName())
                .age(Faker.instance().number().numberBetween(18, 99))
                .country(AuxiliaryMock.getInstance().getById(1))
                .gender(AuxiliaryMock.getInstance().getById(1))
                .contact(Faker.instance().phoneNumber().cellPhone())
                .passport(Faker.instance().idNumber().ssnValid())
                .build();
        dto.setId(1);
        tourists.add(dto);
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

