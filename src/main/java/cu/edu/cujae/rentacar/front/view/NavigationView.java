package cu.edu.cujae.rentacar.front.view;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import org.primefaces.model.menu.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Named
@SessionScoped
@Getter
public class NavigationView implements Serializable {
    private static final long serialVersionUID = 1L;

    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        DefaultSubMenu management = DefaultSubMenu.builder()
                .label("Administration")
                .expanded(true)
                .build();
        management.getElements().add(DefaultMenuItem.builder()
                .value("Manage Users")
                .outcome("/pages/security/manage/users.faces")
                .build()
        );
        management.getElements().add(DefaultMenuItem.builder()
                .value("Manage Roles")
                .outcome("/pages/security/manage/roles.faces")
                .build()
        );

        DefaultSubMenu entities = DefaultSubMenu.builder()
                .label("Entities")
                .expanded(true)
                .build();
        entities.getElements().add(DefaultMenuItem.builder()
                .value("Manage Pay Methods")
                .outcome("/pages/manage/paymethod.faces")
                .build()
        );
        entities.getElements().add(DefaultMenuItem.builder()
                .value("Manage Brands")
                .outcome("/pages/car/manage-brands.faces")
                .build()
        );

        model.getElements().add(management);
        model.getElements().add(entities);
    }
}
