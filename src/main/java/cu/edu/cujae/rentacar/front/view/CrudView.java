package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.dto.EntityDTO;
import cu.edu.cujae.rentacar.front.service.CrudService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Data
public abstract class CrudView<DTO extends EntityDTO> {
    protected List<DTO> items;
    protected DTO selectedItem;
    protected List<DTO> selectedItems;
    protected String entityName;
    protected String upperEntityName;
    protected CrudService<DTO> crudService;

    public abstract void add();

    public void save() {
        DTO dto = this.selectedItem;
        this.save(dto);
    }

    public void save(DTO dto) {
        if (dto.getId() == null) {
            ApiResponse response = crudService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, entityName + "_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, entityName + "_not_added");
            }
        } else {
            ApiResponse response = crudService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, entityName + "_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, entityName + "_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageEntityDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:entities");
    }

    public void delete() {
        ApiResponse response = crudService.delete(this.selectedItem.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, entityName + "_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:entities");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, entityName + "_not_deleted");
        }
    }

    public void deleteSelectedProducts() {
        ApiResponse response = crudService.delete(this.selectedItems.stream().map(DTO::getId).collect(Collectors.toUnmodifiableList()));
        this.selectedItems = null;

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, entityName + "_deleted_p");
            PrimeFaces.current().ajax().update("form:messages", "form:entities");
            PrimeFaces.current().executeScript("PF('entities').clearFilters()");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, entityName + "_not_deleted_p");
        }
    }

    public boolean hasSelectedProducts() {
        return this.selectedItems != null && !this.selectedItems.isEmpty();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedItems.size();
            return size > 1 ? size + " " + JsfUtils.getStringValueFromBundle("paymethod_selected_p") : "1 " + JsfUtils.getStringValueFromBundle("paymethod_selected");
        }
        return JsfUtils.getStringValueFromBundle("delete");
    }
}
