package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.dto.CategoryDTO;
import cu.edu.cujae.rentacar.front.service.CategoryService;
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
public class CategoryView implements Serializable {
    private List<CategoryDTO> categories;
    private CategoryDTO selected;
    @Inject
    private CategoryService categoryService;

    @PostConstruct
    public void init() {
        this.categories = categoryService.getAll();
    }

    public void save() {
        CategoryDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = categoryService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "category_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "category_not_added");
            }
        } else {
            ApiResponse response = categoryService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "category_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "category_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageCategoryDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:categories");
    }

    public void delete() {
        ApiResponse response = categoryService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "category_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:categories");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "category_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:categories");
    }

    public void add() {
        this.selected = new CategoryDTO();
    }
}
