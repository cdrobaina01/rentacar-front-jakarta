package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.BrandDTO;

import java.util.ArrayList;
import java.util.List;

public class BrandMock {
    private static BrandMock instance;
    private final List<BrandDTO> brands;

    public static BrandMock getInstance() {
        if (instance == null) {
            instance = new BrandMock();
        }
        return instance;
    }

    private BrandMock() {
        brands = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            brands.add(BrandDTO.builder().id(i).name(Faker.instance().lorem().word()).build());
        }
    }
    public List<BrandDTO> getAll() {
        return brands;
    }
    public BrandDTO getById(Integer id) {
        BrandDTO role = null;
        for(BrandDTO dto : brands) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }
}
