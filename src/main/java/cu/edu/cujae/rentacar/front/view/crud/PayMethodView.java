package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class PayMethodView extends CrudView<AuxiliaryDTO> implements Serializable {
    @Inject
    private PayMethodService payMethodService;

    @PostConstruct
    public void init() {
        entityName = "paymethod";
        upperEntityName = "PayMethod";
        this.crudService = payMethodService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = AuxiliaryDTO.builder().build();
    }
}
