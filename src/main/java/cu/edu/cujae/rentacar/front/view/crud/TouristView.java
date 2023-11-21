package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.AuxiliaryDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.dto.TouristDTO;
import cu.edu.cujae.rentacar.front.service.CountryService;
import cu.edu.cujae.rentacar.front.service.GenderService;
import cu.edu.cujae.rentacar.front.service.TouristService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TouristView extends CrudView<TouristDTO> implements Serializable {
    @Getter
    @Setter
    private Integer selectedCountry;
    @Getter
    @Setter
    private Integer selectedGender;
    @Inject
    private TouristService touristService;
    @Inject
    private CountryService countryService;
    @Inject
    private GenderService genderService;

    @PostConstruct
    public void init() {
        entityName = "tourist";
        upperEntityName = "Tourist";
        this.crudService = touristService;
        this.items = crudService.getAll();
    }

    @Override
    public void save() {
        TouristDTO dto = this.selectedItem;
        dto.setGender(genderService.getById(selectedGender));
        dto.setCountry(countryService.getById(selectedCountry));
        super.save(dto);
    }

    @Override
    public void add() {
        this.selectedItem = TouristDTO.builder().build();
        this.selectedCountry = null;
        this.selectedGender = null;
    }
    public void edit(){
        this.selectedGender = this.selectedItem.getGender().getId();
        this.selectedCountry = this.selectedItem.getCountry().getId();
    }
    public List<AuxiliaryDTO> getCountries() {
        return countryService.getAll();
    }
    public List<AuxiliaryDTO> getGenders() {
        return genderService.getAll();
    }
}


