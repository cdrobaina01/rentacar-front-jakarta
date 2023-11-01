package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.service.CategoryService;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class CategoryView extends CrudView<AuxiliaryDTO> implements Serializable {
    @Inject
    private CategoryService categoryService;

    @PostConstruct
    public void init() {
        entityName = "category";
        upperEntityName = "Category";
        this.crudService = categoryService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = AuxiliaryDTO.builder().build();
    }
}
