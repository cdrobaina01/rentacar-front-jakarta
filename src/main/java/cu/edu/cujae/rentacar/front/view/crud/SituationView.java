package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import cu.edu.cujae.rentacar.front.service.SituationService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
@Named
@ViewScoped
public class SituationView extends CrudView<AuxiliaryDTO> implements Serializable {
    @Inject
    private SituationService situationService;

    @PostConstruct
    public void init() {
        entityName = "situation";
        upperEntityName = "Situation";
        this.crudService = situationService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = AuxiliaryDTO.builder().build();
    }
}
