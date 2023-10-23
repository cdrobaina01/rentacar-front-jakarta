package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.dto.CountryDTO;
import cu.edu.cujae.rentacar.front.service.CountryService;
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
public class CountryView  implements Serializable {
    private List<CountryDTO> countries;
    @Setter
    private CountryDTO selected;
    @Inject
    private CountryService countryService;

    @PostConstruct
    public void init() { this.countries = countryService.getAll(); }

    public void save() {
        CountryDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = countryService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "country_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "country_not_added");
            }
        } else {
            ApiResponse response = countryService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "country_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "country_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageCountryDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:countries");
    }

    public void delete() {
        ApiResponse response = countryService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "country_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:countries");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "country_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:countries");
    }

    public void add() {
        this.selected = new CountryDTO();
    }
}


