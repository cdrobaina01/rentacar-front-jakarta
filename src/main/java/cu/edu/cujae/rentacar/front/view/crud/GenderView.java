package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.service.GenderService;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class GenderView extends CrudView<AuxiliaryDTO> implements Serializable {
    @Inject
    private GenderService genderService;

    @PostConstruct
    public void init() {
        entityName = "gender";
        upperEntityName = "Gender";
        this.crudService = genderService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = AuxiliaryDTO.builder().build();
    }
}
