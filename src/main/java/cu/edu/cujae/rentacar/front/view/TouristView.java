package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.dto.TouristDTO;
import cu.edu.cujae.rentacar.front.service.CountryService;
import cu.edu.cujae.rentacar.front.service.TouristService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Data
public class TouristView implements Serializable {
    private List<TouristDTO> tourists;
    @Setter
    private TouristDTO selected;
    private Integer selectedCountry;
    @Inject
    private TouristService touristService;
    @Inject
    private CountryService countryService;

    @PostConstruct
    public void init() { this.tourists = touristService.getAll(); }
    public void setSelectedRole(Integer selectedCountry) {
        this.selectedCountry = selectedCountry;
    }
    public List<TouristDTO> getTourist(){return tourists;}

    public void save() {
        TouristDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = touristService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "tourist_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "tourist_not_added");
            }
        } else {
            ApiResponse response = touristService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "tourist_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "tourist_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageTouristDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:tourists");
    }

    public void delete() {
        ApiResponse response = touristService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "tourist_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:tourists");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "tourist_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:tourists");
    }

    public void add() {
        this.selected = new TouristDTO();
    }
    public List<CountryDTO> getCountries(){
        return countryService.getAll();
    }
}


