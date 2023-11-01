package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.security.service.RoleService;
import cu.edu.cujae.rentacar.front.view.crud.CrudView;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class RoleView extends CrudView<RoleDTO> implements Serializable {
    @Inject
    private RoleService roleService;

    @PostConstruct
    public void init() {
        entityName = "paymethod";
        upperEntityName = "PayMethod";
        this.crudService = roleService;
        this.items = crudService.getAll();
    }

    @Override
    public void add() {
        this.selectedItem = RoleDTO.builder().build();
    }
}
