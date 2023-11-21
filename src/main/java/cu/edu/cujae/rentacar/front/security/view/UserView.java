package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.security.service.RoleService;
import cu.edu.cujae.rentacar.front.security.service.UserService;
import cu.edu.cujae.rentacar.front.view.crud.CrudView;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserView extends CrudView<UserDTO> implements Serializable {
    @Inject
    private UserService userService;
    @Inject
    private RoleService roleService;
    @Getter @Setter
    private Integer selectedRole;

    @PostConstruct
    public void init() {
        entityName = "user";
        upperEntityName = "User";
        this.crudService = userService;
        this.items = crudService.getAll();
    }

    @Override
    public void save() {

        UserDTO dto = this.selectedItem;
        dto.setRole(roleService.getById(selectedRole));
        super.save(dto);
    }

    @Override
    public void add() {
        this.selectedItem = UserDTO.builder().build();
        this.selectedRole = null;
    }

    public void edit() {
        this.selectedRole = this.selectedItem.getRole().getId();
    }

    public List<RoleDTO> getRoles() {
        return roleService.getAll();
    }

    public boolean isNewUser() {
        return selectedItem.getId() == null;
    }
}
