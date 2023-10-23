package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryMock {
    private static CategoryMock instance;
    private final List<CategoryDTO> categories;

    public static CategoryMock getInstance() {
        if (instance == null) {
            instance = new CategoryMock();
        }
        return instance;
    }

    private CategoryMock() {
        categories = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            categories.add(new CategoryDTO(i, String.valueOf(Faker.instance().lorem().character())));
        }
    }
    public List<CategoryDTO> getAll() {
        return categories;
    }
    public CategoryDTO getById(Integer id) {
        CategoryDTO role = null;
        for(CategoryDTO dto : categories) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }
}
