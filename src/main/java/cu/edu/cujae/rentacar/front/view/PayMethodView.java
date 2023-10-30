package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.dto.PayMethodDTO;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class PayMethodView extends CrudView<PayMethodDTO> implements Serializable {
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
        this.selectedItem = PayMethodDTO.builder().build();
    }
}
