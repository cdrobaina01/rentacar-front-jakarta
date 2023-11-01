package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.dto.BrandDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.service.BrandService;
import cu.edu.cujae.rentacar.front.service.ModelService;
import cu.edu.cujae.rentacar.front.service.PayMethodService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BrandView extends CrudView<AuxiliaryDTO> implements Serializable {
    @Inject
    private BrandService brandService;

    @PostConstruct
    public void init() {
        entityName = "brand";
        upperEntityName = "Brand";
        this.crudService = brandService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = AuxiliaryDTO.builder().build();
    }
}
