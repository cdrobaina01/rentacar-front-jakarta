package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.service.BrandService;
import cu.edu.cujae.rentacar.front.service.ModelService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ModelView extends CrudView<ModelDTO> implements Serializable {
    @Inject
    private ModelService modelService;
    @Inject
    private BrandService brandService;
    @Getter
    @Setter
    private Integer selectedBrand;

    @PostConstruct
    public void init() {
        entityName = "model";
        upperEntityName = "Model";
        this.crudService = modelService;
        this.items = crudService.getAll();
    }

    @Override
    public void save() {

        ModelDTO dto = this.selectedItem;
        dto.setBrand(brandService.getById(selectedBrand));
        super.save(dto);
    }

    @Override
    public void add() {
        this.selectedItem = ModelDTO.builder().build();
        this.selectedBrand = null;
    }
    public void edit(){
        this.selectedBrand = this.selectedItem.getBrand().getId();
    }

    public List<AuxiliaryDTO> getBrands() {
        return brandService.getAll();
    }
}
