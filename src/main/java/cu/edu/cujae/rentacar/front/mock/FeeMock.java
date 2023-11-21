package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.dto.FeeDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FeeMock {
    private static FeeMock instance;
    private final List<FeeDTO> items;

    public static FeeMock getInstance() {
        if (instance == null) {
            instance = new FeeMock();
        }
        return instance;
    }

    private FeeMock() {
        items = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            FeeDTO dto = FeeDTO.builder()
                    .fee(Faker.instance().number().randomDouble(2, 0, 200))
                    .name(Faker.instance().pokemon().name())
                    .build();
            dto.setId(i);
            items.add(dto);
        }
    }

    public List<FeeDTO> getAll() {
        return items;
    }

    public FeeDTO getById(Integer id) {
        FeeDTO role = null;
        for(FeeDTO dto : items) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }

    public boolean save(FeeDTO dto) {
        boolean result = true;
        for (FeeDTO item : items) {
            if (item.getId().equals(dto.getId())) {
                result = false;
                break;
            }
        }
        if (result) {
            dto.setId(items.size() + 1);
            items.add(dto);
        }
        return result;
    }

    public boolean update(FeeDTO dto) {
        boolean result = false;
        for (FeeDTO item : items) {
            if (item.getId().equals(dto.getId())) {
                result = true;
                item = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        FeeDTO deleted = null;
        for (FeeDTO item : items) {
            if (item.getId().equals(id)) {
                result = true;
                deleted = item;
            }
        }
        items.remove(deleted);
        return result;
    }

    public void delete(List<Integer> ids) {
        List<FeeDTO> list = new LinkedList<>();
        for (FeeDTO dto : items) {
            if (ids.contains(dto.getId())) {
                list.add(dto);
            }
        }
        items.removeAll(list);
    }
}
