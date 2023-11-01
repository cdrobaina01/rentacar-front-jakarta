package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.BrandDTO;
import cu.edu.cujae.rentacar.front.service.BrandService;
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
@Data
public class BrandView implements Serializable {
    private List<BrandDTO> brands;
    private BrandDTO selected;
    @Inject
    private BrandService brandService;

    @PostConstruct
    public void init() {
        this.brands = brandService.getAll();
    }

    public void save() {
        BrandDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = brandService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "brand_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "brand_not_added");
            }
        } else {
            ApiResponse response = brandService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "brand_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "brand_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageBrandDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:brands");
    }

    public void delete() {
        ApiResponse response = brandService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "brand_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:brands");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "brand_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:brands");
    }

    public void add() {
        this.selected = new BrandDTO();
    }
}
