package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.security.service.RoleService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RoleView implements Serializable {
    private List<RoleDTO> roles;
    private RoleDTO selected;

    @Inject
    private RoleService roleService;

    @PostConstruct
    public void init() { this.roles = roleService.getAll(); }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public RoleDTO getSelected() {
        return selected;
    }

    public void setSelected(RoleDTO selected) {
        this.selected = selected;
    }

    public void save() {
        RoleDTO dto = this.selected;
        if (dto.getId() == null) {
            ApiResponse response = roleService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "role_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "role_not_added");
            }
        } else {
            ApiResponse response = roleService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "role_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "role_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageRoleDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:roles");
    }

    public void delete() {
        ApiResponse response = roleService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "role_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:role");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "role_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:roles");
    }

    public void add() {
        this.selected = new RoleDTO();
    }
}
