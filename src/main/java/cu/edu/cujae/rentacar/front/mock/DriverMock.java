package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.dto.DriverDTO;

import java.util.ArrayList;
import java.util.List;

public class DriverMock {
    private static DriverMock instance;
    private final List<DriverDTO> drivers;

    public static DriverMock getInstance() {
        if (instance == null) {
            instance = new DriverMock();
        }
        return instance;
    }

    private DriverMock() {
        drivers = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            DriverDTO dto = DriverDTO.builder()
                    .id(i)
                    .name(Faker.instance().name().fullName())
                    .dni(Faker.instance().idNumber().ssnValid())
                    .address(Faker.instance().address().fullAddress())
                    .build();
            drivers.add(dto);
        }
    }
    public List<DriverDTO> getAll() {
        return drivers;
    }

    public DriverDTO getById(Integer id) {
        DriverDTO role = null;
        for(DriverDTO dto : drivers) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }
}
