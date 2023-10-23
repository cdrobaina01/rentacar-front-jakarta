package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.security.service.RoleService;
import cu.edu.cujae.rentacar.front.security.service.UserService;
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
public class UserView implements Serializable {
    private List<UserDTO> users;
    private UserDTO selected;
    private Integer selectedRole;
    @Inject
    private UserService userService;
    @Inject
    private RoleService roleService;

    @PostConstruct
    public void init() {
        this.users = userService.getAll();
    }

    public List<UserDTO> getUsers() {
        return users;
    }
    public UserDTO getSelected() {
        return selected;
    }
    public void setSelected(UserDTO selected) {
        this.selected = selected;
    }
    public Integer getSelectedRole() {
        return selectedRole;
    }
    public void setSelectedRole(Integer selectedRole) {
        this.selectedRole = selectedRole;
    }

    public void save() {
        UserDTO dto = this.selected;
        dto.setRole(roleService.getById(selectedRole));
        if (dto.getId() == null) {
            ApiResponse response = userService.save(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "user_added");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "user_not_added");
            }
        }
        else {
            ApiResponse response = userService.update(dto);
            if (response.isSuccess()) {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "user_edited");
            } else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "user_not_edited");
            }
        }
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:users");
    }

    public void deleteUser() {
        ApiResponse response = userService.delete(this.selected.getId());

        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "user_deleted");
            PrimeFaces.current().ajax().update("form:messages", "form:users");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "user_not_deleted");
        }
        PrimeFaces.current().ajax().update("form:messages", "form:users");
    }

    public void add() {
        this.selected = new UserDTO();
    }

    public List<RoleDTO> getRoles() {
        return roleService.getAll();
    }
}
