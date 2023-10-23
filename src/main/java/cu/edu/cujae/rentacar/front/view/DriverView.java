package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.dto.DriverDTO;
import cu.edu.cujae.rentacar.front.service.CategoryService;
import cu.edu.cujae.rentacar.front.service.DriverService;
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
public class DriverView implements Serializable {
    private List<DriverDTO> drivers;
    private DriverDTO selected;
    private Integer selectedCategory;
    @Inject
    private DriverService driverService;
    @Inject
    private CategoryService categoryService;

    @PostConstruct
    public void init() {
        this.drivers = driverService.getAll();
    }

    public void save() {
        DriverDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = driverService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "driver_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "driver_not_added");
            }
        } else {
            ApiResponse response = driverService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "driver_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "driver_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageDriverDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:drivers");
    }

    public void delete() {
        ApiResponse response = driverService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "driver_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:drivers");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "driver_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:drivers");
    }

    public void add() {
        this.selected = new DriverDTO();
    }

    public List<CategoryDTO> getCategories() {
        return categoryService.getAll();
    }
}
