package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.dto.FeeDTO;
import cu.edu.cujae.rentacar.front.service.CategoryService;
import cu.edu.cujae.rentacar.front.service.FeeService;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class FeeView extends CrudView<FeeDTO> implements Serializable {
    @Inject
    private FeeService feeService;

    @PostConstruct
    public void init() {
        entityName = "fee";
        upperEntityName = "Fee";
        this.crudService = feeService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = FeeDTO.builder().build();
    }
}
