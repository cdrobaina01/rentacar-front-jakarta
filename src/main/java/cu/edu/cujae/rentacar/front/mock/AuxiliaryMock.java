package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AuxiliaryMock {
    private static AuxiliaryMock instance;
    private final List<AuxiliaryDTO> items;

    public static AuxiliaryMock getInstance() {
        if (instance == null) {
            instance = new AuxiliaryMock();
        }
        return instance;
    }

    private AuxiliaryMock() {
        items = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            AuxiliaryDTO dto = AuxiliaryDTO.builder().name(Faker.instance().lorem().word()).build();
            dto.setId(i);
            items.add(dto);
        }
    }

    public List<AuxiliaryDTO> getAll() {
        return items;
    }

    public AuxiliaryDTO getById(Integer id) {
        AuxiliaryDTO role = null;
        for(AuxiliaryDTO dto : items) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }

    public boolean save(AuxiliaryDTO dto) {
        boolean result = true;
        for (AuxiliaryDTO item : items) {
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

    public boolean update(AuxiliaryDTO dto) {
        boolean result = false;
        for (AuxiliaryDTO item : items) {
            if (item.getId().equals(dto.getId())) {
                result = true;
                item = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        AuxiliaryDTO deleted = null;
        for (AuxiliaryDTO item : items) {
            if (item.getId().equals(id)) {
                result = true;
                deleted = item;
            }
        }
        items.remove(deleted);
        return result;
    }

    public void delete(List<Integer> ids) {
        List<AuxiliaryDTO> list = new LinkedList<>();
        for (AuxiliaryDTO dto : items) {
            if (ids.contains(dto.getId())) {
                list.add(dto);
            }
        }
        items.removeAll(list);
    }
}
