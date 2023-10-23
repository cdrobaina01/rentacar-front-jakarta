package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelMock {
    private static ModelMock instance;
    private final List<ModelDTO> models;

    public static ModelMock getInstance() {
        if (instance == null) {
            instance = new ModelMock();
        }
        return instance;
    }

    private ModelMock() {
        models = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i < 6; i++) {
            models.add(
                    ModelDTO.builder()
                            .id(i)
                            .name(Faker.instance().lorem().word())
                            .brand(BrandMock.getInstance().getById(rand.nextInt(5) + 1))
                            .build()
            );
        }
    }
    public List<ModelDTO> getAll() {
        return models;
    }

    public ModelDTO getById(Integer id) {
        ModelDTO role = null;
        for(ModelDTO
                dto : models) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }
}
