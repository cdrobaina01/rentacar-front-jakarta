package cu.edu.cujae.rentacar.front.view.crud;

import cu.edu.cujae.rentacar.front.dto.BrandDTO;
import cu.edu.cujae.rentacar.front.dto.ModelDTO;
import cu.edu.cujae.rentacar.front.service.BrandService;
import cu.edu.cujae.rentacar.front.service.ModelService;
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
public class ModelView implements Serializable {
    private List<ModelDTO> models;
    private ModelDTO selected;
    private Integer selectedBrand;
    @Inject
    private ModelService modelService;
    @Inject
    private BrandService brandService;

    @PostConstruct
    public void init() {
        this.models = modelService.getAll();
    }

    public void save() {
        ModelDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = modelService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "model_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "model_not_added");
            }
        } else {
            ApiResponse response = modelService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "model_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "model_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageModelDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:models");
    }

    public void delete() {
        ApiResponse response = modelService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "model_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:models");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "model_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:models");
    }

    public void add() {
        this.selected = new ModelDTO();
    }

    public List<BrandDTO> getBrands() {
        return brandService.getAll();
    }
}
