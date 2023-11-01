package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.service.CountryService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class CountryView extends CrudView<AuxiliaryDTO> implements Serializable {
    @Inject
    private CountryService countryService;

    @PostConstruct
    public void init() {
        entityName = "country";
        upperEntityName = "Country";
        this.crudService = countryService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = AuxiliaryDTO.builder().build();
    }
}