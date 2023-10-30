package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.BrandDTO;
import cu.edu.cujae.rentacar.front.dto.PayMethodDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PayMethodMock {
    private static PayMethodMock instance;
    private final List<PayMethodDTO> items;

    public static PayMethodMock getInstance() {
        if (instance == null) {
            instance = new PayMethodMock();
        }
        return instance;
    }

    private PayMethodMock() {
        items = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            PayMethodDTO dto = PayMethodDTO.builder().name(Faker.instance().lorem().word()).build();
            dto.setId(i);
            items.add(dto);
        }
    }

    public List<PayMethodDTO> getAll() {
        return items;
    }

    public PayMethodDTO getById(Integer id) {
        PayMethodDTO role = null;
        for(PayMethodDTO dto : items) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }

    public boolean save(PayMethodDTO dto) {
        boolean result = true;
        for (PayMethodDTO item : items) {
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

    public boolean update(PayMethodDTO dto) {
        boolean result = false;
        for (PayMethodDTO item : items) {
            if (item.getId().equals(dto.getId())) {
                result = true;
                item = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        PayMethodDTO deleted = null;
        for (PayMethodDTO item : items) {
            if (item.getId().equals(id)) {
                result = true;
                deleted = item;
            }
        }
        items.remove(deleted);
        return result;
    }

    public void delete(List<Integer> ids) {
        List<PayMethodDTO> list = new LinkedList<>();
        for (PayMethodDTO dto : items) {
            if (ids.contains(dto.getId())) {
                list.add(dto);
            }
        }
        items.removeAll(list);
    }
}
